package com.example.brainsterquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class BrainsterHomeUnregistered extends AppCompatActivity {
    Dialog loginDialog;
    Dialog registerDialog;
    ImageButton openLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brainster_home_unregistered);
        getSupportActionBar().hide();
        loginDialog = new Dialog(this);
        registerDialog = new Dialog(this);

    }
    public void openLogin(View v) {
        loginDialog.setContentView(R.layout.activity_login);
        registerDialog.setContentView(R.layout.activity_registration);
        ImageView closeButton = (ImageView) loginDialog.findViewById(R.id.closeButtonLogo);
        Button loginButton = (Button) loginDialog.findViewById(R.id.loginButton);
        TextView signInLink = (TextView) registerDialog.findViewById(R.id.signIn);
        TextView signUpLink = (TextView) loginDialog.findViewById(R.id.signUp);

        signInLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerDialog.dismiss();
                loginDialog.show();
            }
        });

        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginDialog.dismiss();
                registerDialog.show();
            }
        });
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginDialog.dismiss();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(view);
            }
        });
        loginDialog.show();
    }

    public void login(View v) {
        EditText usernameTxt = (EditText) loginDialog.findViewById(R.id.usernameTxt);
        EditText passwordTxt = (EditText) loginDialog.findViewById(R.id.passwordTxt);

        if ((usernameTxt.getText().toString().equals("admin")) && (passwordTxt.getText().toString().equals("admin"))){
            startActivity(new Intent(BrainsterHomeUnregistered.this, BrainsterHome.class));
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT).show();
            usernameTxt.setText("");
            passwordTxt.setText("");
        }
    }
}