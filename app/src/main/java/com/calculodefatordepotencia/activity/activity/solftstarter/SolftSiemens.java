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

public class SolftSiemens extends AppCompatActivity {

    ImageView img3rw30;
    ImageView img3rw44;
    ImageView img3rw50;
    ImageView img3rw52;
    ImageView img3rw55;

    //BrodCast do dwnload
    private long downloadId;
    // dialogo de download em andamento
    AlertDialog dialog;
    //teste para o icone do botao do manual se foi baixado
    String nomeArquivo = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solft_siemens);

        setTitle("Solftstarter Siemens");

        img3rw30 = findViewById(R.id.Img3rw30);
        img3rw44 = findViewById(R.id.Img3rw44);
        img3rw50 = findViewById(R.id.img3rw50);
        img3rw52 = findViewById(R.id.img3rw52);
        img3rw55 = findViewById(R.id.img3rw55);

        //registrando broad cast
        registerReceiver(onDownloadComplet, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

        File file3r30 = new File(getExternalFilesDir(null), "siemens_3RW30_3RW40_pt-BR.pdf");
        File file3r44 = new File(getExternalFilesDir(null), "siemens_3rw44_pt-BR.pdf");
        File file3r50 = new File(getExternalFilesDir(null), "siemens_3RW50_pt-BR.pdf");
        File file3r52 = new File(getExternalFilesDir(null), "siemens_3RW52_pt-BR.pdf");
        File file3r55 = new File(getExternalFilesDir(null), "siemens_3RW55_pt-BR.pdf");

        if (file3r30.exists()){
            img3rw30.setImageResource(R.drawable.siemens3rw30_3rw40);
        }
        if (file3r44.exists()){
            img3rw44.setImageResource(R.drawable.siemens3rw44);
        }
        if (file3r50.exists()){
            img3rw50.setImageResource(R.drawable.siemens3rw50);
        }
        if (file3r52.exists()){
            img3rw52.setImageResource(R.drawable.siemens3rw52);
        }
        if (file3r55.exists()){
            img3rw55.setImageResource(R.drawable.siemens3rw55);
        }


        img3rw30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "siemens_3RW30_3RW40_pt-BR.pdf";
                String url = "https://"+
                        "drive.google.com/u/0/uc?id=1LmGSIavVGIrwnrb-Wv-uE-TJ2LjCvaDU&export=download";
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

        img3rw44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "siemens_3rw44_pt-BR.pdf";
                String url = "https://"+
                        "drive.google.com/u/0/uc?id=1pcYn8mxa-EyuwuSe0zcrg7woL40N5PNs&export=download";
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

        img3rw50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "siemens_3RW50_pt-BR.pdf";
                String url = "https://"+
                        "drive.google.com/u/0/uc?id=1ML6p2hudPV46CZz4L0obXHBOH52LFbD5&export=download";
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

        img3rw52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "siemens_3RW52_pt-BR.pdf";
                String url = "https://"+
                        "drive.google.com/u/0/uc?id=1H43wgnwRaSk9i3-oVdHVZztPBYth0Lb2&export=download";
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

        img3rw55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "siemens_3RW55_pt-BR.pdf";
                String url = "https://"+
                        "drive.google.com/u/0/uc?id=1PDLvnRks6LkFxBD3jRRXxFcxYNrVEPIR&export=download";
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
                        case "siemens_3RW30_3RW40_pt-BR.pdf":
                            img3rw30.setImageResource(R.drawable.siemens3rw30_3rw40);
                            break;
                        case "siemens_3rw44_pt-BR.pdf":
                            img3rw44.setImageResource(R.drawable.siemens3rw44);
                            break;
                        case "siemens_3RW50_pt-BR.pdf":
                            img3rw50.setImageResource(R.drawable.siemens3rw50);
                            break;
                        case "siemens_3RW52_pt-BR.pdf":
                            img3rw52.setImageResource(R.drawable.siemens3rw52);
                            break;
                        case "siemens_3RW55_pt-BR.pdf":
                            img3rw55.setImageResource(R.drawable.siemens3rw55);
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