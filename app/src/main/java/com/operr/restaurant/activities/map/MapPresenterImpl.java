package com.operr.restaurant.activities.map;

import android.app.Activity;

import com.operr.restaurant.utils.Utils;

/**
 * Created by Daoud Shaheen on 6/4/2017.
 */

public class MapPresenterImpl implements MapPresenter {

    private MapView mapView;
    private Activity activity;

    public MapPresenterImpl(MapView mapView, Activity activity) {

        this.mapView = mapView;
        this.activity = activity;
    }

    @Override
    public void getResturantNearBy(double latitude, double longitude) {
        if(Utils.isNetworkConnected(activity)) {
            new SearchRestaurantNearByAsyncTask(latitude, longitude, this.mapView).execute();
        } else {
            mapView.showMessage("No Internet Connection");
        }
    }


}
