package com.calculodefatordepotencia.activity.activity.inversores;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inverores_a_b_b);

        setTitle("Inversores ABB");

        File file = new File(getExternalFilesDir(null), "abb pse.pdf");
        acs150 = findViewById(R.id.imginvacs150);
        if (file.exists()){
            acs150.setImageResource(R.drawable.acs150);
        }
        acs350 = findViewById(R.id.imginvacs350);
        acs550 = findViewById(R.id.imginvacs550);
        acs800 = findViewById(R.id.imginvacs800);

        acs150.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "acs150");
                startActivity(intent);*/
                String nomeArquivo = "abb pse.pdf";
                String url = "https://drive.google.com/u/0/uc?id=1-JOnKy7ZBbTXDT5tF6_1bFQJ7THM-NNW&export=download";
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

                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "acs355");
                startActivity(intent);
            }
        });

        acs550.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "acs550");
                startActivity(intent);
            }
        });

        acs800.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ManuaisPdf.class);
                intent.putExtra("indexManual", "acs800");
                startActivity(intent);
            }
        });
    }

    private BroadcastReceiver onDownloadComplet = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            if (downloadId==id){
                acs150.setImageResource(R.drawable.acs150);
                Toast.makeText(getBaseContext(), "Download completo", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(onDownloadComplet);
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
        DownloadManager.Query status = new DownloadManager.Query();
        status.setFilterById(downloadId);
        Cursor cursor = downloadManager.query(status);
        cursor.moveToFirst();
        boolean isDownloading = true;
        int totalBytesDownloaded, totalBytes, downloadStatus;
        ProgressDialog prog = new ProgressDialog(this);
        prog.setTitle("titulo");
        prog.setMessage("mensagem");
        prog.setMax(100);
        prog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        prog.show();
        int i = 0;

        //https://www.youtube.com/watch?v=hJZq6InFlW4

        while (isDownloading) {
            prog.setProgress(i);
            i++;
            totalBytes = Integer.parseInt(String.valueOf(
                    cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES)));
            totalBytesDownloaded = Integer.parseInt(String.valueOf(
                    cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR)));
            downloadStatus = Integer.parseInt(String.valueOf(
                    cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)));
            //prog.setProgress(totalBytesDownloaded*100/totalBytes);


            if (downloadStatus == DownloadManager.STATUS_SUCCESSFUL) {
                isDownloading = false;
            }
        }

    }

    private void Dialogo(String nomeArquivo, String url, File file){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("O download pelos dados moveis pode gerá custos!\n" +
                "Deseja fazer o Download mesmo assim?");
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
}