package com.example.studying.studies.di;

import com.example.studying.domain.interacton.Dz10UseCase;
import com.example.studying.studies.lesson17.Gson;
import com.example.studying.studies.lesson17.OkHttp;
import com.example.studying.studies.lesson17.Rest;
import com.example.studying.studies.lesson17.SharedPrefs;
import com.example.studying.studies.lesson17.UseCase1;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

//По сути фабрика для создания объектов, которые мы потом хотим инджектить
@Module
public class AppModule {

    @Provides
/*    @Singleton*/
    public UseCase1 provideUseCase1(Rest rest, SharedPrefs sharedPrefs){
        return new UseCase1(rest, sharedPrefs);
    }

    @Provides
    public OkHttp provideOkHttp(){
        return new OkHttp();
    }

    @Provides
    public Gson provideGson(){
        return new Gson();
    }

    @Provides
    public Rest provideRest(OkHttp okHttp, Gson gson){
        return new Rest(okHttp, gson);
    }

    @Provides
    public SharedPrefs sharedPrefs (){return new SharedPrefs();}

    @Provides
    public Dz10UseCase provideDz10UseCAse(){
        return new Dz10UseCase();
    }


}
