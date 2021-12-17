package com.calculodefatordepotencia.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.FragmentTransitionSupport;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.fragmenty.MonoFragment;
import com.calculodefatordepotencia.activity.fragmenty.TrifasicoFragment;

public class QuedaDeTensao extends AppCompatActivity {

    private Button btnMono;
    private Button btnTrifasico;
    private MonoFragment monoFragment;
    private TrifasicoFragment trifasicoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queda_de_tensao);

        //configurando botôes.
        btnMono = findViewById(R.id.btnMono);
        btnTrifasico = findViewById(R.id.btnTrifasico);

        //configurando classes
        monoFragment = new MonoFragment();
        trifasicoFragment = new TrifasicoFragment();

        //configurar o objeto para ser exibido no frame layot
        /*FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayoutQuedaDeTensao, monoFragment);
        transaction.commit();*/


    }

}