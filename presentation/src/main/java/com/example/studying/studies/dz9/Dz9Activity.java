package com.example.studying.studies.dz9;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.studying.domain.entity.Country;
import com.example.studying.studies.R;
import com.example.studying.studies.base.BaseActivity;
import com.example.studying.studies.databinding.ActivityDz9Binding;


public class Dz9Activity extends BaseActivity {

    private Country country;
    private RecyclerView recyclerView;

    public static void show(Activity activity){
        Intent intent = new Intent(activity, Dz9Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Dz9ViewModel viewModel = new Dz9ViewModel(this);
        this.viewModel = viewModel;

        ActivityDz9Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz9);
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);

        recyclerView = (RecyclerView)findViewById(R.id.rv_dz9);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(Dz9Activity.this);
        recyclerView.setLayoutManager(gridLayoutManager);

        RVAdapter myAdapter = new RVAdapter(this);
        recyclerView.setAdapter(myAdapter);
        Log.e("DDDDDDD", "onCreateDZ9Activity");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }
}
