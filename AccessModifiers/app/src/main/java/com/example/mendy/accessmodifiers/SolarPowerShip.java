package com.example.mendy.accessmodifiers;

/**
 * Created by mendy on 2/7/2017.
 */

//we added the interface to this class to extend
public class SolarPowerShip extends Ship implements MarineVessel{

    private final int MAX_NUMBER_OF_PEOPLE_ON_BOARD = 100;

    @Override
    public void accelerate(){
        this.currentCruisingSpeedInKnotsPerHour +=10;
    }

    //to find and autocomplete this from the interface start typing GET and it will show the methods from the interface


    //see the other example for how to implement an abstract interface method that we are overriding when we extend and implement an interface
    @Override
    public int getMaxNumberOfPeopleOnBoard() {
        //we removed the default super and will add our own wich is the constant
        return MAX_NUMBER_OF_PEOPLE_ON_BOARD;
    }
}
