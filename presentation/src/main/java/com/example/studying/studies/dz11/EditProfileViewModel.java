package com.example.studying.studies.dz11;

import android.app.Activity;
import android.content.Intent;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studying.domain.entity.ProfileModel;
import com.example.studying.domain.interacton.GetProfileUseCase;
import com.example.studying.domain.interacton.SaveProfileUseCase;
import com.example.studying.domain.interacton.SetProfileUseCase;
import com.example.studying.studies.R;
import com.example.studying.studies.base.BaseViewModel;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

import static android.widget.Toast.LENGTH_SHORT;


public class EditProfileViewModel implements BaseViewModel {

    public Activity activity;
    public String id;

    public ObservableField<String> firstName = new ObservableField<>("");
    public ObservableField<String> lastName = new ObservableField<>("");
    public ObservableInt age = new ObservableInt(0);

    private GetProfileUseCase getProfileUseCase = new GetProfileUseCase();
    private SetProfileUseCase setProfileUseCase = new SetProfileUseCase();

    public EditProfileViewModel(Activity activity, String id){
        this.activity = activity;
        this.id = id;
    }

    @Override
    public void init() {}

    @Override
    public void release() {}

    @Override
    public void resume() {
        final ProfileModel model = new ProfileModel();
        Button editButton = (Button)activity.findViewById(R.id.editButton);
        final TextView editSurname = (TextView) activity.findViewById(R.id.edit_surname);
        final TextView editName = (TextView) activity.findViewById(R.id.edit_name);
        final TextView editAge = (TextView) activity.findViewById(R.id.edit_age);

        getProfileUseCase.execute(id, new DisposableObserver<ProfileModel>() {
            @Override
            public void onNext(@NonNull ProfileModel profileModel) {
                model.setLastName(profileModel.getLastName());
                model.setFirstName(profileModel.getFirstName());
                model.setAge(profileModel.getAge());
                model.setId(profileModel.getId());

                firstName.set(model.getFirstName());
                lastName.set(model.getLastName());
                age.set(model.getAge());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAAAAA", "alarma! ", e);
            }

            @Override
            public void onComplete() {

            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfileModel modelEdited = new ProfileModel();
                String sur = editSurname.getText().toString();
                String name = editName.getText().toString();
                int age = Integer.parseInt(editAge.getText().toString());
                modelEdited.setId(model.getId());
                modelEdited.setLastName(sur);
                modelEdited.setFirstName(name);
                modelEdited.setAge(age);

                setProfileUseCase.execute(modelEdited, new DisposableObserver<Void>() {
                    @Override
                    public void onNext(@NonNull Void aVoid) {}

                    @Override
                    public void onError(@NonNull Throwable e) {}

                    @Override
                    public void onComplete() {}
                });

                Toast toast = Toast.makeText(activity.getApplicationContext(), "Profile updated.", Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(activity, Dz11Activity.class);
                activity.startActivity(intent);
                activity.finish();

            }
        });

    }

    @Override
    public void pause() {
        getProfileUseCase.dispose();
    }
}
