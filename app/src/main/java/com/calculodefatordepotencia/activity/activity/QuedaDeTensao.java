
package com.calculodefatordepotencia.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.FragmentTransitionSupport;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.fragmenty.MonoFragment;
import com.calculodefatordepotencia.activity.fragmenty.TrifasicoFragment;

public class QuedaDeTensao extends AppCompatActivity {


    private MonoFragment monoFragment;
    private TrifasicoFragment trifasicoFragment;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queda_de_tensao);
        getSupportActionBar().setElevation(0);

        //colocar gradiente no action bar
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));





        //configurando classes
        monoFragment = new MonoFragment();
        trifasicoFragment = new TrifasicoFragment();

        //configurar o objeto para ser exibido no frame layot
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutQuedaDeTensao, monoFragment);
        fragmentTransaction.commit();


    }

    public void ExibirFragmentMono(View v){

        monoFragment = new MonoFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutQuedaDeTensao, monoFragment);
        fragmentTransaction.commit();

    }

    public void ExibirFragmentTrifasico(View v){

        trifasicoFragment = new TrifasicoFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutQuedaDeTensao, trifasicoFragment);
        fragmentTransaction.commit();

    }
}