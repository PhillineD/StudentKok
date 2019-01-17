package com.example.phill.studentcheff;

import java.sql.Time;

public class HistoryItem {
    public String id;
    public String picture;
    float rating;
    Time time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public HistoryItem(String id, String picture, String title, float rating, Time time) {
        this.id = id;
        this.picture = picture;
        this.title = title;
        this.rating = rating;
        this.time =time;
    }

    public String title;


}
