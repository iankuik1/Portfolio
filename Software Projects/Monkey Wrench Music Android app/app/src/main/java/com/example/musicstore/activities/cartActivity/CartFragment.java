package com.example.musicstore.activities.cartActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicstore.R;
import com.example.musicstore.activities.itemlistactivity.ItemListAdapter;
import com.example.musicstore.activities.mainactivity.SpaceItemDecoration;
import com.example.musicstore.database.Database;
import com.example.musicstore.database.Dataprovider;
import com.example.musicstore.items.Item;

import java.util.ArrayList;

public class CartFragment extends Fragment {

    // added to prevent restyling after reopening activity
    private static boolean alreadyAltered = false;
    private ArrayList<Item> cart;
    private ItemListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("CartFragment", "onViewCreated() called");

        // set views
        ImageView placeHolderImage = view.findViewById(R.id.placeholderImage);
        TextView addItemsPrompt = view.findViewById(R.id.addItemPrompt);
        RecyclerView cartView = view.findViewById(R.id.cartList);
        TextView totalCost = view.findViewById(R.id.totalCost);
        Button checkOutButton = view.findViewById(R.id.checkoutButton);

        // arraylist containing items in cart
        cart = new ArrayList<>();
        adapter = new ItemListAdapter(getContext(), cart, this);
        for (Item item : Database.getInstance().getAllItems()) {
            if (item.getCart()) {
                cart.add(item);
                Log.d("CartFragment", "Cart has been updated");
            }
        }
        // Get cart total
        float cartTotal = Dataprovider.getCartTotal(cart);

        // if the cart is empty, enable placeholder views
        if (cart.size() == 0) {
            placeHolderImage.setImageResource(R.drawable.empty_cart);
            placeHolderImage.setVisibility(View.VISIBLE);
            addItemsPrompt.setVisibility(View.VISIBLE);
            checkOutButton.setVisibility(View.INVISIBLE);
            totalCost.setText("No items found");
        } else {
            // normal operation
            placeHolderImage.setVisibility(View.INVISIBLE);
            addItemsPrompt.setVisibility(View.INVISIBLE);
            // Padding between items
            int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing_medium);
            cartView.addItemDecoration(new SpaceItemDecoration(spacingInPixels, alreadyAltered));
            Log.d("WishlistFragment", "list is referenced");
            cartView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            cartView.setAdapter(adapter);
            checkOutButton.setText("Buy now");
            // update total cost
            totalCost.setText("Total: " + String.format("$%.2f", cartTotal) );
        }

        checkOutButton.setOnClickListener(v -> {
            // remove all items from cart and update total if there are any
            cart.clear();
            Dataprovider.clearCart();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            checkOutButton.setVisibility(View.INVISIBLE);
            addItemsPrompt.setVisibility(View.VISIBLE);
            addItemsPrompt.setText("Thank you for shopping with us!");
            totalCost.setText("Your purchase will arrive in a few days");
        });
    }
}
