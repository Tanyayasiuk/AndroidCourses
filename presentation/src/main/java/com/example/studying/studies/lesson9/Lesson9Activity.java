package com.example.studying.studies.lesson9;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.studying.studies.R;
import com.example.studying.studies.base.BaseActivity;
import com.example.studying.studies.databinding.ActivityLesson9Binding;


public class Lesson9Activity extends BaseActivity {

    public static void show(Activity activity){
        Intent intent = new Intent(activity, Lesson9Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Lesson9ViewModel viewModel = new Lesson9ViewModel(this);
        this.viewModel = viewModel;

        ActivityLesson9Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson9);
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);
        Log.e("AAAAAA", "create activity");
    }
}
