/*
package com.example.studying.studies.dz16;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.studying.domain.entity.ProfileModel;
import com.example.studying.domain.interacton.ProfilesListUseCase;
import com.example.studying.studies.R;
import com.example.studying.studies.base.BaseViewModel;
import com.example.studying.studies.dz11.AddProfileActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.realm.Realm;

import static com.example.studying.studies.dz16.Dz16ViewModel.STATE.DATA;

public class Dz16ViewModel implements BaseViewModel {

    private Activity activity;
    public Dz16ViewModel(Activity activity){
        this.activity = activity;
    }
    public List<ProfileModel> profiles;
    private ProfilesListUseCase useCase = new ProfilesListUseCase();
    private List<ItemViewModel> itemsList = new ArrayList<>();

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private Realm realm;


    @Override
    public void init() {}

    @Override
    public void release() {}

    @Override
    public void resume() {
        final RecyclerView recyclerView = (RecyclerView)activity.findViewById(R.id.rv_dz16);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(manager);

        realm = Realm.getDefaultInstance();

        FloatingActionButton fab = (FloatingActionButton) activity.findViewById(R.id.fab16);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity, AddProfileActivity.class));
            }
        });

        useCase.execute(activity, new DisposableObserver<List<ProfileModel>>() {
            @Override
            public void onNext(@NonNull List<ProfileModel> profileModels) {
                profiles = profileModels;
                itemsList = new ArrayList<>(profiles.size());
                for(int i = 0; i < profiles.size(); i++) {
                    itemsList.add(new ItemViewModel(profiles.get(i).getFirstName(),
                            profiles.get(i).getLastName(), profiles.get(i).getAge(),
                            profiles.get(i).getId()));
                }
                Dz16Adapter adapter = new Dz16Adapter(activity, itemsList);
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
*/
