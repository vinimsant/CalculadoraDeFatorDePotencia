package com.calculodefatordepotencia.activity.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.calculodefatordepotencia.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class ManuaisPdf extends AppCompatActivity{

    PDFView pdfView;
    String indexManual = "";
    String assentManual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manuais_pdf);

        //recuperando extra
        Bundle extra = getIntent().getExtras();
        if (extra != null){
            indexManual = extra.getString("indexManual");
        }
        // recuperando o pdfviewr
        pdfView = (PDFView) findViewById(R.id.pdfview);

        //metodo de selecionar a strig do assent
        selecionarAssent();

        // selecionando o pdf através do index
        pdfView.fromAsset(assentManual)
                .scrollHandle(new DefaultScrollHandle(this)).load();
        
    }

    private void selecionarAssent(){
        switch (indexManual){
            case "cfw08":
                assentManual = "Manual-do-Usuario-CFW08.pdf";
                break;

            case "cfw09":
                assentManual = "Manual Weg CFW09.pdf";
                break;

            case "cfw11manual":
                assentManual = "Manual WEG CFW11_portugues.pdf";
                break;

            case "cfw11bornes":
                assentManual = "WEG-cfw11-manual-do-usuario-manual-portugues-br_regua de bornes.pdf";
                break;

            case "cfw500manual":
                assentManual = "WEG-cfw500-manual-de-programacao-10001469555-1.1x-manual-portugues-br.pdf";
                break;

            case "cfw500bornes":
                assentManual = "Manual-do-Usuário-CFW500-regua de borne.pdf";
                break;

            case "acs150":
                assentManual = "abb_acs150.pdf";
                break;

            case "acs350":
                assentManual = "abb_acs350.pdf";
                break;

            case "acs550":
                assentManual = "abb_acs550.pdf";
                break;

            case "acs800":
                assentManual = "abb_acs800.pdf";
                break;

            case "acs35":
                assentManual = "Manual WEG CFW11_portugues.pdf";
                break;

            case "acs30":
                assentManual = "Manual WEG CFW11_portugues.pdf";
                break;

            case "acs50":
                assentManual = "Manual WEG CFW11_portugues.pdf";
                break;



        }

    }
}