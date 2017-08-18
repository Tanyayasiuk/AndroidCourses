package com.example.studying.domain.interacton.Base;

public abstract class CUseCase <InParam, OutParam>   {

    protected abstract OutParam buildUseCase(); //lesson9 variant

   public OutParam execute(InParam param) {
        return buildUseCase();
    }
}
