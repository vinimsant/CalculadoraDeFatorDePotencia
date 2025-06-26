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
    private Spinner potencia;


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
        potencia = findViewById(R.id.spn_potencia);

        //configurar o spner potencia

        //criando um adapter para o spinner potencia monofasico
        ArrayAdapter<CharSequence> adapter_potencia_monofasico = ArrayAdapter.createFromResource(this,
                R.array.potencia_monofasico, R.layout.custom_spinner_item);

        //especificar um layout para o spinner
        adapter_potencia_monofasico.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);

        //criando um adapter para o spinner potencia trifasico
        ArrayAdapter<CharSequence> adapter_potencia_trifasico = ArrayAdapter.createFromResource(this,
                R.array.potencia_trifasico, R.layout.custom_spinner_item);

        //especificar um layout para o spinner
        adapter_potencia_trifasico.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);


        //configurar o spiner tensão primaria

        //criando um adapter para o spinner caso o transformador seja monofásico
        ArrayAdapter<CharSequence> adapter_tensao_monofasico = ArrayAdapter.createFromResource(this,
                R.array.tensão_primaria_monofasico, R.layout.custom_spinner_item);

        //especificar um layout para o spinner
        adapter_tensao_monofasico.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);

        //criando um adapter para o spinner caso o transformador seja trifasico
        ArrayAdapter<CharSequence> adapter_tensao_trifasico = ArrayAdapter.createFromResource(this,
                R.array.tensão_primaria_trifasico, R.layout.custom_spinner_item);

        //especificar um layout para o spinner
        adapter_tensao_trifasico.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);

        //configurar o spiner tipo de transformador

        //criando um adapter para o spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tipo_de_transformador, R.layout.custom_spinner_item);

        //especificar um layout para o spinner
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        //aplicar o adapter ao spinner
        tipoTransformador.setAdapter(adapter);
        //criar ouvinte para a seleção do spner
        tipoTransformador.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1){
                    tensaoPrimaria.setAdapter(adapter_tensao_monofasico);
                    potencia.setAdapter(adapter_potencia_monofasico);
                }
                if (position == 0){
                    tensaoPrimaria.setAdapter(adapter_tensao_trifasico);
                    potencia.setAdapter(adapter_potencia_trifasico);
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

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void linpar(View view){
        Intent intent = new Intent(this, EloDeTransformador.class);
        startActivity(intent);
    }

    public void calcular(View view){
        //tensão trifasica selecionada
        if (tipoTransformador.getSelectedItemPosition() == 0){
            int tensao = tensaoPrimaria.getSelectedItemPosition();
            int potencia = this.potencia.getSelectedItemPosition();
            String elo;
            switch (tensao){
                //tensão 11,4 KV
                case 0:
                    switch (potencia){
                        //potencia 15kva
                        case 0:
                            resultado.setText("O ELO fusivel adequado para o transformador de 15Kva em 11,4Kv é o ELO 1H!");
                            break;
                        //potencia 30kva
                        case 1:
                            resultado.setText("O ELO fusivel adequado para o transformador de 30Kva em 11,4Kv é o ELO 2H!");
                            break;
                        //potencia 45kva
                        case 2:
                            resultado.setText("O ELO fusivel adequado para o transformador de 45Kva em 11,4Kv é o ELO 2H!");
                            break;
                        //potencia 75kva
                        case 3:
                            resultado.setText("O ELO fusivel adequado para o transformador de 75Kva em 11,4Kv é o ELO 3H!");
                            break;
                        //potencia 112,5kva
                        case 4:
                            resultado.setText("O ELO fusivel adequado para o transformador de 112,5Kva em 11,4Kv é o ELO 5H!");
                            break;
                        //potencia 150kva
                        case 5:
                            resultado.setText("O ELO fusivel adequado para o transformador de 150Kva em 11,4Kv é o ELO 8k!");
                            break;
                        //potencia 225kva
                        case 6:
                            resultado.setText("O ELO fusivel adequado para o transformador de 225Kva em 11,4Kv é o ELO 12k!");
                            break;
                        //potencia 300kva
                        case 7:
                            resultado.setText("O ELO fusivel adequado para o transformador de 300Kva em 11,4Kv é o ELO 15k!");
                            break;
                        //potencia 400kva
                        case 8:
                            resultado.setText("O ELO fusivel adequado para o transformador de 400Kva em 11,4Kv é o ELO 20k!");
                            break;
                        //potencia 500kva
                        case 9:
                            resultado.setText("O ELO fusivel adequado para o transformador de 500Kva em 11,4Kv é o ELO 25k!");
                            break;
                        //potencia 750kva
                        case 10:
                            resultado.setText("O ELO fusivel adequado para o transformador de 750Kva em 11,4Kv é o ELO 40k!");
                            break;
                        //potencia 1000kva
                        case 11:
                            resultado.setText("Não têm transformador comercial operando nessa faixa de tensão!");
                            break;
                    }
                    break;
                //tensão 13,8 KV
                case 1:
                    switch (potencia){
                        //potencia 15kva
                        case 0:
                            resultado.setText("O ELO fusivel adequado para o transformador de 15Kva em 13,8Kv é o ELO 0,5H!");
                            break;
                        //potencia 30kva
                        case 1:
                            resultado.setText("O ELO fusivel adequado para o transformador de 30Kva em 13,8Kv é o ELO 1H!");
                            break;
                        //potencia 45kva
                        case 2:
                            resultado.setText("O ELO fusivel adequado para o transformador de 45Kva em 13,8Kv é o ELO 2H!");
                            break;
                        //potencia 75kva
                        case 3:
                            resultado.setText("O ELO fusivel adequado para o transformador de 75Kva em 13,8Kv é o ELO 3H!");
                            break;
                        //potencia 112,5kva
                        case 4:
                            resultado.setText("O ELO fusivel adequado para o transformador de 112,5Kva em 13,8Kv é o ELO 5H!");
                            break;
                        //potencia 150kva
                        case 5:
                            resultado.setText("O ELO fusivel adequado para o transformador de 150Kva em 13,8Kv é o ELO 6k!");
                            break;
                        //potencia 225kva
                        case 6:
                            resultado.setText("O ELO fusivel adequado para o transformador de 225Kva em 13,8Kv é o ELO 10k!");
                            break;
                        //potencia 300kva
                        case 7:
                            resultado.setText("O ELO fusivel adequado para o transformador de 300Kva em 13,8Kv é o ELO 12k!");
                            break;
                        //potencia 400kva
                        case 8:
                            resultado.setText("O ELO fusivel adequado para o transformador de 400Kva em 13,8Kv é o ELO 15k!");
                            break;
                        //potencia 500kva
                        case 9:
                            resultado.setText("O ELO fusivel adequado para o transformador de 500Kva em 13,8Kv é o ELO 25k!");
                            break;
                        //potencia 750kva
                        case 10:
                            resultado.setText("O ELO fusivel adequado para o transformador de 750Kva em 13,8Kv é o ELO 30k!");
                            break;
                        //potencia 1000kva
                        case 11:
                            resultado.setText("O ELO fusivel adequado para o transformador de 1000Kva em 13,8Kv é o ELO 40k!");
                            break;
                    }
                    break;
                //tesão 22kv
                case 2:
                    switch (potencia){
                        //potencia 15kva
                        case 0:
                            resultado.setText("O ELO fusivel adequado para o transformador de 15Kva em 22Kv é o ELO 0,5H!");
                            break;
                        //potencia 30kva
                        case 1:
                            resultado.setText("O ELO fusivel adequado para o transformador de 30Kva em 22Kv é o ELO 1H!");
                            break;
                        //potencia 45kva
                        case 2:
                            resultado.setText("O ELO fusivel adequado para o transformador de 45Kva em 22Kv é o ELO 1H!");
                            break;
                        //potencia 75kva
                        case 3:
                            resultado.setText("O ELO fusivel adequado para o transformador de 75Kva em 22Kv é o ELO 2H!");
                            break;
                        //potencia 112,5kva
                        case 4:
                            resultado.setText("O ELO fusivel adequado para o transformador de 112,5Kva em 22Kv é o ELO 3H!");
                            break;
                        //potencia 150kva
                        case 5:
                            resultado.setText("O ELO fusivel adequado para o transformador de 150Kva em 22Kv é o ELO 5H!");
                            break;
                        //potencia 225kva
                        case 6:
                            resultado.setText("O ELO fusivel adequado para o transformador de 225Kva em 22Kv é o ELO 5H!");
                            break;
                        //potencia 300kva
                        case 7:
                            resultado.setText("O ELO fusivel adequado para o transformador de 300Kva em 22Kv é o ELO 8k!");
                            break;
                        //potencia 400kva
                        case 8:
                            resultado.setText("O ELO fusivel adequado para o transformador de 400Kva em 22Kv é o ELO 10k!");
                            break;
                        //potencia 500kva
                        case 9:
                            resultado.setText("O ELO fusivel adequado para o transformador de 500Kva em 22Kv é o ELO 12k!");
                            break;
                        //potencia 750kva
                        case 10:
                            resultado.setText("O ELO fusivel adequado para o transformador de 750Kva em 22Kv é o ELO 20k!");
                            break;
                        //potencia 1000kva
                        case 11:
                            resultado.setText("O ELO fusivel adequado para o transformador de 1000Kva em 22Kv é o ELO 25k!");
                            break;
                    }
                    break;
                //tensão 34,5 KV
                case 3:
                    switch (potencia){
                        //potencia 15kva
                        case 0:
                            resultado.setText("O ELO fusivel adequado para o transformador de 15Kva em 22Kv é o ELO 0,5H!");
                            break;
                        //potencia 30kva
                        case 1:
                            resultado.setText("O ELO fusivel adequado para o transformador de 30Kva em 22Kv é o ELO 0,5H!");
                            break;
                        //potencia 45kva
                        case 2:
                            resultado.setText("O ELO fusivel adequado para o transformador de 45Kva em 22Kv é o ELO 1H!");
                            break;
                        //potencia 75kva
                        case 3:
                            resultado.setText("O ELO fusivel adequado para o transformador de 75Kva em 22Kv é o ELO 1H!");
                            break;
                        //potencia 112,5kva
                        case 4:
                            resultado.setText("O ELO fusivel adequado para o transformador de 112,5Kva em 22Kv é o ELO 2H!");
                            break;
                        //potencia 150kva
                        case 5:
                            resultado.setText("O ELO fusivel adequado para o transformador de 150Kva em 22Kv é o ELO 3H!");
                            break;
                        //potencia 225kva
                        case 6:
                            resultado.setText("O ELO fusivel adequado para o transformador de 225Kva em 22Kv é o ELO 5H!");
                            break;
                        //potencia 300kva
                        case 7:
                            resultado.setText("O ELO fusivel adequado para o transformador de 300Kva em 22Kv é o ELO 5H!");
                            break;
                        //potencia 400kva
                        case 8:
                            resultado.setText("O ELO fusivel adequado para o transformador de 400Kva em 22Kv é o ELO 6k!");
                            break;
                        //potencia 500kva
                        case 9:
                            resultado.setText("O ELO fusivel adequado para o transformador de 500Kva em 22Kv é o ELO 10k!");
                            break;
                        //potencia 750kva
                        case 10:
                            resultado.setText("O ELO fusivel adequado para o transformador de 750Kva em 22Kv é o ELO 12k!");
                            break;
                        //potencia 1000kva
                        case 11:
                            resultado.setText("O ELO fusivel adequado para o transformador de 1000Kva em 22Kv é o ELO 15k!");
                            break;
                    }
                    break;
            }
        }
        //rensão monofasica selecionada
        if (tipoTransformador.getSelectedItemPosition() == 1){
            int tensao = tensaoPrimaria.getSelectedItemPosition();
            int potencia = this.potencia.getSelectedItemPosition();

            switch (tensao){
                //tensão 6,5Kv
                case 0:
                    switch (potencia){
                        //potencia 5kva
                        case 0:
                            resultado.setText("O ELO fusivel adequado para o transformador de 5Kva em 6,5Kv é o ELO 0,5H!");
                            break;
                        //potencia 10kva
                        case 1:
                            resultado.setText("O ELO fusivel adequado para o transformador de 10Kva em 6,5Kv é o ELO 1H!");
                            break;
                        //potencia 15kva
                        case 2:
                            resultado.setText("O ELO fusivel adequado para o transformador de 15Kva em 6,5Kv é o ELO 2H!");
                            break;
                        //potencia 25kva
                        case 3:
                            resultado.setText("O ELO fusivel adequado para o transformador de 25Kva em 6,5Kv é o ELO 3H!");
                            break;
                    }
                    break;
                //tensão 7,9Kv
                case 1:
                    switch (potencia) {
                        //potencia 5kva
                        case 0:
                            resultado.setText("O ELO fusivel adequado para o transformador de 5Kva em 7,9Kv é o ELO 0,5H!");
                            break;
                        //potencia 10kva
                        case 1:
                            resultado.setText("O ELO fusivel adequado para o transformador de 10Kva em 7,9Kv é o ELO 1H!");
                            break;
                        //potencia 15kva
                        case 2:
                            resultado.setText("O ELO fusivel adequado para o transformador de 15Kva em 7,9Kv é o ELO 2H!");
                            break;
                        //potencia 25kva
                        case 3:
                            resultado.setText("O ELO fusivel adequado para o transformador de 25Kva em 7,9Kv é o ELO 3H!");
                            break;
                    }
                    break;
                //tensão 12,7Kv
                case 2:
                    switch (potencia){
                        //potencia 5kva
                        case 0:
                            resultado.setText("O ELO fusivel adequado para o transformador de 5Kva em 12,7Kv é o ELO 0,5H!");
                            break;
                        //potencia 10kva
                        case 1:
                            resultado.setText("O ELO fusivel adequado para o transformador de 10Kva em 12,7Kv é o ELO 1H!");
                            break;
                        //potencia 15kva
                        case 2:
                            resultado.setText("O ELO fusivel adequado para o transformador de 15Kva em 12,7Kv é o ELO 1H!");
                            break;
                        //potencia 25kva
                        case 3:
                            resultado.setText("O ELO fusivel adequado para o transformador de 25Kva em 12,7Kv é o ELO 2H!");
                            break;
                    }
                    break;
                //tensão 19,9Kv
                case 3:
                    switch (potencia){
                        //potencia 5kva
                        case 0:
                            resultado.setText("O ELO fusivel adequado para o transformador de 5Kva em 19,9Kv é o ELO 0,5H!");
                            break;
                        //potencia 10kva
                        case 1:
                            resultado.setText("O ELO fusivel adequado para o transformador de 10Kva em 19,9Kv é o ELO 0,5H!");
                            break;
                        //potencia 15kva
                        case 2:
                            resultado.setText("O ELO fusivel adequado para o transformador de 15Kva em 19,9Kv é o ELO 1H!");
                            break;
                        //potencia 25kva
                        case 3:
                            resultado.setText("O ELO fusivel adequado para o transformador de 25Kva em 19,9Kv é o ELO 2H!");
                            break;
                    }
                    break;
            }
        }
    }
}