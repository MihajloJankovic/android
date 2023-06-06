package com.example.brainsterquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class NumberGame extends AppCompatActivity {

    private TextView neededNumber;
    private TextView bluePlayerNumber;
    private TextView redPlayerNumber;
    private RelativeLayout clearInput;
    private TextView confirmTxt;

    private TextView number1;
    private TextView number2;
    private TextView number3;
    private TextView number4;
    private TextView number5;
    private TextView number6;

    private TextView timer;
    private int turn;
    private int round;
    private String rName;
    private TextView rName1;
    private String bName;
    private String rScore;
    private String bScore;
    private TextView addition;
    private TextView subtraction;
    private TextView multiplication;
    private TextView division;
    private TextView bName1;
    private TextView rScore1;
    private TextView bScore1;

    private int hint = 0;
    private int opened;
    private int posetion =1;
    private int cardPosition =1;
    private int allSubmited= 0;
    private int guessedTrue = 0;

    Map<Integer,Integer> combination=new HashMap<Integer,Integer>();
    Map<Integer,Integer> guessedCombination=new HashMap<Integer,Integer>();
    Map<Integer,Integer> temp=new HashMap<Integer,Integer>();
    CountDownTimer timera;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_game);
        getSupportActionBar().hide();
<<<<<<< Updated upstream
=======

        db = FirebaseFirestore.getInstance();

        this.opened = 0;

        this.turn = 3;
        this.rName = "Guest";
        this.bName = "";

        this.bScore = "";
        //   int solo = 3;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            int solo = extras.getInt("solo");
            this.round = extras.getInt("round");
            if(solo == 1)
            {
                this.turn = 3;
                this.bName = "";
                this.rScore = extras.getString("rScore");
                this.rName = "Guest";

            }
            else{
                this.rName = extras.getString("rName");
                this.bName = extras.getString("bName");
                this.rScore = extras.getString("rScore");
                this.bScore = extras.getString("bScore");
            }
            //The key argument here must match that used in the other activity
        }

        setupUI();
        timera= new CountDownTimer(120000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setText("done!");
                if(round == 1&& turn != 3)
                {
                    Intent intent = new Intent(getApplicationContext(), BrainsterHomeUnregistered.class);
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
                    intent.putExtra("round", 0);

                    startActivity(intent);

               }
                if(round == 0 && turn == 3)
                {
                    Intent intent = new Intent(getApplicationContext(), BrainsterHomeUnregistered.class);
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
                    intent.putExtra("round", 0);

                    startActivity(intent);

                }
                if(round == 0 && turn !=3)
                {
                    Intent intent = new Intent(getApplicationContext(), NumberGame.class);
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

>>>>>>> Stashed changes
    }


    public void setupUI(){
        this.neededNumber = (TextView) findViewById(R.id.neededNumber);
        this.bluePlayerNumber = (TextView) findViewById(R.id.bluePlayerNumber);
        this.redPlayerNumber = (TextView) findViewById(R.id.redPlayerNumber);
        this.clearInput = (RelativeLayout) findViewById(R.id.clearInput);
        this.confirmTxt = (TextView) findViewById(R.id.confirmTxt);
        this.number1 = (TextView) findViewById(R.id.number1);
        this.number2 = (TextView) findViewById(R.id.number2);
        this.number3 = (TextView) findViewById(R.id.number3);
        this.number4 = (TextView) findViewById(R.id.number4);
        this.number5 = (TextView) findViewById(R.id.number5);
        this.number6 = (TextView) findViewById(R.id.number6);
        this.addition = (TextView) findViewById(R.id.addition);
        this.subtraction = (TextView) findViewById(R.id.subtraction);
        this.multiplication = (TextView) findViewById(R.id.subtraction);
        this.division =(TextView) findViewById(R.id.division);

        this.timer = (TextView) findViewById(R.id.timer);
        this.rScore1 = (TextView) findViewById(R.id.redPlayerScore);
        this.bScore1 = (TextView) findViewById(R.id.bluePlayerScore);
        this.rName1 = (TextView) findViewById(R.id.redPlayerName);
        this.bName1 = (TextView) findViewById(R.id.bluePlayerName);
        this.rScore1.setText(rScore);
        this.bScore1.setText(bScore);
        this.rName1.setText(rName);
        this.bName1.setText(bName);

    }


}