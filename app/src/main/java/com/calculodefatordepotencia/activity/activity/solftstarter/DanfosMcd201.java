package com.calculodefatordepotencia.activity.activity.solftstarter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class DanfosMcd201 extends AppCompatActivity {

    ImageView mcd201m;
    ImageView mcd201b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danfos_mcd201);

        setTitle("SolftStarter MCD201/202");

        mcd201m = findViewById(R.id.ImgMcd201M);
        mcd201b = findViewById(R.id.ImgMcd201G);

        mcd201m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "mcd201/202 manual");
                startActivity(intent);
            }
        });

        mcd201b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "mcd201/202 bornes");
                startActivity(intent);
            }
        });
    }
}