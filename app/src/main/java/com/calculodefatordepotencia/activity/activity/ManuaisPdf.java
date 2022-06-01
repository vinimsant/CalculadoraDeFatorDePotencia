package com.calculodefatordepotencia.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.calculodefatordepotencia.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class ManuaisPdf extends AppCompatActivity {

    PDFView pdfView;
    int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manuais_pdf);

        // recuperando o pdfviewr
        page = 0;
        pdfView = (PDFView) findViewById(R.id.pdfview);
        pdfView.fromAsset("Manual-do-Usuario-CFW08.pdf")
                .scrollHandle(new DefaultScrollHandle(this)).defaultPage(page).load();

    }
}