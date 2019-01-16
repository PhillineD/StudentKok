package com.example.phill.studentcheff;

public class HistoryItem {
    public String id;
    public String picture;

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

    public HistoryItem(String id, String picture, String title) {
        this.id = id;
        this.picture = picture;
        this.title = title;
    }

    public String title;


}
