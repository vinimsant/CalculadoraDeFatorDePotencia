package com.calculodefatordepotencia.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.ui.inversor.InversorFragment;

public class Manuais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manuais_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, InversorFragment.newInstance())
                    .commitNow();
        }
    }
}