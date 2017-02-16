package com.example.mendy.staranimationloadinggraphicinandroid;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };


    //declaring fonts and widgets
    Typeface codystarFont;
    Typeface contrailFont;
    TextView txtTitle;
    Button btnDummy;



    //ONCREATE FUNCTION
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        //we will set up the action bar to display in the center
        //and custamize it a bit with the action bar center xml
        //get the action bar
        ActionBar myActionBar = getSupportActionBar();
        //waiting to initialize the bar, i.e. if we are starting in full screen don't do this, if we are regular then it's ok to do these things
        if (myActionBar !=null) {
            //referencing the xml file we made xml in layout
            myActionBar.setCustomView(R.layout.action_bar_center);
            myActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        }

        //initializing the xml views, font's and widgets we declared above
        codystarFont = Typeface.createFromAsset(getAssets(), "Fonts/Codystar-Regular.ttf");
        contrailFont = Typeface.createFromAsset(getAssets(), "Fonts/ContrailOne-Regular.ttf");
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        btnDummy = (Button) findViewById(R.id.dummy_button);

        //setting up the fonts
        txtTitle.setTypeface(contrailFont);
        btnDummy.setTypeface(codystarFont);


        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);


        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
    }

    //variable declarations that are global
    //adding Image view as global bc below it will be only local
    AnimationDrawable starListAnimation;
    FrameLayout animationContainer;
    AnimationSet myAnimationSet;
    Animation fadeEffect;
    Animation rotateItself;
    Animation circleRotate;


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);

        //setup star list animation (mendy)
        //xml file is linked to ImageView
        ImageView starImage = (ImageView) findViewById(R.id.starImage);
        starImage.setBackgroundResource(R.drawable.star_animation_list);
        //declared above, initialized below, and it's global so we can call it from anywhere
        //note typecast
        starListAnimation = (AnimationDrawable) starImage.getBackground();
        starListAnimation.start();

        //initialize the animation container
        animationContainer = (FrameLayout) findViewById(R.id.animationContainer);
        //set the farme layout to visible (see the togggle method below)
        //toggle below changed from full screen to a screen with the buttons and action bar
        //we only wants it when the user clicks through to the main full screen



        //animations initialization variables for the fade effect
        // (animation declaration was above this method)
        fadeEffect = AnimationUtils.loadAnimation(this, R.anim.fade_effect);
        rotateItself = AnimationUtils.loadAnimation(this, R.anim.rotate_itself);
        circleRotate = AnimationUtils.loadAnimation(this, R.anim.circle_rotate);

        //set and add animations
        myAnimationSet = new AnimationSet(true);
        myAnimationSet.addAnimation(fadeEffect);
        myAnimationSet.addAnimation(rotateItself);
        myAnimationSet.addAnimation(circleRotate);


        //set duration for all the animation I added above
        //1.5 seconds or 1500 miliseconds
        //rotate is already now part of the animation set so we don't need to do anythign more
        myAnimationSet.setDuration(1500);

        //set up the animation listener so that myAnimation set can loop infinitly
        myAnimationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animation.reset();
                animation.start();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        //setup myAnimationSet on star image
        //rotate is already now part of the animation set so we don't need to do anythign more
        starImage.setAnimation(myAnimationSet);

        //start the animation set we made
        //rotate is already now part of the animation set so we don't need to do anythign more
        myAnimationSet.start();

    }

    private void toggle() {
        if (mVisible) {
            hide();
            //this is to remove the dummy content that is on the screen
            mContentView.setAlpha(0);
            //getting the star animation to show in the full screen mode
            //fullscreen - frame needs to be visible and TEXT invisible
            animationContainer.setVisibility(View.VISIBLE);
        } else {
            show();

            //showing the dummy content again when back into the regular screen
            mContentView.setAlpha(1);
            //screen with all the elemnts and action bar and text we want to remove the frame and animation

            animationContainer.setVisibility(View.INVISIBLE);
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
}
