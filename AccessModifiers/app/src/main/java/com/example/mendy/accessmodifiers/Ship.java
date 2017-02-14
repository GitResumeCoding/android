package com.example.mendy.accessmodifiers;

/**
 * Created by mendy on 2/7/2017.
 */

public class Ship implements MarineVessel{
    private String cruiseLinerName;
    protected double currentCruisingSpeedInKnotsPerHour;
    private double fuelTankCapacityInGallons;

    //default constructor so I can extend this class
    public Ship(){
        this.cruiseLinerName = "";
        this.currentCruisingSpeedInKnotsPerHour = 0;
        this.fuelTankCapacityInGallons = 200000;
    }

    //constructor
    public Ship(String cruiseLinerName, double initialCruisingSpeed){
        this.cruiseLinerName = cruiseLinerName;
        this.currentCruisingSpeedInKnotsPerHour = initialCruisingSpeed;
        this.fuelTankCapacityInGallons = 200000;


    }

    @Override
    public int getMaxNumberOfPeopleOnBoard() {
        //we need to typecast it as an int
        //just used a simple algorith to know the size of the ship
        return (int)(fuelTankCapacityInGallons*2);
    }

    //setter method, we made it final so that the override function (which we create then removed already) cant mess with this from the solar ship creation instance
    public final void setFuelTankCapacityInGallons(double capacityInGallons) {
        this.fuelTankCapacityInGallons = capacityInGallons;

    }

    //same name and zero parameters for overloading a method
    //signature accelerate, zero parameters, no types given
    public void accelerate (){
        this.currentCruisingSpeedInKnotsPerHour += 5;

    }
    //same name with one parameter for overloading a method
    //signature accelerate, one parameters, double as the data type for the variable
    public void accelerate(double increaseInSpeed){
        this.currentCruisingSpeedInKnotsPerHour += increaseInSpeed;
    }

    //same name, one parameter, with different data type for overloading a method
    ///signature accelerate, one parameters, String as the data type for the variable
    public void accelerate(String amountAndUnitsForAcceleration){
        //amountsAndUnitsForAcceleration: 6 km per hour or 9 knots per hour is the expected values
        //from the user when we call this method
        //then update the speed
        double amount; //holds decimal number
        final double KM_TO_KNOTS = 0.53;
        String units;
        String[] words = amountAndUnitsForAcceleration.split(" ");

        amount = Double.parseDouble(words [0]); //we need to convert from string to number will hold the number which is the first word on the array
        units = words[1] + " " + words[2] + " " + words[3];//adding back a space and the words together of XXX per hour

        if(units.equals("knots per hour")) {
            this.currentCruisingSpeedInKnotsPerHour += amount;
            }
        //we need to do an extra step here to convert to km per hour using out conversion using tghe final from above
        else if(units.equals("kilometers per hour")) {
            this.currentCruisingSpeedInKnotsPerHour += (amount * KM_TO_KNOTS);
        }
    }

    public static Ship[] createFleetOf5Ships(String brand0, double initialSpeed0,
                                             String brand1, double initialSpeed1,
                                             String brand2, double initialSpeed2,
                                             String brand3, double initialSpeed3,
                                             String brand4, double initialSpeed4){
        Ship[] myFleet = new Ship[5];
        myFleet[0] = new Ship(brand0, initialSpeed0);
        myFleet[1] = new Ship(brand1, initialSpeed1);
        myFleet[2] = new Ship(brand2, initialSpeed2);
        myFleet[3] = new Ship(brand3, initialSpeed3);
        myFleet[4] = new Ship(brand4, initialSpeed4);

        return myFleet;


    }



    //bc there is no return method here, we need to call this from within the constructor method in MainActivity
    //this simply takes an array and adds the accelerate 5 knots to each in the array
    //can use a data type I created such as the ship, or I can use a string array or somethign else entirely
    public static void hastenUpFleet(Ship[] myFleet){
        for(Ship myCruiser : myFleet){
            myCruiser.accelerate(); //method ship array with no return it's a void method
            //therefore we added in the main activity the Ship.hatenUpMyFleet(myFleet); method

        }
    }

    @Override
    public String toString(){

        return  "Cruise Liner Name: " + this.cruiseLinerName +
                "\nCurrent Cruising Speed in knots per hour: " + this.currentCruisingSpeedInKnotsPerHour + "knots per hour";
    }
}
