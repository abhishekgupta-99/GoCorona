package com.tachyon.gocorona.models;

/**
 * Created by abhishek on 3/2020.
 */

public class Donate_ngo_model {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    // public int id;
    public String name;
    public String description;

    public int views;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String image_url;







}
