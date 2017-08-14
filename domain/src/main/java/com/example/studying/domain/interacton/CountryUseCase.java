package com.example.studying.domain.interacton;

import com.example.studying.domain.entity.Country;
import com.example.studying.domain.entity.CountryNum;
import com.example.studying.domain.interacton.Base.UseCase;

public class CountryUseCase extends UseCase<CountryNum, Country> {

    //int id;

    /*public static Country[] ITEMS = new Country[]{
            new Country("Australia", "http://ru.freeflagicons.com/download/?series=round_icon&country=australia&size=64"),
            new Country("Austria", "http://ru.freeflagicons.com/download/?series=round_icon&country=austria&size=64")
           new Country("Fedor", "Sokolov", 26, "http://icons.iconarchive.com/icons/hopstarter/face-avatars/256/Male-Face-E4-icon.png", 'm'),
            new Country("Artem", "Semenov", 22, "http://icons.iconarchive.com/icons/hopstarter/face-avatars/256/Male-Face-F1-icon.png", 'm'),
            new Country("Marina", "Anikina", 23, "http://icons.iconarchive.com/icons/hopstarter/face-avatars/256/Female-Face-FE-5-blonde-icon.png", 'f'),
            new Country("Ignat", "Domeiko", 44, "http://icons.iconarchive.com/icons/hopstarter/face-avatars/256/Male-Face-A3-icon.png", 'm'),
            new Country("Anna-Maria", "Akselrod", 25, "http://icons.iconarchive.com/icons/hopstarter/face-avatars/256/Female-Face-FI-1-icon.png", 'f')
    };*/

    @Override
    protected Country biuldUseCase() {
        Country country = new Country();
        country.setCountryName("Australia");
        country.setImageUrl("http://ru.freeflagicons.com/download/?series=round_icon&country=australia&size=64");
        return country;
    }

}
