package com.example.studying.studies.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.studying.studies.R;
import com.example.studying.studies.dz10.Dz10Activity;
import com.example.studying.studies.dz11.Dz11Activity;
import com.example.studying.studies.dz14.Dz14Activity;
//import com.example.studying.studies.dz16.Dz16Activity;
import com.example.studying.studies.dz2.Dz2Activity;
import com.example.studying.studies.dz3.Dz3Activity;
import com.example.studying.studies.dz4.Dz4Activity;
import com.example.studying.studies.dz5.Dz5Activity;
import com.example.studying.studies.dz6.Dz6Activity;
import com.example.studying.studies.dz7.Dz7Activity;
import com.example.studying.studies.dz7_1.Dz7_1Activity;
import com.example.studying.studies.dz9.Dz9Activity;
import com.example.studying.studies.lesson12.Lesson12Activity;
import com.example.studying.studies.lesson13.Lesson13Activity;
import com.example.studying.studies.lesson14.Lesson14Activity;
import com.example.studying.studies.lesson16.Lesson16Activity;
import com.example.studying.studies.lesson18.Lesson18Activity;
import com.example.studying.studies.lesson2.Lesson2Activity;
import com.example.studying.studies.lesson22.MapsActivity;
import com.example.studying.studies.lesson8.Lesson8Activity;
import com.example.studying.studies.lesson9.Lesson9Activity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // подключаем лэйаут


        Button dz1Button = findViewById(R.id.dz1Button);
        dz1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Намерение. Объект который для нас что-то сделает
                Intent intent = new Intent(MainActivity.this, Lesson2Activity.class);
                startActivity(intent);
            }
        });

        Button dz2Button = findViewById(R.id.dz2Button);
        dz2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Dz2Activity.class);
                startActivity(intent);
            }
        });

        Button dz3Button = findViewById(R.id.dz3Button);
        dz3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Dz3Activity.class);
                startActivity(intent);
            }
        });

        Button dz4Button = findViewById(R.id.dz4Button);
        dz4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Dz4Activity.class);
                startActivity(intent);
                //Задает анимацию смены активити
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        Button dz5Button = findViewById(R.id.dz5Button);
        dz5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Dz5Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        Button dz6Button = findViewById(R.id.dz6Button);
        dz6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Dz6Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        Button dz7Button = findViewById(R.id.dz7Button);
        dz7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Dz7Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        Button dz71Button = findViewById(R.id.dz71Button);
        dz71Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Dz7_1Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        Button dz8Button = findViewById(R.id.dz8Button);
        dz8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent = new Intent(MainActivity.this, Lesson9Activity.class);
/*                startActivity(intent);
                */
               /* Lesson9Activity.show(MainActivity.this);*/
                Intent intent = new Intent(MainActivity.this, Dz9Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        Button l9Button = findViewById(R.id.l9Button);
        l9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent = new Intent(MainActivity.this, Lesson9Activity.class);
/*                startActivity(intent);
                */
               /* Lesson9Activity.show(MainActivity.this);*/
                Intent intent = new Intent(MainActivity.this, Lesson9Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        Button dz10Button = findViewById(R.id.dz10Button);
        dz10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Dz10Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        Button dz11Button = findViewById(R.id.dz11Button);
        dz11Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Dz11Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        Button l12Button = findViewById(R.id.l12Button);
        l12Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Lesson12Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        Button l13Button = findViewById(R.id.l13Button);
        l13Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Lesson13Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        Button l14Button = findViewById(R.id.l14Button);
        l14Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Lesson14Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        Button dz14Button = findViewById(R.id.dz14Button);
        dz14Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Dz14Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        Button l16Button = findViewById(R.id.l16Button);
        l16Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Lesson16Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        /*Button dz16Button = findViewById(R.id.dz16Button);
        dz16Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Dz16Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });*/

        /*Button l18Button = findViewById(R.id.l18Button);
        l18Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Lesson18Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });
*/
        Button mapButton = findViewById(R.id.l18Button);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });
    }


}
