package com.example.android.starwarsquizz;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int finalScore = 0;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //** Find the submit button and set listener to it.
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(submitButton);

    }

    //**Get 1st answer. Check it.
    private void FirstQuestionScore() {
        RadioButton blue = findViewById(R.id.A1_3);
        boolean isBlue = blue.isChecked();
        if (isBlue) {
            finalScore += 10;
        }
    }

    //**Get 2nd answer. Check it.
    private void SecondQuestionScore() {
        RadioButton obi = findViewById(R.id.A2_2);
        boolean isObi = obi.isChecked();
        if (isObi) {
            finalScore += 10;
        }
    }

    // **Get 3rd answer.
    private String answerThree() {
        EditText isMilleniumFalcon = (EditText) findViewById(R.id.Quest3);
        return isMilleniumFalcon.getText().toString();
    }

    // ** check 3rd answer.
    private void ThirdQuestionScore() {
        if (answerThree().equals(getString(R.string.milFalc))) {
            finalScore += 20;
        }
    }

    //Get 4th answer. Check it.
    private void FourthQuestionScore() {
        // get the answers to boolean
        CheckBox red = findViewById(R.id.A4_1);
        boolean choseRed = red.isChecked();

        CheckBox black = findViewById(R.id.A4_2);
        boolean choseBlack = black.isChecked();

        //get the score
        if (choseBlack) {
            finalScore += 10;
        }
        if (choseRed) {
            finalScore += 10;
        } else finalScore += 0;

    }


    //** deal with submit button. Make it listen to the scores and display the results.
    public View.OnClickListener submitButton = new View.OnClickListener() {

        public void onClick(View v) {
            FirstQuestionScore();
            SecondQuestionScore();
            ThirdQuestionScore();
            FourthQuestionScore();

            boolean lowScore = finalScore <= 20;
            boolean midScore = finalScore == 40;
            boolean highScore = finalScore == 60;
            String lowScoreMessage = getString(R.string.lowScore);
            String midScoreMessage = getString(R.string.midScore);
            String highScoreMessage = getString(R.string.highScore);
            if (lowScore) {
                Toast.makeText(MainActivity.this, lowScoreMessage, Toast.LENGTH_LONG).show();
            }
            if (midScore)
                Toast.makeText(MainActivity.this, midScoreMessage, Toast.LENGTH_LONG).show();
            if (highScore) {
                Toast.makeText(MainActivity.this, highScoreMessage, Toast.LENGTH_LONG).show();
            }

            //** make submit button not clickable again in the same play.
            submit.setClickable(false);
        }

    };

    //** deal with reset button. By clicking it, activity restarts and displays a message.

    public void reset(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        String certain = getString(R.string.stOver);
        Toast toast = Toast.makeText(MainActivity.this,certain, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}



