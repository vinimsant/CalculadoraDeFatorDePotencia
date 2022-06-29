package com.calculodefatordepotencia.activity.activity.inversores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class Micromaster440 extends AppCompatActivity {

    ImageView mm440b;
    ImageView mm440m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micromaster440);

        setTitle("Micromaster 440");

        mm440b = findViewById(R.id.InvImgMM440B);
        mm440m = findViewById(R.id.InvImgMM440M);

        mm440b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "Guia Micromaster440");
                startActivity(intent);
            }
        });

        mm440m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "Manual Micromaster440");
                startActivity(intent);
            }
        });
    }
}