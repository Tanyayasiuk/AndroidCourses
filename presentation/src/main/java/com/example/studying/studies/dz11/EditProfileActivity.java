package com.example.studying.studies.dz11;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.studying.studies.R;
import com.example.studying.studies.base.BaseActivity;
import com.example.studying.studies.databinding.ActivityEditVmBinding;

public class EditProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Bundle extras = getIntent().getExtras();
        String id = extras.getString("ID");
        Log.e("AAAAAA", "ID got = " + id);

        EditProfileViewModel viewModel = new EditProfileViewModel(this, id);
        this.viewModel = viewModel;

        ActivityEditVmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_vm);
        binding.setEditItem(viewModel);
        super.onCreate(savedInstanceState);



    }


}
