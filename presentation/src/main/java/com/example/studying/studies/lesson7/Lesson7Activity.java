package com.example.studying.studies.lesson7;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.studying.studies.R;
import com.example.studying.studies.databinding.ActivityLesson7Binding;
import com.example.studying.studies.dz7.User;


public class Lesson7Activity extends Activity {

    public ObservableField<String> myText = new ObservableField<>("It works!");
    private Thread thread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLesson7Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson7);
        User user = new User("Ivan", "Ivanov", "28", "http://www.iconarchive.com/show/oxygen-icons-by-oxygen-icons.org/Emotes-face-smile-big-icon.html", 'm');
        //возможность ссылаться на активити в xml
        binding.setActivity(this);

        //Можно и  так обращаться ко вью
        //binding.superTextView.setText("Hi there!");
   }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

   /* @Override
    protected void onResume() {
        super.onResume();
    }*/

    @Override
    protected void onPause() {
        super.onPause();
    }
}
