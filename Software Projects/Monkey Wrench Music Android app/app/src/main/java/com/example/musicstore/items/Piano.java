package com.example.musicstore.items;

public abstract class Piano extends Item{

    public Piano(String name, String description, int image1, int image2, int image3, float price, String specs) {
        super(name, description, image1, image2, image3, price, specs);
        this.category = "Piano";
    }

    public String getCategory() {return "Pianos";}

    @Override
    public abstract String getSubcategory();
}
