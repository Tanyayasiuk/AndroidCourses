package com.example.studying.domain.interacton;

import com.example.studying.domain.entity.Dz10Model;
import com.example.studying.domain.interacton.Base.RxUseCase;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Dz10UseCase extends RxUseCase<Void,Long> {

    @Override
    protected Observable<Long> buildUseCase() {
        return Observable.interval(1, TimeUnit.SECONDS);
    }
}
