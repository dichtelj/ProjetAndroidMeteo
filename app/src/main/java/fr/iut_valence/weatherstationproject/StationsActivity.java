package fr.iut_valence.weatherstationproject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class StationsActivity extends ListActivity{
    private ProgressDialog pDialog;

    private static final String NOM_STATION = "nom";
    private static final String LIBELLE_STATION = "libelle";
    private final String urlStation = "/stations";
    JSONArray stations = null;

    ArrayList<HashMap<String, String>> stationList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations);

        stationList = new ArrayList<HashMap<String, String>>();

        ListView lv = getListView();
        new GetStations().execute();
    }
    private class GetStations extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(StationsActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            RestClient client = new RestClient();

            String jsonStr = client.query(urlStation);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONArray stations = new JSONArray(jsonStr);

                    for (int i = 0; i < stations.length(); i++) {
                        JSONObject c = stations.getJSONObject(i);

                        String nom = c.getString(NOM_STATION);
                        String libelle = c.getString(LIBELLE_STATION);

                        HashMap<String, String> station = new HashMap<String, String>();

                        station.put(NOM_STATION, nom);
                        station.put(LIBELLE_STATION, libelle);
                        stationList.add(station);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();
            ListAdapter adapter = new SimpleAdapter(
                    StationsActivity.this, stationList,
                    R.layout.stations_item_layout, new String[] { NOM_STATION, LIBELLE_STATION }, new int[] { R.id.nom,
                    R.id.libelle });

            setListAdapter(adapter);
        }

    }

}
