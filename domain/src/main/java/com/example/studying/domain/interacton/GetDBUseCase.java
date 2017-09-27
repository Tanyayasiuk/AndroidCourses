package com.example.studying.domain.interacton;

import android.content.Context;

import com.example.studying.data.database.DatabaseManager;
import com.example.studying.data.dbentity.Country;
import com.example.studying.domain.entity.CountryDB;
import com.example.studying.domain.entity.User;
import com.example.studying.domain.interacton.Base.UseCase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;


public class GetDBUseCase extends UseCase<Context, List<User>> {
    @Override
    protected Observable<List<User>> buildUseCase(Context context) {
        DatabaseManager databaseManager = new DatabaseManager(context);
        databaseManager.open(false);
        List<User> domainUserList = new ArrayList<>();
        List<com.example.studying.data.dbentity.User> dataUserList = databaseManager.getUsers();
        for(com.example.studying.data.dbentity.User u: dataUserList){
            domainUserList.add(convertUser(u));
        }
        return Observable.just(domainUserList);
    }

    private com.example.studying.domain.entity.User convertUser(com.example.studying.data.dbentity.User userData){
        com.example.studying.domain.entity.User userDomain = new com.example.studying.domain.entity.User();
        userDomain.setId(userData.getId());
        userDomain.setName(userData.getName());
        userDomain.setAge(userData.getAge());
        userDomain.setCountry(convert(userData.getCountry()));
        return userDomain;
    }

    private CountryDB convert (Country dataCountry){
        CountryDB countryDB = new CountryDB();
        countryDB.setName(dataCountry.getName());
        countryDB.setCountryId(dataCountry.getCountryId());
        return countryDB;
    }

}
