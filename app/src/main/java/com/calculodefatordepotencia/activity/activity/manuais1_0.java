package com.calculodefatordepotencia.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.fragmenty.SolftFragmentes;
import com.calculodefatordepotencia.ui.inversor.InversorFragment;

public class manuais1_0 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manuais1_0);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutManuais1_0, InversorFragment.newInstance())
                .commit();

    }

    public void solftFragment(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutManuais1_0, SolftFragmentes.newInstance())
                .commit();

    }

    public void inversoresFragment(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutManuais1_0, InversorFragment.newInstance())
                .commit();
    }
}