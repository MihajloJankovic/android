package com.example.brainsterquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NumberGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_game);
        getSupportActionBar().hide();
    }
}