package com.calculodefatordepotencia.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.calculodefatordepotencia.Manuais;
import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.inversores.InversoresDanfos;
import com.google.android.gms.ads.AdRequest;

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
    ImageView manuais;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));

        /*txtPotenciaAtiva = (EditText)findViewById(R.id.txtPotenciaAtiva);
        txtFP = (EditText)findViewById(R.id.txtFatorDePotencia);
        txtFPDesejado = (EditText)findViewById(R.id.txtDesejado);
        resultado = (TextView)findViewById(R.id.txtResultado);*/



        //Interticial


        manuais = findViewById(R.id.imgMainManuais);
        manuais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), manuais1_0.class);
                startActivity(intent);
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

                   //Admob

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

    public void ChamarQueda(View v){
        Intent intent = new Intent(this, QuedaDeTensao.class);
        startActivity(intent);
    }

    public void ChamarManuais(View v){
        Intent intent = new Intent(this, manuais1_0.class);
        startActivity(intent);
    }



}