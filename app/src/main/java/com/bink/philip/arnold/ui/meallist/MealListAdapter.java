package com.bink.philip.arnold.ui.meallist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bink.philip.arnold.MainActivityInterface;
import com.bink.philip.arnold.R;
import com.bink.philip.arnold.model.Meals;

public class MealListAdapter extends RecyclerView.Adapter<MealListHolder> {
    private Meals mealList;
    private MainActivityInterface mainActivityInterface;

    MealListAdapter(Meals mealList, MainActivityInterface mainActivityInterface) {
        this.mealList = mealList;
        this.mainActivityInterface = mainActivityInterface;
    }

    @NonNull
    @Override
    public MealListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MealListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recycler, parent, false), mainActivityInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MealListHolder holder, int position) {
        holder.bind(mealList.meals.get(position));
    }

    @Override
    public int getItemCount() {
        return mealList.meals.size();
    }

    void resetData(Meals mealList) {
        this.mealList = mealList;
        notifyDataSetChanged();
    }
}
