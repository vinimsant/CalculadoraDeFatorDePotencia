package com.calculodefatordepotencia.activity.activity.inversores;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;

import java.io.File;

public class InveroresABB extends AppCompatActivity {

    private ImageView acs150;
    private ImageView acs350;
    private ImageView acs550;
    private ImageView acs800;

    //BrodCast do dwnload
    private long downloadId;
    // dialogo de download em andamento
    AlertDialog dialog;
    //teste para o icone do botao do manual se foi baixado
    String nomeArquivo = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inverores_a_b_b);

        setTitle("Inversores ABB");

        acs150 = findViewById(R.id.imginvacs150);
        acs350 = findViewById(R.id.imginvacs350);
        acs550 = findViewById(R.id.imginvacs550);
        acs800 = findViewById(R.id.imginvacs800);

        //registrando broad cast
        //registerReceiver(onDownloadComplet, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

        File fileAcss150 = new File(getExternalFilesDir(null), "abb_acs150.pdf");
        File fileAcss350 = new File(getExternalFilesDir(null), "abb_acs350.pdf");
        File fileAcss550 = new File(getExternalFilesDir(null), "abb_acs550.pdf");
        File fileAcss800 = new File(getExternalFilesDir(null), "abb_acs800.pdf");

        if (fileAcss150.exists()){
            acs150.setImageResource(R.drawable.acs150);
        }
        if (fileAcss350.exists()){
            acs350.setImageResource(R.drawable.acs355);
        }
        if (fileAcss550.exists()){
            acs550.setImageResource(R.drawable.acs550);
        }
        if (fileAcss800.exists()){
            acs800.setImageResource(R.drawable.acs800);
        }


        acs150.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nomeArquivo = "abb_acs150.pdf";
                String url = "https://"+"drive.google.com/u/0/uc?id=1NHyIXe_Rs2ZFXf7Itjc3ZItZA3EGA0kD&export=download";
                File file = new File(getExternalFilesDir(null), nomeArquivo);

                //Instancia da classe para testar se o arquivo já foi baixado
                Download download = new Download();
                String texteConexao = download.TesteConexao(getBaseContext());
                if (file.exists()){
                    Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                    intent.putExtra("indexManual", nomeArquivo);
                    startActivity(intent);
                }else if (!file.exists()){
                    if (texteConexao == "wifi"){
                        Download(nomeArquivo, url, file);
                    }else if (texteConexao == "dados moveis"){
                        //Chamar dialogo para autorizar o download pelos dados moveis
                        Dialogo(nomeArquivo, url, file);

                    }else if (texteConexao == "false"){
                        Toast.makeText(getBaseContext(), "Dispositivo sem conexão!\n" +
                                "Por favor ative o wi-fi ou os dados moveis para realizar o Download " +
                                "do Manual!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        acs350.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nomeArquivo = "abb_acs350.pdf";
                String url = "https://"+"drive.google.com/u/0/uc?id=1U_l3pj8irfQPHhDvutByn23iBAEnWe9Y&export=download";
                File file = new File(getExternalFilesDir(null), nomeArquivo);

                //Instancia da classe para testar se o arquivo já foi baixado
                Download download = new Download();
                String texteConexao = download.TesteConexao(getBaseContext());
                if (file.exists()){
                    Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                    intent.putExtra("indexManual", nomeArquivo);
                    startActivity(intent);
                }else if (!file.exists()){
                    if (texteConexao == "wifi"){
                        Download(nomeArquivo, url, file);
                    }else if (texteConexao == "dados moveis"){
                        //Chamar dialogo para autorizar o download pelos dados moveis
                        Dialogo(nomeArquivo, url, file);

                    }else if (texteConexao == "false"){
                        Toast.makeText(getBaseContext(), "Dispositivo sem conexão!\n" +
                                "Por favor ative o wi-fi ou os dados moveis para realizar o Download " +
                                "do Manual!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        acs550.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nomeArquivo = "abb_acs550.pdf";
                String url = "https://"+"drive.google.com/u/0/uc?id=10NdJ3eyq0VjWoP0Ab36fZMAne_-98GRx&export=download";
                File file = new File(getExternalFilesDir(null), nomeArquivo);

                //Instancia da classe para testar se o arquivo já foi baixado
                Download download = new Download();
                String texteConexao = download.TesteConexao(getBaseContext());
                if (file.exists()){
                    Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                    intent.putExtra("indexManual", nomeArquivo);
                    startActivity(intent);
                }else if (!file.exists()){
                    if (texteConexao == "wifi"){
                        Download(nomeArquivo, url, file);
                    }else if (texteConexao == "dados moveis"){
                        //Chamar dialogo para autorizar o download pelos dados moveis
                        Dialogo(nomeArquivo, url, file);

                    }else if (texteConexao == "false"){
                        Toast.makeText(getBaseContext(), "Dispositivo sem conexão!\n" +
                                "Por favor ative o wi-fi ou os dados moveis para realizar o Download " +
                                "do Manual!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        acs800.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nomeArquivo = "abb_acs800.pdf";
                String url = "https://"+"drive.google.com/u/0/uc?id=1MeSFfIqStFD23fCPPsAfop4JyBObEixQ&export=download";
                File file = new File(getExternalFilesDir(null), nomeArquivo);

                //Instancia da classe para testar se o arquivo já foi baixado
                Download download = new Download();
                String texteConexao = download.TesteConexao(getBaseContext());
                if (file.exists()){
                    Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                    intent.putExtra("indexManual", nomeArquivo);
                    startActivity(intent);
                }else if (!file.exists()){
                    if (texteConexao == "wifi"){
                        Download(nomeArquivo, url, file);
                    }else if (texteConexao == "dados moveis"){
                        //Chamar dialogo para autorizar o download pelos dados moveis
                        Dialogo(nomeArquivo, url, file);

                    }else if (texteConexao == "false"){
                        Toast.makeText(getBaseContext(), "Dispositivo sem conexão!\n" +
                                "Por favor ative o wi-fi ou os dados moveis para realizar o Download " +
                                "do Manual!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private void Download(String nomeArquivo, String url, File file){
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url))
                .setTitle(nomeArquivo)
                .setDescription("Download do Manual "+nomeArquivo)
                .setDestinationUri(Uri.fromFile(file))
                .setMimeType("application/pdf");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        DownloadManager downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
        downloadId = downloadManager.enqueue(request);
        DialogoEspereDownload();

        //codigo teste de dilog progress
        /*DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(downloadId);
        DownloadManager d =(DownloadManager)getSystemService(DOWNLOAD_SERVICE);
        Cursor cursor = d.query(query);
        //progress dialogo
        ProgressDialog prog = new ProgressDialog(this);
        prog.setTitle("titulo");
        prog.setMessage("mensagem");
        prog.setMax(100);
        prog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        prog.show();
        if (cursor.moveToFirst()){
            int colunIndex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
            int statusInt = cursor.getInt(colunIndex);
            int indexSofar = cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR);
            int soFar = cursor.getInt(indexSofar);
            int indexTotal = cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES);
            int total = cursor.getInt(indexTotal);
            prog.setProgress(soFar);
        }*/

        //https://www.youtube.com/watch?v=hJZq6InFlW4

    }

    private void Dialogo(String nomeArquivo, String url, File file){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialogo_dados_moveis);
        builder.setTitle("O wi-fi está desconectado!");
        builder.setPositiveButton("Download", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Download(nomeArquivo, url, file);
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "download cancelado", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog =    builder.create();
        dialog.show();
    }

    private void DialogoEspereDownload(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Por favor espere o Download terminar!\nVocê pode " +
                "acompanhar o progresso do download pela barra de notificações!");
        builder.setTitle("Download em Andamento");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();
        dialog.show();
    }

    private BroadcastReceiver onDownloadComplet = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);

            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(downloadId);
            DownloadManager d =(DownloadManager)getSystemService(DOWNLOAD_SERVICE);
            Cursor cursor = d.query(query);
            int indexStatus = 0, status = 0;
            if (cursor.moveToFirst()){
                indexStatus = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
                status = cursor.getInt(indexStatus);
            }

            if (downloadId==id){
                //Toast.makeText(getBaseContext(), "Download completo", Toast.LENGTH_LONG).show();

                if (DownloadManager.STATUS_SUCCESSFUL == status) {
                    Toast.makeText(getBaseContext(), "Download completo", Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                    switch (nomeArquivo){
                        case "abb_acs150.pdf":
                            acs150.setImageResource(R.drawable.acs150);
                            break;
                        case "abb_acs350.pdf":
                            acs350.setImageResource(R.drawable.acs355);
                            break;
                        case "abb_acs550.pdf":
                            acs550.setImageResource(R.drawable.acs550);
                            break;
                        case "abb_acs800.pdf":
                            acs800.setImageResource(R.drawable.acs800);
                            break;
                    }
                }
                if (DownloadManager.STATUS_FAILED == status) {
                    Toast.makeText(getBaseContext(), "download cancelado", Toast.LENGTH_LONG).show();
                }
                }

            }
    };

    /*@Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(onDownloadComplet);
    }*/
}