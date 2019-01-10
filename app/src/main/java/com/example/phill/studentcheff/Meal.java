package com.example.phill.studentcheff;

public class Meal {
    private String id, Ingredients, Instruction, Youtubelink, Picture,  title;

    public Meal(String id, String Ingredients, String Instruction, String Youtubelink, String Picture, String title){
        this.id = id;
        this.Ingredients = Ingredients;
        this.Instruction = Instruction;
        this.Youtubelink = Youtubelink;
        this.title =title;
    }

    public String getId() {
        return id;
    }


    public String getitle() {
        return title;
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
