package com.example.studying.domain.interacton;

import com.example.studying.data.entity.Profile;
import com.example.studying.data.net.RestService;
import com.example.studying.domain.entity.ProfileId;
import com.example.studying.domain.entity.ProfileModel;
import com.example.studying.domain.interacton.Base.CUseCase;
import com.example.studying.domain.interacton.Base.UseCase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


public class ProfilesListUseCase extends UseCase<Void, List<ProfileModel>>{

    @Override
    protected Observable<List<ProfileModel>> buildUseCase(Void aVoid) {
        return RestService.getInstance().getProfiles()
                .map(new Function<List<Profile>, List<ProfileModel>>() {
                    @Override
                    public List<ProfileModel> apply(@NonNull List<Profile> profiles) throws Exception {
                        List<ProfileModel> list = new ArrayList<>();
                        for (Profile p : profiles ){
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

