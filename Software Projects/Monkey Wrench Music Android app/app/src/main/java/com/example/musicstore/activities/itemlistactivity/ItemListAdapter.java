package com.example.musicstore.activities.itemlistactivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Scene;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicstore.R;
import com.example.musicstore.activities.expandeditemactivity.ExpandedItemActivity;
import com.example.musicstore.activities.mainactivity.SearchFragment;
import com.example.musicstore.items.Item;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

/**
 * Item List Adapter class
 */
public class ItemListAdapter extends RecyclerView.Adapter<ItemListViewHolder>{
    private final Fragment fragment;
    Context context;
    List<Item> items;

    /**
     * The adapter that is responsible for holding the items within their category/ subcategory.
     * @param context application context
     * @param items the items to be added to the list
     */
    public ItemListAdapter(Context context, List<Item> items, Fragment fragment) {
        this.context = context;
        this.items = items;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    /**
     * Stores the individual item views within a list
     */
    public ItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemListViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_view, parent, false));
    }

    @Override
    /**
     * Binds data to view to be displayed
     */
    public void onBindViewHolder(@NonNull ItemListViewHolder holder, int position) {
        Item itemToBePassed = items.get(position);
        // set views
        holder.nameView.setText(itemToBePassed.getName());
        holder.imageView.setImageResource(itemToBePassed.getImagesList().get(0)); // get first image from list
        holder.priceView.setText(itemToBePassed.getPrice());
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(context,R.anim.recycler_anim));

        // if the item is pressed, then go to expanded item view of passed in item
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ExpandedItemActivity.class);
            // pass the entire item object into new activity
            intent.putExtra("item", itemToBePassed);
            // if the current fragment is cart or wishlist, then disable back button in expanded item fragment
            String fragmentName = fragment.getClass().getSimpleName();
            intent.putExtra("fragmentName",fragmentName);
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        });
    }

    @Override
    /**
     * Returns the number of items in the list
     */
    public int getItemCount() {return items.size();}

}
