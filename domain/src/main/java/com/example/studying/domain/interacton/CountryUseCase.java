package com.example.studying.domain.interacton;

import com.example.studying.domain.entity.Country;
import com.example.studying.domain.interacton.Base.UseCase;

import io.reactivex.Observable;


public class CountryUseCase extends UseCase<Void, Country[]>{
    //@Override
    protected Country[] buildUseCase() {
        Country[] countries = new Country[]{
                new Country("Australia", "http://ru.freeflagicons.com/download/?series=round_icon&country=australia&size=64"),
                new Country("Austria", "http://ru.freeflagicons.com/download/?series=round_icon&country=austria&size=64"),
                new Country("Azerbaijan", "http://ru.freeflagicons.com/download/?series=round_icon&country=azerbaijan&size=64"),
                new Country("Albania", "http://ru.freeflagicons.com/download/?series=round_icon&country=albania&size=64"),
                new Country("Algeria", "http://ru.freeflagicons.com/download/?series=round_icon&country=algeria&size=64"),
                new Country("Argentina", "http://ru.freeflagicons.com/download/?series=round_icon&country=argentina&size=64"),
                new Country("Armenia", "http://ru.freeflagicons.com/download/?series=round_icon&country=armenia&size=64"),
                new Country("Afghanistan", "http://ru.freeflagicons.com/download/?series=round_icon&country=afghanistan&size=64"),
                new Country("Bahamas", "http://ru.freeflagicons.com/download/?series=round_icon&country=bahamas&size=64"),
                new Country("Bangladesh", "http://ru.freeflagicons.com/download/?series=round_icon&country=bangladesh&size=64"),
                new Country("Barbados", "http://ru.freeflagicons.com/download/?series=round_icon&country=barbados&size=64"),
                new Country("Bahrain", "http://ru.freeflagicons.com/download/?series=round_icon&country=bahrain&size=64"),
                new Country("Beliz", "http://ru.freeflagicons.com/download/?series=round_icon&country=belize&size=64"),
                new Country("Belarus", "http://ru.freeflagicons.com/download/?series=round_icon&country=belarus&size=64"),
                new Country("Belgium", "http://ru.freeflagicons.com/download/?series=round_icon&country=belgium&size=64"),
                new Country("Benin", "http://ru.freeflagicons.com/download/?series=round_icon&country=benin&size=64"),
        };
        return countries;
    }

    @Override
    protected Observable<Country[]> buildUseCase(Void aVoid) {
        return null;
    }
}
