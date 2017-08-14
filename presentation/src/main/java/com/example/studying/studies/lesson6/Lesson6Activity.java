package com.example.studying.studies.lesson6;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.studying.studies.R;

import java.util.ArrayList;


public class Lesson6Activity extends Activity {

    private RecyclerView recyclerView;
    private ArrayList<String> stringArrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson6);

        stringArrayList.add("Item 1");
        stringArrayList.add("Item 2");
        stringArrayList.add("Item 3");
        stringArrayList.add("Item 4");
        stringArrayList.add("Item 5");
        stringArrayList.add("Item 6");
        stringArrayList.add("Item 7");
        stringArrayList.add("Item 8");
        stringArrayList.add("Item 9");
        stringArrayList.add("Item 10");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MyAdapter myAdapter = new MyAdapter(stringArrayList);
        recyclerView.setAdapter(myAdapter);

    }
}
