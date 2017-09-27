package com.example.studying.studies.dz14;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studying.domain.entity.AddUser;
import com.example.studying.domain.entity.CountryDB;
import com.example.studying.domain.entity.GetUser;
import com.example.studying.domain.entity.User;
import com.example.studying.domain.interacton.DeleteUserUseCase;
import com.example.studying.domain.interacton.GetDBUseCase;
import com.example.studying.domain.interacton.GetUserDBUseCase;
import com.example.studying.domain.interacton.InsertUserUseCase;
import com.example.studying.studies.R;
import com.example.studying.studies.base.BaseViewModel;

import org.json.JSONArray;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class Dz14ViewModel implements BaseViewModel{

    private Activity activity;
    public Dz14ViewModel(Activity activity){
        this.activity = activity;
    }

    SharedPreferences preferences;
    private static final String SHARED_PREF_NAME = "SharedPref";
    private static final String KEY_CODE = "KEY_CODE";

    List<Country> countryList = new ArrayList<>();
    public ObservableField<String> userName = new ObservableField<>("");
    public ObservableField<String> userAge = new ObservableField<>();
    public ObservableField<String> showName = new ObservableField<>();
    public ObservableField<String> showNames = new ObservableField<>();

    InsertUserUseCase useCase = new InsertUserUseCase();
    GetUserDBUseCase getUserDBUseCase = new GetUserDBUseCase();
    GetDBUseCase getDBUseCase = new GetDBUseCase();
    DeleteUserUseCase deleteUserUseCase = new DeleteUserUseCase();

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        preferences = activity.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        Button addUserButton = (Button) activity.findViewById(R.id.addUserButton);
        Button showUserButton = (Button) activity.findViewById(R.id.showUserButton);
        Button showAllUserButton = (Button) activity.findViewById(R.id.showAllButton);
        Button deleteUserButton = (Button) activity.findViewById(R.id.deleteUserButton);
        Log.e("SSS", "SharedPreferences = " + preferences.getString(KEY_CODE, ""));

        try {
            JSONArray array = new JSONArray(loadStringFromAsset("countries.json"));

            for(int i = 0; i< array.length(); i++){
                Country country = new Country();
                country.setName(array.getJSONObject(i).getString("name"));
                country.setCode(array.getJSONObject(i).getString("code"));
                countryList.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        final CountryAdapter adapter = new CountryAdapter(activity);

        final Spinner spinner = (Spinner) activity.findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        int position = 0;

        for (Country c: countryList){
            if(c.getCode().equals(preferences.getString(KEY_CODE, ""))){
                position = countryList.indexOf(c);
                Log.e("SSS", "Position = " + position);
            };
        }
        spinner.setSelection(position);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                preferences.edit().putString(KEY_CODE, countryList.get(i).getCode())
                        /*Так, конечно, было бы значительно показывать в спиннере выбранное, безо всяких переборов: запомнил
                        себе номер позиции, потом запер ее в spinner.setSelection(position) - Bingo!
                        .putInt("SELECTED", spinner.getSelectedItemPosition()) */
                        .apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView userName = (TextView) activity.findViewById(R.id.userName);
                TextView userAge = (TextView) activity.findViewById(R.id.userAge);

                CountryDB countryDB = new CountryDB();
                countryDB.setName(countryList.get(spinner.getSelectedItemPosition()).getName());
                countryDB.setCountryId(spinner.getSelectedItemPosition());

                User user = new User();
                user.setName(userName.getText().toString());
                user.setAge(Integer.parseInt(userAge.getText().toString()));
                user.setCountry(countryDB);

                AddUser addUser = new AddUser(activity, user);
                Log.e("SSS", "name: " + addUser.getUser().getName());
                Log.e("SSS", "age: " + String.valueOf(addUser.getUser().getAge()));
                Log.e("SSS", "country: " + addUser.getUser().getCountry().getName());
                Log.e("SSS", "countryId: " + addUser.getUser().getCountry().getCountryId());

                useCase.execute(addUser, new DisposableObserver<Void>() {
                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull Void aVoid) {
                        Log.e("SSS", "onNext");
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                        Log.e("SSS", "onError " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("SSS", "onComplete");
                    }
                });

                Toast toast = Toast.makeText(activity.getApplicationContext(), "User created.", Toast.LENGTH_SHORT);
                toast.show();


            }
        });

        showUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("SSS", "SHOW - OnClick");

                TextView search = (TextView) activity.findViewById(R.id.search);
                GetUser getUser = new GetUser(activity, search.getText().toString());
                getUserDBUseCase.execute(getUser, new DisposableObserver<User>() {
                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull User users) {
                        Log.e("SSS", "List USERS " + users.toString());
                        Log.e("SSS", "USERS Name " + users.getName());
                        Log.e("SSS", "USERS Age " + String.valueOf(users.getAge()));

                        StringBuilder userName = new StringBuilder();
                        userName.append("id");
                        userName.append(users.getId());
                        userName.append(" - ");
                        userName.append(users.getName());
                        userName.append(" - ");
                        userName.append(String.valueOf(users.getAge()));
                        userName.append(" - ");
                        userName.append(users.getCountry().getName());
                        showName.set(userName.toString());

                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                        Log.e("SSS", "GET USER LIST ERROR " + e.getLocalizedMessage());
                        Toast toast = Toast.makeText(activity.getApplicationContext(), "Cannot find such user", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });

        showAllUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDBUseCase.execute(activity, new DisposableObserver<List<User>>() {
                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull List<User> users) {
                        StringBuilder names = new StringBuilder();
                        names.append("Users:\n");

                        for(User u: users){
                            names.append("id");
                            names.append(u.getId());
                            names.append(" - ");
                            names.append(u.getName());
                            names.append(" - ");
                            names.append(String.valueOf(u.getAge()));
                            names.append(" - ");
                            names.append(u.getCountry().getName());
                            names.append("\n");

                        }
                        showNames.set(names.toString());

                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });

        deleteUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView search = (TextView) activity.findViewById(R.id.search);
                GetUser getUser = new GetUser(activity, search.getText().toString());
                deleteUserUseCase.execute(getUser, new DisposableObserver<Void>() {
                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull Void aVoid) {

                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
                Toast toast = Toast.makeText(activity.getApplicationContext(), "User might be deleted.", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    @Override
    public void pause() {
       /* useCase.dispose();
        getUserDBUseCase.dispose();
        getDBUseCase.dispose();*/
    }


    private  String loadStringFromAsset(String assetName) throws Exception {
        InputStream is = activity.getAssets().open(assetName);
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        return new String(buffer, "UTF-8");
    }


    private class CountryAdapter extends ArrayAdapter<Country>{

        public CountryAdapter(@NonNull Context context) {
            super(context, android.R.layout.simple_list_item_2, countryList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Country country = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(android.R.layout.simple_spinner_item, null);
            }
            ((TextView) convertView.findViewById(android.R.id.text1))
                    .setText(country.getName());
            return convertView;
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Country country = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(android.R.layout.simple_spinner_dropdown_item, null);
            }
            ((TextView) convertView.findViewById(android.R.id.text1))
                    .setText(country.getName());
            return convertView;
        }
    }




}


