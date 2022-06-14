package com.calculodefatordepotencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.calculodefatordepotencia.activity.fragmenty.SolftFragmentes;
import com.calculodefatordepotencia.ui.inversor.InversorFragment;

public class Manuais extends AppCompatActivity {

    private SolftFragmentes solftFragmentes;
    private InversorFragment inversorFragment;
    private Button btnInv, btnSolft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manuais_activity);

        //recuperando fragmentes
        solftFragmentes = new SolftFragmentes();
        inversorFragment = new InversorFragment();

        //recuperando botoões
        btnInv = findViewById(R.id.btnManuaisInv);
        btnSolft = findViewById(R.id.btnManuaisSolft);

        //getSupportActionBar().setElevation(0);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameManuais, InversorFragment.newInstance())
                    .commitNow();
        }
    }

    public void chamarFragmenteInv(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameManuais,
                inversorFragment).commitNow();
        //btnInv.setTextColor(R.color.selesionado);
        //btnSolft.setTextColor(R.color.naoSelesionado);
    }

    public void chamarFragmentSolft(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameManuais,
                solftFragmentes).commitNow();
        //btnSolft.setTextColor(R.color.selesionado);
        //btnInv.setTextColor(R.color.naoSelesionado);
    }
}