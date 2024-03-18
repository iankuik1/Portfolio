package com.example.musicstore.items;

public abstract class Audio extends Item {
    public Audio(String name, String description, int image1, int image2, int image3, float price, String specs) {
        super(name, description, image1, image2, image3, price, specs);
    }

    @Override
    public String getCategory() {return "Audio";}

    @Override
    public abstract String getSubcategory();
}
