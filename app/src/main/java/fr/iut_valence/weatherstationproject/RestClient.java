package fr.iut_valence.weatherstationproject;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import android.content.Context;

public class RestClient {

    private static final String API_URL =
            "http://intranet.iut-valence.fr/~durotm/a_publier/tps/meteo/api";

    public static String query(String station){
        try {
            URL url = new URL(String.format(API_URL, station));
            HttpURLConnection connection =
                    (HttpURLConnection)url.openConnection();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp="";
            while((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();

            return json.toString();
        }catch(Exception e){
            return null;
        }
    }
}