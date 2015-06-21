package com.example.rafaelkrentz.androidparse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivityList extends Activity{

    private ListView lvInstitutes;
    private List<Institute> institutes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.institute_list);

        final Button btnMap = (Button) findViewById(R.id.btnMap);
        lvInstitutes = (ListView) findViewById(R.id.lvInstitute);

        lvInstitutes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Globals.currentProfile = institutes.get(position);
                Log.d("Instituto", "Posicao" + Globals.currentProfile.getName());
                Intent it = new Intent(ActivityList.this, ActivityProfile.class);
                startActivity(it);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ActivityList.this, ActivityMap.class);
                startActivity(it);
            }
        });


        try {
          createList();
        } catch (com.parse.ParseException e) {
            e.printStackTrace();
        }
        ArrayAdapter<Institute> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, institutes);
        lvInstitutes.setAdapter(adp);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

   private void createList() throws com.parse.ParseException {
       List<Institute> list = new ArrayList<>();

       ParseQuery<ParseObject> query = ParseQuery.getQuery("Institute");
       query.selectKeys(Arrays.asList("objectId", "name", "target", "cnpj", "address", "location"));
       List<ParseObject> results = query.find();

//       Log.d("Instituto", "Tamanho: " + results.size());
       for (ParseObject institute : results) {
           list.add(new Institute(
                   institute.getObjectId(),
                   institute.getString("name"),
                   institute.getString("target"),
                   institute.getString("cnpj"),
                   institute.getString("address"),
                   institute.getParseGeoPoint("location")
                   ));
       }
       institutes = list;
       Globals.currentInstList = list;
    }

}




//INSERE NO PARSE

       /* ParseObject institute  = new ParseObject("Institute");
        ParseGeoPoint instituteMap = new ParseGeoPoint(30.089535, -51.217725);
        institute.put("address", "Av. Nonoai, 600");
        institute.put("location",instituteMap);
        institute.put("name", "Spaan");
        institute.put("cnpj", "92855600000150");
        institute.put("idCity", "RWmL6iBmT8");
        institute.put("idTarget","1zJSeZa0V0");
        institute.saveInBackground();*/

       /* ParseObject institute  = new ParseObject("Institute");
        ParseGeoPoint instituteMap = new ParseGeoPoint(-30.052080, -51.170135);
        institute.put("address", "R. Prof. Cristiano Fischer, 1510");
        institute.put("location",instituteMap);
        institute.put("name", "AACD");
        institute.put("cnpj", "60979457000111");
        institute.put("idCity", "RWmL6iBmT8");
        institute.put("idTarget","1zJSeZa0V0");
        institute.saveInBackground();*/

       /*
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