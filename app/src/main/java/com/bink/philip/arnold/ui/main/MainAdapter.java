package com.bink.philip.arnold.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bink.philip.arnold.R;
import com.bink.philip.arnold.model.Categories;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {
    private Categories categories;

    public MainAdapter(Categories categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.bind(categories.categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.categories.size();
    }

    public void resetData(Categories categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }
}
