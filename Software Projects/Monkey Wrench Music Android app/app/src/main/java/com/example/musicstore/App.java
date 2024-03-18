package com.example.musicstore;

import android.app.Application;

import androidx.fragment.app.Fragment;

import com.example.musicstore.database.Database;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Database.getInstance(); // will be able to accessed globally


    }
}

