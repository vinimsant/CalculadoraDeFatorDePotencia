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

public class SolftDanfos extends AppCompatActivity {

    ImageView mcd100;
    ImageView mcd201;
    ImageView mcd500;
    ImageView mcd600;

    //BrodCast do dwnload
    private long downloadId;
    // dialogo de download em andamento
    AlertDialog dialog;
    //teste para o icone do botao do manual se foi baixado
    String nomeArquivo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solft_danfos);

        setTitle("SolftStarter Danfoss");

        mcd100 = findViewById(R.id.ImgMcd100);
        mcd201 = findViewById(R.id.ImgMcd201);
        mcd500 = findViewById(R.id.ImgMcd500);
        mcd600 = findViewById(R.id.ImgMcd600);

        //registrando broad cast
        registerReceiver(onDownloadComplet, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

        File fileMdc100 = new File(getExternalFilesDir(null), "mcd100.pdf");
        File fileMdc500 = new File(getExternalFilesDir(null), "mcd500.pdf");
        File fileMdc600 = new File(getExternalFilesDir(null), "mcd600.pdf");
        if (fileMdc100.exists()){
            mcd100.setImageResource(R.drawable.mcd100);
        }
        if (fileMdc500.exists()){
            mcd500.setImageResource(R.drawable.mcd500);
        }
        if (fileMdc600.exists()){
            mcd600.setImageResource(R.drawable.mcd600);
        }


        mcd100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "mcd100.pdf";
                String url = "https://"+
                "drive.google.com/u/0/uc?id=1lNhXrM9s3A7kA1M6JiF5lJibe3VJfH23&export=download";
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

        mcd201.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),DanfosMcd201.class));
            }
        });

        mcd500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "mcd500.pdf";
                String url = "https://"+
                "drive.google.com/u/0/uc?id=1IhO8qZ7et9qZvJfUo5cy6xluD-WIWmG1&export=download";
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

        mcd600.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "mcd600.pdf";
                String url = "https://"+
                        "drive.google.com/u/0/uc?id=1XtWV05RSKFJEXWiqaGbhh2KKZis5wYwC&export=download";
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
                        case "mcd100.pdf":
                            mcd100.setImageResource(R.drawable.mcd100);
                            break;
                        case "mcd500.pdf":
                            mcd500.setImageResource(R.drawable.mcd500);
                            break;
                        case "mcd600.pdf":
                            mcd600.setImageResource(R.drawable.mcd600);
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