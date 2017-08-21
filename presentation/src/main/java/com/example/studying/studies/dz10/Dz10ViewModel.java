package com.example.studying.studies.dz10;

import android.app.Activity;
import android.databinding.ObservableField;
import android.util.Log;

import com.example.studying.domain.interacton.Dz10UseCase;
import com.example.studying.studies.base.BaseViewModel;


import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;


public class Dz10ViewModel implements BaseViewModel {

    public Activity activity;
    public ObservableField<String> name = new ObservableField<>("");
    private Dz10UseCase useCase = new Dz10UseCase();

    public Dz10ViewModel(Activity activity){
        this.activity = activity;
    }

    @Override
    public void init() {}

    @Override
    public void release() {}

    @Override
    public void resume() {
        useCase.execute(null, new DisposableObserver<Long>() {
            @Override
            public void onNext(@NonNull Long aLong) {
                name.set(String.valueOf(aLong));
                Log.e("AAA", String.valueOf(aLong));
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void pause() {
        useCase.dispose();
        Log.e("AAA" , "DISPOSE");
    }
}
