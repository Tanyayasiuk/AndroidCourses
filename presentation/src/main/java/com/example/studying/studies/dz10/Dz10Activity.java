package com.example.studying.studies.dz10;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.example.studying.studies.R;
import com.example.studying.studies.base.BaseActivity;
import com.example.studying.studies.databinding.ActivityDz10Binding;


public class Dz10Activity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Dz10ViewModel viewModel = new Dz10ViewModel(this);
        this.viewModel = viewModel;

        ActivityDz10Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz10);
        binding.setDz10viewModel(viewModel);
        super.onCreate(savedInstanceState);
    }
}
