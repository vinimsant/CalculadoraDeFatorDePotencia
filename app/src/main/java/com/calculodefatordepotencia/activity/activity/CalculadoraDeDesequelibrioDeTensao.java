package com.calculodefatordepotencia.activity.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.calculodefatordepotencia.R;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;


import java.text.DecimalFormat;

public class CalculadoraDeDesequelibrioDeTensao extends AppCompatActivity {

    public double rs;
    public double rt;
    public double ts;
    public double desequilibrio;

    public TextView result;
    public EditText txtRS;
    public EditText txtRT;
    public EditText txtTS;

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_de_desequelibrio_de_tensao);
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));

        result = (TextView)findViewById(R.id.txtResultadoDesequilibrio);
        txtRS = (EditText)findViewById(R.id.txtRS);
        txtRT = (EditText)findViewById(R.id.txtRT);
        txtTS = (EditText)findViewById(R.id.txtTS);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-2398950190237031/1457840060", adRequest,
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


    }

    public void Limpar(View v){
        txtTS.setText("");
        txtRT.setText("");
        txtRS.setText("");
        result.setText("");
        rs = 0;
        rt = 0;
        ts = 0;
        desequilibrio = 0;
    }

    public void Resultado(View v){
        if (txtRS.getText().length() != 0){
           if (txtRT.getText().length() != 0){
               if (txtTS.getText().length() != 0){

                   rs = Double.parseDouble(txtRS.getText().toString());
                   rt = Double.parseDouble(txtRT.getText().toString());
                   ts = Double.parseDouble(txtTS.getText().toString());
                   CalcDesequilibrio();
                   DecimalFormat df = new DecimalFormat("0.00");
                   result.setText("\nDesequilibrio de Tensâo de " +
                           ""+df.format(desequilibrio)+"%\n"+"De acordo com o PRODIST " +
                           "Módulo 8 " +
                           "da ANEEL, o desequilibrio maximo aceitavel é de 3% para tensões menores ou iguais a 1.000 " +
                           "Volts e de 2% para tensões entre 1.000 e 230.000 Volts!");
                   EsconderTeclado();

                  //AdMob
                   if (mInterstitialAd != null) {
                       mInterstitialAd.show(this);
                   } else {
                       Log.d("TAG", "The interstitial ad wasn't ready yet.");
                   }


               }else {
                   Toast.makeText(getApplicationContext(), "Preencha o valor da Tensão TS" +
                           "", Toast.LENGTH_LONG).show();
               }
           }else {
               Toast.makeText(getApplicationContext(), "Preencha o valor da Tensão RT" +
                       "", Toast.LENGTH_LONG).show();
           }
        }else {
            Toast.makeText(getApplicationContext(),"Preencha o valor da Tensão RS" +
                    "", Toast.LENGTH_LONG).show();
        }

    }
    public void CalcDesequilibrio(){

        double beta1 = (Math.pow(rs, 4)+Math.pow(rt, 4)+Math.pow(ts, 4));
        Log.i("1",""+beta1);
        double beta2 = (Math.pow(rs, 2)+Math.pow(rt, 2)+Math.pow(ts, 2));
        Log.i("1",""+beta2);;
        beta2 = Math.pow(beta2, 2);
        Log.i("1",""+beta2);
        double beta =  (beta1/beta2);
        Log.i("1",""+beta);
        double betaVezesSeis = 6*beta;
        Log.i("1",""+betaVezesSeis);
        double tresmenosBetaV = 3-betaVezesSeis;
        double desq1 = Math.sqrt(tresmenosBetaV);
        Log.i("1",""+desq1);
        double desq2 = 1-desq1;
        Log.i("1",""+desq2);
        double desq3 = 1+desq1;
        Log.i("1",""+desq3);
        double des2divides3 = desq2/desq3;
        desequilibrio = 100*Math.sqrt(des2divides3);
        Log.i("1",""+desequilibrio);


    }

    public void EsconderTeclado(){
        ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(result.getWindowToken(), 0 );
    }
}