package com.example.marcadoresappjava;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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

        LatLng marcador1 = new LatLng(-13.5242178, -71.9754913);
        mMap.addMarker(new MarkerOptions()
                .position(marcador1)
                .title("Machu Picchu - Perú")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        LatLng marcador2 = new LatLng(-12.0262676, -77.1278653);
        mMap.addMarker(new MarkerOptions()
                .position(marcador2)
                .title("Lima - Perú")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        LatLng marcador3 = new LatLng(40.6892534, -74.0466891);
        mMap.addMarker(new MarkerOptions()
                .position(marcador3)
                .title("Estatua de la Libertad - EEUU")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));

        LatLng marcador4 = new LatLng(48.8583701, 2.2922926);
        mMap.addMarker(new MarkerOptions()
                .position(marcador4)
                .title("Torre Eiffel - Francia")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marcador)));


        // Centrar Marcadores
        LatLngBounds.Builder constructor = new LatLngBounds.Builder();

        constructor.include(marcador1);
        constructor.include(marcador2);
        constructor.include(marcador3);
        constructor.include(marcador4);

        LatLngBounds limites = constructor.build();

        int ancho = getResources().getDisplayMetrics().widthPixels;
        int alto = getResources().getDisplayMetrics().heightPixels;
        int padding = (int) (alto * 0.25); // 25% de espacio (padding) superior e inferior

        CameraUpdate centrarmarcadores = CameraUpdateFactory.newLatLngBounds(limites, ancho, alto, padding);

        mMap.animateCamera(centrarmarcadores);

    }
}
