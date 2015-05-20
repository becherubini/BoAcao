package com.example.rafaelkrentz.androidparse;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        inst.add(new Institute("AACD", "crianças", "São Paulo"));
        inst.add(new Institute("Airton Senna", "crianças", "Av Senna"));

        return inst;
    }
}
