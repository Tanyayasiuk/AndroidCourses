package com.example.studying.studies.lesson2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.studying.studies.R;
import com.example.studying.studies.dz1.Dz1Activity;

public class Lesson2Activity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);

        final EditText username = (EditText) findViewById(R.id.usernameText);
        final EditText password = (EditText) findViewById(R.id.passwordText);
        Button loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson2Activity.this, Dz1Activity.class);

                intent.putExtra(Dz1Activity.KEY_USERNAME, username.getText().toString());
                intent.putExtra(Dz1Activity.KEY_PASSWORD, password.getText().toString());

                startActivity(intent);
            }
        });


    }
}
