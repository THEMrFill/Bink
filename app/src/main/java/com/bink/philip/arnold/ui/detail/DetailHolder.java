package com.bink.philip.arnold.ui.detail;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bink.philip.arnold.R;
import com.bink.philip.arnold.model.Ingredient;

class DetailHolder extends RecyclerView.ViewHolder {
    private TextView ingredient;
    private TextView measure;

    DetailHolder(@NonNull View itemView) {
        super(itemView);
        ingredient = itemView.findViewById(R.id.ingredient);
        measure = itemView.findViewById(R.id.measure);
    }

    void bind(Ingredient item) {
        ingredient.setText(item.ingredient);
        measure.setText(item.measure);
    }
}
