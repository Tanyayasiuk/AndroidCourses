package com.example.studying.studies.dz4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.format.Time;
import android.widget.TextView;

import com.example.studying.studies.R;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class ClockActivity extends Activity {

    Time mTime;
    Calendar calendar;
    Runnable r;
    Handler handler;
    TextView text;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        calendar = new GregorianCalendar();
        //deprecated, конечно, но почему-то только с ним секунды тикают
        mTime = new Time();

        r = new Runnable() {
            @Override
            public void run() {
                mTime.setToNow();
                calendar.getInstance();

                ClockView cv = new ClockView(ClockActivity.this,
                        calendar.get(Calendar.HOUR),
                        calendar.get(Calendar.MINUTE),
                        mTime.second);
                setContentView(cv);
                handler.postDelayed(r, 1000);
            }
        };

        handler = new Handler();
        handler.postDelayed(r, 100);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
