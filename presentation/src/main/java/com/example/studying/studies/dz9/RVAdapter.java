package com.example.studying.studies.dz9;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.studying.studies.R;
import com.example.studying.studies.databinding.ItemRvDz9Binding;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.Holder> {

    private Context context;
    private ItemViewModel[] items;


    public RVAdapter (Context context, ItemViewModel[] items){
        this.context = context;
        this.items = items;
    }

    @Override
    public RVAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_dz9, parent, false);
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.binding.setItem(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }


    public static class Holder extends RecyclerView.ViewHolder{

        ItemRvDz9Binding binding;

        public Holder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    @BindingAdapter({"app:src"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }
}
