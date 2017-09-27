package com.example.studying.studies.dz14;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;


import com.example.studying.studies.R;
import com.example.studying.studies.base.BaseActivity;
import com.example.studying.studies.databinding.ActivityDz14Binding;
import com.example.studying.studies.lesson14.Lesson14Activity;


public class Dz14Activity extends BaseActivity {

    public static void show(Activity activity){
        Intent intent = new Intent(activity, Lesson14Activity.class);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Dz14ViewModel viewModel = new Dz14ViewModel(this);
        this.viewModel = viewModel;

        final ActivityDz14Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz14);
        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("SSS", "OnPAUSE - main");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() ==  MotionEvent.ACTION_DOWN) hideKeyboard();
        return super.dispatchTouchEvent(ev);
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
}
