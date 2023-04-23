package com.example.brainsterquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class BrainsterHome extends AppCompatActivity {

    private ImageButton logoutButton;
    private Dialog userProfile;
    private ImageButton myProfileButton;
    private RelativeLayout closeButtonProfile;
    private RelativeLayout statisticsButton;
    private RelativeLayout editProfileButtonClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brainster_home);
        getSupportActionBar().hide();

        userProfile = new Dialog(this);


    }

    public void myProfileDialogListeners(View view) {
        setUIViews();
        userProfile.show();

        statisticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //opening Statistics dialog...
            }
        });

        closeButtonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userProfile.dismiss();
            }
        });

        editProfileButtonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //function for changing profile picture...
            }
        });
    }
    public void setUIViews(){
        logoutButton = (ImageButton) this.findViewById(R.id.logoutButton);
        userProfile.setContentView(R.layout.my_profile_layout);
        closeButtonProfile = (RelativeLayout) userProfile.findViewById(R.id.closeButton);
        myProfileButton = (ImageButton) this.findViewById(R.id.myProfileButton);
        statisticsButton = (RelativeLayout) this.findViewById(R.id.statistics);
        editProfileButtonClick = (RelativeLayout) userProfile.findViewById(R.id.editProfilePictureLayout);
    }


    public void logout(View view) {
        // need alert dialog...
        startActivity(new Intent(BrainsterHome.this, BrainsterHomeUnregistered.class));
    }
}