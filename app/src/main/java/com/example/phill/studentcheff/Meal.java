package com.example.phill.studentcheff;

public class Meal {
    private String id, Ingredients, Recipe, Instruction, Youtubelink, Picture,  title;

    public Meal(String id, String Ingredients, String Recipe, String Instruction, String Youtubelink, String Picture, String title){
        this.id = id;
        this.Ingredients = Ingredients;
        this.Recipe =  Recipe;
        this.Instruction = Instruction;
        this.Youtubelink = Youtubelink;
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

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String ingredients) {
        Ingredients = ingredients;
    }

    public String getRecipe() {
        return Recipe;
    }

    public void setRecipe(String recipe) {
        Recipe = recipe;
    }

    public String getInstruction() {
        return Instruction;
    }

    public void setInstruction(String instruction) {
        Instruction = instruction;
    }

    public String getYoutubelink() {
        return Youtubelink;
    }

    public void setYoutubelink(String youtubelink) {
        Youtubelink = youtubelink;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }


}
