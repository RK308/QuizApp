package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class QuizPage extends AppCompatActivity {

    float noOfQuestions = 6;
    float noOfQuestionsCorrect = 0;
    float score;
    int ans;
    int ansId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizpage);
    }

    public void checkAnswers(View view) {

        /*
         * * Q1Ans "2.5 Billions"
         */
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.qOneRadioGrp);
        if (radioGroup.getCheckedRadioButtonId() == R.id.qOneRadioButton2) {
            noOfQuestionsCorrect = noOfQuestionsCorrect + 1;
        }
        /*
         * * Q3Ans "Larynx"
         */
        RadioGroup radioGroup1 = findViewById(R.id.qTwoRadioGrp);
        ans = radioGroup1.getCheckedRadioButtonId();
        RadioButton radioButton1 = findViewById(R.id.qTwoRadioButton1);
        ansId = radioButton1.getId();
        if (ans == ansId) {
            noOfQuestionsCorrect = noOfQuestionsCorrect + 1;
        }
        /*
         * * Q5Ans "A double helix"
         */
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.qThreeRadioGrp);
        ans = radioGroup2.getCheckedRadioButtonId();
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.qThreeRadioButton2);
        ansId = radioButton2.getId();
        if (ans == ansId) {
            noOfQuestionsCorrect = noOfQuestionsCorrect + 1;
        }
        /*
         * * Q6Ans "James Watson & Francis Crick"
         */
        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.qFourRadioGrp);
        ans = radioGroup3.getCheckedRadioButtonId();
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.qFourRadioButton4);
        ansId = radioButton3.getId();
        if (ans == ansId) {
            noOfQuestionsCorrect = noOfQuestionsCorrect + 1;
        }
        /*
         * * Q2Ans "c1,c2 and c4"
         */
        CheckBox c1 = (CheckBox) findViewById(R.id.qFiveCheckbox1);
        CheckBox c2 = (CheckBox) findViewById(R.id.qFiveCheckbox2);
        CheckBox c3 = (CheckBox) findViewById(R.id.qFiveCheckbox3);
        CheckBox c4 = (CheckBox) findViewById(R.id.qFiveCheckbox4);
        if (c1.isChecked() && c2.isChecked() && c4.isChecked() && !c3.isChecked()) {
            noOfQuestionsCorrect += 1;
        } else {
            noOfQuestionsCorrect += 0;
        }
        /*
         * * Q4Ans "yes"
         */
        EditText edittext1 = (EditText) findViewById(R.id.ques6);
        String ans = edittext1.getText().toString();
        ans = ans.trim();
        if (ans.equalsIgnoreCase("yes")) {
            noOfQuestionsCorrect += 1;
        } else {
            noOfQuestionsCorrect += 0;
        }

        // If the quiz is incomplete display the message to the user
        if (radioGroup.getCheckedRadioButtonId() == -1
                || !c1.isChecked() && !c2.isChecked() && !c3.isChecked() && !c4.isChecked()
                || radioGroup1.getCheckedRadioButtonId() == -1
                || edittext1.getText().toString().isEmpty()
                || radioGroup2.getCheckedRadioButtonId() == -1
                || radioGroup3.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Try to complete the quiz", Toast.LENGTH_SHORT).show();
        } else {

            /*
             * * calculate the score in percentage
             */
            score = (noOfQuestionsCorrect / noOfQuestions) * 100;
            /*
             ** Display the correct answers at the end of the quiz
             */
            String a = "Q1Ans ---> 2.5 Billions\n" + "Q2Ans ---> Vastus lateralis, Vastus intermedius and Rectus femoris\n" + "Q3Ans ---> Larynx\n" + "Q4Ans ---> yes\n" + "Q5Ans ---> A double helix\n" + "Q6Ans ---> James Watson & Francis Crick\n";

            /*
             ** Show the score to the user
             */
            Toast toast = Toast.makeText(QuizPage.this, "You scored : " + score + "%", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            /*
             ** Display the correct answers at the end of the quiz
             */
            Toast toast1 = Toast.makeText(this, a, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast1.show();

            noOfQuestionsCorrect = 0;
            radioGroup.clearCheck();
            radioGroup1.clearCheck();
            radioGroup2.clearCheck();
            radioGroup3.clearCheck();
            c1.setChecked(false);
            c2.setChecked(false);
            c3.setChecked(false);
            c4.setChecked(false);
            edittext1.setText("");
        }
    }
}
