package com.calculodefatordepotencia.activity.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.calculodefatordepotencia.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

//admob
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.io.File;


public class ManuaisPdf extends AppCompatActivity{

    PDFView pdfView;
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
        pdfView = (PDFView) findViewById(R.id.pdfview);

        //metodo de selecionar a strig do assent
        //selecionarAssent();

        // selecionando o pdf através do index
        //pdfView.fromAsset(assentManual)
        //        .scrollHandle(new DefaultScrollHandle(this)).load();
        File file = new File(getExternalFilesDir(null), indexManual);
        pdfView.fromFile(file).scrollHandle(new DefaultScrollHandle(this)).load();
    }

    private void chamarInterticial(){
        if (mInterstitialAd != null) {
            mInterstitialAd.show(ManuaisPdf.this);
            Log.d("ADMOB", "o interticial foi chamado");
        } else {
            Log.d("ADMOB", "The interstitial ad wasn't ready yet.");
        }
    }

    }
