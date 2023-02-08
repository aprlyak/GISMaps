package com.apriliya.peta;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync( this);
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

        // Add a marker in Sydney and move the camera
        LatLng myhouse = new LatLng(-0.9097432682609001, 119.88846010076836);
        mMap.addMarker(new MarkerOptions().position(myhouse).title("mark myhouse"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(myhouse));
        LatLng stimik = new LatLng(-0.8866506,119.8752671);
        mMap.addMarker(new MarkerOptions().position(stimik).title("mark stimik"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(stimik));

        //custom size marker
        int tinggi = 120;
        int lebar = 120;
        BitmapDrawable bitmapstart = (BitmapDrawable) getResources().getDrawable(com.google.android.gms.base.R.drawable.googleg_standard_color_18);
        BitmapDrawable bitmapdes = (BitmapDrawable) getResources().getDrawable(com.google.android.gms.base.R.drawable.googleg_disabled_color_18);
        Bitmap s = bitmapstart.getBitmap();
        Bitmap d = bitmapdes.getBitmap();
        Bitmap markstart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markdes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

        //add marker to map
        mMap.addMarker(new MarkerOptions().position(myhouse).title("mark myhouse")
                .snippet("ini rumahku")
                .icon(BitmapDescriptorFactory.fromBitmap(markstart)));
        mMap.addMarker(new MarkerOptions().position(stimik).title("mark kampus")
                .snippet("ini stimik")
                .icon(BitmapDescriptorFactory.fromBitmap(markdes)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(stimik, 14));

        mMap.addPolyline(new PolylineOptions().add(
                myhouse,
                new LatLng(-0.9095992172403274, 119.88992792144946),
                new LatLng(-0.8938297802303853, 119.88654833708287),
                new LatLng(-0.8930788544510815, 119.88516431747985),
                new LatLng(-0.8919739173370118, 119.88365155106172),
                new LatLng(-0.8892598495240625, 119.88152724449391),
                new LatLng(-0.8883801915732606, 119.8777292345317),
                new LatLng(-0.8877579932696555, 119.87525087239366),
                new LatLng(-0.8866315976598255, 119.87539034657564),
                stimik).width(12).color(Color.BLUE));

    }
}
