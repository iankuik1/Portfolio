package com.example.musicstore.database;

import android.util.Log;

import com.example.musicstore.items.Item;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class to access and handle information calls globally
 */
public class Dataprovider {
    private static ArrayList<Integer> recentClicks = new ArrayList<Integer>();
    private static ArrayList<Integer> cartItems = new ArrayList<Integer>();
    public Dataprovider() {
    }

    /**
     * Generates the entire list of all items in our shop
     * @return List<Item> all Items
     */

    public static void updateItemWishlistStatus(Item item) {
        ArrayList<Item> allItems = Database.getInstance().getAllItems();
        for(int i = 0; i < allItems.size(); i++) {
            if(allItems.get(i).getName().equals(item.getName())) {
                Log.d("WishlistClicked","Item found");
                allItems.get(i).changeWishlistStatus();
                break;
            }
        }
    }

    /**
     * Updates the cart status of a particular item
     * @param item
     */
    public static void updateItemCartStatus(Item item) {
        ArrayList<Item> allItems = Database.getInstance().getAllItems();
        for(int i = 0; i < allItems.size(); i++) {
            if(allItems.get(i).getName().equals(item.getName())) {
                allItems.get(i).changeCartStatus();
                // When item is to be removed
                if (cartItems.contains(i) & (!allItems.get(i).getCart())){
                    for (int j = 0; j < cartItems.size(); j++){
                        if (cartItems.get(j) == i){
                            Log.d("ItemRemoval","Item gone");
                            cartItems.remove(j);
                        }
                    }
                }
                // When item was in initial list, bring it front
                else if(cartItems.contains(i)){
                    for (int k = 0; k < 3; k++){
                        if (cartItems.get(k) == i){
                            cartItems.remove(k);
                            break;
                        }
                    }
                    cartItems.add(i);
                }
                // Add to end
                else{
                    cartItems.add(i);
                }

                break;
            }
        }
    }

    /**
     * Creates category list of items
     * @param categoryName
     * @return
     */
    public static ArrayList<Item> createItemCategoriesList(String categoryName) {
        ArrayList<Item> allItems = Database.getInstance().getAllItems();
        ArrayList<Item> categoryItemsList = new ArrayList<Item>();
        // Return all items when category is all items
        if (categoryName.equals("All Items")){
            categoryItemsList = allItems;
        }
        else{
            for(int i = 0; i < allItems.size(); i++) {
                // check if class name equals category entered
                if(allItems.get(i).getCategory().contains(categoryName)) {
                    categoryItemsList.add(allItems.get(i));
                }
            }
        }
        return categoryItemsList;
    }


    /**
     *  Creates a recently viewed list based for home fragment
     * @return recentlyViewed, an arraylist of items representing what has been viewed
     */
    public static ArrayList<Item> createRecentlyViewedList() {
        ArrayList<Item> allItems = Database.getInstance().getAllItems();
        ArrayList<Item> recentlyViewed = new ArrayList<>();
        ArrayList<Integer> numClicks = allItems.get(0).getClicked();
        Item currentItem;


        if (numClicks.size() != 0){
            Collections.reverse(recentClicks);
            for(int i = 0; i < numClicks.size(); i++) {
                currentItem = allItems.get(recentClicks.get(i));
                // Exclude previous views of same item to prevent duplicates
                if(recentlyViewed.contains(currentItem)) {
                    continue;
                }
                else{
                    recentlyViewed.add(currentItem);
                }
                // Display only first 6 recently viewed items
                if (recentlyViewed.size() == 6){
                    break;
                }
            }
            Collections.reverse(recentClicks);
        }

        return recentlyViewed;
    }

    /**
     * Checks the number of items the user has clicked
     */
    public static void checkClicks(){
        ArrayList<Item> allItems = Database.getInstance().getAllItems();
        ArrayList<Integer> numClicks = allItems.get(0).getClicked();
        // When an item has been clicked, add it to recentClicks
        if (numClicks.size() != 0){
            recentClicks.add(numClicks.get(numClicks.size() - 1));
        }
    }

    /**
     * Creates top selling list with initialised items
     * @return
     */
    public static ArrayList<Item> createTopSellingList(){
        ArrayList<Item> allItems = Database.getInstance().getAllItems();
        ArrayList<Item> topSelling = new ArrayList<>();
        int cartSize = cartItems.size();

        Item currentItem;
        Integer counter = 0;
        boolean notMax = true;

            // top 3 picks
            while (counter < cartItems.size() && notMax){
                currentItem = allItems.get(cartItems.get(counter));
                // add to top selling
                topSelling.add(currentItem);
                // break out of loop
                if (counter == 2){
                    notMax = false;
                }
                counter = counter + 1;

            }
        if (!cartItems.contains(24) && counter <= 2){
            topSelling.add( allItems.get(24));
            counter = counter + 1;
        }
        if (!cartItems.contains(0) && counter <= 2){
            topSelling.add( allItems.get(0));
            counter = counter + 1;
        }
        if (!cartItems.contains(30) && counter <= 2){
            topSelling.add( allItems.get(30));
            counter = counter + 1;
        }
        Collections.reverse(topSelling);

        return topSelling;
    }

    /**
     * Creates a list of all the items in each subcategory
     * @param categoryName
     * @return
     */
    public static ArrayList<Item> createItemSubcategoriesList(String categoryName) {
        ArrayList<Item> allItems = Database.getInstance().getAllItems();
        ArrayList<Item> subCategoryItemsList = new ArrayList<>();
        for(int i = 0; i < allItems.size(); i++) {
            if(allItems.get(i).getSubcategory().equals(categoryName)) {
                subCategoryItemsList.add(allItems.get(i));
            }
        }
        return subCategoryItemsList;
    }


    /**
     * Sort the category by price value
     * @param category, the category of items to sort
     * @param lowToHigh, either true or false sorting lowtoHigh or HightoLow respectively
     * @return categoryItems, all items in category but sorted based on lowToHigh
     */
    public static List<Item> createCategoryListByPrice(String category, boolean lowToHigh) {
        ArrayList<Item> categoryItems;
        // Determine items required to sort
        if(category.equals("All Items")) {
            categoryItems = Database.getInstance().getAllItems();
        } else {
            categoryItems = createItemCategoriesList(category);
        }

        // Bubble sort implementation to sort items by price
        if(lowToHigh) {
            for (int i = 0; i < categoryItems.size() - 1; i++) {
                for (int j = 0; j < categoryItems.size() - i - 1; j++) {
                    if (categoryItems.get(j).getPriceFloat() > categoryItems.get(j + 1).getPriceFloat()) {
                        // Swap items
                        Item temp = categoryItems.get(j);
                        categoryItems.set(j, categoryItems.get(j + 1));
                        categoryItems.set(j + 1, temp);
                    }
                }
            }
        } else {
            for (int i = 0; i < categoryItems.size() - 1; i++) {
                for (int j = 0; j < categoryItems.size() - i - 1; j++) {
                    if (categoryItems.get(j).getPriceFloat() < categoryItems.get(j + 1).getPriceFloat()) {
                        // Swap items
                        Item temp = categoryItems.get(j);
                        categoryItems.set(j, categoryItems.get(j + 1));
                        categoryItems.set(j + 1, temp);
                    }
                }
            }
        }

        return categoryItems;
    }

    /**
     * Within a subcategory, sort based on price
     * @param category
     * @param lowToHigh
     * @return
     */
    public static List<Item> createSubcategoryListByPrice(String category, boolean lowToHigh) {
        ArrayList<Item> categoryItems = createItemSubcategoriesList(category);
        // Bubble sort implementation to sort items by price high to low/ low to high
        if(lowToHigh) {
            for (int i = 0; i < categoryItems.size() - 1; i++) {
                for (int j = 0; j < categoryItems.size() - i - 1; j++) {
                    if (categoryItems.get(j).getPriceFloat() > categoryItems.get(j + 1).getPriceFloat()) {
                        // Swap items
                        Item temp = categoryItems.get(j);
                        categoryItems.set(j, categoryItems.get(j + 1));
                        categoryItems.set(j + 1, temp);
                    }
                }
            }
        } else {
            for (int i = 0; i < categoryItems.size() - 1; i++) {
                for (int j = 0; j < categoryItems.size() - i - 1; j++) {
                    if (categoryItems.get(j).getPriceFloat() < categoryItems.get(j + 1).getPriceFloat()) {
                        // Swap items
                        Item temp = categoryItems.get(j);
                        categoryItems.set(j, categoryItems.get(j + 1));
                        categoryItems.set(j + 1, temp);
                    }
                }
            }
        }

        return categoryItems;
    }

    /**
     * Returns the total price of the items in the cart
     * @param cart, Arraylist of items that are in cart
     * @return total, cost of all items in cart
     */
    public static float getCartTotal(ArrayList<Item> cart) {
        float total = 0;
        for(Item item: cart) {
            total += item.getPriceFloat();
        }
        return total;
    }

    /**
     * Clears cart by setting boolean in item class to False
     */
    public static void clearCart() {
        ArrayList<Item> allItems = Database.getInstance().getAllItems();
        for(Item item: allItems) {
            if(item.getCart()) {
                item.changeCartStatus();
            }
        }
        Collections.reverse(cartItems);
    }
}
