package com.calculodefatordepotencia.activity.activity.inversores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class Cfw11 extends AppCompatActivity {

    private ImageView imgManual;
    private ImageView imgBornes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cfw11);

        imgManual = findViewById(R.id.cfw11manual);
        imgBornes = findViewById(R.id.cfw11borne);
        setTitle("Inversor CFW11");

        imgManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "cfw11manual");
                startActivity(intent);
            }
        });

        imgBornes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "cfw11bornes");
                startActivity(intent);
            }
        });
    }
}