package com.calculodefatordepotencia.activity.activity.inversores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class InversoresWeg extends AppCompatActivity {

    ImageView cfw08;
    ImageView cfw09;
    ImageView cfw11;
    ImageView cfw11Borne;
    ImageView cfw500;
    ImageView cfw500Borne;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inversores_weg);
        cfw08 = findViewById(R.id.cfw08);
        cfw08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", 1);
                startActivity(intent);
            }
        });
        cfw09 = findViewById(R.id.cfw09);
        cfw09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", 2);
                startActivity(intent);
            }
        });
        cfw11 = findViewById(R.id.cfw11);
        cfw11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", 3);
                startActivity(intent);
            }
        });
    }
}