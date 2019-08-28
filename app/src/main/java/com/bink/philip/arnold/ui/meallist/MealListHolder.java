package com.bink.philip.arnold.ui.meallist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bink.philip.arnold.MainActivityInterface;
import com.bink.philip.arnold.R;
import com.bink.philip.arnold.model.MealItem;
import com.bumptech.glide.Glide;

class MealListHolder extends RecyclerView.ViewHolder {
    private MainActivityInterface mainActivityInterface;
    private ViewGroup outer;
    private ImageView imageView;
    private TextView title;

    MealListHolder(@NonNull View itemView, MainActivityInterface mainActivityInterface) {
        super(itemView);
        outer = itemView.findViewById(R.id.outer);
        imageView = itemView.findViewById(R.id.imageView);
        title = itemView.findViewById(R.id.title);
        this.mainActivityInterface = mainActivityInterface;
    }

    void bind(final MealItem mealItem) {
        title.setText(mealItem.strMeal);
        Glide.with(imageView)
                .load(mealItem.strMealThumb)
                .into(imageView);
        outer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityInterface.pushMeal(mealItem.idMeal);
            }
        });
    }

}
