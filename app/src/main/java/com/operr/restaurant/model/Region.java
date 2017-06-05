package com.operr.restaurant.model;

import java.io.Serializable;

/**
 * Created by Daoud Shaheen on 6/2/2017.
 */
public class Region implements Serializable {
    private Location center;

    public Location getCenter() {
        return center;
    }

    public void setCenter(Location center) {
        this.center = center;
    }
}
