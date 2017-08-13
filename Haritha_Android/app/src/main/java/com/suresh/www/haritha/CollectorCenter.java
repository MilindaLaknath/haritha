package com.suresh.www.haritha;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class CollectorCenter extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collector_center);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng g1 = new LatLng(6.902106, 79.861676);
        mMap.addMarker(new MarkerOptions().position(g1).title("Smart Dustbin #100"));
        LatLng g2 = new LatLng(6.903283, 79.862290);
        mMap.addMarker(new MarkerOptions().position(g2).title("Smart Dustbin #001"));
        LatLng g3 = new LatLng(6.901346, 79.859351);
        mMap.addMarker(new MarkerOptions().position(g3).title("Smart Dustbin #002"));
        LatLng g4 = new LatLng(6.901854, 79.861983);
        mMap.addMarker(new MarkerOptions().position(g4).title("Smart Dustbin #003"));
        LatLng g5 = new LatLng(6.903953, 79.858430);
        mMap.addMarker(new MarkerOptions().position(g5).title("Smart Dustbin #004"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(g1));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 16.0f ) );

    }
}
