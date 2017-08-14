package com.example.studying.domain.interacton.Base;

public abstract class UseCase<InParam, OutParam> {

    protected abstract OutParam biuldUseCase();

    public OutParam execute(InParam param) {
        return biuldUseCase();
    }
}
