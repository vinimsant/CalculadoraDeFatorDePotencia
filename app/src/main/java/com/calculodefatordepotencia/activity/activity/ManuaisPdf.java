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
    int indexManual = 0;
    String assentManual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manuais_pdf);

        //recuperando extra
        Bundle extra = getIntent().getExtras();
        if (extra != null){
            indexManual = extra.getInt("indexManual");
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
            case 1:
                assentManual = "Manual-do-Usuario-CFW08.pdf";
                break;

            case 2:
                assentManual = "Manual Weg CFW09.pdf";
                break;

            case 3:
                assentManual = "Manual WEG CFW11_portugues.pdf";
                break;
        }

    }
}