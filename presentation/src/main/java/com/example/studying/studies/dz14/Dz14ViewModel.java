package com.example.studying.studies.dz14;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.studying.studies.R;
import com.example.studying.studies.base.BaseViewModel;

import org.json.JSONArray;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Dz14ViewModel implements BaseViewModel{

    private Activity activity;
    public Dz14ViewModel(Activity activity){
        this.activity = activity;
    }

    SharedPreferences preferences;
    private static final String SHARED_PREF_NAME = "SharedPref";
    private static final String KEY_CODE = "KEY_CODE";

    List<Country> countryList = new ArrayList<>();

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        preferences = activity.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
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

        CountryAdapter adapter = new CountryAdapter(activity);

        Spinner spinner = (Spinner) activity.findViewById(R.id.spinner);
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

    }

    @Override
    public void pause() {

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


