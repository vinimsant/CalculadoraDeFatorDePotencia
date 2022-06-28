package com.calculodefatordepotencia.activity.activity.inversores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class InversoresVacon extends AppCompatActivity {

    ImageView vacon10;
    ImageView vacon20;
    ImageView vacon100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inversores_vacon);

        setTitle("Inversores Vacon");

        vacon10 = findViewById(R.id.ImgInvVacon10);
        vacon20 = findViewById(R.id.ImgInvVacon20);
        vacon100 = findViewById(R.id.ImgInvVacon100);

        vacon10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "vacon10");
                startActivity(intent);
            }
        });

        vacon20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "vacon20");
                startActivity(intent);
            }
        });

        vacon100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "vacon100");
                startActivity(intent);
            }
        });
    }
}