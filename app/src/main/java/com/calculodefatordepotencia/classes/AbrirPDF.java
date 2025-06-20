package com.calculodefatordepotencia.classes;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import java.io.File;

public abstract class AbrirPDF {

    public static void abrirPDF(Context context, String indexManual){

        String patch = "storage/emulated/0/Android/data/com.calculodefatordepotencia/files/"+indexManual;
        File file = new File(patch);
        //função para solicitar android um app para abrir o pdf
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
