package com.example.studying.studies.dz9;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.studying.domain.entity.Country;

import com.example.studying.domain.interacton.CountryUseCase;
import com.example.studying.studies.R;
import com.example.studying.studies.base.BaseViewModel;


public class Dz9ViewModel implements BaseViewModel {

    public Activity activity;

    public Dz9ViewModel(Activity activity){
        this.activity = activity;
    }
    public Country[] countries;
    private CountryUseCase useCase = new CountryUseCase();
    public ItemViewModel[] items;

    @Override
    public void init() {
        Log.e("AAA", "init ViewModel");
    }

    @Override
    public void release() {
    }

    @Override
    public void resume() {
        RecyclerView recyclerView = (RecyclerView) activity.findViewById(R.id.rv_dz9);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        /*countries = useCase.execute(null);
        items = new ItemViewModel[countries.length];
        for (int i=0; i<countries.length; i++) {
            String picture = countries[i].getUrl();
            String name = countries[i].getName();
            items[i] = new ItemViewModel(name, picture);
        }
*/
        RVAdapter myAdapter = new RVAdapter(recyclerView.getContext(), items);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void pause() {
    }
}
