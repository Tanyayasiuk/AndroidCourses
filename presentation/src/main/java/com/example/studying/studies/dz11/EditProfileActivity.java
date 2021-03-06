package com.example.studying.studies.dz11;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.studying.studies.R;
import com.example.studying.studies.base.BaseActivity;
import com.example.studying.studies.databinding.ActivityEditVmBinding;

public class EditProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Bundle extras = getIntent().getExtras();
        String id = extras.getString("ID");

        EditProfileViewModel viewModel = new EditProfileViewModel(this, id);
        this.viewModel = viewModel;

        ActivityEditVmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_vm);
        binding.setEditItem(viewModel);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
        startActivity(new Intent(this, Dz11Activity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
