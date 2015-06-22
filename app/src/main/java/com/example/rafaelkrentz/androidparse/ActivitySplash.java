package com.example.rafaelkrentz.androidparse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                try {
                    createList();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                depoisEspera();

            }
        }.start();
    }

    private void depoisEspera(){
        Intent it = new Intent(this, ActivityList.class);
        startActivity(it);
        finish();
    }

    private void createList() throws com.parse.ParseException {
        List<Institute> list = new ArrayList<>();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Institute");
        query.selectKeys(Arrays.asList("objectId", "name", "target", "cnpj", "address", "location", "phone", "email", "image"));
        List<ParseObject> results = query.find();

        for (ParseObject institute : results) {
            list.add(new Institute(
                    institute.getObjectId(),
                    institute.getString("name"),
                    institute.getString("target"),
                    institute.getString("cnpj"),
                    institute.getString("address"),
                    institute.getParseGeoPoint("location"),
                    institute.getString("phone"),
                    institute.getString("email"),
                    institute.getParseFile("image")
            ));
        }
        Globals.currentInstList = list;
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
