package com.calculodefatordepotencia.activity.activity.inversores;

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

import java.io.File;

public class InversoresSchneider extends AppCompatActivity {

    private ImageView atv11;
    private ImageView atv12;
    private ImageView atv212;
    private ImageView atv28;
    private ImageView atv31;
    private ImageView atv32;
    private ImageView atv61;
    private ImageView atv71;
    private ImageView atv312;
    private ImageView atv320;
    private ImageView atv600;
    private ImageView atv630;

    //BrodCast do dwnload
    private long downloadId;
    // dialogo de download em andamento
    AlertDialog dialog;
    //teste para o icone do botao do manual se foi baixado
    String nomeArquivo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inversores_schneider);

        //colocar o titulo da activity na barra de ferramentas do app(app bar)
        setTitle("Inversores Schneider/Telemecanique");

        atv11 = findViewById(R.id.mImgInvAtv11);
        atv12 = findViewById(R.id.mImgInvAtv12);
        atv28 = findViewById(R.id.mImgInvAtv28);
        atv31 = findViewById(R.id.mImgInvAtv31);
        atv32 = findViewById(R.id.mImgInvAtv32);
        atv61 = findViewById(R.id.mImgInvAtv61);
        atv71 = findViewById(R.id.mImgInvAtv71);
        atv212 = findViewById(R.id.mImgInvAtv212);
        atv312 = findViewById(R.id.mImgInvAtv312);
        atv320 = findViewById(R.id.mImgInvAtv320);
        atv600 = findViewById(R.id.mImgInvAtv600);
        atv630 = findViewById(R.id.mImgInvAtv630);

        //registrando broad cast
        //registerReceiver(onDownloadComplet, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

        File fileAtv11 = new File(getExternalFilesDir(null), "ATV11.pdf");
        File fileAtv12 = new File(getExternalFilesDir(null), "atv12.pdf");
        File fileAtv28 = new File(getExternalFilesDir(null), "atv28.pdf");
        File fileAtv31 = new File(getExternalFilesDir(null), "atv31.pdf");
        File fileAtv32 = new File(getExternalFilesDir(null), "atv32.pdf");
        File fileAtv61 = new File(getExternalFilesDir(null), "ATV61.pdf");
        File fileAtv71 = new File(getExternalFilesDir(null), "atv71.pdf");
        File fileAtv212 = new File(getExternalFilesDir(null), "ATV212.pdf");
        File fileAtv312 = new File(getExternalFilesDir(null), "atv312.pdf");
        File fileAtv320 = new File(getExternalFilesDir(null), "atv320.pdf");
        File fileAtv600 = new File(getExternalFilesDir(null), "atv600_manual_de_programação.pdf");
        File fileAtv630 = new File(getExternalFilesDir(null), "atv630_manual_de_instalação.pdf");

        if (fileAtv11.exists()){
            atv11.setImageResource(R.drawable.atv11);
        }
        if (fileAtv12.exists()){
            atv12.setImageResource(R.drawable.atv12);
        }
        if (fileAtv28.exists()){
            atv28.setImageResource(R.drawable.atv28);
        }
        if (fileAtv31.exists()){
            atv31.setImageResource(R.drawable.atv31);
        }
        if (fileAtv32.exists()){
            atv32.setImageResource(R.drawable.atv32);
        }
        if (fileAtv61.exists()){
            atv61.setImageResource(R.drawable.atv61);
        }
        if (fileAtv71.exists()){
            atv71.setImageResource(R.drawable.atv71);
        }
        if (fileAtv212.exists()){
            atv212.setImageResource(R.drawable.atv212);
        }
        if (fileAtv312.exists()){
            atv312.setImageResource(R.drawable.atv312);
        }
        if (fileAtv320.exists()){
            atv320.setImageResource(R.drawable.atv320);
        }
        if (fileAtv600.exists()){
            atv600.setImageResource(R.drawable.atv600);
        }
        if (fileAtv630.exists()){
            atv630.setImageResource(R.drawable.atv630);
        }


        atv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "ATV11.pdf";
                String url = "https://"+
                "drive.google.com/u/0/uc?id=1Z3QyVOXgtn5KC2N7ipinwZw0_aTu0qUu&export=download";
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

        atv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "atv12.pdf";
                String url = "https://"+
                "drive.google.com/u/0/uc?id=1Jw9PLZqb8aeez9geTgm0d7HXdX1UdpCb&export=download";
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

        atv28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "atv28.pdf";
                String url = "https://"+
                "drive.google.com/u/0/uc?id=1qy0PLzKtyLrrftSekwirTzfmIOwSAgCm&export=download";
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

        atv31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "atv31.pdf";
                String url = "https://"+
                "drive.google.com/u/0/uc?id=1aU9Slk7BjcCJALgDxzuDDt2xaqvYXtEy&export=download";
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

        atv32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "atv32.pdf";
                String url = "https://"+
                "drive.google.com/u/0/uc?id=1RTi8RmwlWSWMfXede5jtKbslrVZ3WOTk&export=download";
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

        atv61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "ATV61.pdf";
                String url = "https://"+
                "drive.google.com/u/0/uc?id=1oG_A8sgwNMrUBcnyKMqGGDKPDwCWCXzC&export=download\n";
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

        atv71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "atv71.pdf";
                String url = "https://"+
                "drive.google.com/u/0/uc?id=1SErQMxgqjy-Ybh88yNEfZuPc00xgkoHa&export=download";
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

        atv212.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "ATV212.pdf";
                String url = "https://"+
                "drive.google.com/u/0/uc?id=1q7ArmaVEuNzG5YOobr4XPCaSBxTUYXap&export=download";
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

        atv312.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "atv312.pdf";
                String url = "https://"+
                "drive.google.com/u/0/uc?id=1m47-6u7mrEtTIh_7G8nhEeOM767M6muf&export=download";
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

        atv320.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "atv320.pdf";
                String url = "https://"+
                "drive.google.com/u/0/uc?id=1Ymzp4GT7ebkv3y6Xs9VNkmrbg-6RcgDh&export=download";
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

        atv600.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "atv600_manual_de_programação.pdf";
                String url = "https://"+
                "drive.google.com/u/0/uc?id=17Fq_mUSXUi14C0xJmRibkvgaLrfEgYiL&export=download";
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

        atv630.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeArquivo = "atv630_manual_de_instalação.pdf";
                String url = "https://"+
                "drive.google.com/u/0/uc?id=1NA0YK-VR4dJqMIvjMjdvSSKAG2ESgSC1&export=download";
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
                        case "ATV11.pdf":
                            atv11.setImageResource(R.drawable.atv11);
                            break;
                        case "atv12.pdf":
                            atv12.setImageResource(R.drawable.atv12);
                            break;
                        case "atv28.pdf":
                            atv28.setImageResource(R.drawable.atv28);
                            break;
                        case "atv31.pdf":
                            atv31.setImageResource(R.drawable.atv31);
                            break;
                        case "atv32.pdf":
                            atv32.setImageResource(R.drawable.atv32);
                            break;
                        case "ATV61.pdf":
                            atv61.setImageResource(R.drawable.atv61);
                            break;
                        case "atv71.pdf":
                            atv71.setImageResource(R.drawable.atv71);
                            break;
                        case "ATV212.pdf":
                            atv212.setImageResource(R.drawable.atv212);
                            break;
                        case "atv312.pdf":
                            atv312.setImageResource(R.drawable.atv312);
                            break;
                        case "atv320.pdf":
                            atv320.setImageResource(R.drawable.atv320);
                            break;
                        case "atv600_manual_de_programação.pdf":
                            atv600.setImageResource(R.drawable.atv600);
                            break;
                        case "atv630_manual_de_instalação.pdf":
                            atv630.setImageResource(R.drawable.atv630);
                            break;
                    }
                }
                if (DownloadManager.STATUS_FAILED == status) {
                    Toast.makeText(getBaseContext(), "download cancelado", Toast.LENGTH_LONG).show();
                }
            }

        }
    };


}