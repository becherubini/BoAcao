package com.example.rafaelkrentz.androidparse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;

public class ActivityList extends Activity implements SearchView.OnQueryTextListener {

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
        setupSearchView();
    }

    private void createListView(){
        adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, institutes);
        lvInstitutes.setAdapter(adp);
        lvInstitutes.setTextFilterEnabled(true);
    }
    private void setupSearchView() {
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
    }


    /**
     * Called when the user submits the query. This could be due to a key press on the
     * keyboard or due to pressing a submit button.
     * The listener can override the standard behavior by returning true
     * to indicate that it has handled the submit request. Otherwise return false to
     * let the SearchView handle the submission by launching any associated intent.
     *
     * @param query the query text that is to be submitted
     * @return true if the query has been handled by the listener, false to let the
     * SearchView perform the default action.
     */
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    /**
     * Called when the query text is changed by the user.
     *
     * @param newText the new content of the query text field.
     * @return false if the SearchView should perform the default action of showing any
     * suggestions if available, true if the action was handled by the listener.
     */
    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            lvInstitutes.clearTextFilter();
        } else {
            lvInstitutes.setFilterText(newText.toString());
        }
        return true;
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