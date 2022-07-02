package com.calculodefatordepotencia.activity.activity.solftstarter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class SolftScheneider extends AppCompatActivity {

    ImageView ats01;
    ImageView ats22;
    ImageView ats48;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solft_scheneider);

        setTitle("SolftStarter Schneider/Telemecanique");

        ats01 = findViewById(R.id.ImgAts01);
        ats22 = findViewById(R.id.ImgAts22);
        ats48 = findViewById(R.id.ImgAts48);

        ats01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "Ats01");
                startActivity(intent);
            }
        });

        ats22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "Ats22");
                startActivity(intent);
            }
        });

        ats48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "Ats48");
                startActivity(intent);
            }
        });
    }
}