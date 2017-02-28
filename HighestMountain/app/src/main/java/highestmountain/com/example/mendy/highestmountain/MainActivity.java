package highestmountain.com.example.mendy.highestmountain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //instance variables that will hold out buttons and text views
    private Button showMeButton;
    private TextView showTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up button
        showMeButton = (Button) findViewById(R.id.buttonID);
        showTextView = (TextView) findViewById(R.id.textViewID);

        //creating the string that will hold all our mountin names
        final String[] mountains = {"Everest", "Kelimanjaro", "Makulu", "Maket", "Trivor", "K12", "Ultar", "Mana", };

        //hook up button to an event listener so when it's clicked we can know to do something specific
        //in this case it will be to show a random mountain
        showMeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //handle our events
                //we created this by writing the showMeButton.setOnClickListener(and created this new instance)
                //then we right clicked and clicked generate... and then in override we choose the onclick option

                //create random number
                Random rand = new Random();
                //variable that will hold that random number
                //pass in the array length so it will be 8 items (from 0-7)
                int randomNum = rand.nextInt(mountains.length);
                //fetch the text viw
                //call setText and pass it the random number choice in the mountain array call
                showTextView.setText(mountains[randomNum]);

            }
        });

    }
}
