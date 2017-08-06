package com.example.studying.studies.lesson6;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studying.studies.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder>{

    private ArrayList<String> items;
    public MyAdapter(ArrayList<String> items) {
        this.items = items;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        Log.e("AAA", "onCreateViewHolder");
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Log.e("AAA", "onBindViewHolder() position = " + position);

        String item = items.get(position);
        //holder.imageView - заполнить дома
        holder.textView.setText(item);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public Holder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
