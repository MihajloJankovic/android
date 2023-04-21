package com.example.brainsterquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class BrainsterHomeUnregistered extends AppCompatActivity {
    Dialog loginDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brainster_home_unregistered);
        getSupportActionBar().hide();
        loginDialog = new Dialog(this);
    }
    public void openLogin(View v) {
        loginDialog.setContentView(R.layout.activity_login);
        loginDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView closeButton = (ImageView) loginDialog.findViewById(R.id.closeButton);
        Button loginButton = (Button) loginDialog.findViewById(R.id.loginButton);
        TextView signUpButton = (TextView) loginDialog.findViewById(R.id.signUp);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginDialog.dismiss();
            }
        });
        loginDialog.show();
    }
}