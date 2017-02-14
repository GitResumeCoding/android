package com.example.mendy.floatmethodsandbooleanmethods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String itemSelected = "white shirt";
        float priceOfItemSelected = getPrice(itemSelected);
        //now we will display this from here not from the method
        Toast.makeText(MainActivity.this, "You selected: " + itemSelected +
                "\nPrice: "  + priceOfItemSelected, Toast.LENGTH_SHORT).show();

    }

    //use void to display something to the screen via a method not an int or float or double
    

    //signature of an item
    //type, name, parameters and their types
    //calculates from all the store items and gives us the price according to that item
    float getPrice(String nameOfItemSelected) {
        float price = 0;


        if(nameOfItemSelected.equals("white shirt")) {
            price = 20.5f;
        }
        else if(nameOfItemSelected.equals("blue tshirt")){
            price = 10;
        }
        else if(nameOfItemSelected.equals("red shoes")){
            price = 35.75f;
        }
        else if(nameOfItemSelected.equals("red T-Shirt")){
            price = 15f;
        }

        return price;
        //we are returning the price not displaying it

    }
}
