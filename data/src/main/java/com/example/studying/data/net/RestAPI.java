package com.example.studying.data.net;

import com.example.studying.data.entity.Profile;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestAPI { //Здесь будут все методы для доступа к серверу

    @GET("data/profiles")
    Observable<List<Profile>> getProfiles();

    @POST("data/profiles")
    Observable<Void> saveProfile (@Body Profile profile);
    
    @GET("data/profiles/{id}") //поиск по id
    Observable<Profile> getProfile(@Path("id") String id);

}
