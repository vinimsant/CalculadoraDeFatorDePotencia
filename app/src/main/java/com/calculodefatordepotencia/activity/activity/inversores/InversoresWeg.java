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
    ImageView cfw100;
    ImageView cfw300;
    ImageView cfw500;
    ImageView cfw501;
    ImageView cfw700;
    ImageView cfw701;
    ImageView mvw01;
    ImageView mvw500;
    ImageView mvw3000;



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

        cfw100 = findViewById(R.id.imgInvCfw100);
        cfw100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getBaseContext(), Cfw100.class);
                startActivity(intent);
            }
        });

        cfw300 = findViewById(R.id.cfw300);
        cfw300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Cfw300.class);
                startActivity(intent);
            }
        });

        cfw501 = findViewById(R.id.cfw501);
        cfw501.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "cfw501");
                startActivity(intent);

            }
        });

        cfw700 = findViewById(R.id.cfw700);
        cfw700.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Cfw700.class);
                startActivity(intent);

            }
        });

        cfw701 = findViewById(R.id.cfw701);
        cfw701.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "cfw701");
                startActivity(intent);

            }
        });

        mvw01 = findViewById(R.id.mvw01);
        mvw01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "mvw01");
                startActivity(intent);

            }
        });

        mvw500 = findViewById(R.id.mvw500);
        mvw500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Mvw500.class);
                startActivity(intent);

            }
        });

        mvw3000 = findViewById(R.id.mvw3000);
        mvw3000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Mvw3000.class);
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