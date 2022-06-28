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
    ImageView cfw500;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inversores_weg);

        setTitle("Inversores WEG");
        cfw08 = findViewById(R.id.cfw08);
        cfw08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "cfw08");
                startActivity(intent);
            }
        });
        cfw09 = findViewById(R.id.cfw09);
        cfw09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "cfw09");
                startActivity(intent);
            }
        });
        cfw11 = findViewById(R.id.cfw11);
        cfw11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Cfw11.class);
                startActivity(intent);
            }
        });
        cfw500 = findViewById(R.id.cfw500);
        cfw500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Cfw500.class);
                startActivity(intent);
            }
        });
    }
}