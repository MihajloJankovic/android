package com.example.brainsterquiz;

import static java.util.concurrent.TimeUnit.SECONDS;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.CircularArray;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;


public class NumberGame extends AppCompatActivity {
    private Timer singleDigitTimer;
    private TextView neededNumber;
    private TextView bluePlayerNumber;
    private TextView redPlayerNumber;
    private RelativeLayout clearInput;
    private TextView confirmTxt;
    private TextView inputNumbers;
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
    private int stopped;
    private String bScore;
    private TextView addition;
    private TextView subtraction;
    private TextView multiplication;
    private TextView division;

    private TextView openBracket;
    private TextView closedBracket;
    private TextView bName1;
    private TextView rScore1;
    private TextView bScore1;
    private List<Integer> digits;
    private List<Integer> doubleDigits;
    private List<Integer> lastDigits;

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
        digits = new ArrayList<Integer>();
        doubleDigits = new ArrayList<Integer>();
        lastDigits = new ArrayList<Integer>();

        digits.add(1);
        digits.add(2);
        digits.add(3);
        digits.add(4);
        digits.add(5);
        digits.add(6);
        digits.add(7);
        digits.add(8);
        digits.add(9);

        doubleDigits.add(10);
        doubleDigits.add(15);
        doubleDigits.add(20);

        lastDigits.add(25);
        lastDigits.add(50);
        lastDigits.add(100);

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
        this.openBracket = (TextView) findViewById(R.id.openBracket);
        this.closedBracket = (TextView) findViewById(R.id.closedBracket);
        this.inputNumbers = (TextView) findViewById(R.id.inputNumbers);
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
    public void generateNumbers(View view) {
        setupUI();

        Random random = new Random();

        List<Integer> neededNumbers = new ArrayList<Integer>();

        for (int i = 1; i<=1000; i++){
            neededNumbers.add(i);
        }

        neededNumber.setText(neededNumbers.get(random.nextInt(neededNumbers.size())).toString());
        number1.setText(digits.get(random.nextInt(digits.size())).toString());
        number2.setText(digits.get(random.nextInt(digits.size())).toString());
        number3.setText(digits.get(random.nextInt(digits.size())).toString());
        number4.setText(digits.get(random.nextInt(digits.size())).toString());

        number5.setText(doubleDigits.get(random.nextInt(doubleDigits.size())).toString());
        number6.setText(lastDigits.get(random.nextInt(lastDigits.size())).toString());

        confirmTxt.setText("CONFIRM");

        number1.setClickable(true);
        number2.setClickable(true);
        number3.setClickable(true);
        number4.setClickable(true);
        number5.setClickable(true);
        number6.setClickable(true);

        addition.setClickable(false);
        subtraction.setClickable(false);
        multiplication.setClickable(false);
        division.setClickable(false);
        openBracket.setClickable(true);
        closedBracket.setClickable(true);
    }

    public void makeExpression(View view){
        setupUI();
        generateNumbers(view);

        inputNumbers.setText("");
        String inputTxt = inputNumbers.getText().toString();

        String num1Value = number1.getText().toString();
        String num2Value = number2.getText().toString();
        String num3Value = number3.getText().toString();
        String num4Value = number4.getText().toString();
        String num5Value = number5.getText().toString();
        String num6Value = number6.getText().toString();

        clearInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputNumbers.setText("");
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTxt.concat("+");
                addition.setClickable(false);
                subtraction.setClickable(false);
                multiplication.setClickable(false);
                division.setClickable(false);
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTxt.concat("−");
                addition.setClickable(false);
                subtraction.setClickable(false);
                multiplication.setClickable(false);
                division.setClickable(false);
            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTxt.concat("×");
                addition.setClickable(false);
                subtraction.setClickable(false);
                multiplication.setClickable(false);
                division.setClickable(false);
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTxt.concat("/");
                addition.setClickable(false);
                subtraction.setClickable(false);
                multiplication.setClickable(false);
                division.setClickable(false);
            }
        });

        openBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTxt.concat("(");
                addition.setClickable(false);
                subtraction.setClickable(false);
                multiplication.setClickable(false);
                division.setClickable(false);
            }
        });

        closedBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTxt.concat(")");
                addition.setClickable(false);
                subtraction.setClickable(false);
                multiplication.setClickable(false);
                division.setClickable(false);
            }
        });


        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTxt.concat(num1Value);
                number1.setClickable(false);
                number2.setClickable(false);
                number3.setClickable(false);
                number4.setClickable(false);
                number5.setClickable(false);
                number6.setClickable(false);
            }
        });

        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTxt.concat(num2Value);
                number1.setClickable(false);
                number2.setClickable(false);
                number3.setClickable(false);
                number4.setClickable(false);
                number5.setClickable(false);
                number6.setClickable(false);
            }
        });

        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTxt.concat(num3Value);
                number1.setClickable(false);
                number2.setClickable(false);
                number3.setClickable(false);
                number4.setClickable(false);
                number5.setClickable(false);
                number6.setClickable(false);
            }
        });

        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTxt.concat(num4Value);
                number1.setClickable(false);
                number2.setClickable(false);
                number3.setClickable(false);
                number4.setClickable(false);
                number5.setClickable(false);
                number6.setClickable(false);
            }
        });

        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTxt.concat(num5Value);
                number1.setClickable(false);
                number2.setClickable(false);
                number3.setClickable(false);
                number4.setClickable(false);
                number5.setClickable(false);
                number6.setClickable(false);
            }
        });

        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputTxt.concat(num6Value);
                number1.setClickable(false);
                number2.setClickable(false);
                number3.setClickable(false);
                number4.setClickable(false);
                number5.setClickable(false);
                number6.setClickable(false);
            }
        });
    }
}