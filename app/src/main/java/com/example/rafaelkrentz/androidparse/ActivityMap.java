package com.example.rafaelkrentz.androidparse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cherubiniNB on 17/06/2015.
 */
public class ActivityMap extends Activity{

    GoogleMap googleMap;
    private List<Institute> institutes;
    private Map<Marker, Institute> markersMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        createMapView();

        Button btnList = (Button) findViewById(R.id.btnList);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addGpsLocation();
        addMarker();
    }

    private void createMapView(){
        /**
         * Catch the null pointer exception that
         * may be thrown when initialising the map
         */
        try {
            if(null == googleMap){
                googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.mapView)).getMap();

                /**
                 * If the map is still null after attempted initialisation,
                 * show an error to the user
                 */
                if(null == googleMap) {
                    Toast.makeText(getApplicationContext(),
                            "Error creating map", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (NullPointerException exception){
            Log.e("mapApp", exception.toString());
        }
    }

    private void addGpsLocation(){
        // Enable MyLocation Layer of Google Map
        googleMap.setMyLocationEnabled(true);

        // Get LocationManager object from System Service LOCATION_SERVICE
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // Create a criteria object to retrieve provider
        Criteria criteria = new Criteria();

        // Get the name of the best provider
        String provider = locationManager.getBestProvider(criteria, true);

        // Get Current Location
        Location myLocation = locationManager.getLastKnownLocation(provider);

        // set map type
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Get latitude of the current location
        double latitude = myLocation.getLatitude();

        // Get longitude of the current location
        double longitude = myLocation.getLongitude();

        // Create a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);

        // Show the current location in Google Map
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        // Zoom in the Google Map
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(13));
    }

    private void addMarker() {
        this.institutes = Globals.currentInstList;
        for (Institute institute : institutes) {
            Marker marker = googleMap.addMarker(
                    new MarkerOptions()
                            .position(
                                    new LatLng(
                                            institute.getLocation().getLatitude(),
                                            institute.getLocation().getLongitude()
                                    )
                            ).title(institute.getName())
                            .snippet(institute.getAddress() + " - " + institute.getTarget())
            );
            markersMap.put(marker, institute);
        }

        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Globals.currentProfile = markersMap.get(marker);
                //Toast.makeText(ActivityMap.this, Globals.currentProfile.getName(), Toast.LENGTH_SHORT).show();
                Intent it = new Intent(ActivityMap.this, ActivityProfile.class);
                startActivity(it);
            }
        });


    }
}
/*
 googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(ActivityMap.this, marker.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

// Use default InfoWindow frame
@Override
public View getInfoWindow(Marker args) {
        return null;
        }

// Defines the contents of the InfoWindow
@Override
public View getInfoContents(Marker args) {

        // Getting view from the layout file info_window_layout
        View v = getLayoutInflater().inflate(R.layout.info_window_layout, null);

        // Getting the position from the marker
        clickMarkerLatLng = args.getPosition();

        TextView title = (TextView) v.findViewById(R.id.tvTitle);
        title.setText(args.getTitle());

        map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
public void onInfoWindowClick(Marker marker) {
        if (SGTasksListAppObj.getInstance().currentUserLocation != null) {
        if (String.valueOf(SGTasksListAppObj.getInstance().currentUserLocation.getLatitude()).substring(0, 8).contains(String.valueOf(clickMarkerLatLng.latitude).substring(0, 8)) &&
        String.valueOf(SGTasksListAppObj.getInstance().currentUserLocation.getLongitude()).substring(0, 8).contains(String.valueOf(clickMarkerLatLng.longitude).substring(0, 8))) {
        Toast.makeText(getApplicationContext(), "This your current location, navigation is not needed.", Toast.LENGTH_SHORT).show();
        } else {
        FlurryAgent.onEvent("Start navigation window was clicked from daily map");
        tasksRepository = SGTasksListAppObj.getInstance().tasksRepository.getTasksRepository();
        for (Task tmptask : tasksRepository) {
        String tempTaskLat = String.valueOf(tmptask.getLatitude());
        String tempTaskLng = String.valueOf(tmptask.getLongtitude());

        Log.d(TAG, String.valueOf(tmptask.getLatitude()) + "," + String.valueOf(clickMarkerLatLng.latitude).substring(0, 8));

        if (tempTaskLat.contains(String.valueOf(clickMarkerLatLng.latitude).substring(0, 8)) && tempTaskLng.contains(String.valueOf(clickMarkerLatLng.longitude).substring(0, 8))) {
        task = tmptask;
        break;
        }
        }

        Intent intent = new Intent(getApplicationContext(), RoadDirectionsActivity.class);
        intent.putExtra(TasksListActivity.KEY_ID, task.getId());
        startActivity(intent);

        }
        } else {
        Toast.makeText(getApplicationContext(), "Your current location could not be found,\nNavigation is not possible.", Toast.LENGTH_SHORT).show();
        }
        }
        });

        // Returning the view containing InfoWindow contents
        return v;

        }
        });
        */
