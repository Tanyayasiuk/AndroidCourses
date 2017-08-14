package com.example.studying.studies.lesson9;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.AsyncTask;
import android.util.Log;

import com.example.studying.domain.entity.Profile;
import com.example.studying.domain.entity.ProfileId;
import com.example.studying.domain.interacton.ProfileUseCase;
import com.example.studying.studies.base.BaseViewModel;

public class Lesson9ViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}

    public Activity activity;
   // public ObservableField<String> helloText = new ObservableField<>("Hello");
    public ObservableField<String> firstName = new ObservableField<>("");
    public ObservableField<String> lastName = new ObservableField<>("");
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);
    public ObservableInt age = new ObservableInt(0);
    private ProfileUseCase useCase = new ProfileUseCase();

    public Lesson9ViewModel(Activity activity){
        this.activity = activity;
    }

    @Override
    public void init() {}

    @Override
    public void release() {
    }

    @Override
    public void resume() {
        ProfileId profileId = new ProfileId();
        profileId.setId("123");
        Profile profile = useCase.execute(profileId);

        firstName.set(profile.getFirstName());
        lastName.set(profile.getLastName());
        age.set(profile.getAge());

        state.set(STATE.DATA);
    }

    @Override
    public void pause() {}
}
