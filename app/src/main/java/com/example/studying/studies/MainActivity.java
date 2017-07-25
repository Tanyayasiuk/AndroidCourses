package com.example.studying.studies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{ //variant #1 for click

    private Button mixButton;
    private TextView text1;
    private TextView text2;

    //variant #2 for click
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mix();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mixButton = (Button) findViewById(R.id.mix_button);
        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);

        text1.setOnClickListener(listener);
        text2.setOnClickListener(this);

        //variant #3 for click
        mixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mix();
            }
        });
    }

    @Override
    public void onClick(View view) {
        mix();
    }

    public void mix(){
        String tempText = (String) text1.getText();
        text1.setText(text2.getText());
        text2.setText(tempText);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //Когда разворачивается приложение
    @Override
    protected void onStart() {
        super.onStart();
    }

    //Запускается, когда сворачивается приложение
    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
