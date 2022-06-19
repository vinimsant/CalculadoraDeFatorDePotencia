package com.calculodefatordepotencia.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
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

            case "cw11manual":
                assentManual = "Manual WEG CFW11_portugues.pdf";
                break;

            case "c11manual":
                assentManual = "Manual WEG CFW11_portugues.pdf";
                break;

            case "cmanual":
                assentManual = "Manual WEG CFW11_portugues.pdf";
                break;
        }

    }
}