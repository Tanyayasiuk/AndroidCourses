package com.example.studying.studies.dz7;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.studying.studies.R;
import com.example.studying.studies.databinding.ActivityDz7Binding;


public class Dz7Activity extends Activity {
    ImageView view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDz7Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz7);
        User user = new User("Ivan", "Ivanov", "28", "http://icons.iconarchive.com/icons/hopstarter/face-avatars/256/Male-Face-F5-icon.png", 'm');
        //User user = new User("Mary", "Ivanova", "28", "http://icons.iconarchive.com/icons/hopstarter/face-avatars/256/Female-Face-FH-3-slim-icon.png", 'f');

        binding.setActivity(this);
        binding.setUser(user);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

    @BindingAdapter({"android:src"})
    public static void loadImage(ImageView view, String imageUrl) {
        RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.progress_bar);
        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(options)
                .into(view);
    }
}
