package com.example.musicstore.activities.mainactivity.categoryslider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicstore.R;
import com.example.musicstore.activities.itemlistactivity.ItemListActivity;

import java.util.List;

/**
 * Category list adapter, contains all our categories- Pianos, Guitars, Audio and all Items.
 */
public class CategoryListAdapter extends RecyclerView.Adapter<CategoriesViewHolder> {
    Context context;
    Bundle bundle;
    List<Integer> images;
    List<String> labels;

    public CategoryListAdapter(Context context, List<Integer> images, List<String> labels){
        this.context = context;
        this.images = images;
        this.labels = labels;
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoriesViewHolder(LayoutInflater.from(context).inflate(R.layout.categories_slider, parent, false));
    }


    @Override
    /**
     * Binds data to view to be displayed and starts the relevant activity depending on what item
     * is clicked.
     */
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        Integer currentImage = images.get(position);
        String currentLabel = labels.get(position);
        holder.labelView.setText(currentLabel);
        holder.imageView.setImageResource(currentImage);

        // if the item is pressed, then go to expanded item view- item instance in
        holder.itemView.setOnClickListener(v -> {
            switch (position) {
                case 0:
                    // Handle click for the first image
                    Intent intent1 = new Intent(context, ItemListActivity.class);
                    intent1.putExtra("category", "Pianos");
                    context.startActivity(intent1);
                    ((Activity) context).overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                    break;
                case 1:
                    // Handle click for the second image
                    Intent intent2 = new Intent(context, ItemListActivity.class);
                    intent2.putExtra("category", "Guitars");
                    context.startActivity(intent2);
                    ((Activity) context).overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                    break;
                case 2:
                    // Handle click for the third image
                    Intent intent3 = new Intent(context, ItemListActivity.class);
                    intent3.putExtra("category","Audio");
                    context.startActivity(intent3);
                    ((Activity) context).overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                    break;
                case 3:
                    // Handle click for the fourth image
                    Intent intent4 = new Intent(context, ItemListActivity.class);
                    intent4.putExtra("category","All Items");
                    context.startActivity(intent4);
                    ((Activity) context).overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                    break;
            }
        });
    }
}