package com.example.brainsterquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BrainsterHomeUnregistered extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brainster_home_unregistered);
        getSupportActionBar().hide();
    }
}