package com.calculodefatordepotencia.activity.activity;

import static android.widget.Toast.LENGTH_LONG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.calculodefatordepotencia.R;

public class EloDeTransformador extends AppCompatActivity {

    private TextView resultado;
    private Spinner tipoTransformador;
    private Spinner tensaoPrimaria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));
        actionBar.setTitle("Elo de Transformador");
        setContentView(R.layout.activity_elo_de_transformador);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        resultado = findViewById(R.id.txt_elo_resultado);
        tipoTransformador = findViewById(R.id.spn_tipo_de_trnasformador);
        tensaoPrimaria = findViewById(R.id.spn_tensao_primario);


        //configurar o spiner tensão primaria

        //criando um adapter para o spinner caso o transformador seja monofásico
        ArrayAdapter<CharSequence> adapter_tensao_monofasico = ArrayAdapter.createFromResource(this,
                R.array.tensão_primaria_monofasico, android.R.layout.simple_spinner_item);

        //especificar um layout para o spinner
        adapter_tensao_monofasico.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //criando um adapter para o spinner caso o transformador seja trifasico
        ArrayAdapter<CharSequence> adapter_tensao_trifasico = ArrayAdapter.createFromResource(this,
                R.array.tensão_primaria_trifasico, android.R.layout.simple_spinner_item);

        //especificar um layout para o spinner
        adapter_tensao_trifasico.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //configurar o spiner tipo de transformador

        //criando um adapter para o spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tipo_de_transformador, android.R.layout.simple_spinner_item);

        //especificar um layout para o spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //aplicar o adapter ao spinner
        tipoTransformador.setAdapter(adapter);
        //criar ouvinte para a seleção do spner
        tipoTransformador.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1){
                    tensaoPrimaria.setAdapter(adapter_tensao_monofasico);
                }
                if (position == 0){
                    tensaoPrimaria.setAdapter(adapter_tensao_trifasico);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        //aplicar o adapter ao spinner
        tensaoPrimaria.setAdapter(adapter_tensao_trifasico);

        //criar ouvinte para a seleção do spner
        tensaoPrimaria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "spiner tensão auterado", LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void linpar(){
        Intent intent = new Intent(this, EloDeTransformador.class);
        startActivity(intent);
    }

    public void calcular(){
        if (tipoTransformador.getSelectedItemPosition() == 0){
            int tensao = tensaoPrimaria.getSelectedItemPosition();
            String elo;
            switch (tensao){
                case 0:
                    elo = "11,4 KV";
                    break;
                case 1:
                    elo = "13,8 KV";
                    break;
                case 2:
                    resultado.setText("22 KV");
                    break;
                case 3:
                    resultado.setText("34,5 KV");
                    break;
            }
        }
        if (tipoTransformador.getSelectedItemPosition() == 1){

        }
    }
}