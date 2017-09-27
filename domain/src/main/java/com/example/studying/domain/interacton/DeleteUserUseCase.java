package com.example.studying.domain.interacton;

import com.example.studying.data.database.DatabaseManager;
import com.example.studying.domain.entity.GetUser;
import com.example.studying.domain.interacton.Base.UseCase;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

public class DeleteUserUseCase extends UseCase<GetUser, Void> {
    @Override
    protected Observable<Void> buildUseCase(final GetUser getUser) {
        return Observable.create(new ObservableOnSubscribe<Void>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Void> e) throws Exception {
                DatabaseManager manager = new DatabaseManager(getUser.getContext());
                manager.open(true);
                manager.deleteUser(getUser.getUserId());
                manager.close();
            }
        });
    }
}
