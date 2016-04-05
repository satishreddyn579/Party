package com.example.satti.party;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.parse.Parse;
import com.parse.ParseInstallation;

public class SplashScreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    private static boolean isParseInitialized = false;
    public static final String APPLICATION_ID = "WsBqV89xRR4dpzIVgNeiG9PEOojvhVnRuBah0uif";
    public static final String CLIENT_KEY =  "ktfv8KcDLoyHI9CswBfd4aBg0RF6Ul1hlcmoCd56";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //if the application running in background
        if(isParseInitialized==false) {
            Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);
            isParseInitialized = true;
        }

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}



