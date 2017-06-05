package com.operr.restaurant.activities.map;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.operr.restaurant.R;
import com.operr.restaurant.activities.restaurant.RestaurantActivity;
import com.operr.restaurant.model.Business;
import com.operr.restaurant.utils.Constants;

import java.util.List;

public class MapsActivity extends FragmentActivity implements  MapView {

    private GoogleMap mMap;
    private ProgressDialog dialog;
    private MapPresenter presenter;
    private double currentLat;
    private double currentLng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        presenter = new MapPresenterImpl(this, this);
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
        //set initial point
        currentLat = 37.767413217936834;
        currentLng = -122.42820739746094;
        LatLng position = new LatLng(currentLat, currentLng);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, Constants.MAX_MIN_ZOOM));

        presenter.getResturantNearBy(mMap.getCameraPosition().target.latitude, mMap.getCameraPosition().target.longitude);

        mMap.setMaxZoomPreference(Constants.MAX_MIN_ZOOM);
        mMap.setMinZoomPreference(Constants.MAX_MIN_ZOOM);
        mMap.setOnInfoWindowClickListener(this);
        mMap.setOnCameraMoveListener(this);
        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(this));

    }

    @Override
    public void toRestaurantProfile(Business restaurant) {
        Intent toActivty = new Intent(getApplicationContext(),
                RestaurantActivity.class);
        toActivty.putExtra("restaurant", restaurant);
        startActivity(toActivty);
    }

    @Override
    public void setRestaurantsOnMap(List<Business> businesses) {
        for (Business restaurant: businesses) {
            LatLng position = new LatLng(restaurant.getCoordinates().getLatitude(), restaurant.getCoordinates().getLongitude());
            mMap.addMarker(new MarkerOptions().position(position)).setTag(restaurant);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(position));
        }
    }

    @Override
    public void dismissProgressDialog() {
        if (dialog != null)
            dialog.dismiss();
    }

    @Override
    public void showProgressDialog() {
        if (dialog == null)
            dialog = ProgressDialog.show(this, "", "");
        else
            dialog.show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        toRestaurantProfile((Business) marker.getTag());
    }

    @Override
    public void onCameraMove() {

        double latitude = mMap.getCameraPosition().target.latitude;
        double longitude = mMap.getCameraPosition().target.longitude;
        //only update the Map after the difference between the old lat and new one is above a specific thresold
        if(Math.abs(Math.abs(latitude)- Math.abs(currentLat))>0.003 && Math.abs(Math.abs(longitude) - Math.abs(currentLng)) > 0.003) {
            presenter.getResturantNearBy(latitude, longitude);
            currentLat = latitude;
            currentLng = longitude;
        }
    }
}
