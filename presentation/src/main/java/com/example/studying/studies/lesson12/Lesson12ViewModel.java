package com.example.studying.studies.lesson12;

import android.app.Activity;
import android.databinding.ObservableField;

import com.example.studying.studies.base.BaseViewModel;

public class Lesson12ViewModel implements BaseViewModel {

    private Activity activity;
    public Lesson12ViewModel(Activity activity){
        this.activity = activity;
    }

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
}
