package com.example.musicstore.activities.itemlistactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.musicstore.R;
import com.example.musicstore.activities.cartActivity.CartFragment;
import com.example.musicstore.activities.mainactivity.HomeFragment;
import com.example.musicstore.activities.mainactivity.SearchFragment;
import com.example.musicstore.activities.wishlistactivity.WishlistFragment;
import com.example.musicstore.databinding.ActivityMainBinding;

/**
 * Item List Activity
 */
public class ItemListActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // same binding as activity main
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // get incoming intent and send it to the fragment
        String category = (String) getIntent().getSerializableExtra("category");
        // create bundle and put category in bundle
        Bundle bundle = new Bundle();
        bundle.putSerializable("category", category);
        ItemListFragment itemListFragment = new ItemListFragment();
        itemListFragment.setArguments(bundle);
        replaceFragment(itemListFragment);

        // enable navbar functionality
        binding.navBar.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.home){
                replaceFragment(new HomeFragment());
            }
            else if (id == R.id.search){
                replaceFragment(new SearchFragment());
            }
            else if (id == R.id.wishlist){
                replaceFragment(new WishlistFragment());
            }
            else if (id == R.id.cart) {
                replaceFragment(new CartFragment());
            }
            return true;
        });
    }

    /**
     * Replaces the current fragment with another one
     * @param fragment
     */
    private void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.currentState, fragment).addToBackStack(null)
                .commit();

    }

}

