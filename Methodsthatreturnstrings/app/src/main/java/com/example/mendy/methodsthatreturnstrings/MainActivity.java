package com.example.mendy.methodsthatreturnstrings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //a user just selected from a drop down list and we know what the items are
        String itemName = "white shirt";
        double itemPrice = 20.5; // we will truncate the numbers to a normals price if it's very logn via the message function
        String messageForThisItem = getMessageForItem(itemName, itemPrice);
        Toast.makeText(MainActivity.this, messageForThisItem, Toast.LENGTH_LONG).show();


    }
    String getMessageForItem(String nameOfItem, double priceOfItem){
        String message = "";
        message = String.format(Locale.getDefault(),
                "Item name: %s\nItem price: %.2f", nameOfItem, priceOfItem);
        return message;
        //we can also just replace message with return and return it that way bc we arent doing any operations on these items

    }
    //string methods
    //we can return some things from a strings method
    //return "" //an empty string
    //return null
    //return "sentence or more"

    }
}
