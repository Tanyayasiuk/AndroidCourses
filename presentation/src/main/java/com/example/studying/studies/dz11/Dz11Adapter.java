package com.example.studying.studies.dz11;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studying.studies.R;
import com.example.studying.studies.databinding.ItemRv11Binding;
import com.example.studying.studies.main.MainActivity;

import java.util.List;


public class Dz11Adapter extends RecyclerView.Adapter<Dz11Adapter.Holder> {

    private Context context;
    private List<ItemViewModel> itemsList;

    public Dz11Adapter (Context context, List<ItemViewModel> itemsList){
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_11, parent, false);
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.binding.setItem(itemsList.get(position));
        final String id = itemsList.get(position).id;
        //int age = itemsList.get(position).age;
        Log.e("AAAAAA", "Id " + id);
        //Log.e("AAAAAA", "AGE =  " + age);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditProfileActivity.class);
                intent.putExtra("ID", id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    public static class Holder extends RecyclerView.ViewHolder{

        ItemRv11Binding binding;

        public Holder(final View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }
    }
}
