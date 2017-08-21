package com.example.studying.domain.interacton;

import com.example.studying.data.entity.Profile;
import com.example.studying.data.net.RestService;
import com.example.studying.domain.entity.ProfileModel;
import com.example.studying.domain.interacton.Base.UseCase;

import io.reactivex.Observable;


public class AddProfileUseCase extends UseCase<ProfileModel, Void> {
    @Override
    protected Observable<Void> buildUseCase(ProfileModel profileModel) {
        Profile profileData = new Profile();
        profileData.setLastName(profileModel.getLastName());
        profileData.setFirstName(profileModel.getFirstName());
        profileData.setAge(profileModel.getAge());

        return RestService.getInstance().addProfile(profileData);
    }
}
