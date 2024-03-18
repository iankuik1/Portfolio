package com.example.musicstore.items;

public class Grand extends Piano {
    public Grand(String name, String description, int image1, int image2, int image3, float price, String specs) {
        super(name, description, image1, image2, image3, price, specs);
    }

    public String getSubcategory() {return "Grand";}
}
