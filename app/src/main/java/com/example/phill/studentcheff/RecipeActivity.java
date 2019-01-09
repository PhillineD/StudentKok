package com.example.phill.studentcheff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity implements MealsRequest.Callback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_activity);

        MealsRequest ArrayAdapter = new MealsRequest(this);
        ArrayAdapter.getMeals(this);

    }


    @Override
    public void gotMeals(ArrayList<String> meals) {

    }

    @Override
    public void gotMealsError(String message) {

    }

    public void clicktostart(View view) {
        Intent intent = new Intent(getApplicationContext(), StartActivity.class);
        startActivity(intent);
    }
}
