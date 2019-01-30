/**
 * Classes with meal items, use for RecipeRequest.
 *
 *
 * @author      Philline Dikker
 * @version     1
 *
 *
 * This work complies with the JMU Honor Code.
 */

package com.example.phill.studentcheff.Models;

public class Meal {

    private String id, Ingredients1, Instruction, Youtubelink, Picture,  title;
    private  String measure1, measure2, measure3, measure4, measure5, measure6, measure7, measure8, measure9, measure10, measure11, measure12;
    String Ingredients2, Ingredients3, Ingredients4, Ingredients5, Ingredients6, Ingredients7, Ingredients8, Ingredients9, Ingredients10, Ingredients11, Ingredients12;
    String Hint;
    String Ingredients13, Ingredients14, Ingredients15;
    String measure13, measure14, measure15;
    String measure16, measure17, measure18;
    String Ingredients16, Ingredients17, Ingredients18;

    // contructer
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
                String Ingredients16, String measure16,
                String Ingredients17, String measure17,
                String Ingredients18, String measure18,
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
        this.Ingredients16 = Ingredients16;
        this.measure16 = measure16;
        this.Ingredients17 = Ingredients17;
        this.measure17 = measure17;
        this.Ingredients18 = Ingredients18;
        this.measure18 = measure18;
        this.Hint = hint;
    }

    // getters and setters for items
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

    public String getMeasure9() {
        return measure9;
    }

    public String getMeasure10() {
        return measure10;
    }

    public String getMeasure11() {
        return measure11;
    }

    public String getMeasure12() {
        return measure12;
    }

    public String getMeasure13() {
        return measure13;
    }

    public String getMeasure14() {
        return measure14;
    }

    public String getMeasure15() {
        return measure15;
    }

    public String getMeasure16() {
        return measure16;
    }

    public String getMeasure17() {
        return measure17;
    }

    public String getMeasure18() {
        return measure18;
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

    public String getIngredients9() {
        return Ingredients9;
    }

    public String getIngredients10() {
        return Ingredients10;
    }

    public String getIngredients11() {
        return Ingredients11;
    }

    public String getIngredients12() {
        return Ingredients12;
    }

    public String getIngredients13() {
        return Ingredients13;
    }

    public String getIngredients14() {
        return Ingredients14;
    }

    public String getIngredients15() {
        return Ingredients15;
    }

    public String getIngredients16() {
        return Ingredients16;
    }

    public String getIngredients17() {
        return Ingredients17;
    }

    public String getIngredients18() {
        return Ingredients18;
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
