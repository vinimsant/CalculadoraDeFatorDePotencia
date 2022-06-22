package com.calculodefatordepotencia.activity.activity.inversores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class InversoresSchneider extends AppCompatActivity {

    private ImageView atv11;
    private ImageView atv12;
    private ImageView atv212;
    private ImageView atv28;
    private ImageView atv31;
    private ImageView atv32;
    private ImageView atv61;
    private ImageView atv71;
    private ImageView atv312;
    private ImageView atv320;
    private ImageView atv600;
    private ImageView atv630;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inversores_schneider);

        //colocar o titulo da activity na barra de ferramentas do app(app bar)
        setTitle("Inversores Schneider/Telemecanique");

        atv11 = findViewById(R.id.mImgInvAtv11);
        atv12 = findViewById(R.id.mImgInvAtv12);
        atv28 = findViewById(R.id.mImgInvAtv28);
        atv31 = findViewById(R.id.mImgInvAtv31);
        atv32 = findViewById(R.id.mImgInvAtv32);
        atv61 = findViewById(R.id.mImgInvAtv61);
        atv71 = findViewById(R.id.mImgInvAtv71);
        atv212 = findViewById(R.id.mImgInvAtv212);
        atv312 = findViewById(R.id.mImgInvAtv312);
        atv320 = findViewById(R.id.mImgInvAtv320);
        atv600 = findViewById(R.id.mImgInvAtv600);
        atv630 = findViewById(R.id.mImgInvAtv630);

        atv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "atv11");
                startActivity(intent);
            }
        });

        atv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "atv12");
                startActivity(intent);

            }
        });

        atv28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "atv28");
                startActivity(intent);

            }
        });

        atv31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "atv31");
                startActivity(intent);

            }
        });

        atv32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "atv32");
                startActivity(intent);

            }
        });

        atv61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "atv61");
                startActivity(intent);

            }
        });

        atv71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "atv71");
                startActivity(intent);

            }
        });

        atv212.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "atv212");
                startActivity(intent);

            }
        });

        atv312.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "atv312");
                startActivity(intent);

            }
        });

        atv320.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "atv320");
                startActivity(intent);

            }
        });

        atv600.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "atv600");
                startActivity(intent);

            }
        });

        atv630.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "atv630");
                startActivity(intent);

            }
        });


    }
}