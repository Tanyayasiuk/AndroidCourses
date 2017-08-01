package com.example.studying.studies.dz4;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.studying.studies.R;

public class BlinkOwlActivity extends Activity {

    Button start, stop;
    ImageView imageView;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blinkowl);

        start = (Button) findViewById(R.id.start_blink);
        stop = (Button) findViewById(R.id.stop_blink);

        imageView = (ImageView) findViewById(R.id.owl);
        imageView.setBackgroundResource(R.drawable.owlanimation);

        animationDrawable = (AnimationDrawable) imageView.getBackground();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationDrawable.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationDrawable.stop();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }
}
