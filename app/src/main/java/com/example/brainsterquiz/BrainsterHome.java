package com.example.brainsterquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BrainsterHome extends AppCompatActivity {

    private ImageButton logoutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brainster_home);
        getSupportActionBar().hide();

        logoutButton = (ImageButton) findViewById(R.id.logoutButton);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout(view);
            }
        });
    }
    private void logout(View view) {
        startActivity(new Intent(BrainsterHome.this, BrainsterHomeUnregistered.class));
    }
}