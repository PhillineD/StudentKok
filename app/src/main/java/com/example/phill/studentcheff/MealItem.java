package com.example.phill.studentcheff;

public class MealItem {
    private String id, Picture,  title;

    public MealItem(String id, String Picture, String title){
        this.id = id;
        this.Picture = Picture;
        this.title =title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getitle() {
        return title;
    }

    public void setTitle(String id) {
        this.title = title;
    }


    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }



}
