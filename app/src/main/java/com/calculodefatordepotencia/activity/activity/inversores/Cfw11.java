package com.calculodefatordepotencia.activity.activity.inversores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class Cfw11 extends AppCompatActivity {

    private ImageView imgCfw11Manual;
    private ImageView imgCfw11Guia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cfw11);

        imgCfw11Manual.findViewById(R.id.cfw11manuais);
        imgCfw11Guia.findViewById(R.id.cfw11borne);

        imgCfw11Manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", 3);
                startActivity(intent);
            }
        });

        imgCfw11Guia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", 4);
                startActivity(intent);
            }
        });
    }
}