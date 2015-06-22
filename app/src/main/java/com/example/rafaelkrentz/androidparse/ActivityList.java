package com.example.rafaelkrentz.androidparse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;

public class ActivityList extends Activity{

    private ListView lvInstitutes;
    private List<Institute> institutes;
    private SearchView searchView;
    private Button btnMap;
    private ArrayAdapter<Institute> adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.institute_list);

        institutes = Globals.currentInstList;

        btnMap = (Button) findViewById(R.id.btnMap);
        lvInstitutes = (ListView) findViewById(R.id.lvInstitute);
        searchView = (SearchView) findViewById(R.id.searchView);

        lvInstitutes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Globals.currentProfile = institutes.get(position);
                Intent it = new Intent(ActivityList.this, ActivityProfile.class);
                startActivity(it);
            }
        });

        /*searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i("Nomad", "onQueryTextSubmit");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("Nomad", "onQueryTextChange");

                if (TextUtils.isEmpty(newText)) {
                    adp.getFilter().filter("");
                    Log.i("Nomad", "onQueryTextChange Empty String");
                    //placesListView.clearTextFilter();
                } else {
                    Log.i("Nomad", "onQueryTextChange " + newText.toString());
                    adp.getFilter().filter(newText.toString());
                }
                return true;
            }
        });*/

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ActivityList.this, ActivityMap.class);
                startActivity(it);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        createListView();
    }

    private void createListView(){
        adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, institutes);
        lvInstitutes.setAdapter(adp);
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