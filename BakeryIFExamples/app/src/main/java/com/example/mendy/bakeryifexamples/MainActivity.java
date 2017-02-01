package com.example.mendy.bakeryifexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //first way to write an if statement
        //if (/*condition*/)
            //statement, but only one

        //example

        if (5>3)
            Toast.makeText(MainActivity.this, "5 is greater than 3", Toast.LENGTH_SHORT).show();

        //if (/*condition*/) {
            //as many statements as you want

        //best example to generally use for if conditions
        boolean myFirstCondition = "Birds fly.".length() == 10 ; //true false
        if(myFirstCondition) {
            Toast.makeText(MainActivity.this, "Birds Fly.", Toast.LENGTH_SHORT).show();
            Toast.makeText(MainActivity.this, "Has 10 Characters", Toast.LENGTH_SHORT).show();
            //TODO input statements
        }

        //condition with boolean expressions
        int minimumPriceThreshold = 30;
        int currentProductPrice = 45;

        if (currentProductPrice>minimumPriceThreshold) {
            Toast.makeText(MainActivity.this, "Price is setupcorrectly", Toast.LENGTH_LONG).show();

        }

        //structure of an if else statement

        int housePrice = 900000;
        int marketPrice = 1000000000;


        if (housePrice>marketPrice) {
            Toast.makeText(MainActivity.this, "House Price is Above Market price", Toast.LENGTH_SHORT).show();;
        }
        else {
            Toast.makeText(MainActivity.this, "House Price is Below Market price", Toast.LENGTH_SHORT).show();;
        }

        //new example of an if else statement in java on android
        String feedback = "T-Shirts are nice";
        String feedbackStore = "Nice Store";
        int lengthOfText = feedback.length();
        int lengthOfTextStore = feedbackStore.length();
        int textLengthLimit = 15;

        if (lengthOfText <= textLengthLimit) {
            Toast.makeText(MainActivity.this, "Thanks for the feedback", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "Error: Text is above 15 characters.", Toast.LENGTH_SHORT).show();
        }

        if (lengthOfTextStore <= textLengthLimit) {
            Toast.makeText(MainActivity.this, "Thanks for the feedback", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "Error: Text is above 15 characters.", Toast.LENGTH_SHORT).show();
        }


        //NESTED IF STATEMENTS
        double speedOfBikeInKmPerHour = 40.75;
        //we are checking if the bike is moving
        if(speedOfBikeInKmPerHour > 0) {
            Toast.makeText(MainActivity.this, "Bike is moving", Toast.LENGTH_SHORT).show();
            //nested if to check if bike is moving fast
            if(speedOfBikeInKmPerHour>20) {
                Toast.makeText(MainActivity.this, "Bike is moving quite fast", Toast.LENGTH_SHORT).show();
                //Second nested if to cjeck if we are moving supersonic fast
                if(speedOfBikeInKmPerHour>40) {
                    Toast.makeText(MainActivity.this, "Bike is moving supersonic fast!", Toast.LENGTH_SHORT).show();
                }
            }

        }
        else {
            Toast.makeText(MainActivity.this, "Bike is Not Moving at all.", Toast.LENGTH_SHORT).show();
        }

        //nested if else or chain of else-if statements
        //Bakery examples
        int breadCount = 45;
        int amountRequired = 100;

        //to check productions progress
        if (breadCount == amountRequired/2 ) {
            Toast.makeText(MainActivity.this, "Half of amount required is done!", Toast.LENGTH_SHORT).show();
            }
        else {
            if (breadCount > amountRequired /2) {
                Toast.makeText(MainActivity.this, "More than half of the amount required is done", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this, "Less than half the required amount is done!", Toast.LENGTH_SHORT).show();
            }
        }

        //chaining if else statements
        //bakery selling limited amounts of drinks
        //americano coffe 2.35
        //lemonade 3.35
        //cappucino 4.50
        //green tea 5.50

        String productSelectedByTheUser = "green tea";

        float price = 0; //need decimal for float or double
        //setting up the price
        if(productSelectedByTheUser.equals("americano coffee")){
            price = 2.35f; //if we had a double we souldnt need the f
        }
        else if (productSelectedByTheUser.equals("lemonade")){
            price = 3.35f;
        }
        else if (productSelectedByTheUser.equals("cappucino")){
            price = 4.50f;
        }
        else {
            price = 5.50f; //this is the catch-all for green tea
        }
        Toast.makeText(MainActivity.this, productSelectedByTheUser + " has a price of " + price, Toast.LENGTH_SHORT).show();

        //logical operators AND/OR and improving the logical conditions for the if statements

        //AND operator with the 30-80 mph speed of a car within the legal limits
        int speedOfCarWithingCityLimitsInMph = 55;
        int lowerLimit = 30;
        int upperLimit = 80;

        if (lowerLimit <= speedOfCarWithingCityLimitsInMph && speedOfCarWithingCityLimitsInMph<=upperLimit){
            Toast.makeText(MainActivity.this, "We are driving within the legal speeds of 30 and 80", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "Illegal speeds within city limits!", Toast.LENGTH_SHORT).show();
        }

        //an example where to NOT use an OR operator bc this will crash our app
        //split this into a nested if statement

        String myString = null; //null string
        String myText = ""; //empty string

        //if (myString.isEmpty() || myString == null) {
        //    Toast.makeText(MainActivity.this, "Initialize variable", Toast.LENGTH_SHORT).show();
        //}

        //use this one instead
        if (myString == null) {
            Toast.makeText(MainActivity.this, "Intialize variable myString. Variable is not set to NULL", Toast.LENGTH_SHORT).show();
        }
        else {
            //if it's not null and is the empty string
            Toast.makeText(MainActivity.this, "Initialize variable myString. Variable is now an EMPTY string", Toast.LENGTH_SHORT).show();
        }

        //example for using the OR operator
        //multiplayer game with 2 players
        //boolen variable to see if player one won the gaem
        boolean didPlayerOneWin = true;
        boolean didPlayerTwoWin = false;

        if (didPlayerOneWin || didPlayerTwoWin) {
            Toast.makeText(MainActivity.this, "Game Over", Toast.LENGTH_SHORT).show();
        }

        //negations
        //not operator
        //useful to get unstuck when you need to change a condition based on the opposites
        //only want one if statement and negate the initial condition
        //to show a message to a user but don't care if they are connected to the internet only want to know when he is not conencted to the internet

        boolean userHasInternetAndIsConnected = false;
        boolean isConnectedToMobileData = false;

        //two step or one step method
        //check if user has internet access and then negate it
        //this only works when both of these are set to false
        if (! (userHasInternetAndIsConnected || isConnectedToMobileData)){
            Toast.makeText(MainActivity.this, "You need internet to use this app.", Toast.LENGTH_SHORT).show();
        }
        // other two step checking mothed for this using AND and the ! not operator
        if (!userHasInternetAndIsConnected &&  !isConnectedToMobileData){
            Toast.makeText(MainActivity.this, "You need internet to use this app.", Toast.LENGTH_SHORT).show();
        }

        //other named for the logic operators
        //not = negation
        //AND = conjuntion
        //OR = Disjunction



        //parity checking of a number
        //ODDS AND EVENS! is called parity checking

        //dice example when rolled
        //algorithm for checking parity
        //using the modulo rules
        // divide by 2 if 1 is the remainder means it's odd
        // divide by 2 if the remainder is 0 means it is even

        int numberDisplayedOnDice = 5;
        //checking of the number on the dice is even
        if (numberDisplayedOnDice %2 == 0) {
            Toast.makeText(MainActivity.this, "Dice is Even", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "Dice is Odd", Toast.LENGTH_SHORT).show();
        }
















        }
}
