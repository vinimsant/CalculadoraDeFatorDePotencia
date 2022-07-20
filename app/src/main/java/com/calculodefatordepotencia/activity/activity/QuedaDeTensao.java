
package com.calculodefatordepotencia.activity.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.FragmentTransitionSupport;

import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.fragmenty.MonoFragment;
import com.calculodefatordepotencia.activity.fragmenty.TrifasicoFragment;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.text.DecimalFormat;


public class QuedaDeTensao extends AppCompatActivity {


    private MonoFragment monoFragment;
    private TrifasicoFragment trifasicoFragment;
    private Fragment fragment;

    private Spinner tipoDeCondutor;
    private Spinner tipoDeCalculo;
    private Spinner triOuMono;
    private EditText txtQuedaTensao;
    private EditText txtFatorDePotencia;
    private EditText txtCorrente;
    private EditText txtBitola;
    private EditText txtComprimento;
    private TextView txtResultado;
    private Button limpar;
    private Button calcular;
    // verificador tipo de condutor, 0 = cobre 0,0172, 1 alumino 0,0282
    private double resistividadeDoFio = 0.0172;
    // verificador do spiner queda ou bitola caso variavel receba 0 selecionado queda caso receba 1 bitola selecionada
    private int spinerQueda = 0;
    //verificador de tensão trifásica ou monofásica
    private boolean trifasico = true;

    private InterstitialAd mInterstitialAd;


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
        /*FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutQuedaDeTensao, monoFragment);
        fragmentTransaction.commit();*/

        //Recuperando componetes do layot
        txtQuedaTensao = findViewById(R.id.txtQuedaDeTensao);
        txtBitola = findViewById(R.id.txtBitolaCondutor);
        txtComprimento = findViewById(R.id.txtComprimentoCondutor);
        txtCorrente = findViewById(R.id.txtCorrente);
        txtFatorDePotencia = findViewById(R.id.txtFatorDePotenciaQueda);
        txtResultado = findViewById(R.id.txtResultadoQueda);
        limpar = findViewById(R.id.btnLimparQueda);
        calcular = findViewById(R.id.btnCalcularQueda);



        //Interticial
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-2398950190237031/3343984412", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("TAG", "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d("TAG", loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });

        //Configuração do spiner tipo de condutor
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.tipo_de_condutor, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoDeCondutor = findViewById(R.id.spnTipoDeCondutor);
        tipoDeCondutor.setAdapter(arrayAdapter);
        tipoDeCondutor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        resistividadeDoFio = 0.0172;
                        break;
                    case 1:
                        resistividadeDoFio = 0.0282;
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Configuração do spiner tipo de calculo - por queda ou por bitola
        ArrayAdapter<CharSequence> arrayAdapter1 = ArrayAdapter.createFromResource(this,
                R.array.tipo_de_calculo_de_queda, android.R.layout.simple_spinner_item);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoDeCalculo = findViewById(R.id.spnCalcQuedaOuBitola);
        tipoDeCalculo.setAdapter(arrayAdapter1);
        tipoDeCalculo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //escreva os comandos aqui
                switch (position){
                    case 0:
                        spinerQueda = 0;
                        txtBitola.setEnabled(false);
                        Drawable d = getResources().getDrawable(R.drawable.custon_edit_text_desligado);
                        txtBitola.setBackground(d);
                        txtQuedaTensao.setEnabled(true);
                        Drawable l = getResources().getDrawable(R.drawable.custon_edit_text);
                        txtQuedaTensao.setBackground(l);
                        LimparTelaQueda();
                        break;
                    case 1:
                        spinerQueda = 1;
                        txtQuedaTensao.setEnabled(false);
                        Drawable d1 = getResources().getDrawable(R.drawable.custon_edit_text_desligado);
                        txtQuedaTensao.setBackground(d1);
                        txtBitola.setEnabled(true);
                        Drawable l1 = getResources().getDrawable(R.drawable.custon_edit_text);
                        txtBitola.setBackground(l1);
                        LimparTelaQueda();
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //configuração do spner trifasico ou mono
        ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(this,
                R.array.sistema_trifasico_ou_monofasico, android.R.layout.simple_spinner_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        triOuMono = findViewById(R.id.spn_TriOuMono);
        triOuMono.setAdapter(arrayAdapter2);
        triOuMono.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    //sistema trifásico
                    case 0:
                        trifasico = true;
                        break;
                    //sistema monofásico
                    case 1:
                        trifasico = false;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LimparTelaQueda();
            }
        });

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calcular();
            }
        });



    }

    public void LimparTelaQueda(){

        txtResultado.setText("");
        txtFatorDePotencia.setText("");
        txtCorrente.setText("");
        txtComprimento.setText("");
        txtBitola.setText("");
        txtQuedaTensao.setText("");
        EsconderTeclado();

    }

    public void EsconderTeclado(){

        ((InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(txtResultado.getWindowToken(), 0);



    }



    public void Calcular(){

        //constante trifasica
        double constanteTriOuMono;
        if (trifasico == true){
            constanteTriOuMono = 1.73;
        }else {
            constanteTriOuMono = 1;
        }
        // calcular bitola
        if (spinerQueda == 0){
            double comprimento = 0;
            double bitola = 0;
            double queda = 0;
            double corrente = 0;
            double fatorDePotencia = 0;

            //verificar se campos estao preenchidos

            if (txtFatorDePotencia.getText().toString().trim().length() != 0){
                if (txtCorrente.getText().toString().trim().length() != 0){
                    if (txtQuedaTensao.getText().toString().trim().length() != 0){
                        if (txtComprimento.getText().toString().trim().length() != 0){
                            comprimento = Double.parseDouble(txtComprimento.getText().toString());
                            queda = Double.parseDouble(txtQuedaTensao.getText().toString());
                            corrente = Double.parseDouble(txtCorrente.getText().toString());
                            fatorDePotencia = Double.parseDouble(txtFatorDePotencia.getText().toString());

                            bitola = 2*(resistividadeDoFio*comprimento*constanteTriOuMono/queda)*corrente*fatorDePotencia;

                            DecimalFormat result = new DecimalFormat("0.00");
                            txtResultado.setText("Necessário um " +
                                    "condutor com aproximadamente " +
                                    "" +result.format(bitola) + "mm²!");

                            //Admob
                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(this);
                            } else {
                                Log.d("TAG", "The interstitial ad wasn't ready yet.");
                            }
                        }
                    }
                }
            }

            EsconderTeclado();

            // calcular queda
        }else if (spinerQueda == 1){
            double comprimento = 0;
            double quedaDeTensao = 0;
            double bitola = 0;
            double corrente = 0;
            double fatorDePotencia = 0;

            //verificar se campos estao preenchidos

            if (txtFatorDePotencia.getText().toString().trim().length() != 0){
                if (txtCorrente.getText().toString().trim().length() != 0){
                    if (txtBitola.getText().toString().trim().length() != 0){
                        if (txtComprimento.getText().toString().trim().length() != 0){
                            comprimento = Double.parseDouble(txtComprimento.getText().toString());
                            bitola = Double.parseDouble(txtBitola.getText().toString());
                            corrente = Double.parseDouble(txtCorrente.getText().toString());
                            fatorDePotencia = Double.parseDouble(txtFatorDePotencia.getText().toString());

                            quedaDeTensao = 2*(resistividadeDoFio*comprimento*constanteTriOuMono/bitola)*corrente*fatorDePotencia;

                            DecimalFormat result = new DecimalFormat("0.00");
                            txtResultado.setText(result.format(quedaDeTensao) + " Volts de queda!");

                            //Admob
                            if (mInterstitialAd != null) {
                                mInterstitialAd.show(this);
                            } else {
                                Log.d("TAG", "The interstitial ad wasn't ready yet.");
                            }
                        }
                    }
                }
            }

            EsconderTeclado();
        }
    }



}