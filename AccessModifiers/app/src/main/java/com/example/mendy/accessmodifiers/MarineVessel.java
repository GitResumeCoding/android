package com.example.mendy.accessmodifiers;

/**
 * Created by mendy on 2/9/2017.
 */

//ABSTRACT METHODS
//signatures of abstract methods
//have nothing in the body so not implementations
//declare them in the interface will be used to implement the classes
//here we are using them to declare:
//marinevessle (interface) will declare ship and solar ship

//this interface is a
//platform shared for a number of classes
//my ship and my solar powered ship will be marine vessles and share some functionaltiy
    //therefore they will share this interface


    //no methods
    //only declare the methods that are abstracted
    //then the classes will explain those methods (differently for each vessle type)

public interface MarineVessel {
    public abstract int getMaxNumberOfPeopleOnBoard(){
        //no body allowed bc they are abstracts, go see the class for this body implementation
        //each ship will have a different implementation
    }
}
