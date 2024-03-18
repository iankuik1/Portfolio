package com.example.musicstore.activities.itemlistactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicstore.R;
import com.example.musicstore.activities.mainactivity.SpaceItemDecoration;
import com.example.musicstore.database.Database;
import com.example.musicstore.database.Dataprovider;
import com.example.musicstore.databinding.ActivityMainBinding;
import com.example.musicstore.items.Item;

import java.util.List;

/**
 * Fragment which contains the item lists of each category. ie, all the pianos,
 * guitars or extras.
 */
public class ItemListFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private String category;
    private View fragmentView;
    private static boolean alreadyAltered = false;

    public ItemListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        category = (String) getArguments().getSerializable("category");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentView = view;
        TextView title = view.findViewById(R.id.category_title);
        title.setText(category);
        setUpButtons(category, view);

        // sort dropdown menu
        Spinner dropdown = view.findViewById(R.id.filterDropdown);
        ArrayAdapter<CharSequence> filterAdapter = ArrayAdapter.createFromResource(getContext(), R.array.spinnerItems, android.R.layout.simple_spinner_item);
        filterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(filterAdapter);
        dropdown.setOnItemSelectedListener(this);

        // Laying out recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        // Setting recyclerview adapters based on categories
        if(category.equals("Pianos") || category.equals("Guitars") || category.equals("Audio")) {
            recyclerView.setAdapter(new ItemListAdapter(getContext(), Dataprovider.createItemCategoriesList(category), this));
        } else if (category.equals("All Items")){
            recyclerView.setAdapter(new ItemListAdapter(getContext(), Database.getInstance().getAllItems(), this));
        } else {
            recyclerView.setAdapter(new ItemListAdapter(getContext(), Dataprovider.createItemSubcategoriesList(category), this));
        }

        // Padding between items
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing_medium);
        recyclerView.addItemDecoration(new SpaceItemDecoration(spacingInPixels, alreadyAltered));

        // Back button that closes current activity
        Button backButton = view.findViewById(R.id.BackButton);
        backButton.setOnClickListener(v -> {
            requireActivity().finish();
            requireActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        });
    }

    /**
     *  Sets up the buttons that create a new item list activity based on the subcategories available
     * @param category
     * @param view
     */
    private void setUpButtons(String category, View view) {
        boolean enable = false;
        String subcat1 = null, subcat2 = null;
        // change buttons depending on (sub)category passed in
        switch (category) {
            case "Pianos":
                subcat1 = "Keyboards";
                subcat2 = "Grand";
                enable = true;
                break;
            case "Guitars":
                subcat1 = "Acoustic";
                subcat2 = "Electric";
                enable = true;
                break;
            case "Audio":
                subcat1 = "Headphones";
                subcat2 = "Monitors";
                enable = true;
                break;
        }

            Button subcat1Button = view.findViewById(R.id.button1);
            subcat1Button.setText(subcat1);
            String finalSubcat = subcat1;


            Button subcat2Button = view.findViewById(R.id.button2);
            subcat2Button.setText(subcat2);
            String finalSubcat1 = subcat2;

        // For when subcategories are available
        if (enable){
            subcat1Button.setOnClickListener(v -> {
                Intent intent = new Intent(getContext(), ItemListActivity.class);
                intent.putExtra("category", finalSubcat);
                startActivity(intent);
                ((Activity) getContext()).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            });

            subcat2Button.setOnClickListener(v -> {
                Intent intent = new Intent(getContext(), ItemListActivity.class);
                intent.putExtra("category", finalSubcat1);
                startActivity(intent);
                ((Activity) getContext()).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            });
        }
        else{
            // Disable usage and visibility of buttons
            subcat1Button.setEnabled(false);
            subcat2Button.setEnabled(false);
        }

    }

    /**
     * This is the method that creates action when an item in the dropdown spinner is selected
     * @param parent The AdapterView where the selection happened
     * @param view The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        List<Item> items;
        if(category.equals("Pianos") || category.equals("Guitars") || category.equals("Audio")) {
            switch (parent.getItemAtPosition(position).toString()) {
                case "Price: Low to High":
                    items = Dataprovider.createCategoryListByPrice(category, true);
                    break;
                case "Price: High to Low":
                    items = Dataprovider.createCategoryListByPrice(category, false);
                    break;
                default:
                    items = Dataprovider.createItemCategoriesList(category);
            }
            // When all items is selected category
        } else if (category.equals("All Items")){
            switch(parent.getItemAtPosition(position).toString()) {
                case "Price: Low to High":
                    items = Dataprovider.createCategoryListByPrice(category, true);
                    break;
                case "Price: High to Low":
                    items = Dataprovider.createCategoryListByPrice(category, false);
                    break;
                default:
                    items = Database.getInstance().getAllItems();
                    break;
            }
        } else {
            switch (parent.getItemAtPosition(position).toString()) {
                case "Price: Low to High":
                    items = Dataprovider.createSubcategoryListByPrice(category, true);
                    break;
                case "Price: High to Low":
                    items = Dataprovider.createSubcategoryListByPrice(category, false);
                    break;
                default:
                    items = Dataprovider.createItemSubcategoriesList(category);
            }
        }

        // Laying out recyclerview based on categories and sorted by price
        RecyclerView recyclerView = fragmentView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        // Padding between items
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing_medium);
        recyclerView.addItemDecoration(new SpaceItemDecoration(spacingInPixels, alreadyAltered));

        ItemListAdapter adapter = new ItemListAdapter(getContext(), items, this);
        recyclerView.setAdapter(adapter);
        // indicate that itemlist has changed based on the sorting
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
