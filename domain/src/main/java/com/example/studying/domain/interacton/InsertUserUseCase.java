package com.example.studying.domain.interacton;

import com.example.studying.data.database.DatabaseManager;
import com.example.studying.domain.entity.AddUser;
import com.example.studying.domain.entity.CountryDB;
import com.example.studying.domain.entity.User;
import com.example.studying.domain.interacton.Base.UseCase;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

public class InsertUserUseCase extends UseCase<AddUser,Void> {

    @Override
    protected Observable<Void> buildUseCase(final AddUser addUser) {
        return Observable.create(new ObservableOnSubscribe<Void>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Void> e) throws Exception {
                DatabaseManager databaseManager = new DatabaseManager(addUser.getContext());
                databaseManager.open(true);
                databaseManager.insertUser(convert(addUser.getUser()));
                databaseManager.close();
            }
        });
    }

    private com.example.studying.data.dbentity.User convert(User user){
        com.example.studying.data.dbentity.User userData = new com.example.studying.data.dbentity.User();
        userData.setName(user.getName());
        userData.setAge(user.getAge());
        userData.setCountry(convertCountry(user.getCountry()));
        return  userData;
    }

    private com.example.studying.data.dbentity.Country convertCountry(CountryDB country){
        com.example.studying.data.dbentity.Country countryData = new com.example.studying.data.dbentity.Country();
        countryData.setName(country.getName());
        countryData.setCountryId(country.getCountryId());
        return countryData;
    }
}
