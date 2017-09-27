package com.example.studying.studies.main;

import android.app.Application;

import com.example.studying.studies.di.AppComponent;
import com.example.studying.studies.di.AppModule;
import com.example.studying.studies.di.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

import io.realm.Realm;


public class MyApplication extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        Realm.init(this);

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }
}
