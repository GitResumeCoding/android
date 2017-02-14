package com.example.mendy.basicfunctions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //calling the car class we started to create
        //calling the constructor in our new class that we made
        Car myCar = new Car();
        //the constructor set the speed to 0
        //now we are calling the accelerate function
        //and then we will use the display method to show the speed
        //we passed the accelerate method an int that we want for speed
        myCar.accelerate(15);
        //we need to pass the display our context so we use this which gives it the screen/browser to use
        myCar.displaySpeedInKmPerHr(this);


        //integer functions that return integers
        //we created some from the car class
        myCar.displaySpeedInMilesPerHr(this);




        //calling my function, watch for what parameters were needed
        myFunction();
    }

    //void functions
    //doesn't return anything
    //just a place to hold code

    void myFunction(/*parameters*/) {
        //code to execure

    }

}
