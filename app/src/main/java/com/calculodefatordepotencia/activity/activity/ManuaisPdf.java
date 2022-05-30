package com.calculodefatordepotencia.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.calculodefatordepotencia.R;
import com.github.barteksc.pdfviewer.PDFView;

public class ManuaisPdf extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manuais_pdf);

        // recuperando o pdfviewr
        pdfView = (PDFView) findViewById(R.id.pdfview);
        pdfView.fromAsset("Manual-do-Usuario-CFW08.pdf").load();
    }
}