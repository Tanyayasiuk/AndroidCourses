package com.example.studying.studies.dz9;

import android.app.Activity;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.studying.domain.entity.Country;
import com.example.studying.domain.interacton.CountryUseCase;
import com.example.studying.studies.R;
import com.example.studying.studies.databinding.ItemRvDz9Binding;
import com.example.studying.studies.main.MainActivity;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.Holder> {

    private Context context;
    private Dz9ViewModel viewModel;


    public RVAdapter (Context context){this.context = context;}

    @Override
    public RVAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_dz9, parent, false);
        Log.e("AAAAAA", "onCreateViewHolder");
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        //Country item = CountryUseCase.ITEMS[position];
        holder.binding.setViewModel(viewModel);
        Log.e("AAAAAA", "onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return 2;
    }


    public static class Holder extends RecyclerView.ViewHolder{

        ItemRvDz9Binding binding;

        public Holder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    @BindingAdapter({"android:src"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }
}
