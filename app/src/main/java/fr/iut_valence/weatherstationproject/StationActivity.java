package fr.iut_valence.weatherstationproject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class StationActivity extends Activity {

    public static final String WEATHER_PREF = "Weather";
    private String  stationURL = "stations";


    private final String TAG_LATITUDE = "latitude";
    private final String TAG_LONGITUDE = "longitude";
    private final String TAG_ALTITUDE = "altitude";
    private final String TAG_LIBELLE = "libelle";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Restore preferences
        SharedPreferences settings = getSharedPreferences(WEATHER_PREF, 0);
        String idStation = settings.getString("station", WEATHER_PREF);

        RestClient client = new RestClient();
        String jsonStr = client.query(stationURL + "/" + idStation);

        if (jsonStr != null) {
            try {
                JSONObject stationJson = new JSONObject(jsonStr);
                Station station = new Station(idStation,
                        stationJson.getString(TAG_LIBELLE), stationJson.getString(TAG_LATITUDE), stationJson.getString(TAG_LONGITUDE), stationJson.getString(TAG_ALTITUDE));

                View convertView = LayoutInflater.from(this.getBaseContext()).inflate(R.layout.activity_station,null, false);
                TextView nomTextView = (TextView) this.findViewById(R.id.nom);
                nomTextView.setText(station.getNomStation());
                TextView libelleTextView = (TextView) this.findViewById(R.id.libelle);
                libelleTextView.setText(station.getLibelleStation());
                TextView latitudeTextView = (TextView) this.findViewById(R.id.latitude);
                latitudeTextView.setText(station.getLatitude());
                TextView longitudeTextView = (TextView) this.findViewById(R.id.longitude);
                longitudeTextView.setText(station.getLongitude());
                TextView altitudeTextView = (TextView) this.findViewById(R.id.altitude);
                altitudeTextView.setText(station.getAltitude());






            } catch (Exception e) {}
        }
    }


}
