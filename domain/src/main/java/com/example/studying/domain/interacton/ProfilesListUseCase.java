package com.example.studying.domain.interacton;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.studying.data.entity.Profile;
import com.example.studying.data.net.RestService;
import com.example.studying.domain.entity.ProfileId;
import com.example.studying.domain.entity.ProfileModel;
import com.example.studying.domain.interacton.Base.UseCase;

import java.util.ArrayList;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;



public class ProfilesListUseCase extends UseCase<Void, List<ProfileModel>>{

    /*@Override
    protected Observable<List<ProfileModel>> buildUseCase(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if(netInfo != null && netInfo.isConnectedOrConnecting()){
            return RestService.getInstance().getProfiles()
                    .map(new Function<List<Profile>, List<ProfileModel>>() {
                        @Override
                        public List<ProfileModel> apply(@NonNull List<Profile> profiles) throws Exception {
                            List<ProfileModel> list = new ArrayList<>();
                            for (Profile p : profiles) {
                                ProfileModel model = new ProfileModel();
                                model.setLastName(p.getLastName());
                                model.setFirstName(p.getFirstName());
                                model.setAge(p.getAge());
                                model.setId(p.getId());
                                list.add(model);

                            }
                            *//*realm.beginTransaction();
                            realm.copyToRealmOrUpdate(list);
                            realm.commitTransaction();*//*
                            return list;
                        }
                    });
        } else {
            // return data from local database
            return null;
        }

    }*/

    @Override
    protected Observable<List<ProfileModel>> buildUseCase(Void aVoid) {
        return RestService.getInstance().getProfiles()
                .map(new Function<List<Profile>, List<ProfileModel>>() {
                    @Override
                    public List<ProfileModel> apply(@NonNull List<Profile> profiles) throws Exception {
                        List<ProfileModel> list = new ArrayList<>();
                        for (Profile p : profiles) {
                            ProfileModel model = new ProfileModel();
                            model.setLastName(p.getLastName());
                            model.setFirstName(p.getFirstName());
                            model.setAge(p.getAge());
                            model.setId(p.getId());
                            list.add(model);

                        }
                        return list;
                    }
                });

    }
}

