package highestmountain.com.example.mendy.highestmountain;

import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //instance variables that will hold our buttons and text views
    private Button showMeButton;
    private TextView showTextView;
    private TextView showTextViewCounter;
    private EditText getEditTextLength;
    private EditText getEditTextSpeed;

    public long counter = 0;

    public long timerLength = 10000; //10 seconds one second is 1000 CANNOT BE AN INT NEEDS TO BE A LONG
    public long timerSpeedGap = 1000; //1 second gap can change to ever millisecond 100 CANNOT BE AN INT NEEDS TO BE A LONG
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up button
        showMeButton = (Button) findViewById(R.id.buttonID);
        showTextView = (TextView) findViewById(R.id.textViewID);
        showTextViewCounter = (TextView) findViewById(R.id.editTextCounter);
        getEditTextLength = (EditText) findViewById(R.id.editTextTimerLength);
        getEditTextSpeed = (EditText) findViewById(R.id.editTextTimerGap);

        //check if the parser can handle the possible values that textView.getText().toString() can supply.
        // A NumberFormatException is thrown if you try to parse an empty string(""). Or, if you try to parse '.'
        //if (!showTextViewLength.equals("") && !showTextViewLength.equals(".")) {
        //    if(!showTextViewSpeed.equals("") && !showTextViewSpeed.equals(".")){
        //        timerSpeedGap = Integer.valueOf(showTextViewSpeed.getText().toString());
        //    }
        //    timerLength = Integer.valueOf(showTextViewLength.getText().toString());
        //}

//        public long timerSpeedGetConvert() {
//        final long userTimerSpeedGap = Long.parseLong(getEditTextSpeed.getText().toString()); //CANNOT BE AN INT NEEDS TO BE A LONG also valueOf gives you a new object not a primitive
//        return userTimerSpeedGap;
//    }

 //   public long timerLengthGetConvert(){
//        final long userTimerLength = Long.parseLong(getEditTextLength.getText().toString()); //CANNOT BE AN INT NEEDS TO BE A LONG
  //      return userTimerLength;
 //   }
    //    final long userTimerSpeedGap = Long.parseLong(getEditTextSpeed.getText().toString()); //CANNOT BE AN INT NEEDS TO BE A LONG also valueOf gives you a new object not a primitive
     //   final long userTimerLength = Long.parseLong(getEditTextLength.getText().toString()); //CANNOT BE AN INT NEEDS TO BE A LONG





        //creating the string that will hold all our random items
        final String[] mountains = {"Everest", "Kelimanjaro", "Makulu", "Maket", "Trivor", "K12", "Ultar", "Mana",};

        //hook up button to an event listener so when it's clicked we can know to do something specific
        //in this case it will be to show a random mountain
        showMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            final long userTimerLength = Long.parseLong(getEditTextLength.getText().toString()); //CANNOT BE AN INT NEEDS TO BE A LONG
            final long userTimerSpeedGap = Long.parseLong(getEditTextSpeed.getText().toString()); //CANNOT BE AN INT NEEDS TO BE A LONG also valueOf gives you a new object not a primitive



            //creating timer
                new CountDownTimer(userTimerLength, userTimerSpeedGap) {
                    public void onTick(long millisecondsUntilFinished) {

                        showTextViewCounter.setText(String.valueOf(counter));
                        counter++;




                        //create random number
                        Random rand = new Random();
                        //variable that will hold that random number
                        //pass in the array length so it will be 8 items (from 0-7)
                        int randomNum = rand.nextInt(mountains.length);
                        //fetch the text view
                        //call setText and pass it the random number choice in the mountain array call
                        showTextView.setText(mountains[randomNum]);

                    }

                    public void onFinish() {

                    }
                }.start();

                //handle our events
                //we created this by writing the showMeButton.setOnClickListener(and created this new instance)
                //then we right clicked and clicked generate... and then in override we choose the onclick option


            }
        });

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
