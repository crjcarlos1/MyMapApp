package com.cralos.myapplicationmaps.fragments.models;

import com.google.android.gms.maps.model.Marker;

public class VehicleMarker {

    private int idVehicle;
    private Marker marker;

    public VehicleMarker(int idVehicle, Marker marker) {
        this.idVehicle = idVehicle;
        this.marker = marker;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

}
