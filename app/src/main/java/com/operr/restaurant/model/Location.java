package com.operr.restaurant.model;

import java.io.Serializable;

/**
 * Created by Daoud Shaheen on 6/2/2017.
 */
public class Location  implements Serializable {
    private double latitude;
    private double longitude;

    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location() {
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
