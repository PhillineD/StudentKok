package com.example.phill.studentcheff.Models;

public class Meal {
    private String id, Ingredients1, Instruction, Youtubelink, Picture,  title;
    private  String measure1, measure2, measure3, measure4, measure5, measure6, measure7, measure8, measure9, measure10, measure11, measure12;
    String Ingredients2, Ingredients3, Ingredients4, Ingredients5, Ingredients6, Ingredients7, Ingredients8, Ingredients9, Ingredients10, Ingredients11, Ingredients12;
    String Hint;
    String Ingredients13, Ingredients14, Ingredients15;
    String measure13, measure14, measure15;




    public Meal(String id, String Ingredients1, String Instruction, String Youtubelink, String Picture, String title, String measure1,
                String Ingredients2, String measure2,
                String Ingredients3, String measure3,
                String Ingredients4, String measure4,
                String Ingredients5, String measure5,
                String Ingredients6, String measure6,
                String Ingredients7, String measure7,
                String Ingredients8, String measure8,
                String Ingredients9, String measure9,
                String Ingredients10, String measure10,
                String Ingredients11, String measure11,
                String Ingredients12, String measure12,
                String Ingredients13, String measure13,
                String Ingredients14, String measure14,
                String Ingredients15, String measure15,
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
        this.Ingredients9 = Ingredients9;
        this.measure9 = measure9;
        this.Ingredients10 = Ingredients10;
        this.measure10 = measure10;
        this.Ingredients11 = Ingredients11;
        this.measure11 = measure11;
        this.Ingredients12 = Ingredients12;
        this.measure12 = measure12;
        this.Ingredients13 = Ingredients13;
        this.measure13 = measure13;
        this.Ingredients14 = Ingredients14;
        this.measure14= measure14;
        this.Ingredients15 = Ingredients15;
        this.measure15 = measure15;
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


    public String getMeasure9() {
        return measure9;
    }

    public void setMeasure9(String measure9) {
        this.measure9 = measure9;
    }

    public String getIngredients9() {
        return Ingredients9;
    }

    public void setIngredients9(String ingredients9) {
        Ingredients9 = ingredients9;
    }

    public String getMeasure10() {
        return measure10;
    }

    public void setMeasure10(String measure10) {
        this.measure10 = measure10;
    }

    public String getIngredients10() {
        return Ingredients10;
    }

    public void setIngredients10(String ingredients10) {
        Ingredients10 = ingredients10;
    }

    public String getMeasure11() {
        return measure11;
    }

    public void setMeasure11(String measure11) {
        this.measure11 = measure11;
    }

    public String getMeasure12() {
        return measure12;
    }

    public void setMeasure12(String measure12) {
        this.measure12 = measure12;
    }

    public String getIngredients11() {
        return Ingredients11;
    }

    public void setIngredients11(String ingredients11) {
        Ingredients11 = ingredients11;
    }

    public String getIngredients12() {
        return Ingredients12;
    }

    public void setIngredients12(String ingredients12) {
        Ingredients12 = ingredients12;
    }

    public String getIngredients13() {
        return Ingredients13;
    }

    public void setIngredients13(String ingredients13) {
        Ingredients13 = ingredients13;
    }

    public String getIngredients14() {
        return Ingredients14;
    }

    public void setIngredients14(String ingredients14) {
        Ingredients14 = ingredients14;
    }

    public String getIngredients15() {
        return Ingredients15;
    }

    public void setIngredients15(String ingredients15) {
        Ingredients15 = ingredients15;
    }

    public String getMeasure13() {
        return measure13;
    }

    public void setMeasure13(String measure13) {
        this.measure13 = measure13;
    }

    public String getMeasure14() {
        return measure14;
    }

    public void setMeasure14(String measure14) {
        this.measure14 = measure14;
    }

    public String getMeasure15() {
        return measure15;
    }

    public void setMeasure15(String measure15) {
        this.measure15 = measure15;
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
