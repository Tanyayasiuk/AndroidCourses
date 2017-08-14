package com.example.studying.studies.lesson4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.studying.studies.R;

public class Lesson4Activity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4);

    }

    //анимация, когда возвращаешься назад
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }
}
