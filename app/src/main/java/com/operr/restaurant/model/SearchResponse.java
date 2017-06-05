package com.operr.restaurant.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Daoud Shaheen on 6/2/2017.
 */
public class SearchResponse implements Serializable {

    private long total;
    private Region region;
    private List<Business> businesses;

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }
}
