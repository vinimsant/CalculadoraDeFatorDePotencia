package com.calculodefatordepotencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText txtPotenciaAtiva;
    EditText txtFP;
    EditText txtFPDesejado;
    TextView resultado;
    String potenciaAtiva;
    String fp;
    String fpDesejado;

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*txtPotenciaAtiva = (EditText)findViewById(R.id.txtPotenciaAtiva);
        txtFP = (EditText)findViewById(R.id.txtFatorDePotencia);
        txtFPDesejado = (EditText)findViewById(R.id.txtDesejado);
        resultado = (TextView)findViewById(R.id.txtResultado);*/

        MobileAds.initialize(this);

        //Interticial
        interstitialAd = new InterstitialAd(this);
        //Oficial
        interstitialAd.setAdUnitId("ca-app-pub-2398950190237031/2397589163");
        //Teste
        //interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public void Calcular(View v){

        if (txtPotenciaAtiva.getText().length() != 0){
            if (txtFP.getText().length() != 0){
                if (txtFPDesejado.getText().length() != 0){

                    potenciaAtiva = txtPotenciaAtiva.getText().toString();
                    fp = txtFP.getText().toString();
                    fpDesejado = txtFPDesejado.getText().toString();

                    float pa = Float.parseFloat(potenciaAtiva);
                    float fatp = Float.parseFloat(fp);
                    float fatD = Float.parseFloat(fpDesejado);
                    double quaPapAntes = (pa/fatp)*(pa/fatp);
                    double quadPa = pa*pa;
                    double quadPapDepois = (pa/fatD)*(pa/fatD);
                    double potReaAntes = Math.sqrt(quaPapAntes-quadPa);
                    double potResDepois = Math.sqrt(quadPapDepois-quadPa);
                    double result = potReaAntes-potResDepois;
                    DecimalFormat df = new DecimalFormat("0.00");
                    LimparCampos();
                    EsconderTeclado();

                    resultado.setText("Resultado = "+df.format(result)+"Var\n"
                    +"Adiquira um Banco de Capacitores comercial com valor mais " +
                            "próximo de "
                    +df.format(result/1000)+"KVAR!\n"
                    +"!Certifique-se de verificar a Tensão do Equipamento!");

                    interstitialAd.loadAd(new AdRequest.Builder().build());
                    if (interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }

                }else {
                    Toast.makeText(this, "Digite a Potência o Fator de" +
                            "Potência Desejado" +
                            "!", Toast.LENGTH_LONG).show();
                }

            }else {
                Toast.makeText(this, "Digite a Potência o Fator de" +
                        "Potência do Circuito que será corrigido" +
                        "!", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(this, "Digite a Potência ativa em Watts" +
                    "!", Toast.LENGTH_LONG).show();
        }

    }

    public void EsconderTeclado(){
        ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(resultado.getWindowToken(), 0);
    }

    public void LimparCampos(){
        txtFPDesejado.setText("");
        txtFP.setText("");
        txtPotenciaAtiva.setText("");
    }

    public void ChamarDeseq(View v){
        Intent chamDeseq = new Intent(getApplicationContext(), CalculadoraDeDesequelibrioDeTensao.class);
        startActivity(chamDeseq);
    }

    public void ChamFP(View v){
        Intent cFP = new Intent(this, FatorDePotencia.class);
        startActivity(cFP);
    }


}