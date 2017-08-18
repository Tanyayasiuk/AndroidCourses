package com.example.studying.data.net;

import android.util.Log;

import com.example.studying.data.entity.Profile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestService {

    private static final RestService instance = new RestService();

    private RestAPI restAPI;
    private RestService(){init();}

    public static RestService getInstance(){
        return instance;
    }

    private void init(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder() //замена HTTPUrlConnection
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.backendless.com/D98411AD-4158-F507-FF34-CC7C7669CF00/A6BF2F37-9F1B-437A-FF10-82EE9CECF100/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        Log.e("AAAAAA", "RETROFIT");
        restAPI = retrofit.create(RestAPI.class);

    }

    public Observable<List<Profile>> getProfiles(){
        return restAPI.getProfiles();
    }

    public Observable<Void> saveProfile(Profile profile){
        return restAPI.saveProfile(profile);
    }

    public Observable<Profile> getProfile(String id){
        return restAPI.getProfile(id);}
}
