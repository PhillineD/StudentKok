package com.example.phill.studentcheff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity implements RecipeRequest.Callback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_activity);

        // get id from de meal you chosen
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Log.d("de id", "onCreate: " + id);
        RecipeRequest ArrayAdapter = new RecipeRequest(this);
        ArrayAdapter.getRecipe(this, id);
    }


    public void clicktostart(View view) {
        Intent intent = new Intent(getApplicationContext(), StartActivity.class);
        startActivity(intent);
    }

    @Override
    public void gotRecipe(ArrayList<Meal> meals) {
        Log.d("gotrecipe", "gotMeals: we zijn er "+ meals.get(0));
        Meal stukje = meals.get(0);
        stukje.getitle();
        Log.d("gotrecipe", "gotMeals: we zijn er "+ stukje.getitle());
        TextView title = findViewById(R.id.viewRecipeTitle);
        TextView ingregients = findViewById(R.id.viewIngredients);
        TextView instructions = findViewById(R.id.viewinstructions);
        TextView youtube = findViewById(R.id.viewyoutube);
        title.setText(stukje.getitle());
        ingregients.setText(stukje.getIngredients());
        instructions.setText(stukje.getInstruction());
        youtube.setText(stukje.getYoutubelink());


//        Meal piece = getTitle();
//        meals.getTitle();


    }

    @Override
    public void gotRecipeError(String message) {
        Log.d("gotmealserror", "gotMeals: we zijn er dus niet "+ message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
