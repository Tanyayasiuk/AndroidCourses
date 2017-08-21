package com.example.studying.studies.lesson12;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.studying.domain.entity.ProfileModel;
import com.example.studying.studies.base.BaseAdapter;
import com.example.studying.studies.base.BaseItemViewHolder;
import com.example.studying.studies.databinding.ItemLesson12Binding;


public class ProfileAdapter extends BaseAdapter<ProfileModel, ProfileItemViewModel> {

    private Context context;
    public ProfileAdapter(Context context){
        this.context = context;
    }
    @Override
    public BaseItemViewHolder<ProfileModel, ProfileItemViewModel, ?> onCreateViewHolder(ViewGroup parent, int viewType) {
        ProfileItemViewModel viewModel = new ProfileItemViewModel();
        return ProfileItemViewHolder.create(LayoutInflater.from(context),
                parent, viewModel);

    }
}
