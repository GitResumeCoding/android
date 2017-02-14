package com.example.mendy.accessmodifiers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

//access modifiers

//acessibility modes of methods
//different levels of privacy
//in order of privacy
//where you can call them, same classes or in inheritance ones or on the same package


//public
//protected
//package
//private





public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.myFunction();

        Ship myShip = new Ship("The Royal Cruiser", 10);
        //expecting to see 400K
        Toast.makeText(MainActivity.this, "myShip has a capacity of" +
                myShip.getMaxNumberOfPeopleOnBoard() + "people on board.",
                Toast.LENGTH_LONG).show();

        SolarPowerShip myNovelShip = new SolarPowerShip();
        //default constructor is being used
        Toast.makeText(MainActivity.this, "my solar powered ship has a capacity of" +
                myNovelShip.getMaxNumberOfPeopleOnBoard() +
                "people on board",
                Toast.LENGTH_SHORT).show();

        Ship aNewShip = new Ship("Soverign of Seas", 30);

        aNewShip.accelerate(); //increases by 5 knots bc it was the signature of no input parameters and no data types
        Toast.makeText(MainActivity.this, aNewShip.toString(), Toast.LENGTH_LONG).show();

        aNewShip.accelerate(10); //I am setting the speed as my own (10 knots per hour) with this accelerate signature as it takes a double type as the parameter
        Toast.makeText(MainActivity.this, aNewShip.toString(), Toast.LENGTH_LONG).show();

       //speed increased by roughly 3 knots per hours (1km = 0.53 knots conversion)
        aNewShip.accelerate("6 kilometers per hour"); //signature of accelerate method: String type which will be converted into the units
        Toast.makeText(MainActivity.this, aNewShip.toString(), Toast.LENGTH_LONG).show();

        Ship[] myFleet = Ship.createFleetOf5Ships("Soverign of Seas", 20,
                                                    "Sea Sharp", 35,
                                                        "Majestic", 40,
                                                        "The great White", 20,
                                                         "The Royal Cruiser", 15);
        Ship.hastenUpFleet(myFleet);

        for(Ship myCruiser : myFleet) {
            Toast.makeText(MainActivity.this, myCruiser.toString(), Toast.LENGTH_SHORT).show();

        }



    }

    private static void myFunction(){


    }
}
