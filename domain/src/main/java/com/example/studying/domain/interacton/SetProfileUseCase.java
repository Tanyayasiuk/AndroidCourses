package com.example.studying.domain.interacton;

import android.util.Log;

import com.example.studying.data.entity.Profile;
import com.example.studying.data.net.RestService;
import com.example.studying.domain.entity.ProfileModel;
import com.example.studying.domain.interacton.Base.UseCase;

import io.reactivex.Observable;

public class SetProfileUseCase extends UseCase<ProfileModel, Void> {
    @Override
    protected Observable<Void> buildUseCase(ProfileModel profileModel) {
        String id = profileModel.getId();
        Log.e("AAAAAA", id);
        Profile profileData = new Profile();
        profileData.setLastName(profileModel.getLastName());
        profileData.setFirstName(profileModel.getFirstName());
        profileData.setAge(profileModel.getAge());
        profileData.setId(id);
        Log.e("AAAAAA", "ProfileData set");

        return RestService.getInstance().setProfile(id, profileData);
    }
}
