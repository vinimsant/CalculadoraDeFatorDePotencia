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
import android.util.Base64;
import android.util.Log;
import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Switch;
import android.widget.Toast;

import com.calculodefatordepotencia.R;
//import com.github.barteksc.pdfviewer.PDFView;
//import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
//import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

//admob
import com.calculodefatordepotencia.classes.AbrirPDF;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

        //encontrar webview







        //recuperando extra
        Bundle extra = getIntent().getExtras();
        if (extra != null){
            indexManual = extra.getString("indexManual");
        }

        setTitle(indexManual);

        String patch = "storage/emulated/0/Android/data/com.calculodefatordepotencia/files/"+indexManual;
        File nf = new File(patch);
        //função para solicitar android um app para abrir o pdf
        abrirPDF(getApplicationContext(), nf);
    }

    private void chamarInterticial(){
        if (mInterstitialAd != null) {
            mInterstitialAd.show(ManuaisPdf.this);
            Log.d("ADMOB", "o interticial foi chamado");
        } else {
            Log.d("ADMOB", "The interstitial ad wasn't ready yet.");
        }
    }

    //função para solicitar android um app para abrir o pdf com app do sistema
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

    //função para abrir voltar para a pagina inicial


    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
