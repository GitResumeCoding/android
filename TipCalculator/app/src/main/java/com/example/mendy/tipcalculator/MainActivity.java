package com.example.mendy.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //this will hold the tip percentage
    int tipPercentage;
    final int INITIAL_TIP_PERCENTAGE = 15; //constant

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this is so that when we start the app it will sit at 15% tip
        tipPercentage = INITIAL_TIP_PERCENTAGE;

        //setup for the text change listener for the edittext
        //decaler our edit text as a variable EditText is a data type
        //we are setting it to the xml id's
        //but in order to get the id's from the xml we need to use the findViewById and then R.id.THEN WE HAVE THE XML EDT ID
        //we also need to typecast it bc it has only a View and needs an edittext data type
        EditText edtMeal = (EditText) findViewById(R.id.edtMeal);
        //set up tyhe listener to exactly the edtMeal, but we also need to add an isntance for the text watcher as a param for this method
        //text watcher creates all this code automatically
        edtMeal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //display the total cost if we have an initially given value
                //we will make a function BELOW THE ON CREATE METHOD and then call it right here
                displayTotal();
                displayBillTotal();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //setting up the seekbar
        SeekBar slider = (SeekBar) findViewById(R.id.seekBar);
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tipPercentage = progress;
                displayTipPercentage();
                displayTotal();
                displayBillTotal();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        } );

        //setup the reset button
        Button btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset the meal price input first
                //take the edit text bc it's in a different method
                EditText edtMeal = (EditText) findViewById(R.id.edtMeal);
                edtMeal.setText(null);
                edtMeal.dispatchDisplayHint(View.VISIBLE);

                //reset the tip percentage and slider and the percentage text view
                tipPercentage = INITIAL_TIP_PERCENTAGE;
                SeekBar slider = (SeekBar) findViewById(R.id.seekBar);
                slider.setProgress(tipPercentage);
                displayTipPercentage();

                //reset the result text view
                TextView txtResult = (TextView) findViewById(R.id.txtResult);
                txtResult.setText("Total");

                //my new changes for resetting the TotalBill Text View
                TextView txtBillResult = (TextView) findViewById(R.id.txtBillResult);
                txtResult.setText("Total Bill");

            }
        });
    }

    public void displayTipPercentage(){
        TextView display = (TextView) findViewById(R.id.txtPercentage);
        display.setText(tipPercentage + "%");
    }

    //we are calling this in the text watcher instance for the edtMeal xml text change listener
    //in order to change the total and then display it when the numbers added for the whole meal are changed
    public void displayTotal(){
        double mealCostAsANumber = 0;
        //we need to call the edtMeal again bc it's not inside the other method
        EditText edtMeal = (EditText) findViewById(R.id.edtMeal);
        String mealCostAsTextString = edtMeal.getText().toString();
        //convert meal cost text into meal cost number
        //first check if it's not empty
        if(!mealCostAsTextString.isEmpty()){
            mealCostAsANumber = Double.parseDouble(mealCostAsTextString);
        }

        //now the string was a number so we can do our calculation
        //tip percentage and 100 are ints, so make sure the 100 is a double as 100.00
        //FOR THE PERCENTAGE PLUS THE BILL AMOUNT add one at the end of the PAREN INSIDE THE PAREN
        //this is the total amount paid for by the user
        double totalCost = mealCostAsANumber * (tipPercentage / 100.00);

        //display in the textView with typecasting
        TextView txtResult = (TextView) findViewById(R.id.txtResult);
        //to disdplay the message we need a string not a number and then we need to tweak the formats too
        //locale defaults will work in your region
        //formatting f = fractional or floating point number
        //.2 is the
        String messageTotal = String.format(Locale.getDefault(), "$%.2f", totalCost);
        //now that it;s formated I can start to display it
        txtResult.setText(messageTotal);
    }

    // My addition for showing the while bill
    public void displayBillTotal(){
    double mealCostAsANumber = 0;
    //we need to call the edtMeal again bc it's not inside the other method
    EditText edtMeal = (EditText) findViewById(R.id.edtMeal);
    String mealCostAsTextString = edtMeal.getText().toString();
    //convert meal cost text into meal cost number
    //first check if it's not empty
    if(!mealCostAsTextString.isEmpty()){
        mealCostAsANumber = Double.parseDouble(mealCostAsTextString);
    }

    //now the string was a number so we can do our calculation
    //tip percentage and 100 are ints, so make sure the 100 is a double as 100.00
    //FOR THE PERCENTAGE PLUS THE BILL AMOUNT add one at the end of the PAREN INSIDE THE PAREN
    //this is the total amount paid for by the user
    double totalBillCost = mealCostAsANumber * (tipPercentage / 100.00 +1);

    //display in the textView with typecasting
    TextView txtBillResult = (TextView) findViewById(R.id.txtBillResult);
    //to disdplay the message we need a string not a number and then we need to tweak the formats too
    //locale defaults will work in your region
    //formatting f = fractional or floating point number
    //.2 is the
    String messageBillTotal = String.format(Locale.getDefault(), "$%.2f", totalBillCost);
    //now that it;s formated I can start to display it
    txtBillResult.setText(messageBillTotal);
}
}
