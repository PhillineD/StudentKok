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

        ImageView foto  = findViewById(R.id.picturerecipe);
        Log.d("jeejj", "plaatje laden1" + picture);

        // get title
        TextView titlerecipe = findViewById(R.id.viewRecipeTitle);
        String titlehistory = titlerecipe.getText().toString();

        Intent in = new Intent(getApplicationContext(), HistoryActivity.class);
        in.putExtra("id",id);
        in.putExtra("rating", stars);

        Log.d("rating", "clicktostart: " +  rating.getRating() + "jaa" +  rating.getNumStars() );

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
        TextView instructions = findViewById(R.id.viewinstructions);
        ImageView picture = findViewById(R.id.picturerecipe);

        TextView measure1 = findViewById(R.id.ViewMeasure1);
        TextView measure2 = findViewById(R.id.ViewMeasure2);
        TextView measure3 = findViewById(R.id.ViewMeasure3);
        TextView measure4 = findViewById(R.id.ViewMeasure4);
        TextView measure5 = findViewById(R.id.ViewMeasure5);
        TextView measure6 = findViewById(R.id.ViewMeasure6);
        TextView measure7 = findViewById(R.id.ViewMeasure7);
        TextView measure8 = findViewById(R.id.ViewMeasure8);

        TextView ingregients1 = findViewById(R.id.viewIngredients1);
        TextView ingregients2 = findViewById(R.id.viewIngredients2);
        TextView ingregients3 = findViewById(R.id.viewIngredients3);
        TextView ingregients4 = findViewById(R.id.viewIngredients4);
        TextView ingregients5 = findViewById(R.id.viewIngredients5);
        TextView ingregients6 = findViewById(R.id.viewIngredients6);
        TextView ingregients7 = findViewById(R.id.viewIngredients7);
        TextView ingregients8 = findViewById(R.id.viewIngredients8);

        title.setText(stukje.getitle());
        instructions.setText(stukje.getInstruction());

        ingregients1.setText(stukje.getIngredients1());
        ingregients2.setText(stukje.getIngredients2());
        ingregients3.setText(stukje.getIngredients3());
        ingregients4.setText(stukje.getIngredients4());

        measure1.setText(stukje.getMeasure1());
        measure2.setText(stukje.getMeasure2());
        measure3.setText(stukje.getMeasure3());
        measure4.setText(stukje.getMeasure4());

        if (stukje.getMeasure5() == "null"){
            measure5.setText("");
            ingregients5.setText("");
        }
        else{
            measure5.setText(stukje.getMeasure5());
            ingregients5.setText(stukje.getIngredients5());
        }

        if (stukje.getMeasure6()  == "null"){
            measure6.setText("");
            ingregients6.setText("");
        }
        else{
            measure6.setText(stukje.getMeasure6());
            ingregients6.setText(stukje.getIngredients6());
        }

        if (stukje.getMeasure7()  == "null"){
            measure7.setText("");
            ingregients7.setText("");
        }
        else{
            measure7.setText(stukje.getMeasure7());
            ingregients7.setText(stukje.getIngredients7());
        }

        if (stukje.getMeasure8()  == "null"){
            measure8.setText("");
            ingregients8.setText("");
        }
        else {
            measure8.setText(stukje.getMeasure8());
            ingregients8.setText(stukje.getIngredients8());
        }



//        Log.d("meaures", "gotMeals: we zijn er "+stukje.getMeasure6()+ stukje.getMeasure7() );
        DownloadImageTask Image = new DownloadImageTask(picture);
        Image.execute(stukje.getPicture());

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
