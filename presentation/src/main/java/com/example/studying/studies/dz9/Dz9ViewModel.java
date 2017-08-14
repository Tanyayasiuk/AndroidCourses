package com.example.studying.studies.dz9;

import android.app.Activity;
import android.databinding.ObservableChar;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import com.example.studying.domain.entity.Country;
import com.example.studying.domain.entity.CountryNum;
import com.example.studying.domain.interacton.CountryUseCase;
import com.example.studying.studies.base.BaseViewModel;

public class Dz9ViewModel implements BaseViewModel {

    public Activity activity;
    public ObservableField<String> countryName = new ObservableField<>("");
    public ObservableField<String> imageUrl = new ObservableField<>("");

    private CountryUseCase useCase = new CountryUseCase();
    private ImageView view;

    public Dz9ViewModel(Activity activity){
        this.activity = activity;
    }

    @Override
    public void init() {
        /*CountryNum num = new CountryNum();
        num.setNum("1");
        Country country = useCase.execute(num);
        countryName.set(country.getCountryName());
        imageUrl.set(country.getImageUrl());*/
        Log.e("AAAAAA", "init ViewModel");
    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        CountryNum num = new CountryNum();
        num.setNum("1");
        Country country = useCase.execute(num);
        countryName.set(country.getCountryName());
        imageUrl.set(country.getImageUrl());
        Log.e("AAAAAA", "resume ViewModel");
    }

    @Override
    public void pause() {

    }
}
