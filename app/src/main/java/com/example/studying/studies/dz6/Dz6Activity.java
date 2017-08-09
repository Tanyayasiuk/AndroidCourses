package com.example.studying.studies.dz6;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.studying.studies.R;

import java.util.ArrayList;

public class Dz6Activity extends Activity {

    private RecyclerView recyclerView;
    private ArrayList<String> urls = new ArrayList<>();
    private ArrayList<String> countries = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz6);

        urls.add("http://ru.freeflagicons.com/download/?series=round_icon&country=australia&size=64");
        urls.add("http://ru.freeflagicons.com/download/?series=round_icon&country=austria&size=64");
        urls.add("http://ru.freeflagicons.com/download/?series=round_icon&country=azerbaijan&size=64");
        urls.add("http://ru.freeflagicons.com/download/?series=round_icon&country=albania&size=64");
        urls.add("http://ru.freeflagicons.com/download/?series=round_icon&country=algeria&size=64");
        urls.add("http://ru.freeflagicons.com/download/?series=round_icon&country=argentina&size=64");
        urls.add("http://ru.freeflagicons.com/download/?series=round_icon&country=armenia&size=64");
        urls.add("http://ru.freeflagicons.com/download/?series=round_icon&country=afghanistan&size=64");
        urls.add("http://ru.freeflagicons.com/download/?series=round_icon&country=bahamas&size=64");
        urls.add("http://ru.freeflagicons.com/download/?series=round_icon&country=bangladesh&size=64");
        urls.add("http://ru.freeflagicons.com/download/?series=round_icon&country=barbados&size=64");
        urls.add("http://ru.freeflagicons.com/download/?series=round_icon&country=bahrain&size=64");
        urls.add("http://ru.freeflagicons.com/download/?series=round_icon&country=belize&size=64");
        urls.add("http://ru.freeflagicons.com/download/?series=round_icon&country=belarus&size=64");
        urls.add("http://ru.freeflagicons.com/download/?series=round_icon&country=belgium&size=64");
        urls.add("http://ru.freeflagicons.com/download/?series=round_icon&country=benin&size=64");


        countries.add("Australia");
        countries.add("Austria");
        countries.add("Azerbaijan");
        countries.add("Albania");
        countries.add("Algeria");
        countries.add("Argentina");
        countries.add("Armenia");
        countries.add("Afghanistan");
        countries.add("Bahamas");
        countries.add("Bangladesh");
        countries.add("Barbados");
        countries.add("Bahrain");
        countries.add("Belize");
        countries.add("Belarus");
        countries.add("Belgium");
        countries.add("Benin");

        recyclerView = (RecyclerView)findViewById(R.id.rv_dz6);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Dz6Activity.this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        MyAdapter myAdapter = new MyAdapter(this, urls, countries);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item) {
                Log.e("GGG", "OnitemClick " + item);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

}
