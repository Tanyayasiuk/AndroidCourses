package com.example.studying.studies.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseItemViewHolder
    <Model,
    ViewModel extends BaseItemViewModel<Model>,
    DataBinding extends ViewDataBinding>
        extends RecyclerView.ViewHolder{

    private DataBinding binding;
    private ViewModel viewModel;

    public BaseItemViewHolder(DataBinding binding, ViewModel viewModel) {
        super(binding.getRoot());
        this.binding = binding;
        this.viewModel = viewModel;
        viewModel.init();
    }

    public void bindTo(Model item, int position){
        viewModel.setItem(item, position);
        binding.executePendingBindings();
    }

    public void release(){
        viewModel.release();
    }
}
