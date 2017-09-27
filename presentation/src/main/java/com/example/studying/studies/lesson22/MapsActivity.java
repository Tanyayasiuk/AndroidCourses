package com.example.studying.studies.lesson22;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.studying.studies.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button terrain;
    private Button hybrid;
    private Button satellite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        //ДЛя большей кастомизации использовать  mapView; не забыть переопределять жизненный цикл (onResume, onPause и проч.)
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        terrain = (Button) findViewById(R.id.terrain);
        hybrid = (Button) findViewById(R.id.hybrid);
        satellite = (Button) findViewById(R.id.satellite);

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

        // Add a marker in Minsk and move the camera
        LatLng minsk = new LatLng(53.903111,27.560408);
        LatLng brest = new LatLng(52.102502,23.731124);
        LatLng grodno = new LatLng(53.674644,23.833372);
        LatLng vitebsk = new LatLng(55.191685,30.200856);
        LatLng mogilev = new LatLng(53.904926,30.336463);
        LatLng gomel = new LatLng(52.432944,30.986716);

        mMap.addMarker(new MarkerOptions().position(minsk).title("Minsk"));
        mMap.addMarker(new MarkerOptions().position(brest).title("Brest"));
        mMap.addMarker(new MarkerOptions().position(grodno).title("Grodno"));
        mMap.addMarker(new MarkerOptions().position(vitebsk).title("Vitebsk"));
        mMap.addMarker(new MarkerOptions().position(mogilev).title("Mogilev"));
        mMap.addMarker(new MarkerOptions().position(gomel).title("Gomel"));

        PolylineOptions lineBM=
                new PolylineOptions().add(minsk,
                        brest)
                        .width(5).color(Color.RED);
        PolylineOptions lineGrM=
                new PolylineOptions().add(minsk,
                        grodno)
                        .width(5).color(Color.RED);
        PolylineOptions lineVM=
                new PolylineOptions().add(minsk,
                        vitebsk)
                        .width(5).color(Color.RED);
        PolylineOptions lineMM=
                new PolylineOptions().add(minsk,
                        mogilev)
                        .width(5).color(Color.RED);
        PolylineOptions lineGM=
                new PolylineOptions().add(minsk,
                        gomel)
                        .width(5).color(Color.RED);

        mMap.addPolyline(lineBM);
        mMap.addPolyline(lineGrM);
        mMap.addPolyline(lineVM);
        mMap.addPolyline(lineGM);
        mMap.addPolyline(lineMM);

        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(minsk, 6)));

        terrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            }
        });

        hybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

        satellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

    }
}
