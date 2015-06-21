package com.example.rafaelkrentz.androidparse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by cherubiniNB on 18/05/2015.
 */
public class ActivitySplash extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Parse.initialize(this, "eKOd0SPaY3MVKgtJz58tQBJPGHNdwrYGCbzF3v0t", "ntOylyRdiHA5OxHmhY4nCHcuEbSvUo1z5kuT6Yr9");
        ParseInstallation.getCurrentInstallation().saveInBackground();

       // TextView splashText = (TextView) findViewById(R.id.splashText);

        new Thread(){
            @Override
            public void run() {
                super.run();

                // sleep(5000);
                depoisEspera();

            }
        }.start();
    }

    public void depoisEspera(){
        Intent it = new Intent(this, ActivityList.class);
        startActivity(it);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
