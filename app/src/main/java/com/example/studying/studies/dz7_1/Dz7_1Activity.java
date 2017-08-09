package com.example.studying.studies.dz7_1;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.studying.studies.R;
import com.example.studying.studies.databinding.ActivityDz71Binding;

import java.util.ArrayList;


public class Dz7_1Activity extends Activity {
    ImageView imageView;
    private RecyclerView recyclerView;
    private ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityDz71Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz7_1);
        setContentView(R.layout.activity_dz7_1);
        //binding.setActivity(this);

        recyclerView = (RecyclerView)findViewById(R.id.rv_dz7);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(Dz7_1Activity.this);
        recyclerView.setLayoutManager(gridLayoutManager);

        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(myAdapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }
}
