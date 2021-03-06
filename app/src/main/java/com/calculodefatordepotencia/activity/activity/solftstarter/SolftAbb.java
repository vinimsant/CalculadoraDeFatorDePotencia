package com.calculodefatordepotencia.activity.activity.solftstarter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

public class SolftAbb extends AppCompatActivity {

    ImageView psr;
    ImageView pse;
    ImageView pst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solft_abb);

        setTitle("SolftStarter ABB");

        psr = findViewById(R.id.ImgPsr);
        pse = findViewById(R.id.ImgPse);
        pst = findViewById(R.id.ImgPst);

        psr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "ABB PSR");
                startActivity(intent);
            }
        });

        pse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "ABB PSE");
                startActivity(intent);
            }
        });

        pst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "ABB PST");
                startActivity(intent);
            }
        });
    }
}