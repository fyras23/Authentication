package com.mobile.authentication;

public class Commandeclass {
    private String nom;
    private String prenom;
    private String city;
    private String telephone;
    private double longitude;
    private double latitude;

    public String getNameSK() {
        return nameSK;
    }

    public void setNameSK(String nameSK) {
        this.nameSK = nameSK;
    }

    private String nameSK;

    private int price;

    public int getPrice() {
        return price;
    }

    private String UserId;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Commandeclass() {
    }

    public Commandeclass(String nom, String prenom, String city, String telephone, double longitude, double latitude, String nameSK, int price, String userId) {
        this.nom = nom;
        this.prenom = prenom;
        this.city = city;
        this.telephone = telephone;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nameSK = nameSK;
        this.price = price;
        UserId = userId;
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
