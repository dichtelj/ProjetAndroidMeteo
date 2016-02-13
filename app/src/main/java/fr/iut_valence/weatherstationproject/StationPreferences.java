package fr.iut_valence.weatherstationproject;


import android.app.Activity;
import android.content.SharedPreferences;

public class StationPreferences {

    SharedPreferences prefs;

    public StationPreferences(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    public String getStation(){
        return prefs.getString("station", "Montélimar");
    }

    public void setStation(String station){
        prefs.edit().putString("station", station).commit();
    }

}
