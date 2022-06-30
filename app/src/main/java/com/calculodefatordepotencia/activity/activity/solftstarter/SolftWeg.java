package com.calculodefatordepotencia.activity.activity.solftstarter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class SolftWeg extends AppCompatActivity {

    ImageView ssw05;
    ImageView ssw07;
    ImageView ssw900;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solft_weg);

        setTitle("Solftstarter WEG");

        ssw05 = findViewById(R.id.ssw05);
        ssw07 = findViewById(R.id.ssw07);
        ssw900 = findViewById(R.id.ssw900);

        ssw05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "SSW05");
                startActivity(intent);
            }
        });

        ssw07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "SSW07");
                startActivity(intent);
            }
        });

        ssw900.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "SSW900");
                startActivity(intent);
            }
        });
    }
}