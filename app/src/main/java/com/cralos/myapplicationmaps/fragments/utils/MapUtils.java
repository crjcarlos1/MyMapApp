package com.cralos.myapplicationmaps.fragments.utils;

import com.cralos.myapplicationmaps.fragments.models.Vehicle;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class MapUtils {

    public static List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        return vehicles;
    }

    public static List<LatLng> getPositions() {
        List<LatLng> positions = new ArrayList<>();
        positions.add(new LatLng(19.503308, -99.183287));
        positions.add(new LatLng(19.503829, -99.183159));
        positions.add(new LatLng(19.503669, -99.183287));
        positions.add(new LatLng(19.503441, -99.181917));
        positions.add(new LatLng(19.503019, -99.180590));
        positions.add(new LatLng(19.502488, -99.179067));
        positions.add(new LatLng(19.501670, -99.177220));
        positions.add(new LatLng(19.500539, -99.175257));
        positions.add(new LatLng(19.499698, -99.174924));
        positions.add(new LatLng(19.498651, -99.174546));
        positions.add(new LatLng(19.498482, -99.175053));
        return positions;
    }

}
