package com.example.musicstore.activities.mainactivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.musicstore.R;
import com.example.musicstore.activities.itemlistactivity.ItemListAdapter;
import com.example.musicstore.activities.mainactivity.categoryslider.CategoryListAdapter;
import com.example.musicstore.database.Dataprovider;
import com.example.musicstore.items.Item;

import java.util.ArrayList;

/**
 * Fragment that contains our landing view; with top selling, recently viewed, category slider
 */
public class HomeFragment extends Fragment {
    private static boolean alreadyAltered = false;

    public HomeFragment() {
        alreadyAltered = false;
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Check for clicks and add to recently clicked list
        Dataprovider.checkClicks();
        // set views
        createTopSellingSlider(view);
        createCategorySlider(view);
        createRecentlyViewed(view);// to be updated dynamically with app usage
        alreadyAltered = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        Dataprovider.checkClicks();
        createTopSellingSlider(getView());
        createCategorySlider(getView());
        createRecentlyViewed(getView()); // Update the recently viewed list dynamically when the fragment resumes
    }

    /**
     * Creates recently viewed recycler view and populates it accordingly.
     * @param view
     */
    private void createRecentlyViewed(View view) {
        TextView top_selling = view.findViewById(R.id.recently_viewed_text);
        TextView noItemsPrompt = view.findViewById(R.id.noItemsPrompt);
        top_selling.setText("Recently Viewed");
        RecyclerView recentlyViewedList = view.findViewById(R.id.recently_viewed_list);
        // Padding between items
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing_medium);
        recentlyViewedList.addItemDecoration(new SpaceItemDecoration(spacingInPixels, alreadyAltered));
        // initialise recently viewed list
        ArrayList<Item> viewedList = Dataprovider.createRecentlyViewedList();
        if(viewedList.size() == 0) {
            // if the list is empty, need a placeholder
            noItemsPrompt.setVisibility(View.VISIBLE);
            noItemsPrompt.setText("You'll find your recently viewed items here!");

        } else {
            noItemsPrompt.setVisibility(View.INVISIBLE);
            recentlyViewedList.setLayoutManager(new GridLayoutManager(getContext(),2));
            recentlyViewedList.setHasFixedSize(true);
            recentlyViewedList.setDrawingCacheEnabled(true);
            recentlyViewedList.setAdapter(new ItemListAdapter(getContext(), viewedList, this));
        }
    }

    /**
     * Creates top selling recycler view and populates it accordingly.
     * @param view
     */
    private void createTopSellingSlider(View view) {
        // create list of category images for viewPager
        RecyclerView topSellingList = view.findViewById(R.id.top_slider);
        // Padding between items
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing_small);
        topSellingList.addItemDecoration(new SpaceItemDecoration(spacingInPixels,alreadyAltered));

        ArrayList<Item> topList = Dataprovider.createTopSellingList();

        topSellingList.setLayoutManager(new GridLayoutManager(getContext(),3));
        topSellingList.setHasFixedSize(true);
        topSellingList.setDrawingCacheEnabled(true);
        topSellingList.setAdapter(new ItemListAdapter(getContext(), topList, this));
    }

    /**
     * Creates category list and populates it accordingly. Contains our three item categories
     * and one all items category.
     * @param view
     */
    private void createCategorySlider(View view) {
        TextView categories_title = view.findViewById(R.id.categories_title);
        categories_title.setText("Categories");
        // create list of category images for category slider
        RecyclerView categoryList = view.findViewById(R.id.category_slider);

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing_medium);
        categoryList.addItemDecoration(new SpaceItemDecoration(spacingInPixels,alreadyAltered));

        // List Creation
        ArrayList categoryImages = new ArrayList<Integer>();
        categoryImages.add(R.drawable.piano_category1);
        categoryImages.add(R.drawable.guitar_category1);
        categoryImages.add(R.drawable.audio_category1);
        categoryImages.add(R.drawable.all_category1);
        ArrayList labels = new ArrayList<String>();
        labels.add("Pianos");
        labels.add("Guitars");
        labels.add("Accessories");
        labels.add("All Items");

        CategoryListAdapter adapter = new CategoryListAdapter(getContext(), categoryImages, labels);
        // RecyclerView properties
        categoryList.setLayoutManager(new GridLayoutManager(getContext(),2));
        categoryList.setHasFixedSize(true);
        categoryList.setDrawingCacheEnabled(true);
        categoryList.setAdapter(adapter);
    }

}