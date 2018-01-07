package com.example.ddircz.sandbox;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class Drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback{

    ArrayList<Places> places = new ArrayList<Places>();
    ArrayList<Places> data = SubmitPlace.getData();

    float   HUE_BLUE;
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //Hardcode some locations to places
        places.add(new Places("Keller Hall", 44.974436, -93.232203));
        places.add(new Places("Walter Library", 44.9753, -93.2362));
        places.add(new Places("Starbucks", 44.973938, -93.229838));
        places.add(new Places("Malcom Moos Health Science Tower", 44.973005, -93.231605));
        places.add(new Places("Coffman Memorial Union", 44.9729, -93.2353));

    // Next two lines can be used to start a new activity.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.myplaces) {
            Intent MyPlaces = new Intent(Drawer.this,MyPlacesActivity.class);
            startActivity(MyPlaces);
        } else if (id == R.id.filters) {
            Intent idk = new Intent(Drawer.this,FiltersActivity.class);
            startActivity(idk);
        } else if (id == R.id.nerdy) {
            Intent nerd = new Intent(Drawer.this,NerdyActivity.class);
            startActivity(nerd);
        } else if (id == R.id.submitspot) {
            Intent submit = new Intent(Drawer.this,SubmitPlace.class);
            startActivity(submit);
        } else if (id == R.id.settings) {//Settings Activity
            Intent myIntent = new Intent(Drawer.this, SettingsActivity.class);
            myIntent.putExtra(PreferenceActivity.EXTRA_SHOW_FRAGMENT, SettingsActivity.GeneralPreferenceFragment.class.getName());
            myIntent.putExtra(PreferenceActivity.EXTRA_NO_HEADERS, true);
            Drawer.this.startActivity(myIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        // Commenting below line means drawer will stay open when another activity is opened
        //drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Does map things
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

//        This is not using google places API, I just created a simple places class object, and created
//        an array list of the object

        float zoom = 16.5f;
        // Add a marker in Sydney and move the camera
        LatLng Default = new LatLng(44.975316, -93.233532);
//        mMap.addMarker(new MarkerOptions().position(Default).title("Keller Hall"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Default,zoom));

        //Add few set locations
        for(Places place : data){
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(place.getLatitude(),place.getLongitude()))
                    .title(place.getName())
                    .icon(BitmapDescriptorFactory.defaultMarker(HUE_BLUE))
                    .snippet("More details on location to be added."));
        }

        for(Places place : places){
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(place.getLatitude(),place.getLongitude()))
                    .title(place.getName())
                    .snippet("More details on location to be added."));
        }

    }

    public void addLocation(String locName, double lat,double lon){
        places.add(new Places(locName, lat, lon));
        mapFragment.getMapAsync(this);
    }


}

class Places {
    String Name;
    double Longitude;
    double Latitude;

    public Places(String place,  double latitude, double longitude){
        setPlaceName(place);
        setLongitude(longitude);
        setLatitude(latitude);
    }

    public void setPlaceName(String place){
        Name = place;
    }

    public void setLongitude(double longitude){
        Longitude = longitude;
    }

    public void setLatitude(double latitude){
        Latitude = latitude;
    }

    String getName(){
        return Name;
    }
    double getLongitude(){
        return Longitude;
    }
    double getLatitude(){
        return Latitude;
    }
}
