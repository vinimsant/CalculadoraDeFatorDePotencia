package com.calculodefatordepotencia.activity.activity.solftstarter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class SolftSiemens extends AppCompatActivity {

    ImageView img3rw30;
    ImageView img3rw44;
    ImageView img3rw50;
    ImageView img3rw52;
    ImageView img3rw55;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solft_siemens);

        setTitle("Solftstarter Siemens");

        img3rw30 = findViewById(R.id.Img3rw30);
        img3rw44 = findViewById(R.id.Img3rw44);
        img3rw50 = findViewById(R.id.img3rw50);
        img3rw52 = findViewById(R.id.img3rw52);
        img3rw55 = findViewById(R.id.img3rw55);

        img3rw30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "3rw30/3rw40");
                startActivity(intent);
            }
        });

        img3rw44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "3rw44");
                startActivity(intent);
            }
        });

        img3rw50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "3rw50");
                startActivity(intent);
            }
        });

        img3rw52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "3rw52");
                startActivity(intent);
            }
        });

        img3rw55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "3rw55");
                startActivity(intent);
            }
        });
    }
}