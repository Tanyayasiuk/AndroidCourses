package com.example.studying.studies.lesson12;


import android.databinding.ObservableField;

import com.example.studying.domain.entity.ProfileModel;
import com.example.studying.studies.base.BaseItemViewModel;

public class ProfileItemViewModel extends BaseItemViewModel<ProfileModel> {

    public ObservableField<String> name = new ObservableField<>("");


    @Override
    public void setItem(ProfileModel item, int position) {
        name.set(item.getFirstName());
    }
}
