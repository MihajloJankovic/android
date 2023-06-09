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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BrainsterHome extends AppCompatActivity {

    private ImageButton logoutButton;
    private Dialog userProfile;
    private Dialog playerStatistics;
    private ImageButton myProfileButton;
    private RelativeLayout closeButtonProfile;
    private RelativeLayout statisticsButton;
    private RelativeLayout editProfileButtonClick;

    private RelativeLayout saveProfileButton;
    private RelativeLayout closeButtonStatistics;
    private ProgressBar numberGameProgressBar;
    private ProgressBar stepByStepGameProgressBar;
    private ProgressBar matchingGameProgressBar;
    private ProgressBar combinationsGameProgressBar;
    private ProgressBar questionsGameProgressBar;
    private ProgressBar associationsGameProgressBar;
    private TextView firstBoxPointer;
    private TextView secondBoxPointer;
    private TextView thirdBoxPointer;
    private TextView fourthBoxPointer;
    private TextView fifthBoxPointer;
    private TextView sixthBoxPointer;

    private TextView boxHeader;
    private TextView row1Label;
    private TextView row2Label;
    private TextView row3Label;
    private TextView row4Label;
    private TextView row5Label;
    private TextView row6Label;
    private TextView row7Label;

    private TextView row1Value;
    private TextView row2Value;
    private TextView row3Value;
    private TextView row4Value;
    private TextView row5Value;
    private TextView row6Value;
    private TextView row7Value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brainster_home);
        getSupportActionBar().hide();

        userProfile = new Dialog(this);
        playerStatistics = new Dialog(this);


    }

    public void myProfileDialogListeners(View view) {
        setUIViews();
        userProfile.show();

        saveProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userProfile.dismiss();
                Toast.makeText(BrainsterHome.this, "Saved changes!", Toast.LENGTH_SHORT).show();
                //save changes on profile...
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

    public void statisticsBoxListeners(View view) {
        setUIViews();
        playerStatistics.show();

        closeButtonStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerStatistics.dismiss();
            }
        });

        numberGameProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstBoxPointer.setVisibility(View.VISIBLE);
                secondBoxPointer.setVisibility(View.INVISIBLE);
                thirdBoxPointer.setVisibility(View.INVISIBLE);
                fourthBoxPointer.setVisibility(View.INVISIBLE);
                fifthBoxPointer.setVisibility(View.INVISIBLE);
                sixthBoxPointer.setVisibility(View.INVISIBLE);

                boxHeader.setText("Number game - distance");
                row1Label.setText("correct number: ");
                row1Value.setText("73%");
                row2Label.setText("1-4: ");
                row2Value.setText("10%");
                row3Label.setText("5-9: ");
                row3Value.setText("2%");
                row4Label.setText("10-19: ");
                row4Value.setText("3%");
                row5Label.setText("20-49: ");
                row5Value.setText("2%");
                row6Label.setText("50-99: ");
                row6Value.setText("2%");
                row7Label.setText("100 and more: ");
                row7Value.setText("9%");
            }
        });

        stepByStepGameProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstBoxPointer.setVisibility(View.INVISIBLE);
                secondBoxPointer.setVisibility(View.VISIBLE);
                thirdBoxPointer.setVisibility(View.INVISIBLE);
                fourthBoxPointer.setVisibility(View.INVISIBLE);
                fifthBoxPointer.setVisibility(View.INVISIBLE);
                sixthBoxPointer.setVisibility(View.INVISIBLE);

                boxHeader.setText("Word guessing game - steps");
                row1Label.setText("1 step: ");
                row1Value.setText("73%");
                row2Label.setText("2 steps: ");
                row2Value.setText("10%");
                row3Label.setText("3 steps: ");
                row3Value.setText("2%");
                row4Label.setText("4 steps: ");
                row4Value.setText("3%");
                row5Label.setText("5 steps: ");
                row5Value.setText("2%");
                row6Label.setText("6 to 7 steps: ");
                row6Value.setText("2%");
                row7Label.setText("Not guessed word: ");
                row7Value.setText("9%");
            }
        });

        matchingGameProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firstBoxPointer.setVisibility(View.INVISIBLE);
                secondBoxPointer.setVisibility(View.INVISIBLE);
                thirdBoxPointer.setVisibility(View.VISIBLE);
                fourthBoxPointer.setVisibility(View.INVISIBLE);
                fifthBoxPointer.setVisibility(View.INVISIBLE);
                sixthBoxPointer.setVisibility(View.INVISIBLE);

                boxHeader.setText("Matching game - exactness");
                row1Label.setText("matched pairs: ");
                row1Value.setText("73%");
                row2Label.setText("not matched pairs: ");
                row2Value.setText("27%");
                row3Label.setText("");
                row3Value.setText("");
                row4Label.setText("");
                row4Value.setText("");
                row5Label.setText("");
                row5Value.setText("");
                row6Label.setText("");
                row6Value.setText("");
                row7Label.setText("");
                row7Value.setText("");
            }
        });

        combinationsGameProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstBoxPointer.setVisibility(View.INVISIBLE);
                secondBoxPointer.setVisibility(View.INVISIBLE);
                thirdBoxPointer.setVisibility(View.INVISIBLE);
                fourthBoxPointer.setVisibility(View.VISIBLE);
                fifthBoxPointer.setVisibility(View.INVISIBLE);
                sixthBoxPointer.setVisibility(View.INVISIBLE);

                boxHeader.setText("Combinations game - attempts");
                row1Label.setText("4 and less: ");
                row1Value.setText("20%");
                row2Label.setText("5 attempts: ");
                row2Value.setText("33%");
                row3Label.setText("6 attempts: ");
                row3Value.setText("21%");
                row4Label.setText("Not guessed: ");
                row4Value.setText("25%");
                row5Label.setText("");
                row5Value.setText("");
                row6Label.setText("");
                row6Value.setText("");
                row7Label.setText("");
                row7Value.setText("");
            }
        });

        questionsGameProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstBoxPointer.setVisibility(View.INVISIBLE);
                secondBoxPointer.setVisibility(View.INVISIBLE);
                thirdBoxPointer.setVisibility(View.INVISIBLE);
                fourthBoxPointer.setVisibility(View.INVISIBLE);
                fifthBoxPointer.setVisibility(View.VISIBLE);
                sixthBoxPointer.setVisibility(View.INVISIBLE);

                boxHeader.setText("Questions game - answer exactness");
                row1Label.setText("correct: ");
                row1Value.setText("36%");
                row2Label.setText("not answered: ");
                row2Value.setText("31%");
                row3Label.setText("wrong: ");
                row3Value.setText("33%");
                row4Label.setText("");
                row4Value.setText("");
                row5Label.setText("");
                row5Value.setText("");
                row6Label.setText("");
                row6Value.setText("");
                row7Label.setText("");
                row7Value.setText("");
            }
        });

        associationsGameProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstBoxPointer.setVisibility(View.INVISIBLE);
                secondBoxPointer.setVisibility(View.INVISIBLE);
                thirdBoxPointer.setVisibility(View.INVISIBLE);
                fourthBoxPointer.setVisibility(View.INVISIBLE);
                fifthBoxPointer.setVisibility(View.INVISIBLE);
                sixthBoxPointer.setVisibility(View.VISIBLE);

                boxHeader.setText("Associations game - columns quantity");
                row1Label.setText("whole association: ");
                row1Value.setText("19%");
                row2Label.setText("4 columns: ");
                row2Value.setText("19%");
                row3Label.setText("3 columns: ");
                row3Value.setText("11%");
                row4Label.setText("2 columns: ");
                row4Value.setText("9%");
                row5Label.setText("1 column: ");
                row5Value.setText("17%");
                row6Label.setText("0 columns: ");
                row6Value.setText("25%");
                row7Label.setText("");
                row7Value.setText("");
            }
        });

    }
    public void setUIViews(){
        logoutButton = (ImageButton) this.findViewById(R.id.logoutButton);
        userProfile.setContentView(R.layout.my_profile_layout);
        playerStatistics.setContentView(R.layout.statistics_layout);
        closeButtonProfile = (RelativeLayout) userProfile.findViewById(R.id.closeButton);
        closeButtonStatistics = (RelativeLayout) playerStatistics.findViewById(R.id.closeButton);
        myProfileButton = (ImageButton) this.findViewById(R.id.myProfileButton);
        statisticsButton = (RelativeLayout) this.findViewById(R.id.statistics);
        editProfileButtonClick = (RelativeLayout) userProfile.findViewById(R.id.editProfilePictureLayout);
        saveProfileButton = (RelativeLayout) userProfile.findViewById(R.id.saveProfileButton);

        numberGameProgressBar = (ProgressBar) playerStatistics.findViewById(R.id.progress_bar_number_game);
        stepByStepGameProgressBar = (ProgressBar) playerStatistics.findViewById(R.id.progress_bar_step_by_step_game);
        matchingGameProgressBar = (ProgressBar) playerStatistics.findViewById(R.id.progress_bar_matching_game);
        combinationsGameProgressBar = (ProgressBar) playerStatistics.findViewById(R.id.progress_bar_combinations_game);
        questionsGameProgressBar = (ProgressBar) playerStatistics.findViewById(R.id.progress_bar_questions_game);
        associationsGameProgressBar = (ProgressBar) playerStatistics.findViewById(R.id.progress_bar_associations_game);

        firstBoxPointer = (TextView) playerStatistics.findViewById(R.id.firstBoxPointer);
        secondBoxPointer = (TextView) playerStatistics.findViewById(R.id.secondBoxPointer);
        thirdBoxPointer = (TextView) playerStatistics.findViewById(R.id.thirdBoxPointer);
        fourthBoxPointer = (TextView) playerStatistics.findViewById(R.id.fourthBoxPointer);
        fifthBoxPointer = (TextView) playerStatistics.findViewById(R.id.fifthBoxPointer);
        sixthBoxPointer = (TextView) playerStatistics.findViewById(R.id.sixthBoxPointer);


        boxHeader = (TextView) playerStatistics.findViewById(R.id.boxHeader);

        row1Label = (TextView) playerStatistics.findViewById(R.id.row1Label);
        row1Value = (TextView) playerStatistics.findViewById(R.id.row1Value);
        row2Label = (TextView) playerStatistics.findViewById(R.id.row2Label);
        row2Value = (TextView) playerStatistics.findViewById(R.id.row2Value);
        row3Label = (TextView) playerStatistics.findViewById(R.id.row3Label);
        row3Value = (TextView) playerStatistics.findViewById(R.id.row3Value);
        row4Label = (TextView) playerStatistics.findViewById(R.id.row4Label);
        row4Value = (TextView) playerStatistics.findViewById(R.id.row4Value);
        row5Label = (TextView) playerStatistics.findViewById(R.id.row5Label);
        row5Value = (TextView) playerStatistics.findViewById(R.id.row5Value);
        row6Label = (TextView) playerStatistics.findViewById(R.id.row6Label);
        row6Value = (TextView) playerStatistics.findViewById(R.id.row6Value);
        row7Label = (TextView) playerStatistics.findViewById(R.id.row7Label);
        row7Value = (TextView) playerStatistics.findViewById(R.id.row7Value);

    }

    public void logout(View view) {
        // need alert dialog...
        startActivity(new Intent(BrainsterHome.this, BrainsterHomeUnregistered.class));
    }
}