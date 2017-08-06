package com.example.studying.studies.dz5;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.TextView;

import com.example.studying.studies.R;


public class Dz5Activity extends Activity{

    private TextView textView;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz5);

        textView = (TextView) findViewById(R.id.OnOff);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MyService.MY_ACTION);
        intentFilter.addAction(MyService.WIFI_ACTION);
        localBroadcastManager.registerReceiver(receiver, intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(serviceConnection);
        localBroadcastManager.unregisterReceiver(receiver);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e("AAA", "onServiceConnected()");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("BBB", "OnServiceDisconnected()");
        }
    };

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            WifiManager wifi = (WifiManager)context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            if (wifi.isWifiEnabled()){
                textView.setText(R.string.dz5On);
            } else
                textView.setText(R.string.dz5Off);


        }
    };
}
