package com.example.musicstore.items;

public class Keyboard extends Piano {
    public Keyboard(String name, String description, int image1, int image2, int image3, float price, String specs) {
        super(name, description, image1, image2, image3, price, specs);
    }

    public String getSubcategory(){return "Keyboards";}
}
