package com.example.studying.domain.entity;

import android.widget.ImageView;

public class Country {

    private String countryName;
    private String imageUrl;

    private ImageView view;

    /*public Country(String countryName, String imageUrl) {
        this.countryName = countryName;
        this.imageUrl = imageUrl;
    }*/

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
