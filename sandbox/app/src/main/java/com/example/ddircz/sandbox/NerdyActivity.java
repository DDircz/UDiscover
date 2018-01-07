package com.example.ddircz.sandbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Random;

/**
 * Created by Jaytielle on 4/12/17.
 */

public class NerdyActivity extends AppCompatActivity implements OnMapReadyCallback {

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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        setupActionBar();
        mMap = googleMap;
        float zoom = 16.0f;
        int random = randomNumGenerator(0, 5);

        if (random == 0) {
            Toast.makeText(this,"Nerdy Spot: Keller Hall", Toast.LENGTH_SHORT).show();
            LatLng Default = new LatLng(44.974436, -93.232203);
            mMap.addMarker(new MarkerOptions().position(Default).title("Keller Hall"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Default,zoom));
        } else if (random == 1) {
            Toast.makeText(this,"Nerdy Spot: Coffman Union", Toast.LENGTH_SHORT).show();
            LatLng Default = new LatLng(44.9729, -93.2353);
            mMap.addMarker(new MarkerOptions().position(Default).title("Coffman Union"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Default,zoom));
        } else if (random == 2) {
            Toast.makeText(this,"Nerdy Spot: Walter Library", Toast.LENGTH_SHORT).show();
            LatLng Default = new LatLng(44.9753, -93.2362);
            mMap.addMarker(new MarkerOptions().position(Default).title("Walter Library"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Default,zoom));
        } else if (random == 3) {
            Toast.makeText(this,"Nerdy Spot: Starbucks on Washington", Toast.LENGTH_SHORT).show();
            LatLng Default = new LatLng(44.973938, -93.229838);
            mMap.addMarker(new MarkerOptions().position(Default).title("Starbucks"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Default,zoom));
        } else {
            Toast.makeText(this,"Nerdy Spot: Moos Tower", Toast.LENGTH_SHORT).show();
            LatLng Default = new LatLng(44.973005, -93.231605);
            mMap.addMarker(new MarkerOptions().position(Default).title("Moos Tower"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Default,zoom));
        }
        // Add a marker in Sydney and move the camera
    }

    private static int randomNumGenerator(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
