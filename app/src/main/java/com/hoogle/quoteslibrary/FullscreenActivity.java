package com.hoogle.quoteslibrary;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.MotionEvent;

import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {
    public static int SPLASH_TIME_OUT = 4000;
    public static int SPLASHTIME_OUT = 1200;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_fullscreen);
            VideoView videoView = (VideoView) findViewById(R.id.videoView);


            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gy));
            videoView.start();
            new Handler().postDelayed(new Runnable() {


                /*
                 * Showing splash screen with a timer. This will be useful when you
                 * want to show case your app logo / company
                 */

                @Override
                public void run() {
                    // This method will be executed once the timer is over
                    // Start your app main activity
                    Intent i = new Intent(FullscreenActivity.this, isNetworkAvailable.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }, SPLASH_TIME_OUT);
        } else if (android.os.Build.VERSION.SDK_INT <23) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_fullscreen);
            Toast toast = Toast.makeText(getApplicationContext(),
                    "animation is not supported by device ",
                    Toast.LENGTH_SHORT);

            toast.show();
            new Handler().postDelayed(new Runnable() {


                /*
                 * Showing splash screen with a timer. This will be useful when you
                 * want to show case your app logo / company
                 */

                @Override
                public void run() {
                    // This method will be executed once the timer is over
                    // Start your app main activity
                    Intent i = new Intent(FullscreenActivity.this, isNetworkAvailable.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }, SPLASHTIME_OUT);


        }
    }
}

