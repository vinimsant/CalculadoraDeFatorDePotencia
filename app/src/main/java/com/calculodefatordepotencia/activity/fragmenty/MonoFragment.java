package com.calculodefatordepotencia.activity.fragmenty;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.content.Context;
import android.widget.Toast;

import com.calculodefatordepotencia.R;

import java.text.DecimalFormat;

import com.calculodefatordepotencia.activity.activity.CalculadoraDeDesequelibrioDeTensao;
import com.calculodefatordepotencia.activity.activity.FatorDePotencia;
import com.calculodefatordepotencia.activity.activity.QuedaDeTensao;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import static androidx.core.content.ContextCompat.getSystemService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MonoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonoFragment extends Fragment {

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
    private QuedaDeTensao quedaDeTensao;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MonoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MonoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MonoFragment newInstance(String param1, String param2) {
        MonoFragment fragment = new MonoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mono, container, false);

        //Recuperando componetes do layot
        txtQuedaTensao = (EditText)view.findViewById(R.id.txtQuedaDeTensao);
        txtBitola = (EditText)view.findViewById(R.id.txtBitolaCondutor);
        txtComprimento = (EditText)view.findViewById(R.id.txtComprimentoCondutor);
        txtCorrente = (EditText)view.findViewById(R.id.txtCorrente);
        txtFatorDePotencia = (EditText)view.findViewById(R.id.txtFatorDePotenciaQueda);
        txtResultado = (TextView)view.findViewById(R.id.txtResultadoQueda);
        limpar = (Button)view.findViewById(R.id.btnLimparQueda);
        calcular = (Button)view.findViewById(R.id.btnCalcularQueda);



        //Interticial
        MobileAds.initialize(view.getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(view.getContext(),"ca-app-pub-3940256099942544/1033173712", adRequest,
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
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.tipo_de_condutor, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoDeCondutor = (Spinner)view.findViewById(R.id.spnTipoDeCondutor);
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
        ArrayAdapter<CharSequence> arrayAdapter1 = ArrayAdapter.createFromResource(getContext(),
                R.array.tipo_de_calculo_de_queda, android.R.layout.simple_spinner_item);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoDeCalculo = (Spinner)view.findViewById(R.id.spnCalcQuedaOuBitola);
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
        ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(getContext(),
                R.array.sistema_trifasico_ou_monofasico, android.R.layout.simple_spinner_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        triOuMono = (Spinner)view.findViewById(R.id.spn_TriOuMono);
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

        return view;
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

        ((InputMethodManager)getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
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
                        }
                    }
                }
            }

            EsconderTeclado();
        }
    }



}