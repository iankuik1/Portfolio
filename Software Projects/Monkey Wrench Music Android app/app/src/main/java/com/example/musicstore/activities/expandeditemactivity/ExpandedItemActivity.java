package com.example.musicstore.activities.expandeditemactivity;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.musicstore.R;
import com.example.musicstore.activities.cartActivity.CartFragment;
import com.example.musicstore.activities.mainactivity.HomeFragment;
import com.example.musicstore.activities.mainactivity.SearchFragment;
import com.example.musicstore.activities.wishlistactivity.WishlistFragment;
import com.example.musicstore.database.Database;
import com.example.musicstore.database.Dataprovider;
import com.example.musicstore.databinding.ActivityMainBinding;
import com.example.musicstore.items.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.content.res.ColorStateList;
import android.graphics.Color;

/**
 * Activity which starts a fragment containing the detailed view of a selected item.
 * Takes in intents of the Item and the previous fragment's name.
 */
public class ExpandedItemActivity extends AppCompatActivity  {

    ActivityMainBinding binding;
    Item currentItem;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setStyling();
        // get argument and use it to set views and enable/disable back button
        currentItem = (Item) getIntent().getSerializableExtra("item");
        String fragmentName = (String) getIntent().getSerializableExtra("fragmentName");

        // backButtonEnable disables the backButton if entering from wishlist/ cart
        Boolean backButtonEnable = true;
        if(fragmentName.equals("CartFragment") || fragmentName.equals("WishlistFragment")) {
            // disable the back button if launching from these fragments, when launching from these list
            // activities, use case is just checking that one item. User can navigate via navbar.
            backButtonEnable = false;
        }

        // arguments to be passed into expandedItemFragment
        Bundle bundle = new Bundle();
        bundle.putSerializable("item", currentItem);
        bundle.putSerializable("backButtonEnable", backButtonEnable);

        ExpandedItemFragment expandedItemFragment = new ExpandedItemFragment();
        expandedItemFragment.setArguments(bundle);

        replaceFragment(expandedItemFragment);

        // Set up the OnItemSelectedListener
        binding.navBar.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.home) {
                replaceFragment(new HomeFragment());
            } else if (id == R.id.search) {
                replaceFragment(new SearchFragment());
            } else if (id == R.id.wishlist) {
                replaceFragment(new WishlistFragment());
            } else if (id == R.id.cart) {
                replaceFragment(new CartFragment());
            }
            resetStyling();
            return true;
        });

    }

    /**
     * Styling for navBar
     */
    private void setStyling(){
        binding.navBar.setItemActiveIndicatorEnabled(false);
        binding.navBar.setItemTextAppearanceActive(1);
        binding.navBar.getMenu().findItem(R.id.home).setTitle("");
        binding.navBar.getMenu().findItem(R.id.home).setChecked(false);
    }

    /**
     * Reset styling when a new navigation element is clicked
     */
    private void resetStyling(){
        binding.navBar.setItemActiveIndicatorEnabled(true);
        binding.navBar.setItemTextAppearanceActive(0);
        binding.navBar.getMenu().findItem(R.id.home).setTitle("Home");
    }

    /**
     * Replaces the current fragment with another one.
     * @param fragment
     */
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.currentState, fragment)
                .addToBackStack(null)
                .commit();
    }
}