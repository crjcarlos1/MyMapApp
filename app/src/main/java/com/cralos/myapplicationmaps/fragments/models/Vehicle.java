package com.cralos.myapplicationmaps.fragments.models;

public class Vehicle {
    private String name;
    private int idVehicle;
    private double latitude;
    private double longitude;

    public Vehicle(String name, int idVehicle, double latitude, double longitude) {
        this.name = name;
        this.idVehicle = idVehicle;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
