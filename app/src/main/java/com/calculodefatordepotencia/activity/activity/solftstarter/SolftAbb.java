package com.calculodefatordepotencia.activity.activity.solftstarter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.calculodefatordepotencia.R;
import com.calculodefatordepotencia.activity.activity.ManuaisPdf;
import com.calculodefatordepotencia.activity.activity.inversores.Download;

import java.io.File;

public class SolftAbb extends AppCompatActivity {

    ImageView psr;
    ImageView pse;
    ImageView pst;

    //BrodCast do dwnload
    private long downloadId;
    // dialogo de download em andamento
    AlertDialog dialog;
    //teste para o icone do botao do manual se foi baixado
    String nomeArquivo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solft_abb);

        setTitle("SolftStarter ABB");

        psr = findViewById(R.id.ImgPsr);
        pse = findViewById(R.id.ImgPse);
        pst = findViewById(R.id.ImgPst);

        //registrando broad cast
        registerReceiver(onDownloadComplet, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

        File filePsr = new File(getExternalFilesDir(null), "abb psr.pdf");
        File filePse = new File(getExternalFilesDir(null), "abb pse.pdf");
        File filePst = new File(getExternalFilesDir(null), "abb pst.pdf");
        if (filePsr.exists()){
            psr.setImageResource(R.drawable.abb_psr);
        }
        if (filePse.exists()){
            pse.setImageResource(R.drawable.abb_pse);
        }
        if (filePst.exists()){
            pst.setImageResource(R.drawable.abb_pst);
        }


        psr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "abb psr.pdf";
                String url = "https://"+
                        "drive.google.com/u/0/uc?id=1z0AS3TMRUEf4C2AM_ai1R1iFTeA4DADy&export=download";
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

        pse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "abb pse.pdf";
                String url = "https://"+
                        "drive.google.com/u/0/uc?id=1-JOnKy7ZBbTXDT5tF6_1bFQJ7THM-NNW&export=download";
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

        pst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "abb pst.pdf";
                String url = "https://"+
                        "drive.google.com/u/0/uc?id=1oNeDW8JQOtcpLtn5Jaw6NcvyxYHWse-b&export=download";
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
                        case "abb psr.pdf":
                            psr.setImageResource(R.drawable.abb_psr);
                            break;
                        case "abb pse.pdf":
                            pse.setImageResource(R.drawable.abb_pse);
                            break;
                        case "abb pst.pdf":
                            pst.setImageResource(R.drawable.abb_pst);
                            break;
                    }
                }
                if (DownloadManager.STATUS_FAILED == status) {
                    Toast.makeText(getBaseContext(), "download cancelado", Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                }
            }

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(onDownloadComplet);
    }
}