package com.example.brainsterquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StepByStepGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_by_step_game);
        getSupportActionBar().hide();
    }
}