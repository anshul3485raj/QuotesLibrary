package com.hoogle.quoteslibrary;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;

import android.support.v4.app.FragmentManager;

import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.github.javiersantos.appupdater.AppUpdater;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    public FloatingActionMenu fab3;
    FloatingActionButton fabb1 ,fabb2,fabb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AppUpdater(this)
                .setTitleOnUpdateAvailable("Update available")
                .setContentOnUpdateAvailable("Check out the latest version available of New Blender ")
                .setButtonDismiss("cancel")
                .setButtonDoNotShowAgain(null)
                .setButtonUpdate("Update now")
                .start();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MobileAds.initialize(this, "ca-app-pub-7479732637897937~4795525056");

        fab3 =(FloatingActionMenu) findViewById(R.id.fab32);
        fabb1=(FloatingActionButton) findViewById(R.id.item1);
        fabb2=(FloatingActionButton) findViewById(R.id.item2);
        fabb3=(FloatingActionButton) findViewById(R.id.item3);

        fabb1.setOnClickListener(new View.OnClickListener() {
public void onClick(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto: anshul348567890123@gmail.com"));
        startActivity(Intent.createChooser(emailIntent, "Report bug"));
        emailIntent.putExtra("android.intent.extra.TEXT", "Write your feedback");
        Snackbar.make(view, "Feedback ", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show();

        }
        });

        fabb2.setOnClickListener(new View.OnClickListener() {
public void onClick(View view) {


        Intent text = new Intent();
        text.setAction("android.intent.action.SEND");
        text.setType("text/plain");
        text.putExtra("android.intent.extra.TEXT", " Hey guys I've using this Quotes library app lately developed by hoogle , it helps me to read wonderful quotes .it including some of the latest features and user friendly layout for easy operation. It app is recommended to all by user. download link -->https://play.google.com/store/apps/details?id=com.hoogle.quoteslibrary");
        startActivity(Intent.createChooser(text, " share download link:"));
        }
        });

        fabb3.setOnClickListener(new View.OnClickListener() {
public void onClick(View view) {
        BlankFragment8 blankFragment8 = new BlankFragment8();
        FragmentManager manager =   getSupportFragmentManager();
        manager  .beginTransaction().addToBackStack(null).replace(R.id.oou, blankFragment8).commit();
        }
        });






        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BlankFragment2 blankFragment2 = new BlankFragment2();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.oou,blankFragment2).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

                } else {
                    super.onBackPressed();
                }
            }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            BlankFragment5 blankFragment5 = new BlankFragment5();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().addToBackStack(null).replace(R.id.oou,blankFragment5).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            BlankFragment blankFragment = new BlankFragment();
            FragmentManager manager =   getSupportFragmentManager();
            manager  .beginTransaction().addToBackStack(null).replace(R.id.oou, blankFragment).commit();

        }else if (id == R.id.nav_gallery) {
            BlankFragment4 blankFragment4 = new BlankFragment4();
            FragmentManager manager =   getSupportFragmentManager();
            manager  .beginTransaction().addToBackStack(null).replace(R.id.oou, blankFragment4).commit();
        }
        else if (id == R.id.i) {
            BlankFragment7 blankFragment7 = new BlankFragment7();
            FragmentManager manager =   getSupportFragmentManager();
            manager  .beginTransaction().addToBackStack(null).replace(R.id.oou, blankFragment7).commit();
        }
        else if (id == R.id.sav) {
            BlankFragment12 blankFragment12 = new BlankFragment12();
            FragmentManager manager =   getSupportFragmentManager();
            manager  .beginTransaction().addToBackStack(null).replace(R.id.oou, blankFragment12).commit();
        }
        else if (id == R.id.home) {
            BlankFragment2 blankFragment2 = new BlankFragment2();
            FragmentManager manager =   getSupportFragmentManager();
            manager  .beginTransaction().addToBackStack(null).replace(R.id.oou, blankFragment2).commit();
        }else if (id == R.id.nav_slideshow) {
               BlankFragment3 blankFragment3 = new BlankFragment3();
            FragmentManager manager =   getSupportFragmentManager();
            manager  .beginTransaction().addToBackStack(null).replace(R.id.oou, blankFragment3).commit();

        } else if (id == R.id.nav_manage) {
            BlankFragment9 blankFragment9 = new BlankFragment9();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().addToBackStack(null).replace(R.id.oou,blankFragment9).commit();
        }
        else if (id == R.id.coll) {
            BlankFragment11 blankFragment11 = new BlankFragment11();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().addToBackStack(null).replace(R.id.oou,blankFragment11).commit();
        }
        else if (id == R.id.bf13) {
            BlankFragment13 blankFragment13 = new BlankFragment13();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().addToBackStack(null).replace(R.id.oou,blankFragment13).commit();
        }
        else if (id == R.id.bf14) {
            BlankFragment14 blankFragment14 = new BlankFragment14();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().addToBackStack(null).replace(R.id.oou,blankFragment14).commit();
        }
        else if (id == R.id.bf15) {
            BlankFragment15 blankFragment15 = new BlankFragment15();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().addToBackStack(null).replace(R.id.oou,blankFragment15).commit();
        }
        else if (id == R.id.fav) {
            BlankFragment10 blankFragment10 = new BlankFragment10();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().addToBackStack(null).replace(R.id.oou,blankFragment10).commit();
        } else if (id == R.id.nav_share) {


            Intent text = new Intent();
            text.setAction("android.intent.action.SEND");
            text.setType("text/plain");
            text.putExtra("android.intent.extra.TEXT", " Hey guys I've using this Quotes library app lately developed by hoogle , it helps me to read  wonderful quotes  .it including some of the latest features and user friendly layout for easy operation. It app is recommended to all by user. download link -->https://play.google.com/store/apps/details?id=com.hoogle.quoteslibrary");
            startActivity(Intent.createChooser(text, " share download link:"));
        }


 else if (id == R.id.nav_send) {
            BlankFragment8 blankFragment8 = new BlankFragment8();
            FragmentManager manager =   getSupportFragmentManager();
            manager  .beginTransaction().addToBackStack(null).replace(R.id.oou, blankFragment8).commit();
        }
        else if (id == R.id.funny) {
            BlankFragment6 blankFragment6 = new BlankFragment6();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().addToBackStack(null).replace(R.id.oou,blankFragment6).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
