/*
package com.example.studying.studies.dz16;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.studying.studies.R;
import com.example.studying.studies.base.BaseActivity;
import com.example.studying.studies.databinding.ActivityDz16Binding;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class Dz16Activity extends BaseActivity {

    Realm realm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Dz16ViewModel viewModel = new Dz16ViewModel(this);
        this.viewModel = viewModel;

        ActivityDz16Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz16);
        binding.setViewModel(viewModel);
        realm = Realm.getDefaultInstance();
        loadData();
        super.onCreate(savedInstanceState);
        Log.e("BBB", "DZ16 created");
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("BBB", "OnPAUSE - main");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("BBB", "OnDESTROY - main");
    }

    public void loadData(){
        // Запихать данные из rest'a в local db
    }
}
*/
