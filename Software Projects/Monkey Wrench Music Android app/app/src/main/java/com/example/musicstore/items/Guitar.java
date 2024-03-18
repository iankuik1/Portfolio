package com.example.musicstore.items;

public abstract class Guitar extends Item{

    public Guitar(String name, String description, int image1, int image2, int image3, float price, String specs) {
        super(name, description, image1, image2, image3, price, specs);
    }

    public String getCategory() {return "Guitars";}

    @Override
    public abstract String getSubcategory();
}
