package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class QuizPage extends AppCompatActivity {

    float noOfQues = 3;
    float noOfQuesCorrect = 0;
    float score;
    boolean ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizpage);
    }

    public void correctAnswers(View view){
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton2);
        ans = radioButton1.isChecked();
        if(ans==true){
          noOfQuesCorrect = noOfQuesCorrect + 1;
        }

        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton4);
        ans = radioButton2.isChecked();
        if(ans==true){
            noOfQuesCorrect = noOfQuesCorrect + 1;
        }

        RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton8);
        ans = radioButton3.isChecked();
        if(ans==true){
            noOfQuesCorrect = noOfQuesCorrect + 1;
        }
    //    RadioButton radioButton4 = (RadioButton) findViewById()
    }
}
