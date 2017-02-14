package com.example.mendy.advancedfunctions;

/**
 * Created by mendy on 2/7/2017.
 */

public class Car {
    String brand;
    double currentSpeedInKmPerHour;


    public Car(String brand, double initialSpeedInKmPerHour) {
        this.brand = brand;
        this.currentSpeedInKmPerHour = initialSpeedInKmPerHour;

    }

    //non-static method applied to every car
    void accelerate() {
        this.currentSpeedInKmPerHour += 10;
    }

    //static method ()
    static double convertFromKmToMiles(double kilometers){
        final double KM_TO_MILES = 0.621;
        return kilometers * KM_TO_MILES;
    }
}
