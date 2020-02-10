package com.cralos.myapplicationmaps.activities;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cralos.myapplicationmaps.R;
import com.cralos.myapplicationmaps.fragments.FragmentMap;
import com.google.android.gms.maps.GoogleMap;

public class Activity extends FragmentActivity {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);
        showFragmentMap();
    }

    private void showFragmentMap() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.addToBackStack(FragmentMap.TAG);
        transaction.replace(R.id.containerFragment, new FragmentMap(), FragmentMap.TAG).commit();
    }

}
