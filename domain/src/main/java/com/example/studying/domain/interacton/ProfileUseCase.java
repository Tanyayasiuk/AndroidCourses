package com.example.studying.domain.interacton;

import com.example.studying.domain.entity.Profile;
import com.example.studying.domain.entity.ProfileId;
import com.example.studying.domain.interacton.Base.UseCase;

public class ProfileUseCase extends UseCase<ProfileId, Profile> {

    @Override
    protected Profile biuldUseCase() {

        Profile profile = new Profile();
        profile.setAge(20);
        profile.setFirstName("Ivan");
        profile.setLastName("Ivanov");
        return profile;
    }

}
