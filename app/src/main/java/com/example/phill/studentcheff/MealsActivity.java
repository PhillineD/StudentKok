package com.example.phill.studentcheff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MealsActivity extends AppCompatActivity implements MealsRequest.Callback{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meals_activity);
        Intent intent = getIntent();
        String message = intent.getStringExtra("categorie");

        MealsRequest ArrayAdapter = new MealsRequest(this);
        ArrayAdapter.getMeals(this, message);

    }

    @Override
    public void gotMeals(ArrayList<MealItem> meals) {
//        Toast.makeText(this, meals.get(0),Toast.LENGTH_LONG).show();
        Log.d("gotmeals", "gotMeals: we zijn er "+ meals);

        MealAdapter adapter = new MealAdapter(this, R.layout.meals_activity, meals);
        ListView listView =findViewById(R.id.MealsListView);
        listView.setAdapter(adapter);

    }

    @Override
    public void gotMealsError(String message) {
        Log.d("gotmealserror", "gotMeals: we zijn er dus niet "+ message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void clicktorecipe(View view) {
        Intent intent = new Intent(getApplicationContext(), RecipeActivity.class);
        startActivity(intent);
    }
}
