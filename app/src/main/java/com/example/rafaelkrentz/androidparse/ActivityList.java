package com.example.rafaelkrentz.androidparse;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.Parse;
import com.parse.ParseGeoPoint;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cherubiniNB on 18/05/2015.
 */


public class ActivityList extends Activity{

    private ListView lvInstitutes;
    private List<Institute> institutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.institute_list);



        lvInstitutes = (ListView) findViewById(R.id.lvInstitute);

        FragmentActivity fr = new FragmentActivity();


        //INSERE NO PARSE
/*
        ParseObject state = new ParseObject("State");
        state.put("state", "RS");

        ParseGeoPoint portoAlegrePoint = new ParseGeoPoint(-30.079138, -51.219374);

        ParseObject city = new ParseObject("City");
        city.put("city", "Porto Alegre");
        city.put("location", portoAlegrePoint);
        //city.put("parent", state);//ParseObject.createWithoutData("State", "koAdci7Ta1")

        city.saveInBackground();
 
        ParseObject state = new ParseObject("State");
        state = new ParseObject("State");
        state.put("id", 1);
        state.put("state", "RS");
        state.saveInBackground();

         state.put("id", 2);
        state.put("state", "SC");
        state.saveInBackground();

        state = new ParseObject("State");
        state.put("id", 3);
        state.put("state", "PR");
        state.saveInBackground();
        */

    }

    @Override
    protected void onResume() {
        super.onResume();
        institutes = criaListaTemporaria();
        ArrayAdapter<Institute> adp = new ArrayAdapter<Institute>(this, android.R.layout.simple_list_item_1, institutes);
        lvInstitutes.setAdapter(adp);
    }

    private List<Institute> criaListaTemporaria(){
        List<Institute> inst = new ArrayList<Institute>();

        inst.add(new Institute("Spaan", "idosos", "Av Nonoai"));
        inst.add(new Institute("AACD", "criancas", "Sao Paulo"));
        inst.add(new Institute("Airton Senna", "criancas", "Av Senna"));

        return inst;
    }
}
