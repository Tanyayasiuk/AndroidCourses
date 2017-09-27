package com.example.studying.domain.interacton;

import com.example.studying.data.database.DatabaseManager;
import com.example.studying.data.dbentity.Country;
import com.example.studying.data.dbentity.User;
import com.example.studying.domain.entity.CountryDB;
import com.example.studying.domain.entity.GetUser;
import com.example.studying.domain.interacton.Base.UseCase;


import io.reactivex.Observable;


public class GetUserDBUseCase extends UseCase<GetUser, com.example.studying.domain.entity.User> {


    @Override
    protected Observable<com.example.studying.domain.entity.User> buildUseCase(GetUser getUser) {
        DatabaseManager databaseManager = new DatabaseManager(getUser.getContext());
        databaseManager.open(false);
        com.example.studying.domain.entity.User userDomain = convertUser(databaseManager.getUserById(getUser.getUserId()));
        return Observable.just(userDomain);
    }


    private CountryDB convert (Country dataCountry){
        CountryDB countryDB = new CountryDB();
        countryDB.setName(dataCountry.getName());
        countryDB.setCountryId(dataCountry.getCountryId());
        return countryDB;
    }

    private com.example.studying.domain.entity.User convertUser(User userData){
        com.example.studying.domain.entity.User userDomain = new com.example.studying.domain.entity.User();
        userDomain.setId(userData.getId());
        userDomain.setName(userData.getName());
        userDomain.setAge(userData.getAge());
        userDomain.setCountry(convert(userData.getCountry()));
        return userDomain;
    }


}

