package com.example.brainsterquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button loginButton;
    private TextView signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        username = (EditText) findViewById(R.id.usernameTxt);
        password = (EditText) findViewById(R.id.passwordTxt);
        loginButton = (Button) findViewById(R.id.loginButton);
        signUpButton = (TextView) findViewById(R.id.signUp);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateParametersView(v);
            }
        });
    }

    public void validateParametersView(View view){
        validateParameters(username.getText().toString(), password.getText().toString());
    }
    private void validateParameters (String username, String password) {
        if((username == "admin") && (password == "admin")){
            Intent intent = new Intent(LoginActivity.this, BrainsterHome.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Wrong credentials!", Toast.LENGTH_SHORT).show();
        }
    }
}