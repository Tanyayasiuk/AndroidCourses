package com.example.studying.studies.dz5;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.TextView;


public class MyService extends Service {

    //public static final String MY_ACTION = "com.example.studying.studies.dz5.MY_ACTION";
    public static final String WIFI_ACTION = "android.net.wifi.STATE_CHANGE";


    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle extras = intent.getExtras();
            NetworkInfo info = (NetworkInfo) extras
                    .getParcelable("networkInfo");
            NetworkInfo.State state = info.getState();

            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(MyService.this);
            //Intent intentMy = new Intent(MY_ACTION);
            Intent intentWiFi = new Intent(WIFI_ACTION);


            if (state == NetworkInfo.State.CONNECTED) {
                Log.e("Hello", "Connected");
                intentWiFi.putExtra("MY_ACTION", "ON!");
                localBroadcastManager.sendBroadcast(intentWiFi);
            } else {
                Log.e("Hello", "Disconnected");
                intentWiFi.putExtra("MY_ACTION", "OFF!");
                localBroadcastManager.sendBroadcast(intentWiFi);
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("HI!", "onCreate");
        //Toast.makeText().....
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("HI!", "onBind");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, intentFilter);

        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("HI!", "onUnbind");
        unregisterReceiver(receiver);
        return super.onUnbind(intent);
    }


    @Override
    public void onDestroy() {
        Log.e("HI!", "onDestroy");
        super.onDestroy();
    }
}
