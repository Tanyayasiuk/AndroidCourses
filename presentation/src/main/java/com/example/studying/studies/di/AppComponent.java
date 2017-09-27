package com.example.studying.studies.di;


import com.example.studying.studies.dz10.Dz10ViewModel;
import com.example.studying.studies.lesson17.UI;

import javax.inject.Singleton;

import dagger.Component;

//Настроечный класс. Связующее звено между классами, где исп-зя аннотация Inject, и модулем
@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    //Прописываются все классы, где мы хотим использовать inject

    void inject(UI ui);
    void inject(Dz10ViewModel viewModel);
}
