package com.example.brainsterquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AssociationsGame extends AppCompatActivity {
        private TextView A2Txt;
        private TextView A1Txt;
        private TextView A3Txt;
        private TextView A4Txt;
    private TextView B2Txt;
    private String m_Text = "";
    private TextView B1Txt;
    private TextView B3Txt;
    private TextView B4Txt;
    private TextView C2Txt;
    private TextView C1Txt;
    private TextView C3Txt;
    private TextView C4Txt;
    private TextView D2Txt;
    private TextView D1Txt;
    private TextView D3Txt;
    private TextView D4Txt;
    private TextView ATxt;
    private TextView BTxt;
    private TextView CTxt;
    private TextView DTxt;
    private TextView timer;
    private int turn;
    private int round;
    private String rName;
    private String bName;
    private String rScore;
    private String bScore;
    private TextView rName1;
    private TextView bName1;
    private TextView rScore1;
    private TextView bScore1;
    private int hint = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_associations_game);
        getSupportActionBar().hide();
        this.turn = 1;
        this.rName = "Guest";
        this.bName = "";
        this.rScore = "0";
        this.bScore = "";
     //   int solo = 3;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            int solo = extras.getInt("solo");
            this.round = extras.getInt("round");
            if(solo == 1)
            {
                this.turn = 1;
                   this.bName = "";
                       this.rScore = extras.getString("rScore");
                    this.bScore = "";
                 this.rName = "Guest";
                 //   this.round = 0;
            }
        else{
            this.rName = extras.getString("rName");
            this.bName = extras.getString("bName");
            this.rScore = extras.getString("rScore");
            this.bScore = extras.getString("bScore");
        }
            //The key argument here must match that used in the other activity
        }

        this.A2Txt = (TextView) findViewById(R.id.A2Txt);
        this.A1Txt = (TextView) findViewById(R.id.A1Txt);
        this.A3Txt = (TextView) findViewById(R.id.A3Txt);
        this.A4Txt = (TextView) findViewById(R.id.A4Txt);
        this.B2Txt = (TextView) findViewById(R.id.B2Txt);
        this.B1Txt = (TextView) findViewById(R.id.B1Txt);
        this.B3Txt = (TextView) findViewById(R.id.B3Txt);
        this.B4Txt = (TextView) findViewById(R.id.B4Txt);
        this.C2Txt = (TextView) findViewById(R.id.B2Txt);
        this.C1Txt = (TextView) findViewById(R.id.B1Txt);
        this.C3Txt = (TextView) findViewById(R.id.B3Txt);
        this.C4Txt = (TextView) findViewById(R.id.B4Txt);
        this.D2Txt = (TextView) findViewById(R.id.B2Txt);
        this.D1Txt = (TextView) findViewById(R.id.B1Txt);
        this.D3Txt = (TextView) findViewById(R.id.B3Txt);
        this.D4Txt = (TextView) findViewById(R.id.B4Txt);
        this.CTxt = (TextView) findViewById(R.id.CTxt);
        this.DTxt = (TextView) findViewById(R.id.DTxt);
        this.ATxt = (TextView) findViewById(R.id.ATxt);
        this.BTxt = (TextView) findViewById(R.id.BTxt);
        this.timer = (TextView) findViewById(R.id.timer);
        this.rScore1 = (TextView) findViewById(R.id.redPlayerScore);
        this.bScore1 = (TextView) findViewById(R.id.bluePlayerScore);
        this.rName1 = (TextView) findViewById(R.id.redPlayerName);
        this.bName1 = (TextView) findViewById(R.id.bluePlayerName);
        this.rScore1.setText(rScore);
        this.bScore1.setText(bScore);
        this.rName1.setText(rName);
        this.bName1.setText(bName);

        new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setText("done!");
                if(round == 1)
                {
                    // next game
                }
                if(round == 0)
                {
                    Intent intent = new Intent(getApplicationContext(), AssociationsGame.class);
                    intent.putExtra("rName", rName);
                    intent.putExtra("bName", bName);
                    intent.putExtra("rScore", rScore);
                    intent.putExtra("bScore",bScore);
                    if(turn == 3)
                    {
                        intent.putExtra("solo", 1);
                    }else{
                        intent.putExtra("solo", 0);
                    }
                    intent.putExtra("round", 1);

                    startActivity(intent);
                }
            }
        }.start();






    }
    public void addStep(View v) {
      if(turn == 1 || turn == 3)
      {
          AlertDialog.Builder alert = new AlertDialog.Builder(this);
          alert.setTitle("Enter Value");


          // Set an EditText view to get user input
          final EditText input = new EditText(this);
          alert.setView(input);

          alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int whichButton) {
                  String value = String.valueOf(input.getText());
                  // Do something with value!


              }
          });

          alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int whichButton) {
                  // Canceled.
              }
          });

          alert.show();
      }
    }
}