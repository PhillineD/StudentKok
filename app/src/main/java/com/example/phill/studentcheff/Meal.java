package com.example.phill.studentcheff;

public class Meal {
    private String id, Ingredients, Instruction, Youtubelink, Picture,  title;
    private  String measure1;

    public Meal(String id, String Ingredients, String Instruction, String Youtubelink, String Picture, String title, String measure1){
        this.id = id;
        this.Ingredients = Ingredients;
        this.Instruction = Instruction;
        this.Youtubelink = Youtubelink;
        this.title =title;
        this.Picture = Picture;
        this.measure1 = measure1;
    }

    public String getId() {
        return id;
    }


    public String getitle() {
        return title;
    }
    public String getMeasure1() {
        return measure1;
    }


    public String getIngredients() {
        return Ingredients;
    }


    public String getInstruction() {
        return Instruction;
    }

    public String getYoutubelink() {
        return Youtubelink;
    }

    public String getPicture() {
        return Picture;
    }

}
