package com.example.mendy.methodsthatreturncharacters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //takes a string and finds the first vowel in the string

        String sentence = "The Sky is Blue.";
        char myFirstVowel = getFirstVowel(sentence);
        Toast.makeText(MainActivity.this, "The first vowel inside " +sentence + "is " + myFirstVowel, Toast.LENGTH_LONG).show();


    }

    char getFirstVowel(String mySentence) {
        char[] mySentenceAsCharArray = mySentence.toCharArray();
        //traverse the char array and get each character inside and check if its a vowel
        //vowel means it is in the vowel list
        String vowels = "aeiousAEIOU";
        //enhanced loop without an iterator
        //read the : symbol as IN
        //so for each character in mySentenceAsCharArray Do something
        for(char character : mySentenceAsCharArray){
            //can use the index of, but its more complex
            // this is a typecast change bc of the empty string so therefore this works
            if(vowels.contains(character + "")){
                return character;
            }
        }
        //if there is a vowel inside it's returned
        //otherwise return the NULL character
        //indicating that we didn't have a vowel
        return '\u0000';
    }



    //functions that can return characters

    char myFunction (/*parameters*/){
        return 'char in single quotes';
    }

    //to catch the returnign result from the function
    char myCharacterVariableFromResults = myFunction();

}


