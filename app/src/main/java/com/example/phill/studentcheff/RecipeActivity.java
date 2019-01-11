package com.example.phill.studentcheff;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity implements RecipeRequest.Callback {
    ArrayList<Meal> meals;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_activity);

        // get id from de meal you chosen
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String picture = intent.getStringExtra("picture");
        Log.d("de id", "onCreate: " + id);
        RecipeRequest ArrayAdapter = new RecipeRequest(this);
        ArrayAdapter.getRecipe(this, id);
    }


    public void clicktostart(View view) {

        Intent intent = getIntent();
        String picture = intent.getStringExtra("picture");
        // get id
        String id = intent.getStringExtra("id");

        // get rating
        RatingBar rating = findViewById(R.id.ratingBar);
        float stars = rating.getRating();

        // get title
        TextView titlerecipe = findViewById(R.id.viewRecipeTitle);
        String titlehistory = titlerecipe.getText().toString();

        // get picture
//        Meal stukje = meals.get(0);
//        String picture = stukje.getPicture();

        Intent in = new Intent(getApplicationContext(), HistoryActivity.class);
        in.putExtra("id",id);
        in.putExtra("rating", stars);

        Log.d("rating", "clicktostart: " + stars + id );

        // insert into database
        EntryDatabase.getInstance(this).insert(id,titlehistory, stars, picture);

        startActivity(in);
        finish();
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
        ImageView picture = findViewById(R.id.picturerecipe);

        title.setText(stukje.getitle());
        ingregients.setText(stukje.getIngredients());
        instructions.setText(stukje.getInstruction());

        DownloadImageTask Image = new DownloadImageTask(picture);
        String link = stukje.getPicture();
        Image.execute(link);

        url = stukje.getYoutubelink();
    }

    @Override
    public void gotRecipeError(String message) {
        Log.d("gotmealserror", "gotMeals: we zijn er dus niet "+ message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void clickvideo(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(url)));
        Log.i("Video", "Video Playing....");
    }
}
