package com.example.musicstore.activities.mainactivity.categoryslider;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicstore.R;

/**
 * Viewholder for category list
 */
public class CategoriesViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView labelView;

    /**
     * Viewholder for items in the category list
     * @param itemView
     */
    public CategoriesViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.slider_image);
        labelView = itemView.findViewById(R.id.category_name);
    }
}
