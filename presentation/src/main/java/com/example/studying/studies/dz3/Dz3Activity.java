package com.example.studying.studies.dz3;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.example.studying.studies.BuildConfig;
import com.example.studying.studies.R;

public class Dz3Activity extends Activity {

    public static final String KEY_URL = "KEY_URL";

    private Button button;
    final String link = "http://minionomaniya.ru/wp-content/uploads/2015/09/-миньонов-e1441475723156.jpg";
    final String link2 = "https://goo.gl/oaZVyX";

    private TextView textLink;
    private TextView buildConfigText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz3);

        String url = getIntent().getStringExtra(KEY_URL);

        button = (Button) findViewById(R.id.button);

        textLink = (TextView) findViewById(R.id.editText);
        textLink.setText(url);

        buildConfigText = (TextView) findViewById(R.id.buildConfigText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                download(textLink.getText().toString());
                buildConfigText.setText(BuildConfig.API_ENDPOINT);
            }
        });

    }

    public void download(String url){
        ImageView myImageView = (ImageView) findViewById(R.id.myImageView);
        RequestOptions options = new RequestOptions();
        options.circleCrop();
        options.placeholder(R.drawable.ic_file_download_black_24dp);
        Glide.with(this).load(url).apply(options).into(myImageView);

    }
}
