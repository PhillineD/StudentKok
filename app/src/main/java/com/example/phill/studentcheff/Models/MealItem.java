/**
 * Classes with meal items, use for MealsRequest.
 *
 *
 * @author      Philline Dikker
 * @version
 *
 *
 * This work complies with the JMU Honor Code.
 */
package com.example.phill.studentcheff.Models;

public class MealItem {
    private String id, Picture,  title;

    // contructer
    public MealItem(String id, String Picture, String title){
        this.id = id;
        this.Picture = Picture;
        this.title =title;
    }

    // getters and setters for items
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
