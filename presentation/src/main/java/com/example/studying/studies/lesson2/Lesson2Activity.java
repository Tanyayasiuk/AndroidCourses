package com.example.studying.studies.lesson2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.studying.studies.R;
import com.example.studying.studies.dz1.Dz1Activity;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class Lesson2Activity extends Activity{


    public PublishSubject<String> publishSubject = PublishSubject.create();
    public BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();
    public ReplaySubject replaySubject = ReplaySubject.create();

    Disposable disposable;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);

        replaySubject.onNext("One");
        replaySubject.onNext("Two");
        replaySubject.onNext("Three");
        replaySubject.onNext("Four");
        disposable = (Disposable) replaySubject.subscribeWith(new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String s) {
                Log.e("AAAAAAA", s);
            }

            @Override
            public void onError(@NonNull Throwable e) {}

            @Override
            public void onComplete() {}
        });
        replaySubject.onNext("Five");
        replaySubject.onNext("Six");


        final EditText username = (EditText) findViewById(R.id.usernameText);
        final EditText password = (EditText) findViewById(R.id.passwordText);
        Button loginButton = (Button) findViewById(R.id.loginButton);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson2Activity.this, Dz1Activity.class);

                intent.putExtra(Dz1Activity.KEY_USERNAME, username.getText().toString());
                intent.putExtra(Dz1Activity.KEY_PASSWORD, password.getText().toString());

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(!disposable.isDisposed()){
            disposable.dispose();
        }
    }
}
