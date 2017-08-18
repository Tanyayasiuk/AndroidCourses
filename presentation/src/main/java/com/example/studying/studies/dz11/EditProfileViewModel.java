package com.example.studying.studies.dz11;

import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.example.studying.domain.entity.ProfileModel;
import com.example.studying.domain.interacton.GetProfileUseCase;
import com.example.studying.studies.base.BaseViewModel;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;


public class EditProfileViewModel implements BaseViewModel {

    public Activity activity;
    public String id;

    public ObservableField<String> firstName = new ObservableField<>("");
    public ObservableField<String> lastName = new ObservableField<>("");
    public ObservableInt age = new ObservableInt(0);

    private GetProfileUseCase getProfileUseCase = new GetProfileUseCase();
    public EditProfileViewModel(Activity activity, String id){
        this.activity = activity;
        this.id = id;
        Log.e("AAAAAA", "ID transferred = " + id);
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        final ProfileModel model = new ProfileModel();

        getProfileUseCase.execute(id, new DisposableObserver<ProfileModel>() {
            @Override
            public void onNext(@NonNull ProfileModel profileModel) {
                model.setLastName(profileModel.getLastName());
                model.setFirstName(profileModel.getFirstName());
                model.setAge(profileModel.getAge());
                model.setId(profileModel.getId());

                firstName.set(model.getFirstName());
                Log.e("AAA", "FirstName: " + firstName);
                lastName.set(model.getLastName());
                Log.e("AAA", "LastName: " + lastName);
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

    }

    @Override
    public void pause() {
        getProfileUseCase.dispose();
    }
}
