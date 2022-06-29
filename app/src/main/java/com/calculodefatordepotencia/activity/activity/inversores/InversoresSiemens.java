package com.calculodefatordepotencia.activity.activity.inversores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class InversoresSiemens extends AppCompatActivity {

    ImageView mm420;
    ImageView mm430;
    ImageView mm440;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inversores_siemens);

        setTitle("Inversores Siemens");

        mm420 = findViewById(R.id.ImgInvMM420);
        mm430 = findViewById(R.id.InvImgMM430);
        mm440 = findViewById(R.id.InvImgMM440);

        mm420.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "micromaster420");
                startActivity(intent);
            }
        });

        mm430.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "micromaster430");
                startActivity(intent);

            }
        });

        mm440.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Micromaster440.class);
                startActivity(intent);
            }
        });
    }
}