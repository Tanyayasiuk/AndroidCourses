package com.example.studying.studies.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.studying.studies.R;
import com.example.studying.studies.dz2.Dz2Activity;
import com.example.studying.studies.dz3.Dz3Activity;
import com.example.studying.studies.dz4.Dz4Activity;
import com.example.studying.studies.dz5.Dz5Activity;
import com.example.studying.studies.lesson2.Lesson2Activity;

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
                //Задает анимацию смены активити
                overridePendingTransition(R.anim.right_in, R.anim.left_out);


            }
        });
    }


}
