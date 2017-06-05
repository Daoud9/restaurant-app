package com.operr.restaurant.model;

import java.io.Serializable;

/**
 * Created by Daoud Shaheen on 6/2/2017.
 */
public class Category implements Serializable {
    private String alias;
    private String title;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
