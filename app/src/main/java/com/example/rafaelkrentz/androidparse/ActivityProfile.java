package com.example.rafaelkrentz.androidparse;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseImageView;

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
        TextView btvPhone = (TextView) findViewById(R.id.btvPhone);
        ImageButton btnPhone = (ImageButton) findViewById(R.id.btnPhone);
        TextView btvEmail = (TextView) findViewById(R.id.btvEmail);
        ImageButton btnEmail = (ImageButton) findViewById(R.id.btnEmail);
        Button btVoltar = (Button) findViewById(R.id.btVoltar);
        ImageView imgProfile = (ImageView) findViewById(R.id.imgProfile);

        btvNome.setText(institute.getName());
        btvAlvo.append(institute.getTarget());
        btvCNPJ.append(institute.getCnpj());
        btvEndereco.append(institute.getAddress());
        btvPhone.append(institute.getPhone());
        btvEmail.append(institute.getEmail());

        try {
            byte[] bitmapdata = institute.getFile().getData();
            Bitmap bitmap = BitmapFactory.decodeByteArray(bitmapdata, 0, bitmapdata.length);
            imgProfile.setImageBitmap(bitmap);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:" + institute.getPhone());
                Intent it = new Intent(Intent.ACTION_CALL, uri);
                startActivity(it);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.setType("plain/text");
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{institute.getEmail()});
                it.putExtra(Intent.EXTRA_SUBJECT, "Informacoes de Doacao");
                startActivity(Intent.createChooser(it,""));
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
