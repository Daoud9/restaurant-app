package com.operr.restaurant.activities.map;

import android.app.Activity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.operr.restaurant.R;
import com.operr.restaurant.model.Address;
import com.operr.restaurant.model.Business;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private final Activity activity;

    public CustomInfoWindowAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public View getInfoContents(Marker marker) {

        View view = activity.getLayoutInflater().inflate(R.layout.custom_info_contents, null);
        Business restaurant = (Business) marker.getTag();
        TextView mResturantName = ((TextView) view.findViewById(R.id.restaurantName));
        mResturantName.setText(restaurant.getName());
        TextView mResturnantAddress = ((TextView) view.findViewById(R.id.addressView));
        Address location = restaurant.getLocation();

        mResturnantAddress.setText(location.toString());

        RatingBar mRatingBar = ((RatingBar) view.findViewById(R.id.ratingView));
        mRatingBar.setNumStars(5);
        mRatingBar.setRating((float) restaurant.getRating());
        mRatingBar.setStepSize(1);

        return view;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        // TODO Auto-generated method stub
        return null;
    }

}