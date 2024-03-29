package com.bink.philip.arnold.ui.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bink.philip.arnold.MainActivityInterface;
import com.bink.philip.arnold.R;
import com.bink.philip.arnold.model.Category;
import com.bumptech.glide.Glide;

class MainViewHolder extends RecyclerView.ViewHolder {
    private MainActivityInterface mainActivityInterface;
    private ViewGroup outer;
    private ImageView imageView;
    private TextView title;

    MainViewHolder(@NonNull View itemView, MainActivityInterface mainActivityInterface) {
        super(itemView);
        outer = itemView.findViewById(R.id.outer);
        imageView = itemView.findViewById(R.id.imageView);
        title = itemView.findViewById(R.id.title);
        this.mainActivityInterface = mainActivityInterface;
    }

    void bind(final Category category) {
        title.setText(category.strCategory);
        Glide.with(imageView)
            .load(category.strCategoryThumb)
            .into(imageView);
        outer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityInterface.pushCategory(category.strCategory);
            }
        });
    }
}
