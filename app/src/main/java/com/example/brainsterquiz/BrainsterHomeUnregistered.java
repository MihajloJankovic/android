package com.example.brainsterquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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
    Dialog registerLoginDialog;
    Dialog brainsterHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brainster_home_unregistered);
        getSupportActionBar().hide();
        registerLoginDialog = new Dialog(this);
    }
    public void openLogin(View v) {
        registerLoginDialog.setContentView(R.layout.register_login);
        registerLoginDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView closeButton = (ImageView) registerLoginDialog.findViewById(R.id.closeButton);
        Button loginButton = (Button) registerLoginDialog.findViewById(R.id.loginButton);
        TextView signUpButton = (TextView) registerLoginDialog.findViewById(R.id.signUp);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerLoginDialog.dismiss();
            }
        });
        registerLoginDialog.show();
    }

    public void loginCheck(View view) {
        registerLoginDialog.setContentView(R.layout.register_login);
        registerLoginDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView username = (TextView) findViewById(R.id.usernameTxt);
        TextView password = (TextView) findViewById(R.id.passwordTxt);

        Button loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BrainsterHomeUnregistered.this, "LOGIN SUCCESSFULL", Toast.LENGTH_SHORT).show();
            }
        });
    }
}