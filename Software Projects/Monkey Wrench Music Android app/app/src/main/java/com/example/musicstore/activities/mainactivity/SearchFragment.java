package com.example.musicstore.activities.mainactivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.musicstore.R;
import com.example.musicstore.activities.itemlistactivity.ItemListAdapter;
import com.example.musicstore.database.Database;
import com.example.musicstore.items.Item;

import java.util.ArrayList;

/**
 * Fragment containing search functionality.
 */
public class SearchFragment extends Fragment {
    private static boolean alreadyAltered = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initSearchWidget(view);
    }

    /**
     * Initialises search widget by setting views and hint text. Enables functionality.
     * @param view
     */
    private void initSearchWidget(View view) {
        SearchView searchView = (SearchView) view.findViewById(R.id.searchBar);
        RecyclerView searchList = (RecyclerView) view.findViewById(R.id.searchList);
        // Padding between items
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing_medium);
        searchList.addItemDecoration(new SpaceItemDecoration(spacingInPixels, alreadyAltered));
        TextView noItemsPrompt = view.findViewById(R.id.noItemsPrompt);
        ImageView placeholderImage = view.findViewById(R.id.placeholderImage);
        placeholderImage.setImageResource(R.drawable.logofinal);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            /**
             * Gets called when user inputs text into searchbar. Will dynamically update list
             * with search results.
             * @param query the new content of the query text field.
             *
             * @return
             */
            @Override
            public boolean onQueryTextChange(String query) {
                if(!query.equals("")) {
                    searchList.setVisibility(View.VISIBLE);
                    placeholderImage.setImageResource(0);
                    // create a new filtered list of items
                    ArrayList<Item> filteredItems = new ArrayList<>();
                    ArrayList<Item> allItems = Database.getInstance().getAllItems();
                    for (Item item : allItems) {
                        // if relevant item found
                        if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                            filteredItems.add(item);
                        }
                    }
                    if (filteredItems.size() == 0) {
                        // add no items found prompt
                        noItemsPrompt.setText("No items found, please try again.");
                    } else {
                        noItemsPrompt.setText("");
                    }
                    // create new adapter and set layout
                    ItemListAdapter adapter = new ItemListAdapter(getContext(), filteredItems, SearchFragment.this);
                    searchList.setLayoutManager(new GridLayoutManager(getContext(),1));
                    searchList.setAdapter(adapter);
                } else {
                    searchList.setVisibility(View.INVISIBLE);
                    placeholderImage.setImageResource(R.drawable.logofinal);
                }
                return false;
            }
        });
    }
}