package com.example.studying.studies.dz11;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.studying.studies.R;
import com.example.studying.studies.base.BaseActivity;
import com.example.studying.studies.databinding.ActivityDz11Binding;


public class Dz11Activity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Dz11ViewModel viewModel = new Dz11ViewModel(this);
        this.viewModel = viewModel;

        ActivityDz11Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz11);
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }
}
