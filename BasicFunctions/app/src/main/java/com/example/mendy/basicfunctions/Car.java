package com.example.mendy.basicfunctions;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by mendy on 2/6/2017.
 */

public class Car {
    //private is so that it's not accessible from anywhere outside this class
    private int speedKmPerHr;

    //we need a constant for the conversion from km to miles
    //public so that we can use it elsewhere
    //final so that it is not changed
    //capital with underscores bc it is a constant
        public final double KM_TO_MILES = 0.621;


    //constructor function
    public Car(){
        this.speedKmPerHr = 0;

    }

    //now creating my void functions
    void accelerate(int increaseInSpeed){
        this.speedKmPerHr += increaseInSpeed;
            }
    
    //new void function to display to screen
    //we also made a context parameter in the paranetheses
    void displaySpeedInKmPerHr(Context context){
        Toast.makeText(context, "Current Speed is in KM per hours" + this.speedKmPerHr, Toast.LENGTH_SHORT).show();
    }

    //bc we made the obove km to hour constant accessible with public we can use that instead of forcing to add a parameter
    int convertSpeedFromKmToMiles() {
        //we are adding in int in () so that we can typecast our numbers
        // this means that we are switching all the things to integers since one of them was a double from earlier
        //shrinks things down to whole digits for ease
        return (int) (this.speedKmPerHr * KM_TO_MILES);
    }

    //
    void displaySpeedInMilesPerHr(Context context) {
        Toast.makeText(context, "Current Speed in Miles Per Hour is " + convertSpeedFromKmToMiles(), Toast.LENGTH_SHORT).show();
    }


    //new method that will return an int
    // say int, create a name, add the code, and add RETURN <integer value>; don't forget you'll need some interger variable from inside it
    //it is not stored, it only returns it so to save it you need to store it inside a new variable

    int result = myMethod()

    int myMethod(){
        int myLocalVariable = -150;
        return myLocalVariable;
    }
}
