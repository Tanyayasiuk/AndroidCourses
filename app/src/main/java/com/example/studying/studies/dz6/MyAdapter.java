package com.example.studying.studies.dz6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.studying.studies.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder>{

    private ArrayList<String> urls;
    private ArrayList<String> items;
    private Context context;

    public MyAdapter(Context context, ArrayList<String> urls, ArrayList<String> items){
        this.context = context;
        this.items = items;
        this.urls = urls;
    }

    @Override
    public MyAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_dz6, parent, false);
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(MyAdapter.Holder holder, int position) {

        String item = items.get(position);
        holder.textView.setText(item);

        /*RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.progress_bar);*/
        Glide.with(context)
                .load(urls.get(position))
                //.apply(options)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }


    public static class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        ProgressBar progressBar;

        public Holder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.flag_image);
            textView = itemView.findViewById(R.id.country_name);
            progressBar = itemView.findViewById(R.id.progress_bar);
        }
    }
}
