package com.example.studying.domain.interacton;


import android.util.Log;

import com.example.studying.data.entity.Profile;
import com.example.studying.data.net.RestService;
import com.example.studying.domain.entity.ProfileModel;
import com.example.studying.domain.interacton.Base.CUseCase;
import com.example.studying.domain.interacton.Base.UseCase;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class GetProfileUseCase extends UseCase<String, ProfileModel> {

    @Override
    protected Observable<ProfileModel> buildUseCase(final String id) {
        return RestService.getInstance().getProfile(id)
                .map(new Function<Profile, ProfileModel>() {
                    @Override
                    public ProfileModel apply(@NonNull Profile profile) throws Exception {
                        ProfileModel profileModel = new ProfileModel();
                        profileModel.setFirstName(profile.getFirstName());
                        profileModel.setLastName(profile.getLastName());
                        profileModel.setAge(profile.getAge());
                        profileModel.setId(profile.getId());
                        Log.e("AAAA", "Model: " + profileModel.getLastName());
                        return profileModel;
                    }
                });

    }
}
