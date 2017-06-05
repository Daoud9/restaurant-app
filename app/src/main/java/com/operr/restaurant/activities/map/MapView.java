package com.operr.restaurant.activities.map;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.operr.restaurant.model.Business;

import java.util.List;

/**
 * Created by Daoud Shaheen on 6/3/2017.
 */
public interface MapView extends OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener, GoogleMap.OnCameraMoveListener {
    void toRestaurantProfile(Business resturant);

    void setRestaurantsOnMap(List<Business> businesses);

    void dismissProgressDialog();

    void showProgressDialog();

    void showMessage(String message);
}
