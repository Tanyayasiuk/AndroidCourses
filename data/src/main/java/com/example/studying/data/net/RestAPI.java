package com.example.studying.data.net;

import com.example.studying.data.entity.Profile;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestAPI { //Все методы для доступа к серверу

    @GET("data/profiles")
    Observable<List<Profile>> getProfiles();

    @POST("data/profiles")
    Observable<Void> saveProfile (@Body Profile profile);
    
    @GET("data/profiles/{id}") //поиск по id
    Observable<Profile> getProfile(@Path("id") String id);

    @PUT("data/profiles/{id}")
    Observable<Void> setProfile (@Path("id") String id, @Body Profile profile);

    @POST("data/profiles")
    Observable<Void> addProfile (@Body Profile profile);

}
