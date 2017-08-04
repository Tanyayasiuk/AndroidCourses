package com.example.studying.studies.lesson5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.studying.studies.R;


public class Lesson5Activity extends Activity {

    private TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5);

        Intent intent = new Intent(Lesson5Activity.this, MyIntentService.class);
        intent.putExtra(MyIntentService.KEY_ACTION, "Task 0");
        startService(intent);

        Intent intent2 = new Intent(Lesson5Activity.this, MyIntentService.class);
        intent2.putExtra(MyIntentService.KEY_ACTION, "Task 1");
        startService(intent2);

        Intent intent3 = new Intent(Lesson5Activity.this, MyIntentService.class);
        intent3.putExtra(MyIntentService.KEY_ACTION, "Task 2");
        startService(intent3);


        textView = (TextView) findViewById(R.id.message);

        startService(new Intent(this, MyService.class));

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(Lesson5Activity.this, MyService.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(MyIntentService.MY_ACTION);
        registerReceiver(receiver, intentFilter);

        Intent intent = new Intent(Lesson5Activity.this, MyService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
        unbindService(serviceConnection);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e("AAA", "onServiceConnected()");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("BBB", "OnserviceDisconnected()");
        }
    };

    private BroadcastReceiver receiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {

            /*Bundle extras = intent.getExtras();

            NetworkInfo info = (NetworkInfo) extras
                    .getParcelable("networkInfo");

            NetworkInfo.State state = info.getState();


            if (state == NetworkInfo.State.CONNECTED) {
                textView.setText("Internet is ON");
            } else {
                textView.setText("Internet is OFF");
            }*/
            textView.setText("onReceive");

        }
    };
}
