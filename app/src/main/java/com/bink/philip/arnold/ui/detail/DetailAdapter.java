package com.bink.philip.arnold.ui.detail;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bink.philip.arnold.R;
import com.bink.philip.arnold.model.Ingredient;

import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<DetailHolder> {
    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    @NonNull
    @Override
    public DetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DetailHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailHolder holder, int position) {
        holder.bind(ingredients.get(position));
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    void resetData(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
        notifyDataSetChanged();
    }
}
