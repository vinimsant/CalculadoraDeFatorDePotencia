package com.calculodefatordepotencia.activity.activity.inversores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class Fc051 extends AppCompatActivity {

    ImageView bornes;
    ImageView manual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fc051);

        setTitle("Inversor Fc051");

        bornes = findViewById(R.id.ImgFc051B);
        manual = findViewById(R.id.ImgFc051M);

        bornes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "fc051bornes");
                startActivity(intent);
            }
        });

        manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "fc051");
                startActivity(intent);
            }
        });


    }
}