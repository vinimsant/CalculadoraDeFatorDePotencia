package com.calculodefatordepotencia.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.calculodefatordepotencia.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.text.DecimalFormat;

public class FatorDePotencia extends AppCompatActivity {

    EditText txtPotenciaAtiva;
    EditText txtFP;
    EditText txtFPDesejado;
    TextView resultado;
    String potenciaAtiva;
    String fp;
    String fpDesejado;
    int posicaoSpiner;

    private InterstitialAd interstitialAd;

    private String[] arraySpiner = new String[]{
      "Potência em W", "Potência em KW", "Potência e CV", "Potência em HP"
    };
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fator_de_potencia);

        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));

        txtPotenciaAtiva = (EditText)findViewById(R.id.txtPotenciaAtiva);
        txtFP = (EditText)findViewById(R.id.txtFatorDePotencia);
        txtFPDesejado = (EditText)findViewById(R.id.txtDesejado);
        resultado = (TextView)findViewById(R.id.txtResultado);
        posicaoSpiner = 0;

        MobileAds.initialize(this);

        //Interticial
        interstitialAd = new InterstitialAd(this);
        //Oficial
        interstitialAd.setAdUnitId("ca-app-pub-2398950190237031/2397589163");
        //Teste
        //interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        //Spiner

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.potencia_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        sp = (Spinner)findViewById(R.id.spinner2);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ControleDoHit(position);
                posicaoSpiner = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void Calcular(View v){

        if (txtPotenciaAtiva.getText().length() != 0){
            if (txtFP.getText().length() != 0){
                if (txtFPDesejado.getText().length() != 0){

                    potenciaAtiva = txtPotenciaAtiva.getText().toString();
                    fp = txtFP.getText().toString();
                    fpDesejado = txtFPDesejado.getText().toString();


                    float switchResut =0;


                  switch (posicaoSpiner){
                      case 0:
                       switchResut = Float.parseFloat(potenciaAtiva);
                       break;
                      case 1:
                          switchResut = Float.parseFloat(potenciaAtiva);
                          switchResut = switchResut*1000;
                          break;
                      case 2:
                          switchResut = Float.parseFloat(potenciaAtiva);
                          switchResut = switchResut*736;
                          break;
                      case 3:
                          switchResut = Float.parseFloat(potenciaAtiva);
                          switchResut = switchResut*746;
                          break;
                  }


                    float pa = switchResut;
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

    public void ControleDoHit(int position){
        if (position == 0){
            txtPotenciaAtiva.setHint("Potência ativa em Watts");
        }else if (position == 1){
            txtPotenciaAtiva.setHint("Potência ativa em KiloWatts");
        }else if (position == 2){
            txtPotenciaAtiva.setHint("Potência ativa em CV");
        }else if (position == 3){
            txtPotenciaAtiva.setHint("Potência ativa em HP");
        }

    }

}