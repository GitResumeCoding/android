package com.example.mendy.myapplication;

import android.icu.text.DecimalFormat;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int mendy = 5003;
        Toast.makeText(MainActivity.this, "This is my information " + (mendy + 1), Toast.LENGTH_SHORT).show();
        //declare strings
        String title;
        String word;

        //initialize strings
        String applicationName = "Demo";
        String paragraph = "This is a longe paragraphs of text";

        //operations
        String message = applicationName + " has " + 1 + " text view.";
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

        //CHECKS
        if(applicationName.isEmpty()){
            Toast.makeText(MainActivity.this, "String is empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "String is NOT empty", Toast.LENGTH_SHORT).show();
        }

        //comparison checks
        if(message.equals(("Demo has 1 text view."))){
            Toast.makeText(MainActivity.this, "Strings are .equal", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "Strings are not.equal.", Toast.LENGTH_SHORT).show();
        }

        //convert from a string to a double number
        String numberAsAString  = "123.45";
        numberAsAString +=1;
        Toast.makeText(MainActivity.this, "my number concatonated " + numberAsAString, Toast.LENGTH_SHORT).show();
        double numberAsADouble = Double.parseDouble(numberAsAString);
        numberAsADouble += 1;
        Toast.makeText(MainActivity.this, "My number is: " + numberAsADouble, Toast.LENGTH_SHORT).show();

        //decimal formating
        double myPriceForItemNumber1 = 1234.775 ;
        DecimalFormat formatter = new DecimalFormat("$ #,###,##");
        String priceToDisplay = formatter.format(myPriceForItemNumber1);
        Toast.makeText(MainActivity.this, priceToDisplay, Toast.LENGTH_SHORT).show();

        //STRING FORMATTING USING THE string class
        double anotherPrice = 45.99999999;
        int numberOfItemsInStock = 6;
        String messageToDiplay = String.format(Locale.getDefault(), "My item has a price of $ %.2f Currently we have %d items in stock! ", anotherPrice, numberOfItemsInStock);
        Toast.makeText(MainActivity.this, messageToDiplay, Toast.LENGTH_SHORT).show();


        //Boolean values declaring and initializing variables, true false questions
        boolean isWifiTurnedOn;
        Boolean isUsbWorking = false;
        
        //checking if vairables are primitive (not holding so much space in memorty and good to use often and first created with others created with these)
        boolean intIsPrimitive = int.class.isPrimitive();
        boolean IntegerIsPrimitive = Integer.class.isPrimitive();
        Toast.makeText(MainActivity.this, "int: " + intIsPrimitive + "\nInteger " + IntegerIsPrimitive, Toast.LENGTH_LONG).show();
        char a;
        String b;
        Calendar myCalendar;

        //check if data types are an array or vairable
        boolean isArrayExample = String.class.isArray(); //this is a variable
        boolean isArrayExample2 = int[].class.isArray(); //this is an array (1D array or a vector)
        boolean isArrayExample3 = int[][].class.isArray(); //this is a 2D array or matrix
        Toast.makeText(MainActivity.this, "String: " + isArrayExample + "\nint[]: " + isArrayExample2 + "int[][]: " + isArrayExample3, Toast.LENGTH_LONG).show();

        //check if the string is empty
        String myText = "";
        boolean myCheckForEmptyString = myText.isEmpty();
        //no need to add ==true as the if statement does this automatically
        if (myCheckForEmptyString) {
            Toast.makeText(MainActivity.this, "myText is empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "myText is NOT empty", Toast.LENGTH_SHORT).show();
        }

        String isTheItemInStock = "TRUE";
        boolean isTheItemInStockCheck = Boolean.parseBoolean(isTheItemInStock);
        Toast.makeText(MainActivity.this, isTheItemInStockCheck? "Item is In Stock" : "Item is NOT in stock", Toast.LENGTH_SHORT).show();





        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
