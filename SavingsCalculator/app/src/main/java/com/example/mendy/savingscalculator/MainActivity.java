package com.example.mendy.savingscalculator;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //getting the things we created on the main screen BY ID's from the xml file so it can be displayed
    //and so that we can access them all from the functions on this page
    //and not need to get them from within methods
    //declared
    final int WEEKS_IN_ONE_YEAR = 52;
    TextView txtTitle;
    EditText edtYearlyIncome;
    TextView txtWeeklySavings;
    SeekBar seekBar;
    Button btnReset;
    TextView txtTotalSavings;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the elements we declared above (which matched the names by id from the xml)
        //note we are typecasting from simple view to textview
        //note the capital bc it's a class for the typecasting portion
        //lower case is the variable
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        edtYearlyIncome = (EditText) findViewById(R.id.edtYearlyIncome);
        txtWeeklySavings = (TextView) findViewById(R.id.txtWeeklySavings);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        btnReset = (Button) findViewById(R.id.btnReset);
        txtTotalSavings = (TextView) findViewById(R.id.txtTotalSavings);


        //I included these font's now I am setting them up
        Typeface crimsonFont = Typeface.createFromAsset(getAssets(), "Fonts/CrimsonText-Italic.ttf");
        Typeface oswaldFont = Typeface.createFromAsset(getAssets(), "Fonts/Oswald-Bold.ttf");
        Typeface timmanaFont = Typeface.createFromAsset(getAssets(), "Fonts/Timmana-Regular.ttf");

        //applying the fonts by setting the reference for the fonts once we declared and initialized the xml items
        txtTitle.setTypeface(oswaldFont);
        //edtYearlyIncome.setTypeface();
        txtWeeklySavings.setTypeface(crimsonFont);
        btnReset.setTypeface(timmanaFont);

        //setting up the seekbar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //display progress on the weekly savings textview as we move the seekbar around
                //int progress inserted below is the progress from above
                //which is the progress percentage of the seekbar that is returned
                txtWeeklySavings.setText("Weekly Savings: \n$" + progress);
                //calculate and display the yearly savings
                //pull the weeks of the year above in the final int
                int totalSavingsPerYear = progress * WEEKS_IN_ONE_YEAR;
                //display (but we need to add the blank string to typecast this into a string thing)
                //see the parameters for setText to better understand
                //essentially when there is a string it knows we want a string as the output
                txtTotalSavings.setText("$" + totalSavingsPerYear + "");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //setting up the edit text yearly income add
        //when a user adds in text it will change the calculations
        edtYearlyIncome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //the user puts in a new yearly salary
                //we want to calculate the maximum allowed of savings depending on the users yearly income
                //we want to take the edit text values added and assign them to a string variable
                String yearlyIncomeAsText = edtYearlyIncome.getText().toString();
                //we will change it to a number
                double yearlyIncomeAsNumber = 0;
                //before changing the string to a number we want to make sure there is a number bc
                //otherwise the NULL value will crash the app
                //so we check if it's ! empty
                if (!yearlyIncomeAsText.isEmpty()){
                    yearlyIncomeAsNumber = Double.parseDouble(yearlyIncomeAsText);
                    }
                //calculate a max amount from the salary income
                //here it will be the yearly income divided as two bc you can't save it all
                double weeklyIncome = yearlyIncomeAsNumber / WEEKS_IN_ONE_YEAR;
                //here we are typecasting, but we are also putting the calcualtion in parens
                //that is so that even after the calcuoation happens we will typecast the resuts and trunctate it as an int
                int maxSavingsAllowedOnSeekBar = (int) (weeklyIncome / 2);

                //setup max amount on slider/seekbar
                seekBar.setMax(maxSavingsAllowedOnSeekBar);

            }
        });

        //this reset button code may or may not work as the Video tutorial was having issues playing
        //this may have things in other places tweaked

        //setting up the reset button
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset edit text
                edtYearlyIncome.setText(null);
                edtYearlyIncome.dispatchDisplayHint(View.VISIBLE);
            }

        }
        );
    }

}
