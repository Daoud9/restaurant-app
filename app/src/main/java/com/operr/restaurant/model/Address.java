package com.operr.restaurant.model;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Daoud Shaheen on 6/2/2017.
 */
public class Address implements Serializable {
    String city;
    String country;
    String address2;
    String address3;
    String state;
    String address1;
    @SerializedName("zip_code")
    String zipCode;

    public Address() {
    }

    public Address(String city, String country, String address2, String address3, String state, String address1, String zipCode) {
        this.city = city;
        this.country = country;
        this.address2 = address2;
        this.address3 = address3;
        this.state = state;
        this.address1 = address1;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        StringBuilder address = new StringBuilder();
        address.append(!TextUtils.isEmpty(getAddress1()) ? getAddress1() : "");
        address.append(!TextUtils.isEmpty(getAddress2()) ? "," + getAddress2()  : "");
        address.append(!TextUtils.isEmpty(getAddress3()) ? "," + getAddress3()  : "");
        address.append(!TextUtils.isEmpty(getCity()) ? "," + "\n" + getCity()  : "");
        address.append(!TextUtils.isEmpty(getState()) ? "," + getState()  : "");
        address.append(!TextUtils.isEmpty(getZipCode()) ? "," + "\n" + getZipCode() : "");
        address.append(!TextUtils.isEmpty(getCountry()) ? "," + getCountry() : "");
        return address.toString();
    }
}
