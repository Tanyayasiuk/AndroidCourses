package com.example.studying.studies.lesson9;

import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.example.studying.domain.entity.ProfileModel;
import com.example.studying.domain.entity.ProfileId;
import com.example.studying.domain.interacton.ProfileUseCase;
import com.example.studying.studies.base.BaseViewModel;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.PublishSubject;

public class Lesson9ViewModel implements BaseViewModel {

    //from here new
    //public PublishSubject<String> publishSubject = PublishSubject.create();
    // see lesson2 activity for it



    //till this
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
        //ProfileModel profile = useCase.execute(profileId); // lesson9
        /*useCase.execute(profileId, new DisposableObserver<ProfileModel>() {
            // по сути подписка на получение информации
            @Override
            public void onNext(@NonNull ProfileModel profile) {
                firstName.set(profile.getFirstName());
                lastName.set(profile.getLastName());
                age.set(profile.getAge());
                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAAAAA", "error = ", e);
            }

            @Override
            public void onComplete() {

            }
        });*/

//lesson9
       /* firstName.set(profile.getFirstName());
        lastName.set(profile.getLastName());
        age.set(profile.getAge());
        state.set(STATE.DATA);*/

    }

    @Override
    public void pause() {
        /*useCase.dispose();*/
    }
}
