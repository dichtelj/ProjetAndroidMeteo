package fr.iut_valence.weatherstationproject;


public class Station {
    private String nomStation;
    private String libelleStation;
    private String latitude;
    private String longitude;
    private String altitude;
    private boolean favoriteStation;

    public Station(String nom, String libelle, String latitude, String longitude, String altitude) {
        this.nomStation = nom;
        this.libelleStation = libelle;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.favoriteStation = false;
    }

    public boolean isFavoriteStation() {
        return favoriteStation;
    }

    public String getNomStation() {
        return nomStation;
    }

    public void setNomStation(String nomStation) {
        this.nomStation = nomStation;
    }

    public String getLibelleStation() {
        return libelleStation;
    }

    public void setLibelleStation(String libelleStation) {
        this.libelleStation = libelleStation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }
}
