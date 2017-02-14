package com.example.mendy.arrays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Arrays
        //

        //declare an array of integers
        //course with multiple sections and students in the sections
        int [] numberOfStudentsInSectionOfCourse;

        //Initialize the array to 5 values and add valuies one bu one
        int [] playerScore = new int[5]; //length of the array

        //defaullt values for an array is zero

        //change the array information for playerscore onw
        playerScore[0] = 120;
        playerScore[1] = 320;
        playerScore[2] = 355;
        playerScore[3] = 90;
        playerScore[4] = 220;

        //can't change the 5th one bc we'll get an error bc we never initialized that one

        // new method to initialize and add values all at once
        int [] myPlayerScores = {120, 320, 355, 90, 220};

        //traversal of an array
        //going over each one
        int[] myNumbers = {120, 520, 320, 20, 555, 778, 604, 909};
        //using a for loop to iterate and traverse through an array
        //we use a for loop when we know the exact amount of times we need to go over the array
        //adding 9000 to each of the values and displaying the new numbers to the screen via Toas

        //sorting an array ascending
        Arrays.sort(myNumbers);


        for (int i = 0; i < myNumbers.length; i = i + 1)
        {
            myNumbers[i] += 9000;
            Toast.makeText(MainActivity.this, "The number in index " + i + " contains the values of " + myNumbers, Toast.LENGTH_SHORT).show();

        }
        //descending order of an array
        //adding 9000 to each element in the array
        //traversing of an array
        Integer[] myDescendingNumbers = {120, 520, 320, 20, 555, 778, 604, 909};
        //Or we can dort in descending order
        //need to add an extra parameter
        //need to also change the array to an Integer array (primitive type)
        Arrays.sort(myDescendingNumbers, Collections.reverseOrder());
        for (int i = 0; i < myDescendingNumbers.length; i = i + 1)
        {
            myDescendingNumbers[i] += 9000;
            Toast.makeText(MainActivity.this, "The number in index " + i + " contains the values of " + myDescendingNumbers, Toast.LENGTH_SHORT).show();

        }
        //Collections is considered a Library
        //int is an object
        //Integer is a primitive type and has more tricks to work with

        //==================================================
        //declaring and initializing a decimal number array
        //adding values to the array one by one and all at the same time
        //FLOAT AND DOUBLE PRIMITIVE TYPES 7/15 number places spaces

        //declaring
        float [] setOfNumber;
        double [] anotherSetOfNumbers;

        //initializing and add values one by one
        float int NumberOfStudents = 34;
        float[] gradesForMidtermOne = new float[NumberOfStudents];
        gradesForMidtermOne[0] = 90.5f; //f is for the float indicator
        gradesForMidtermOne[23] = 75f;

        //initialize and add valies all at once
        double[] pricesInAStore = {10.90, 12.5, 0.75, .15, 120, 23.9999, 3.1415988888855543};
        pricesInAStore[0] = pricesInAStore[0] + 10;

        //===============================================

        //FOR EACH LOOP for Traversal and Sorting of Decimal Numbers
        //ascending and descending sorting
        //primitives versus objects and wrappers


        //--> FOR EACH loop stores the VALUES
        //--> FOR loop stores the INDEXES

        //initialize an array
        float[] pricesInStore = {10.95f, 75f, 0.15f, 99.6f, 199.55f};
        //traversal with a for each loop
        //no iterator
        //no index
        Toast.makeText(MainActivity.this, "Display prices: ", Toast.LENGTH_SHORT).show();

        //sorting regular asending from lowest to highest

        Arrays.sort(pricesInAStore);



        //enhanced for loop or for each loop or java enhanced for loop
        //this iterator will hold the values not the indexes
        // need to use the :
        // no computations with this loop bc then we update it for ONLY this loop
        //use a for loop not a for each loop to update the array
        for (float price : pricesInStore )
        {
            Toast.makeText(MainActivity.this, "Price: " + price, Toast.LENGTH_SHORT).show();
        }

        //+++++++++++++++++++++++++
        //Desending order sort of an array
        //needs the float to be changed to FLOAT which is a wrapper class for the primitive float type

        //initialize an array
        Float[] pricesInStoreDesending = {10.95f, 75f, 0.15f, 99.6f, 199.55f};
        //traversal with a for each loop
        //no iterator
        //no index
        Toast.makeText(MainActivity.this, "Display prices from Highest to Lowest : ", Toast.LENGTH_SHORT).show();

        //sorting regular DESCENDING from lowest to highest
        Arrays.sort(pricesInStoreDesending);


        //enhanced for loop or for each loop or java enhanced for loop
        //this iterator will hold the values not the indexes
        // need to use the :
        // no computations with this loop bc then we update it for ONLY this loop
        //use a for loop not a for each loop to update the array
        for (float price : pricesInStoreDesending )
        {
            Toast.makeText(MainActivity.this, "Price: " + price, Toast.LENGTH_SHORT).show();
        }

        //+++++++++++++++++++++++++++++++++++++++++++++++++
        //DOUBLE using the primitives data types (i.e. no wrapper class Double)

        //initialize an array
        double[] pricesInStoreDouble = {10.95, 75, 0.15, 99.6, 199.55};
        //traversal with a for each loop
        //no iterator
        //no index
        Toast.makeText(MainActivity.this, "Display prices of the Doubles: ", Toast.LENGTH_SHORT).show();

        //sorting regular asending from lowest to highest

        Arrays.sort(pricesInStoreDouble);



        //enhanced for loop or for each loop or java enhanced for loop
        //this iterator will hold the values not the indexes
        // need to use the :
        // no computations with this loop bc then we update it for ONLY this loop
        //use a for loop not a for each loop to update the array

        //THIS was changed from FLOAT to DOUBLE
        for (double price : pricesInStoreDouble )
        {
            Toast.makeText(MainActivity.this, "Price: " + price, Toast.LENGTH_SHORT).show();
        }

        // to change the highest from lowest
        //use the Double wrapper class
        //initialize an array
        Double[] pricesInStoreDoubleWrapper = {10.95, 75.0, 0.15, 99.6, 199.55};
        //traversal with a for each loop
        //no iterator
        //no index
        Toast.makeText(MainActivity.this, "Display prices of the Doubles using the wrapper class in high to low desending order : ", Toast.LENGTH_SHORT).show();

        //sorting regular desending from lowest to highest

        Arrays.sort(pricesInStoreDoubleWrapper, Collections.reverseOrder());



        //enhanced for loop or for each loop or java enhanced for loop
        //this iterator will hold the values not the indexes
        // need to use the :
        // no computations with this loop bc then we update it for ONLY this loop
        //use a for loop not a for each loop to update the array

        //THIS was changed from FLOAT to DOUBLE
        for (double price : pricesInStoreDoubleWrapper )
        {
            Toast.makeText(MainActivity.this, "Price: " + price, Toast.LENGTH_SHORT).show();
        }

        //
        // =========================================================
        // CHARACTER ARRAYS
        //==========================================================
        //

        //declare
        char [] word;
        //initialize and add values at once
        char [] myApplicationName = {'a', 'n', 'd', 'r', 'o', 'i', 'd'};

        //initialize and add values to the array
        char [] myCharArray = new char [100];
        myCharArray[0] = '0';
        myCharArray[1] = '+';
        myCharArray[2] = 'x';
        myCharArray[3] = 'w';
        myCharArray[4] = 'l';

       //default value is 0000 with null inside each one

        //=================================================
        //traversal of a char array and sorting of a char array

        //what if we want to know each vowel or constonant in a word
        //traversal through the char array

        //initialize variable
        char [] wordChar = {'a', 'n', 'd', 'r', 'o', 'i', 'd'};
        String vowelsChar = "aeiou";
        // when we traverse we are looking for an index that is greater or = to 0 otherwise it will be a constonant
        // -1 means it is not found
        // >= to 0 means it is found in the string
        //so for each charachter in the the word variable (androind)
        //we will display the message character and the then we check if it's a vowel or a constoant
        // boolean expresion condition
        //index of the vowel (android)
        // is it greater or equal to zero, if it is display VOWEL
        // otherwise if it is negative then it's not in the vowel string then it's a consotnat
        // the else in the condition happens after the ":" when we display the CONSTOTANT for all the char's that are int he char array anddroid


        //traversal
        //with sorted

        for (char character : wordChar)
        {
            Toast.makeText(MainActivity.this, character + " is a " + (vowelsChar.indexOf(character) >= 0? "vowels" : "consonant"), Toast.LENGTH_SHORT).show();
        }

        //============================================
        //SORTING
        char [] wordSorted = {'a', 'n', 'd', 'r', 'o', 'i', 'd'};
        String vowelsSorted = "aeiou";
        Arrays.sort(wordSorted);
        for (char characterSorted : wordSorted)
            Toast.makeText(MainActivity.this, characterSorted + " is a " + (vowelsSorted.indexOf(characterSorted) >= 0? "vowels" : "consonant"), Toast.LENGTH_SHORT).show();

        //SORTING desending triggered by ascii values
        //note the capital letters
        //note the Character wrapper class type
        //note the Collections Library usage of the reversrOrder method

        Character [] wordSortedAscii = {'a', 'N', 'D', 'R', 'o', 'i', 'd'};
        String vowelsCap = "aeiouAEIOU";
        Arrays.sort(wordSortedAscii, Collections.reverseOrder());
        for (char characterCap : wordSortedAscii)
        {
            Toast.makeText(MainActivity.this, characterCap + " is a " + (vowelsCap.indexOf(characterCap) >= 0? "vowels" : "consonant"), Toast.LENGTH_SHORT).show();
        }

        //ascending: alphabetical order
        //takes uppercase ordered first then lowercase letters get ordered

        //++++++++++++++++++++++++++++++++++++++++++
        //declare and initialize STRING arrays
        //used for words and multiple sentences and paragraphs

        //declare String arrays
        String [] playerNames;

        //initialize and add values one by one
        String[] carBrands = new String[10];
        carBrands[0] = "Honda";
        carBrands[0] = "Toyota";
        carBrands[0] = "Ford";
        carBrands[0] = "Infinity";
        carBrands[0] = "Ram";

        //initialize and add values all at onceString
        String[] sentence = {"The", "sky", "is", "blue"};

        //---------------------------------------------------
        //default value is null string in an undefined array

        //split string into arrays, traverse and insensitive case sort

        //initialize and split method
        String sentenceJava = "Jave is a nice and fine programming language";
        String[] words = sentenceJava.split(" ");

        //traversal of the array  called sentence2 above using a for loop and display that each word has how many letters in it
        for (String wordJava: words)
        {
            Toast.makeText(MainActivity.this, wordJava + " has " + wordJava.length() + " letters ", Toast.LENGTH_SHORT).show();
        }

        //==========================================
        //sorting the results of the sentencePython

        String sentencePython = "Python is a nice and fine programming language, but not as interviewed as Java";
        String[] wordsPython = sentencePython.split(" ");

        //SORT
        //Java will be first bc it will have the upper case character
        //This is case SENSITIVE meaning that the upper case letters will start to take precedence and be sorted first
        Arrays.sort(wordsPython);

        //traversal of the array  called sentence above using a for loop and display that each word has how many letters in it
        for (String wordPython: wordsPython)
        {
            Toast.makeText(MainActivity.this, wordPython + " has " + wordPython.length() + " letters ", Toast.LENGTH_SHORT).show();
        }

        //CASE INSENSITIVE SORTING

        String sentencePythonInsensitive = "Python is a nice and fine programming language, but not as interviewed as Java";
        String[] wordsPythonInsensitive = sentencePythonInsensitive.split(" ");

        //SORT alphabetically
        //Java will be first bc it will have the upper case character
        //This is case INSENSITIVE meaning that the upper case letters will NOT start to take precedence and be sorted first
        Arrays.sort(wordsPythonInsensitive, String.CASE_INSENSITIVE_ORDER);
        //called a COMPARATOR for the feature of array sort

        //traversal of the array  called sentence above using a for loop and display that each word has how many letters in it
        for (String wordPythonInsensitive: wordsPythonInsensitive)
        {
            Toast.makeText(MainActivity.this, wordPythonInsensitive + " has " + wordPythonInsensitive.length() + " letters ", Toast.LENGTH_SHORT).show();
        }

        //can use the . as  a separater for when you are trying to split a paragraph into sentences




        //Traversal and sort of a BOOLEAN Array

        //multiple lightbulbs that can be turned on and off

        //declare and initialize 4 light bulbs set to FALSE by default
        // also declating and finalizing the number of lightbulbs in the array

        final int NUMBER_OF_LIGHTS = 4;

        //if we didn't use the sorting method ARRAYS then we could just use the primitive type of boolean
        //using the Boolean wrapper class here
        Boolean [] isLightTurnedOn = new boolean[4];
        isLightTurnedOn[0] = true;
        isLightTurnedOn[1] = false;
        isLightTurnedOn[2] = true;
        isLightTurnedOn[3] = true;


        //SORTING
        Arrays.sort(isLightTurnedOn);
        //The false values come first when sorted!

        //initilize
        // can also initialize it this way
        // boolean [] isLightTurnedOn = {true, false, true, false};
        //must abide by the final value above

        //Traversal with a for loop normal one with an iterator
        //can also use the one less than the array, but we finalized this number so this is more clear
        //note the ? usage here in the sort toast message
        for (int i =0; i < NUMBER_OF_LIGHTS; i++)
        {
            Toast.makeText(MainActivity.this, "Light bulb number " + i + (isLightTurnedOn[i]? " Message given if light is tirned ON as TRUE" : " Message is the light is tirned OFF as FALSE"), Toast.LENGTH_SHORT).show();
        }















    }













































    }
}
