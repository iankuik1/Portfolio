package com.example.musicstore.activities.mainactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.musicstore.R;
import com.example.musicstore.activities.cartActivity.CartFragment;
import com.example.musicstore.activities.wishlistactivity.WishlistFragment;
import com.example.musicstore.databinding.ActivityMainBinding;

/**
 * This activity contains the main activity that our app will be built off. Contains persistent UI and handles the rest in fragments.
 */
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());

        // Navbar functionality
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
            return true;
        });
    }

    /**
     * Replaces the current fragment with a new one
     * @param fragment
     */
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.currentState, fragment)
                .addToBackStack(null)
                .commit();
    }
}
