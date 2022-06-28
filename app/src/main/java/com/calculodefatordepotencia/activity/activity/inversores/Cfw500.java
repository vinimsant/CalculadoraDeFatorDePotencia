package com.calculodefatordepotencia.activity.activity.inversores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class Cfw500 extends AppCompatActivity {

    private ImageView imgCfw500Manuais;
    private ImageView imgCfw500Guia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cfw500);

        setTitle("Inversor CFW500");

        imgCfw500Manuais = findViewById(R.id.cfw500manuais);
        imgCfw500Guia = findViewById(R.id.cfw500borne);

        imgCfw500Manuais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "cfw500manual");
                startActivity(intent);
            }
        });

        imgCfw500Guia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "cfw500bornes");
                startActivity(intent);
            }
        });
    }
}