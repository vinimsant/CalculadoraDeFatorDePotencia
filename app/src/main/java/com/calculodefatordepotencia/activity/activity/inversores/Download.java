package com.calculodefatordepotencia.activity.activity.inversores;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

import java.io.File;

public class Download {



    /*public String TesteConexao(Context cont){

        ConnectivityManager connectivityManager = (ConnectivityManager)cont.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null){
            //Verifica se a conexao e wifi
            if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected()){
                //Toast.makeText(cont, "wifi", Toast.LENGTH_LONG).show();
                return "wifi";
            }
            //verifica se conexao e dados moveis
            if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected()){
                //Toast.makeText(cont, "dados moveis", Toast.LENGTH_LONG).show();
                return "dados moveis";
            }
        }
        //Caso não tenha internet retorna falso
        return "false";

    }*/
    public String TesteConexao(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            Network network = connectivityManager.getActiveNetwork();
            if (network == null) return "false"; // Sem conexão ativa

            NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(network);
            if (capabilities == null) return "false";

            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                return "wifi";
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                return "dados moveis";
            } else {
                return "outro";
            }
        }

        return "false";
    }

}
