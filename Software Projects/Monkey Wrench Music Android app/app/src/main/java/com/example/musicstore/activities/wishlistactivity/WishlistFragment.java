package com.example.musicstore.activities.wishlistactivity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.musicstore.R;
import com.example.musicstore.activities.itemlistactivity.ItemListAdapter;
import com.example.musicstore.activities.mainactivity.SpaceItemDecoration;
import com.example.musicstore.database.Database;
import com.example.musicstore.items.Item;

import java.util.ArrayList;

public class WishlistFragment extends Fragment {
    // added to prevent restyling after reopening activity
    private static boolean alreadyAltered = false;

    public WishlistFragment() {
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
        return inflater.inflate(R.layout.fragment_wishlist, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("WishlistFragment", "onViewCreated() called");
        ArrayList<Item> wishlist = new ArrayList<Item>();
        // set views
        TextView wishlistTitle = view.findViewById(R.id.wishlistTitle);
        wishlistTitle.setText("Wishlist");

        // add items that are wishlisted to arraylist
        for(Item item: Database.getInstance().getAllItems()) {
            if(item.getWishlisted() == Boolean.TRUE) {
                wishlist.add(item);
                Log.d("WishlistFragment", "wishlist has been updated");
            }
        }
        if(wishlist.size() == 0) {
            replaceFragment(new WishlistPlaceHolderFragment()); // start wishlist placeholder fragment if empty
        } else {
            // setup wishlist viewer
            RecyclerView wishlistView = view.findViewById(R.id.wishlistView);
            // Padding between items
            int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing_medium);
            wishlistView.addItemDecoration(new SpaceItemDecoration(spacingInPixels, alreadyAltered));
            Log.d("WishlistFragment", "list is referenced");
            wishlistView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            wishlistView.setAdapter(new ItemListAdapter(requireContext(), wishlist, this));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("WishlistFragment", "onViewCreated() called");
        ArrayList<Item> wishlist = new ArrayList<Item>();
        TextView wishlistTitle = getView().findViewById(R.id.wishlistTitle);
        wishlistTitle.setText("Wishlist");

        for (Item item : Database.getInstance().getAllItems()) {
            if (item.getWishlisted() == Boolean.TRUE) {
                wishlist.add(item);
                Log.d("WishlistFragment", "wishlist has been updated");
            }
        }
        RecyclerView wishlistView = getView().findViewById(R.id.wishlistView);
        Log.d("WishlistFragment", "list is referenced");
        wishlistView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        wishlistView.setAdapter(new ItemListAdapter(requireContext(), wishlist, this));
        if(wishlist.size() == 0) {
            replaceFragment(new WishlistPlaceHolderFragment());}
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.wishlistScreen, fragment);
        transaction.commit();
    }
}