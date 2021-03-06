package com.calculodefatordepotencia.activity.activity.inversores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class InversoresDanfos extends AppCompatActivity {

    ImageView fc051;
    ImageView fc101;
    ImageView fc202;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inversores_danfos);

        setTitle("Inversores Danfos");

        fc051 = findViewById(R.id.ImgInvFc051);
        fc101 = findViewById(R.id.ImgInvFc101);
        fc202 = findViewById(R.id.ImgInvFc202);

        fc051.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Fc051.class);
                startActivity(intent);
            }
        });

        fc101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "fc101");
                startActivity(intent);
            }
        });

        fc202.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "fc202");
                startActivity(intent);
            }
        });
    }
}