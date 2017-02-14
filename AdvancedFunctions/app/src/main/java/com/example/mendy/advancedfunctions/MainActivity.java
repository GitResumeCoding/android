package com.example.mendy.advancedfunctions;


//Static and NON static methods


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Car myCar = new Car ("Honda", 0);

        //non-static
        //called on instance of car
        myCar.accelerate();

        //static
        //conversion method you can call on CLASS CAR and not needed on an instance of a car like above
        Car.convertFromKmToMiles(10);

        //display speed in km/h and m/h
        Toast.makeText(MainActivity.this, "Speed in km per hour: " + myCar.currentSpeedInKmPerHour +
                "\nSpeed in miles per hours: " + Car.convertFromKmToMiles(myCar.currentSpeedInKmPerHour),
                Toast.LENGTH_LONG).show();


    }
}
