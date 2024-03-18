package com.example.musicstore.activities.mainactivity;

import androidx.recyclerview.widget.RecyclerView;
import android.graphics.Rect;
import android.view.View;

/**
 * Sets the item offsets based on inputted parameters
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private final int spacing;
    private boolean alreadyAltered;

    /**
     * Creates space item decorations
     * @param spacing
     * @param altered
     */
    public SpaceItemDecoration(int spacing, boolean altered) {
        this.spacing = spacing;
        this.alreadyAltered = altered;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (!alreadyAltered) {
            outRect.left = spacing;
            outRect.right = spacing;
            outRect.bottom = spacing;
            outRect.top = 0;
        }
        else{}
    }
}
