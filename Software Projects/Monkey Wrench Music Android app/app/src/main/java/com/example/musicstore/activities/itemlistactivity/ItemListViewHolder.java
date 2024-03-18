package com.example.musicstore.activities.itemlistactivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicstore.R;

/**
 * Viewholder for item list
 */
public class ItemListViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView nameView;
    TextView priceView;
    CardView cardView;

    /**
     * ItemListViewHolder class- sets each vies inside the viewholder
     * @param itemView
     */
    public ItemListViewHolder(@NonNull View itemView) {
        super(itemView);
        // set views
        imageView = itemView.findViewById(R.id.imageview);
        nameView = itemView.findViewById(R.id.name);
        priceView = itemView.findViewById(R.id.price);
        cardView = itemView.findViewById(R.id.itemCard);
    }
}
