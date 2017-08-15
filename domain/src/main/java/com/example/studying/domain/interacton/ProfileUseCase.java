package com.example.studying.domain.interacton;

import com.example.studying.data.entity.Profile;
import com.example.studying.domain.entity.ProfileModel;
import com.example.studying.domain.entity.ProfileId;
import com.example.studying.domain.interacton.Base.UseCase;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class ProfileUseCase extends UseCase<ProfileId, ProfileModel> {

 //lesson9 variant
   /*@Override
    protected ProfileModel buildUseCase() {
        return null;
    }
*/

 //lesson9 variant
    @Override
    protected ProfileModel buildUseCase() {

        ProfileModel profile = new ProfileModel();
        profile.setAge(20);
        profile.setFirstName("Ivan");
        profile.setLastName("Ivanov");
        return profile;
    }


   /* @Override
    protected Observable<ProfileModel> buildUseCase() {

        //ProfileModel profile = new ProfileModel();

        //тут делаем запрос к слою дата, в ктором дергается метод на сервере (рест)

        //созздаем объект профайл, который лежит в дата-слое
        //это для теста, в будущем этот объект нам вернет слой дата
        Profile profile = new Profile();
        profile.setAge(20);
        profile.setFirstName("Ivan");
        profile.setLastName("Ivanov");
        //все удалится, когда реализуем рест

        //return Observable.just(profile).delay(3, TimeUnit.SECONDS); //метод just просто создает нам Observable profile
        //нужно трансформировать профайл из даты в профайлмодель домэйна
        //для этого есть метож мап
        return Observable.just(profile)
                .delay(3, TimeUnit.SECONDS)
.filter(new Predicate<Profile>() {
                    @Override
                    public boolean test(@NonNull Profile profile) throws Exception {
                        return profile.getLastName() != null;
                    }
                })

                .map(new Function<Profile, ProfileModel>() {
                    @Override
                    public ProfileModel apply(@NonNull Profile profile) throws Exception {
                        ProfileModel profileModel = new ProfileModel();
                        profileModel.setFirstName(profile.getFirstName());
                        profileModel.setLastName(profile.getLastName());
                        profileModel.setAge(profile.getAge());
                        return profileModel;
                    }
                });
    }*/

}