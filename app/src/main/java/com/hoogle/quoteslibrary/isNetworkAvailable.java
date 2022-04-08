package com.hoogle.quoteslibrary;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class isNetworkAvailable extends Activity {
    private ImageButton btn;
    private Handler h = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_network);
        btn = (ImageButton) findViewById(R.id.bu);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restar();
            }
        });
        if (!isNetworkAvailable()) {
            //Create an alert dialog


            AlertDialog.Builder Checkbuilder = new AlertDialog.Builder(isNetworkAvailable.this);
            Checkbuilder.setIcon(R.drawable.apple11);
            Checkbuilder.setTitle("Error!");
            Checkbuilder.setMessage("Check Your Internet Connection.");
            //Builder Retry Button

            Checkbuilder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    //Restart The Activity
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);

                }
            });


            Checkbuilder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            AlertDialog alert = Checkbuilder.create();
            alert.show();

        } else {
            if (isNetworkAvailable()) {

                Thread tr = new Thread() {
                    public void run() {
                        try {
                            sleep(4);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            Intent i = new Intent(isNetworkAvailable.this, MainActivity.class);
                            startActivity(i);

                            finish();
                        }
                    }
                };
                tr.start();

            }
        }

    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;

    }

    public  void restar(){

        Intent intenet =new Intent(this,isNetworkAvailable.class);

        startActivity(intenet);
        finish();
    }
}



