package fr.iut_valence.weatherstationproject;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class StationFragment extends Fragment {
    Typeface stationFont;

    TextView nom;
    TextView libelle;
    TextView longitude;
    TextView latitude;
    TextView altitude;

    Handler handler;

    public StationFragment(){
        handler = new Handler();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_layout, container, false);
        nom = (TextView)rootView.findViewById(R.id.nom);
        libelle = (TextView)rootView.findViewById(R.id.libelle);
        longitude = (TextView)rootView.findViewById(R.id.longitude);
        latitude = (TextView)rootView.findViewById(R.id.latitude);
        altitude = (TextView)rootView.findViewById(R.id.altitude);

        return rootView;
    }

}

