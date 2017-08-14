package com.example.studying.studies.lesson8;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.studying.studies.R;
import com.example.studying.studies.databinding.ActivityLesson8Binding;

import com.example.studying.studies.base.BaseActivity;

public class Lesson8Activity extends BaseActivity {

    //метод для перехода к этой активити из другой (вызывается Lesson8Activity.show(this <- активити, в которой мы находимся);)
    public static void show(Activity activity){
        Intent intent = new Intent(activity, Lesson8Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Lesson8ViewModel viewModel = new Lesson8ViewModel(this);
        this.viewModel = viewModel;

        ActivityLesson8Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson8);
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);
    }
}
