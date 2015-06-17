package com.example.rafaelkrentz.androidparse;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseGeoPoint;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ActivityList extends Activity{

    private ListView lvInstitutes;
    private List<Institute> institutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.institute_list);



        lvInstitutes = (ListView) findViewById(R.id.lvInstitute);

        FragmentActivity fr = new FragmentActivity();

   /*   ParseObject target  = new ParseObject("Target");
        target.put("target", "infantil");
        target.saveInBackground();*/

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

           @Override
            public void done(List<ParseObject> scoreList, ParseException e){
                if(e==null){
                    Log.d("institute", "Retrieved " + scoreList.size() + " scores");
                }else{
                    Log.d("institute", "Error: " + e.getMessage());
                }
    */
       ParseQuery<ParseObject> queryInst = ParseQuery.getQuery("Institute");
        queryInst.findInBackground((instList, e) -> {
            if (e == null) {
                Log.i("score", "Retrieved " + instList.size() + " institutes");

            } else {
                Log.i("score", "Error: " + e.getMessage());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        institutes = criaListaTemporaria()   ;
        ArrayAdapter<Institute> adp = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, institutes);
        lvInstitutes.setAdapter(adp);
    }

    private List<Institute> criaListaTemporaria(){
        List<Institute> inst = new ArrayList<>();

        inst.add(new Institute("Spaan", "idosos", "Av Nonoai"));
        inst.add(new Institute("AACD", "criancas", "Sao Paulo"));
        inst.add(new Institute("Airton Senna", "criancas", "Av Senna"));

        return inst;
    }
}
