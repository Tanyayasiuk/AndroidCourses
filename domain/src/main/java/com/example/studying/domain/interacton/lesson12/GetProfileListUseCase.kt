package com.example.studying.domain.interacton.lesson12

import com.example.studying.data.entity.DataModel
import com.example.studying.data.entity.Profile
import com.example.studying.data.net.RestService
import com.example.studying.domain.entity.ProfileModel
import com.example.studying.domain.interacton.Base.UseCase

import io.reactivex.Observable

class GetProfileListUseCase : UseCase<Void, List<ProfileModel>>() {

    override fun buildUseCase(param: Void?): Observable<List<ProfileModel>>? {
        return RestService.getInstance().profiles.map {
            it.map{convert(it)}
        }
    }

    private fun convert(dataModel: Profile): ProfileModel {
        val profileModel = ProfileModel();
        profileModel.firstName = dataModel.firstName
        profileModel.lastName = dataModel.lastName
        profileModel.age = dataModel.age
        return profileModel;
    }
}
