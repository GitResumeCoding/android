package com.example.mendy.simplecalculator;

import android.graphics.Typeface;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declared elements
    EditText edtNumber1;
    EditText edtNumber2;
    TextView txtResult;
    Typeface monofettFont;
    Typeface tekoFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing elements
        edtNumber1 = (EditText) findViewById(R.id.edtNumber1);
        edtNumber2 = (EditText) findViewById(R.id.edtNumber2);
        txtResult = (TextView) findViewById(R.id.txtResult);
        monofettFont = Typeface.createFromAsset(getAssets(), "fonts/Monofett.ttf");
        tekoFont = Typeface.createFromAsset(getAssets(), "fonts/Teko-SemiBold.ttf");

        //applying fonts
        edtNumber1.setTypeface(tekoFont);
        edtNumber2.setTypeface(tekoFont);
        txtResult.setTypeface(monofettFont);
    }

    public void compute(View v) {

        //set up alpha transparency animation
        //we set up the anim folder with the alpha xml
        v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_animation));

        //variable declarations
        String firstInputAsText = edtNumber1.getText().toString();
        String secondInputAsText = edtNumber2.getText().toString();
        double firstNumber = 0;
        double secondNumber = 0;
        double resultAsNumber = 0;

        //validate the input as a number only
        //check if each of our inputs have info
        if (!firstInputAsText.isEmpty() && !secondInputAsText.isEmpty()) {
            firstNumber = Double.parseDouble(firstInputAsText);
            secondNumber = Double.parseDouble(secondInputAsText);
        }

        //getting the tag from each of the buttons clicked
        //v = the view which pulls what was clicked as the View
        String operation = v.getTag().toString();

        //set up result depending on operation
        if (operation.equals("addition")) {
            resultAsNumber = firstNumber + secondNumber;
        } else if (operation.equals("subtraction")) {
            resultAsNumber = firstNumber - secondNumber;
        }
        else if(operation.equals("multiplication")){
            resultAsNumber = firstNumber * secondNumber;
        }
        else if(operation.equals("division")){
            resultAsNumber = firstNumber / secondNumber;
        }
        else if(operation.equals("remainder")){
            resultAsNumber = firstNumber % secondNumber;
        }
        else if(operation.equals("exponent")){
            resultAsNumber = Math.pow(firstNumber, secondNumber);
        }

        //format and display the results on the screen
        DecimalFormat formater = new DecimalFormat("#,###.##");
        String resultAsText = formater.format(resultAsNumber);
        txtResult.setText(resultAsText);


    }
}
