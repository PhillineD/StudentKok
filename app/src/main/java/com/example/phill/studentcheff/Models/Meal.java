package com.example.phill.studentcheff.Models;

public class Meal {
    private String id, Ingredients1, Instruction, Youtubelink, Picture,  title;
    private  String measure1, measure2, measure3, measure4, measure5, measure6, measure7, measure8;
    String Ingredients2, Ingredients3, Ingredients4, Ingredients5, Ingredients6, Ingredients7, Ingredients8;
    String Hint;

    public Meal(String id, String Ingredients1, String Instruction, String Youtubelink, String Picture, String title, String measure1,
                String Ingredients2, String measure2,
                String Ingredients3, String measure3,
                String Ingredients4, String measure4,
                String Ingredients5, String measure5,
                String Ingredients6, String measure6,
                String Ingredients7, String measure7,
                String Ingredients8, String measure8,
                String hint
                ){
        this.id = id;
        this.Ingredients1 = Ingredients1;
        this.Instruction = Instruction;
        this.Youtubelink = Youtubelink;
        this.title =title;
        this.Picture = Picture;
        this.measure1 = measure1;
        this.Ingredients2 = Ingredients2;
        this.measure2 = measure2;
        this.Ingredients3 = Ingredients3;
        this.measure3 = measure3;
        this.Ingredients4 = Ingredients4;
        this.measure4 = measure4;
        this.Ingredients5 = Ingredients5;
        this.measure5 = measure5;
        this.Ingredients6 = Ingredients6;
        this.measure6 = measure6;
        this.Ingredients7 = Ingredients7;
        this.measure7 = measure7;
        this.Ingredients8 = Ingredients8;
        this.measure8 = measure8;
        this.Hint = hint;
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

    public String getMeasure2() {
        return measure2;
    }

    public String getMeasure3() {
        return measure3;
    }

    public String getMeasure4() {
        return measure4;
    }

    public String getMeasure5() {
        return measure5;
    }

    public String getMeasure6() {
        return measure6;
    }

    public String getMeasure7() {
        return measure7;
    }

    public String getMeasure8() {
        return measure8;
    }

    public String getIngredients1() {
        return Ingredients1;
    }

    public String getIngredients2() {
        return Ingredients2;
    }

    public String getIngredients3() {
        return Ingredients3;
    }

    public String getIngredients4() {
        return Ingredients4;
    }

    public String getIngredients5() {
        return Ingredients5;
    }

    public String getIngredients6() {
        return Ingredients6;
    }

    public String getIngredients7() {
        return Ingredients7;
    }

    public String getIngredients8() {
        return Ingredients8;
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

    public String getHint() {
        return Hint;
    }

    public void setHint(String hint) {
        Hint = hint;
    }

}
