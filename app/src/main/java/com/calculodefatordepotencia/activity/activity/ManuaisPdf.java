package com.calculodefatordepotencia.activity.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.calculodefatordepotencia.R;
//import com.github.barteksc.pdfviewer.PDFView;
//import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
//import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

//admob
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ManuaisPdf extends AppCompatActivity{

    //PDFView pdfView;


    String indexManual = "";
    String assentManual;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manuais_pdf);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-2398950190237031/9730209615", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("ADMOB", "onAdLoaded");
                        if (mInterstitialAd != null) {
                            mInterstitialAd.show(ManuaisPdf.this);
                            Log.d("ADMOB", "o interticial foi chamado");
                        } else {
                            Log.d("ADMOB", "The interstitial ad wasn't ready yet.");
                        }
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d("ADMOB", loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });




        //recuperando extra
        Bundle extra = getIntent().getExtras();
        if (extra != null){
            indexManual = extra.getString("indexManual");
        }

        setTitle(indexManual);

        // recuperando o pdfviewr
        //pdfView = (PDFView) findViewById(R.id.pdfview);

        //metodo de selecionar a strig do assent
        //selecionarAssent();

        // selecionando o pdf através do index
        //pdfView.fromAsset(assentManual)
        //        .scrollHandle(new DefaultScrollHandle(this)).load();
        File file = new File(getExternalFilesDir(null), indexManual);

        AlertDialog.Builder dialogSelecaoAbrirPDF = new AlertDialog.Builder(this);
        dialogSelecaoAbrirPDF.setTitle("Seleção de APP para Abrir o Arquivo");
        dialogSelecaoAbrirPDF.setMessage("Como deseja exibir o manual?");
        dialogSelecaoAbrirPDF.setCancelable(false);
        //botões
        dialogSelecaoAbrirPDF.setPositiveButton("Aplicativo do sistema", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /*String nomeFile = Environment.getExternalStorageDirectory().toString();
                File f = new File(nomeFile);
                Intent target = new Intent(Intent.ACTION_VIEW);
                target.setDataAndType(Uri.fromFile(f), "application/pdf");

                Intent intent = Intent.createChooser(target, "Abrir arquivo");*/

                String patch = "storage/emulated/0/Android/data/com.calculodefatordepotencia/files/"+indexManual;
                File nf = new File(patch);
                //função para solicitar android um app para abrir o pdf
                abrirPDF(getApplicationContext(), nf);

                /*Uri uri = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".provider", nf);
                Intent it = new Intent();
                it.setAction(android.content.Intent.ACTION_VIEW);
                it.setDataAndType(uri, "aplication/pdf");
                it.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                try {
                    startActivity(it);
                }catch (Exception e){
                    Log.d("exeção", "gerada a exeção "+e+" ao tentar abrir o arquivo pdf pelo APP padrão android nome do arquivo "+nf.toString());
                    Toast.makeText(getApplicationContext(),"Não foi encontrado nenhum APP para abrir o arquivo", Toast.LENGTH_LONG).show();
                    //pdfView.fromFile(file).scrollHandle(new DefaultScrollHandle(getApplicationContext())).load();
                }*/



            }
        });
        dialogSelecaoAbrirPDF.setNegativeButton("APP eletrohelp", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //pdfView.fromFile(file).scrollHandle(new DefaultScrollHandle(getApplicationContext())).load();
            }
        });
        dialogSelecaoAbrirPDF.show();

    }

    private void chamarInterticial(){
        if (mInterstitialAd != null) {
            mInterstitialAd.show(ManuaisPdf.this);
            Log.d("ADMOB", "o interticial foi chamado");
        } else {
            Log.d("ADMOB", "The interstitial ad wasn't ready yet.");
        }
    }

    //função para solicitar android um app para abrir o pdf
    public void abrirPDF(Context context, File file) {
        Uri uri = FileProvider.getUriForFile(
                context,
                context.getPackageName() + ".provider",
                file);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        // Verifica se existe algum app que possa abrir o PDF
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "Nenhum aplicativo encontrado para abrir PDF", Toast.LENGTH_LONG).show();
        }
    }


}
