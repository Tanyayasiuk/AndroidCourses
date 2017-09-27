/*
package com.example.studying.studies.dz16;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studying.studies.R;
import com.example.studying.studies.databinding.ItemRv16Binding;
import com.example.studying.studies.dz16.ItemViewModel;

import java.util.List;


public class Dz16Adapter extends RecyclerView.Adapter<Dz16Adapter.Holder> {

    private Context context;
    private List<ItemViewModel> itemsList;

    public Dz16Adapter(Context context, List<ItemViewModel> itemsList){
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rv_16, parent, false);
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.binding.setItem(itemsList.get(position));
        final String id = itemsList.get(position).id;
        Log.e("AAAAAA", "Id " + id);

        */
/*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditProfileActivity.class);
                intent.putExtra("ID", id);
                context.startActivity(intent);

            }
        });*//*

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }


    public static class Holder extends RecyclerView.ViewHolder{

        ItemRv16Binding binding;

        public Holder(final View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }
    }
}
*/
