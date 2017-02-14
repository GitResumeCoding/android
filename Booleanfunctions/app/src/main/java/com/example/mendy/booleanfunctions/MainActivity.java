package com.example.mendy.booleanfunctions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String questionsOne = "How many teams participate at the EURO 2016 Soccer Competition?" +
                "\na. 14   b. 24   c. 17\n";
        String questionsTwo = "Whats the result of 50/10?\n, " +
                "\na. 14   b. 20   c. 5\n";
        char optionSelectedByUser = 'a';
        boolean isQuestionAnsweredCorrectly = isAnswerCorrect(questionsOne, optionSelectedByUser);
        Toast.makeText(MainActivity.this, questionsOne + (isAnswerCorrect(questionsOne, optionSelectedByUser)? "Correct" : "Incorrect"),
                Toast.LENGTH_LONG).show();

    }
     boolean isAnswerCorrect(String question, char option){
        boolean isAnswerCorrect = false;

        if(question.equals("How many teams participate at the EURO 2016 Soccer Competition?" +
                "\na. 14   b. 24   c. 17\n")) {
            switch (option) {
                case 'a':
                    isAnswerCorrect = false;
                    break;
                case 'b':
                    isAnswerCorrect = true;
                    break;
                case 'c':
                    isAnswerCorrect = false;
                    break;

            }
        }
         if(question.equals("Whats the result of 50/10?\n, " +
                 "\na. 14   b. 20   c. 5\n")) {
             switch (option) {
                 case 'a' : isAnswerCorrect = false; break;
                 case 'b' : isAnswerCorrect = false; break;
                 case 'c' : isAnswerCorrect = true; break;
             }
         }
         return isAnswerCorrect;
     }
}
