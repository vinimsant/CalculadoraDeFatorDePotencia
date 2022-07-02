package com.calculodefatordepotencia.activity.activity.solftstarter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class SolftDanfos extends AppCompatActivity {

    ImageView mcd100;
    ImageView mcd201;
    ImageView mcd500;
    ImageView mcd600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solft_danfos);

        setTitle("SolftStarter Danfoss");

        mcd100 = findViewById(R.id.ImgMcd100);
        mcd201 = findViewById(R.id.ImgMcd201);
        mcd500 = findViewById(R.id.ImgMcd500);
        mcd600 = findViewById(R.id.ImgMcd600);

        mcd100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "mcd100");
                startActivity(intent);
            }
        });

        mcd201.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),DanfosMcd201.class));
            }
        });

        mcd500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "mcd500");
                startActivity(intent);
            }
        });

        mcd600.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "mcd600");
                startActivity(intent);
            }
        });
    }
}