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

        setTitle(indexManual);

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

            case "acs355":
                assentManual = "abb_acs350.pdf";
                break;

            case "acs550":
                assentManual = "abb_acs550.pdf";
                break;

            case "acs800":
                assentManual = "abb_acs800.pdf";
                break;

            case "atv11":
                assentManual = "ATV11.pdf";
                break;

            case "atv12":
                assentManual = "atv12.pdf";
                break;

            case "atv212":
                assentManual = "ATV212.pdf";
                break;

            case "atv28":
                assentManual = "atv28.pdf";
                break;

            case "atv31":
                assentManual = "atv31.pdf";
                break;

            case "atv32":
                assentManual = "atv32.pdf";
                break;

            case "atv61":
                assentManual = "ATV61.pdf";
                break;

            case "atv71":
                assentManual = "atv71.pdf";
                break;

            case "atv312":
                assentManual = "atv312.pdf";
                break;

            case "atv320":
                assentManual = "atv320.pdf";
                break;

            case "atv600":
                assentManual = "atv600_manual_de_programação.pdf";
                break;

            case "atv630":
                assentManual = "atv630_manual_de_instalação.pdf";
                break;

            case "fc101":
                assentManual = "fc101.pdf";
                break;

            case "fc202":
                assentManual = "fc202.pdf";
                break;

            case "fc051":
                assentManual = "fc051.pdf";
                break;

            case "fc051bornes":
                assentManual = "fc051_regua_de_bornes.pdf";
                break;

            case "vacon10":
                assentManual = "vacon10.pdf";
                break;

            case "vacon20":
                assentManual = "vacon20.pdf";
                break;

            case "vacon100":
                assentManual = "vacon100.pdf";
                break;

            case "Guia Micromaster440":
                assentManual = "micromaster_440_guia_com_regua_de_bornes.pdf";
                break;

            case "Manual Micromaster440":
                assentManual = "micromaster440_manual_de_programacao.pdf";
                break;

            case "micromaster420":
                assentManual = "siemens_mm420.pdf";
                break;

            case "micromaster430":
                assentManual = "micromaster430_ingles.pdf";
                break;

            case "vaco2":
                assentManual = "vacon20.pdf";
                break;

            case "vaco0":
                assentManual = "vacon20.pdf";
                break;

            case "vac20":
                assentManual = "vacon20.pdf";
                break;

            case "vaco20":
                assentManual = "vacon20.pdf";
                break;

        }

    }
}