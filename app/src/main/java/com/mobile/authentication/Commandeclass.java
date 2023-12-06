package com.mobile.authentication;

public class Commandeclass {
    private String nom;
    private String prenom;
    private String city;
    private String telephone;
    private double longitude;
    private double latitude;

    public Commandeclass() {
    }

    public Commandeclass(String nom, String prenom, String adresse, String telephone, double longitude, double latitude) {
        this.nom = nom;
        this.prenom = prenom;
        this.city = adresse;
        this.telephone = telephone;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
