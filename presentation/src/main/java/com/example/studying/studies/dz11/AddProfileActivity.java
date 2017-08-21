package com.example.studying.studies.dz11;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.studying.studies.R;
import com.example.studying.studies.base.BaseActivity;
import com.example.studying.studies.databinding.ActivityAddProfileBinding;


public class AddProfileActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        AddProfileViewModel addProfileViewModel = new AddProfileViewModel(this);
        this.viewModel = addProfileViewModel;

        ActivityAddProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_profile);
        binding.setAddView(addProfileViewModel);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        Log.e("CCC", "onPAUSE");
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
        Log.e("CCC", "Starting main activity");
        startActivity(new Intent(this, Dz11Activity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
