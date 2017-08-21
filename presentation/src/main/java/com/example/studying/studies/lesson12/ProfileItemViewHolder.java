package com.example.studying.studies.lesson12;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.studying.domain.entity.ProfileModel;
import com.example.studying.studies.base.BaseItemViewHolder;
import com.example.studying.studies.databinding.ItemLesson12Binding;

public class ProfileItemViewHolder extends BaseItemViewHolder<ProfileModel, ProfileItemViewModel, ItemLesson12Binding> {

    public ProfileItemViewHolder(ItemLesson12Binding binding, ProfileItemViewModel viewModel) {
        super(binding, viewModel);
    }

    public static ProfileItemViewHolder create (LayoutInflater inflater, ViewGroup parent,
                                         ProfileItemViewModel viewModel) {
        ItemLesson12Binding binding = ItemLesson12Binding.inflate(inflater, parent, false);
        return new ProfileItemViewHolder(binding, viewModel);
    }
}
