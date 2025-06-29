package com.calculodefatordepotencia.activity.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.fragmenty.SolftFragmentes;
import com.calculodefatordepotencia.ui.inversor.InversorFragment;

public class manuais1_0 extends AppCompatActivity {

    Button inv;
    Button solft;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manuais1_0);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutManuais1_0, InversorFragment.newInstance())
                .commit();



        inv = findViewById(R.id.btnInvManuais1_0);
        solft = findViewById(R.id.btnSoltManuais1_0);
        inv.setElevation(0);
        solft.setElevation(100);
        inv.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.black));
        solft.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.white));

        //configurando a action bar
        actionBar = this.getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Inversores");
        //actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));

    }

    public void solftFragment(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutManuais1_0, SolftFragmentes.newInstance())
                .commit();
        inv.setElevation(100);
        solft.setElevation(0);
        inv.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.white));
        solft.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.black));
        actionBar.setTitle("SolftStarteres");
    }

    public void inversoresFragment(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutManuais1_0, InversorFragment.newInstance())
                .commit();
        inv.setElevation(0);
        solft.setElevation(100);
        inv.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.black));
        solft.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.white));
        actionBar.setTitle("Inversores");
    }
}