package com.bink.philip.arnold.ui.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bink.philip.arnold.R;
import com.bink.philip.arnold.model.Category;
import com.bumptech.glide.Glide;

public class MainViewHolder extends RecyclerView.ViewHolder {
    ViewGroup outer;
    ImageView imageView;
    TextView title;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        outer = itemView.findViewById(R.id.outer);
        imageView = itemView.findViewById(R.id.imageView);
        title = itemView.findViewById(R.id.title);
    }

    void bind(Category category) {
        title.setText(category.strCategory);
        Glide.with(imageView)
            .load(category.strCategoryThumb)
            .into(imageView);
    }
}
