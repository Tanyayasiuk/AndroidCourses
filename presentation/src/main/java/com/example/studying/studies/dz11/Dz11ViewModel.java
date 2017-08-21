package com.example.studying.studies.dz11;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.studying.domain.entity.ProfileModel;
import com.example.studying.domain.interacton.ProfilesListUseCase;
import com.example.studying.studies.R;
import com.example.studying.studies.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

import static com.example.studying.studies.dz11.Dz11ViewModel.STATE.DATA;

public class Dz11ViewModel implements BaseViewModel {

    private Activity activity;
    public Dz11ViewModel(Activity activity){
        this.activity = activity;
    }
    public List<ProfileModel> profiles;
    private ProfilesListUseCase useCase = new ProfilesListUseCase();
    private List<ItemViewModel> itemsList = new ArrayList<>();

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    @Override
    public void init() {}

    @Override
    public void release() {}

    @Override
    public void resume() {
        final RecyclerView recyclerView = (RecyclerView)activity.findViewById(R.id.rv_dz11);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(manager);

        FloatingActionButton fab = (FloatingActionButton) activity.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity, AddProfileActivity.class));
            }
        });

        useCase.execute(null, new DisposableObserver<List<ProfileModel>>() {
            @Override
            public void onNext(@NonNull List<ProfileModel> profileModels) {
                profiles = profileModels;
                itemsList = new ArrayList<>(profiles.size());
                for(int i = 0; i < profiles.size(); i++) {
                    itemsList.add(new ItemViewModel(profiles.get(i).getFirstName(),
                            profiles.get(i).getLastName(), profiles.get(i).getAge(),
                            profiles.get(i).getId()));
                }
                Dz11Adapter adapter = new Dz11Adapter(activity, itemsList);
                recyclerView.setAdapter(adapter);
                state.set(DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAAAAA", "Error: " + e);
            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void pause() {
        useCase.dispose();
    }




}
