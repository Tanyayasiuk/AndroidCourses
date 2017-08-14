package com.example.studying.studies.dz7_1;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.studying.studies.R;
import com.example.studying.studies.databinding.ItemRvDz7Binding;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder> {

    private Context context;


    public RecyclerViewAdapter(Context context){
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_dz7, parent, false);
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.Holder holder, int position) {
        User item = User.ITEMS[position];
        holder.binding.setUser(item);
    }

    @Override
    public int getItemCount() {
        return User.ITEMS.length;
    }

    public static class Holder extends RecyclerView.ViewHolder{

        ItemRvDz7Binding binding;

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

