package com.calculodefatordepotencia.activity.activity;

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
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

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

    private InterstitialAd interstitialAd;


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

        MobileAds.initialize(this);

        //Interticial
        interstitialAd = new InterstitialAd(this);
        //Oficial
        interstitialAd.setAdUnitId("ca-app-pub-2398950190237031/2397589163");
        //Teste
        //interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());
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
                   /*interstitialAd.loadAd(new AdRequest.Builder().build());
                    if (interstitialAd.isLoaded()){
                        interstitialAd.show();*/
                   interstitialAd.loadAd(new AdRequest.Builder().build());
                   if (interstitialAd.isLoaded()){
                       interstitialAd.show();
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