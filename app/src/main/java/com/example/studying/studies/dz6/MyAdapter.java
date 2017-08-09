package com.example.studying.studies.dz6;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.studying.studies.R;

import java.util.ArrayList;

import static android.view.View.GONE;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder>{

    private ArrayList<String> urls;
    private ArrayList<String> items;
    private Context context;

    private OnItemClickListener listener;

    public MyAdapter(Context context, ArrayList<String> urls, ArrayList<String> items){
        this.context = context;
        this.items = items;
        this.urls = urls;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public MyAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_dz6, parent, false);
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(final MyAdapter.Holder holder, int position) {

        final String item = items.get(position);
        holder.textView.setText(item);

        /*RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.progress_bar);*/
        Glide.with(context)
                .load(urls.get(position))
                //.apply(options)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(holder.imageView);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null)
                    listener.onItemClick(item);
            }
        });
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

    interface OnItemClickListener{
        public void onItemClick(String item);
    }
}
