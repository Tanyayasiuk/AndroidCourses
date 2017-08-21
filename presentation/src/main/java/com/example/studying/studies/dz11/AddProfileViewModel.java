package com.example.studying.studies.dz11;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studying.domain.entity.ProfileModel;
import com.example.studying.domain.interacton.AddProfileUseCase;
import com.example.studying.studies.R;
import com.example.studying.studies.base.BaseViewModel;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;


public class AddProfileViewModel implements BaseViewModel {

    public Activity activity;

    public ObservableField<String> newName = new ObservableField<>("");
    public ObservableField<String> newSurname = new ObservableField<>("");
    public ObservableField<String> age = new ObservableField<>("");

    private AddProfileUseCase addProfileUseCase = new AddProfileUseCase();

    AddProfileViewModel(Activity activity){this.activity = activity;}


    @Override
    public void init() {}

    @Override
    public void release() {}

    @Override
    public void resume() {
        Button addButton = (Button)activity.findViewById(R.id.addButton);
        final TextView addAge = (TextView) activity.findViewById(R.id.add_age);
        final TextView addName = (TextView) activity.findViewById(R.id.add_name);
        final TextView addSurname = (TextView) activity.findViewById(R.id.add_surname);
        final ProfileModel profileModel = new ProfileModel();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                profileModel.setLastName(addSurname.getText().toString());
                profileModel.setFirstName(addName.getText().toString());
                profileModel.setAge(Integer.parseInt(addAge.getText().toString()));

                addProfileUseCase.execute(profileModel, new DisposableObserver<Void>() {
                    @Override
                    public void onNext(@NonNull Void aVoid) {
                        //Почему не видно ничего из onNext?!?!
                        Toast toast = Toast.makeText(activity.getApplicationContext(), "Profile created.", Toast.LENGTH_SHORT);
                        toast.show();
                        Log.e("CCC", "ON NEXT");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("CCC", "error = ", e);
                    }

                    @Override
                    public void onComplete() {
                        //И из onComplete тоже...
                        Toast toast = Toast.makeText(activity.getApplicationContext(), "Profile created.", Toast.LENGTH_SHORT);
                        toast.show();
                        Log.e("CCC", "COMPLETED");
                    }
                });

                Toast toast = Toast.makeText(activity.getApplicationContext(), "Profile created.", Toast.LENGTH_SHORT);
                toast.show();

                activity.startActivity(new Intent(activity, Dz11Activity.class));
                addProfileUseCase.dispose();
                activity.finish();
                }
        });
    }

    @Override
    public void pause() {
    }

}
