package com.cralos.myapplicationmaps.fragments;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cralos.myapplicationmaps.R;
import com.cralos.myapplicationmaps.fragments.models.VehicleMarker;
import com.cralos.myapplicationmaps.fragments.utils.MapUtils;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

public class FragmentMap extends Fragment implements OnMapReadyCallback {

    public static final String TAG = FragmentMap.class.getSimpleName();

    private GoogleMap mMap;
    private MapView mapView;
    private Marker startMaker;
    private Polyline polyline;
    private List<VehicleMarker> markers;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = view.findViewById(R.id.map);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getActivity());
        mapView.setVisibility(View.VISIBLE);
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);

        addMarker();
        addPolyline();
    }

    private void addMarker() {
        Toast.makeText(getContext(), "Agregando marker espere...", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int height = 40;
                int width = 40;
                double latitude = 19.503346;
                double longitude = -99.183409;
                LatLng notificationPosition = new LatLng(latitude, longitude);
                BitmapDrawable bitmapdraw = (BitmapDrawable) getResources().getDrawable(R.drawable.dot_marker);
                Bitmap b = bitmapdraw.getBitmap();
                Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);
                startMaker = mMap.addMarker(new MarkerOptions().position(notificationPosition).title("").icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
                zoomToVehicle(latitude, longitude, 18);
                Toast.makeText(getContext(), "Agregando pilyline espera...", Toast.LENGTH_SHORT).show();
            }
        }, 2000);
    }

    private void addPolyline() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                PolylineOptions options = new PolylineOptions().width(3).color(Color.BLACK).geodesic(true);
                List<LatLng> positions = MapUtils.getPositions();

                for (int z = 0; z < positions.size(); z++) {
                    LatLng point = new LatLng(positions.get(z).latitude, positions.get(z).longitude);
                    builder.include(point);
                    options.add(point);
                }

                LatLngBounds bounds = builder.build();          /**create the bounds from latlngBuilder to set into map camera*/
                int padding = 50;                               /**initialize the padding for map boundary*/
                final CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);       /**create the camera with bounds and padding to set into map*/
                mMap.animateCamera(cu);
                polyline = mMap.addPolyline(options);
            }
        }, 4000);
    }

    private void zoomToVehicle(double latitude, double longitude, float zoom) {
        LatLng notificationPosition = new LatLng(latitude, longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(notificationPosition, zoom));
    }

}
