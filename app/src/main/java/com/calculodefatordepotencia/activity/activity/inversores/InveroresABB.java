package com.calculodefatordepotencia.activity.activity.inversores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class InveroresABB extends AppCompatActivity {

    private ImageView acs150;
    private ImageView acs350;
    private ImageView acs550;
    private ImageView acs800;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inverores_a_b_b);

        setTitle("Inversores ABB");

        acs150 = findViewById(R.id.imginvacs150);
        acs350 = findViewById(R.id.imginvacs350);
        acs550 = findViewById(R.id.imginvacs550);
        acs800 = findViewById(R.id.imginvacs800);

        acs150.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "acs150");
                startActivity(intent);
            }
        });

        acs350.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "acs350");
                startActivity(intent);
            }
        });

        acs550.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "acs550");
                startActivity(intent);
            }
        });

        acs800.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "acs800");
                startActivity(intent);
            }
        });
    }
}