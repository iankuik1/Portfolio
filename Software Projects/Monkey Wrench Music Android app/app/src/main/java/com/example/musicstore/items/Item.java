package com.example.musicstore.items;

import android.annotation.SuppressLint;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Item implements Serializable {
    private final String specs;
    private boolean viewed;
    private Boolean cart;
    private Boolean wishlisted;
    private int image1;
    private int image2;
    private int image3;
    private static int nextId = 0;
    private int id;
    private static ArrayList<Integer> recentlyClicked= new ArrayList<Integer>();
    String name, description, category;

    float price;

    public Item(String name, String description, int image1, int image2, int image3, float price, String specs) {
        this.name = name;
        this.id = nextId;
        nextId++;
        this.description = description;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.price = price;
        this.wishlisted = false;
        this.cart = false;
        this.viewed = false;
        this.specs = specs;
    }

    public String getName() {
        return name;
    }

    public int getId() {return id;}

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Integer> getImagesList() {
        ArrayList<Integer> imageList = new ArrayList<Integer>();
        imageList.add(image1);
        imageList.add(image2);
        imageList.add(image3);
        return imageList;
    }

    public void setImageList(int image1, int image2, int image3) {
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }

    public void changeWishlistStatus() {
        this.wishlisted = !wishlisted;
        Log.d("WishlistClicked", "Status changed");
    }
    public void changeCartStatus() {
        this.cart = !cart;
        Log.d("CartClicked", "Status changed");
    }

    public void changeViewedStatus() {
        recentlyClicked.add(this.id);
        this.viewed = true;
    }

    public boolean getViewed() {
        return this.viewed;
    }

    public ArrayList<Integer> getClicked(){
        return this.recentlyClicked;
    }

    public abstract String getCategory();
    public abstract String getSubcategory();

    @SuppressLint("DefaultLocale")
    public String getPrice() {
        return String.format("$%.2f",price);
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean getWishlisted() {
        return wishlisted;
    }

    public boolean getCart() {return cart;}

    public String getSpecs() {return specs;}

    public float getPriceFloat() {return price;}

}
