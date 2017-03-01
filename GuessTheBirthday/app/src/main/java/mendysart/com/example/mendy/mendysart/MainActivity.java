package mendysart.com.example.mendy.mendysart;

import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.picasso.Picasso;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //instance variables that will hold our buttons and text views
    private Button showMeButton;
    private TextView showTextView;
    private TextView showTextViewCounter;
    private EditText getEditTextLength;
    private EditText getEditTextSpeed;
    private ImageView imageView;

    public long counter = 0;

    //this public variable is used inside the countdowntimer to change the URL in Picasso in the imageview
    public int randomNumUrl = 1;

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
        imageView = (ImageView) findViewById(R.id.imageView);

        //loading image from the URL into the imageview using Picasso
        //Picasso.with(this)
        //        .load("http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/portrait-painting-cinematographer-camera-operator-behind-the-scenes-movie-tv-show-film-chicago-med-mendyz.jpg")
         //       .into(imageView);
        //adding in some error checking if the image doesn't load, and placeholder for real time application use
        //added the placeholder and the imagenotfound from the android add image resource in drawable
        //Picasso.with(this)
         //       .load("http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/portrait-painting-cinematographer-camera-operator-behind-the-scenes-movie-tv-show-film-chicago-med-mendyz.jpg")
         //       .placeholder(R.drawable.placeholder)
         //       .error(R.drawable.imagenotfound)
          //      .into(imageView);
        //error checking in case the image is huge or tiny from the url, we will resize it here
        //needed to use override(200,200) instead used resize with those int values

        Picasso.with(this)
                .load("http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/portrait-painting-cinematographer-camera-operator-behind-the-scenes-movie-tv-show-film-chicago-med-mendyz.jpg")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.imagenotfound)
                .resize(600,600)
                .centerCrop().
                into(imageView);



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
        final String[] mountains = {"Cinematographer Portrait", "Washing", "Eyes to the Soul", "Tulips", "Medical", "Cat Portrait", "A Chance At The World", "Old Wizard",};

        //creating the url string for rotating images
        final String[] imageUrls = {
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/esther-what-is-so-funny-mendyz.jpg",
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/windows-into-the-soul-eye-painting-closeup-all-seeing-eye-in-blue-pink-red-magenta-yellow-eye-of-go-mendyz.jpg",
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/portrait-of-female-with-hair-billowing-everywhere-in-radiant-unsmiling-sharp-features-golden-warm-colors-and-upturned-nose-curls-and-aliens-of-the-departure-mendyz-.jpg",
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/the-little-prince-floating-in-box-on-a-sea-of-dreams-with-chaotic-swirls-and-waves-of-thought-hope-love-and-freedom-portrait-of-a-boy-sleeping-in-a-cardboard-box-on-an-ocean-of-inspiration-mendyz-.jpg",
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/portrait-of-a-man-in-sunglass-smoking-a-cigar-in-the-sunshine-wearing-a-hat-and-riding-a-motorcycle-in-pink-green-yellow-black-blue-oil-paint-with-raking-light-to-pick-up-paint-texture-mendyz-.jpg",
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/portrait-painting-in-acrylic-paint-of-a-young-fresh-girl-with-colorful-hair-in-a-library-with-books-mendyz.jpg",
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/young-woman-washing-river-bent-over-old-master-sketch-painting-in-orange-blue-oil-like-acrylic-warm-paint-mendyz.jpg",
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/portrait-painting-of-girl-in-red-gray-black-with-wistful-thoughts-of-fleeting-memories-mendyz-.jpg",
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/tulip-flowers-bouquet-in-two-round-water-filled-small-globe-shaped-vases-on-a-table-still-life-of-bo-mendyz.jpg",
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/orange-blue-purple-medical-caduceus-thats-atmospheric-and-rising-with-mystery-m-zimmerman.jpg",
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/chabad-lubavitch-rebbe-colorful-bright-acrylic-painting-menachem-schneerson-rabbi-crown-heights-rainbow-mendyz-.jpg",
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/flaming-blue-and-orange-kitty-cat-tiger-resting-gently-from-the-prowl-mendyz.jpg",
                "http://images.fineartamerica.com/images-medium-large-5/rainbow-piano-keyboard-twist-in-acrylic-paint-with-sheet-music-notes-in-blue-yellow-orange-red-m-zimmerman-mendyz.jpg",
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/still-life-oil-painting-table-with-pomegranate-ceramic-kettle-glass-knife-and-bowl-of-fruit-pears-linen-sketch-painting-life-drawing-mendyz.jpg",
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/portrait-in-brown-sepia-on-canvas-in-oil-just-the-underpainting-mendyz-.jpg",
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/a-chance-in-the-world-movie-dark-barn-crowded-into-a-gully-between-a-large-rocky-hill-and-a-grove-of-mendyz.jpg",
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/portrait-colorful-female-wistfully-thoughtful-pastel-mendyz-.jpg",
                "http://images.fineartamerica.com/images/artworkimages/mediumlarge/1/intense-portrait-bulging-eyes-blue-beard-orange-and-sketch-painting-vibrant-vivid-expression-beast-friendly-mendyz-.jpg"
        };



        //hook up button to an event listener so when it's clicked we can know to do something specific
        //in this case it will be to show a random mountain
        showMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            final long userTimerLength = Long.parseLong(getEditTextLength.getText().toString()); //CANNOT BE AN INT NEEDS TO BE A LONG
            final long userTimerSpeedGap = Long.parseLong(getEditTextSpeed.getText().toString()); //CANNOT BE AN INT NEEDS TO BE A LONG also valueOf gives you a new object not a primitive

           //might want to make a variable outside the tick, will try first to put the picasso in the finish method



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

                        //displaying through images each tick
                        //create random number
                        Random randUrl = new Random();
                        randomNumUrl = randUrl.nextInt(imageUrls.length);

                        //Toast.makeText(MainActivity.this, imageUrls[randomNumUrl], Toast.LENGTH_SHORT).show();


                        //specifically the (this) context passing
                        Picasso.with(MainActivity.this)
                                .load(imageUrls[randomNumUrl])
                                .placeholder(R.drawable.placeholder)
                                .error(R.drawable.imagenotfound)
                                .resize(600,600)
                                .centerCrop().
                                into(imageView);




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
