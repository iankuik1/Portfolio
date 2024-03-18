package com.example.musicstore.activities.expandeditemactivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.musicstore.R;
import com.example.musicstore.database.Database;
import com.example.musicstore.database.Dataprovider;
import com.example.musicstore.items.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * Fragment containing the detailed view of a particular item.
 * Arguments are backButtonEnable (disabled if entering from cart/ wishlist activities) and the item.
 */
public class ExpandedItemFragment extends Fragment {
    public ExpandedItemFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_expanded_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // get argument and use it to set views and enable/disable backbutton
        Item item = (Item) getArguments().getSerializable("item");
        item.changeViewedStatus();
        Boolean backButtonEnable = (Boolean) getArguments().getSerializable("backButtonEnable");
        Button backButton = view.findViewById(R.id.BackButton);

        if(backButtonEnable) {
            // back button implementation if enabled
            backButton.setVisibility(View.VISIBLE);
            backButton.setOnClickListener(v -> {
                requireActivity().finish();
                requireActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            });
        } else {
            backButton.setVisibility(View.INVISIBLE);
        }

        // initialise wishlist button appearance
        Button wishlistButton = view.findViewById(R.id.wishlistButton);
        changeWishlistButtonAppearance(wishlistButton, item);

        // enable wishlist functionality
        wishlistButton.setOnClickListener(v -> {
            Log.d("WishlistClicked","wishlist button clicked");
            // update wishlist status
            Dataprovider.updateItemWishlistStatus(item);
            changeWishlistButtonAppearance(wishlistButton, item);
        });

        // cart button as a floating action button
        FloatingActionButton cartButton = view.findViewById(R.id.cartButton);
        changeCartButtonAppearance(cartButton, item);
        cartButton.setOnClickListener(v -> {
            Log.d("CartClicked", "cart button clicked");
            Dataprovider.updateItemCartStatus(item);
            changeCartButtonAppearance(cartButton, item);
        });
        setViews(item, view);
    }

    /**
     * Sets the views in the activity that are not dynamic.
     * These are description, name, price, specs.
     * @param item
     * @param view
     */
    private void setViews(Item item, View view) {
        TextView description = view.findViewById(R.id.itemDescription);
        description.setText(item.getDescription());
        TextView price = view.findViewById(R.id.itemPrice);
        price.setText(item.getPrice());
        TextView descriptionTitle = view.findViewById(R.id.aboutItemTitle);
        descriptionTitle.setText(item.getName());
        TextView specsTitle = view.findViewById(R.id.itemSpecsTitle);
        specsTitle.setText("Specifications");
        TextView specsDescription = view.findViewById(R.id.itemSpecsField);
        specsDescription.setText(item.getSpecs());
        // set up imageSwitcher
        setUpImagePager(view, item);
    }

    /**
     * Initialises the image pager containing the three swipable images of the item.
     * @param view
     * @param item
     */
    private void setUpImagePager(View view, Item item) {
        int listSize = item.getImagesList().size();
        // set up image switcher and the image resources
        ViewPager switcher = view.findViewById(R.id.imagePager);
        ImagePagerAdapter adapter = new ImagePagerAdapter(item.getImagesList());
        switcher.setAdapter(adapter);
    }

    /**
     * Change the appearance of the wishlist button when clicked. Should be filled when item is wishlisted and
     * blank otherwise. Plays an animation as well when clicked.
     * @param wishlistButton
     * @param item
     */
    private void changeWishlistButtonAppearance(Button wishlistButton, Item item) {
        Log.d("WishlistClicked","Function called");
        for(Item listItem: Database.getInstance().getAllItems()) {
            if((listItem.getName().equals(item.getName())) && listItem.getWishlisted() == true) {
                wishlistButton.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.btn_star_big_on, 0, 0, 0);
                wishlistButton.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.rotate_left));
                Log.d("WishlistClicked","Wishlist star on");
                break;
            } else if ((listItem.getName().equals(item.getName())) && listItem.getWishlisted() == false){
                //Log.d("WishlistClicked","Wishlist star off");
                Log.d("Comparison", "listItem name: " + listItem.getName());
                Log.d("Comparison", "item name: " + item.getName());
                wishlistButton.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.btn_star_big_off, 0,0,0);
                wishlistButton.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.rotate_right));
            }
        }
    }

    /**
     * Change the appearance of the cart button when clicked. Should be filled when item is in cart and
     * blank otherwise. Plays an animation as well when clicked.
     * @param cartButton
     * @param item
     */
    private void changeCartButtonAppearance(FloatingActionButton cartButton, Item item) {
        Log.d("CartClicked","Function called");
        for(Item listItem: Database.getInstance().getAllItems()) {
            // if item is wishlisted, then change icon to reflect this
            if((listItem.getName().equals(item.getName())) && listItem.getCart() == true) {
                cartButton.setImageResource(R.drawable.remove_from_cart);
                cartButton.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.rotate_left));
                Log.d("CartClicked","Cart button on");
                break;
                // if item is no longer wishlisted, then change icon to reflect this
            } else if ((listItem.getName().equals(item.getName())) && listItem.getCart() == false){
                cartButton.setImageResource(R.drawable.add_to_cart);
                cartButton.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.rotate_right));
                break;
            }
        }
    }
}
