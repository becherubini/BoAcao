package com.example.rafaelkrentz.androidparse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by cherubiniNB on 21/06/2015.
 */
public class ActivityProfile extends Activity {
    Institute institute = Globals.currentProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.institute_profile);

        TextView btvNome = (TextView) findViewById(R.id.btvNome);
        TextView btvAlvo = (TextView) findViewById(R.id.btvAlvo);
        TextView btvCNPJ = (TextView) findViewById(R.id.btvCNPJ);
        TextView btvEndereco = (TextView) findViewById(R.id.btvEndereco);
        Button btVoltar = (Button) findViewById(R.id.btVoltar);

        btvNome.append(institute.getName());
        btvAlvo.append(institute.getTarget());
        btvCNPJ.append(institute.getCnpj());
        btvEndereco.append(institute.getAddress());

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
