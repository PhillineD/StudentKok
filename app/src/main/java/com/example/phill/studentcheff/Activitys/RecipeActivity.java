/**
 * Get the recipe from a request, set the recipe.
 *
 *
 * @author      Philline Dikker
 * @version
 *
 *
 * This work complies with the JMU Honor Code.
 */

package com.example.phill.studentcheff.Activitys;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phill.studentcheff.Extra.DownloadImageTask;
import com.example.phill.studentcheff.Requests.EntryDatabase;
import com.example.phill.studentcheff.Models.Meal;
import com.example.phill.studentcheff.R;
import com.example.phill.studentcheff.Requests.RecipeRequest;

import java.sql.Time;
import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity implements RecipeRequest.Callback {

    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_activity);

        // get id from de meal you chosen
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
//        String picture = intent.getStringExtra("picture");
        RecipeRequest ArrayAdapter = new RecipeRequest(this);
        ArrayAdapter.getRecipe(this, id);
    }

    /**
     * Open youtube with recipe video.
     *
     * @param view    Represents a view of clicked item.
     */
    public void clickVideo(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(url)));
    }

    /**
     * Finished recipe, go to start and parse information.
     *
     * @param view    Represents a view of clicked item.
     */
    public void clicktostart(View view) {

        Intent intent = getIntent();
        String picture = intent.getStringExtra("picture");

        // get id
        String id = intent.getStringExtra("id");

        // get rating
        RatingBar rating = findViewById(R.id.ratingBar);
        float stars = rating.getRating();

        // get title
        TextView titleRecipe = findViewById(R.id.viewRecipeTitle);
        String titleHistory = titleRecipe.getText().toString();

        // get hint
        TextView setHint = findViewById(R.id.hint);
        String soortMeal = setHint.getText().toString();

        // get time
        TextView timeText = findViewById(R.id.time);
        String time = timeText.getText().toString();

        // only navigate to StartActivity if stars and time are filled in
        if (! time.equals("") && stars != 0 ) {
            float constant = new Float(time);

            Intent in = new Intent(getApplicationContext(), StartActivity.class);
            in.putExtra("id",id);
            in.putExtra("rating", stars);
            in.putExtra("hint", soortMeal);

            // insert into database
            EntryDatabase.getInstance(this).insert(id,titleHistory, stars, picture, soortMeal, constant);

            startActivity(in);
            finish();

        }

        // stars and / or time are not filled
        else{
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Set recipe.
     *
     * @param  "ArrayList<Meal> meals"  List of recipe items.
     */
    @Override
    public void gotRecipe(ArrayList<Meal> meals) {

        // get right piece from list
        Meal pieceRecipe = meals.get(0);
        pieceRecipe.getitle();

        // find views
        ImageView picture = findViewById(R.id.picturerecipe);
        TextView title = findViewById(R.id.viewRecipeTitle);
        TextView instructions = findViewById(R.id.viewinstructions);
        TextView hint = findViewById(R.id.hint);

        TextView measure1 = findViewById(R.id.ViewMeasure1);
        TextView measure2 = findViewById(R.id.ViewMeasure2);
        TextView measure3 = findViewById(R.id.ViewMeasure3);
        TextView measure4 = findViewById(R.id.ViewMeasure4);
        TextView measure5 = findViewById(R.id.ViewMeasure5);
        TextView measure6 = findViewById(R.id.ViewMeasure6);
        TextView measure7 = findViewById(R.id.ViewMeasure7);
        TextView measure8 = findViewById(R.id.ViewMeasure8);
        TextView measure9 = findViewById(R.id.ViewMeasure9);
        TextView measure10 = findViewById(R.id.ViewMeasure10);
        TextView measure11 = findViewById(R.id.ViewMeasure11);
        TextView measure12 = findViewById(R.id.ViewMeasure12);
        TextView measure13 = findViewById(R.id.ViewMeasure13);
        TextView measure14 = findViewById(R.id.ViewMeasure14);
        TextView measure15 = findViewById(R.id.ViewMeasure15);

        TextView ingregients1 = findViewById(R.id.viewIngredients1);
        TextView ingregients2 = findViewById(R.id.viewIngredients2);
        TextView ingregients3 = findViewById(R.id.viewIngredients3);
        TextView ingregients4 = findViewById(R.id.viewIngredients4);
        TextView ingregients5 = findViewById(R.id.viewIngredients5);
        TextView ingregients6 = findViewById(R.id.viewIngredients6);
        TextView ingregients7 = findViewById(R.id.viewIngredients7);
        TextView ingregients8 = findViewById(R.id.viewIngredients8);
        TextView ingregients9 = findViewById(R.id.viewIngredients9);
        TextView ingregients10 = findViewById(R.id.viewIngredients10);
        TextView ingregients11 = findViewById(R.id.viewIngredients11);
        TextView ingregients12 = findViewById(R.id.viewIngredients12);
        TextView ingregients13 = findViewById(R.id.viewIngredients13);
        TextView ingregients14 = findViewById(R.id.viewIngredients14);
        TextView ingregients15 = findViewById(R.id.viewIngredients15);



        // set views
        title.setText(pieceRecipe.getitle());
        instructions.setText(pieceRecipe.getInstruction());
        hint.setText(pieceRecipe.getHint());

        ingregients1.setText(pieceRecipe.getIngredients1());
        ingregients2.setText(pieceRecipe.getIngredients2());
        ingregients3.setText(pieceRecipe.getIngredients3());
        ingregients4.setText(pieceRecipe.getIngredients4());

        measure1.setText(pieceRecipe.getMeasure1());
        measure2.setText(pieceRecipe.getMeasure2());
        measure3.setText(pieceRecipe.getMeasure3());
        measure4.setText(pieceRecipe.getMeasure4());

        // not al recipes has more then 5 ingregients, then measure == null, set nothing.
        if (pieceRecipe.getMeasure5() == "null"){
            measure5.setText("");
            ingregients5.setText("");
        }
        else{
            measure5.setText(pieceRecipe.getMeasure5());
            ingregients5.setText(pieceRecipe.getIngredients5());
        }

        if (pieceRecipe.getMeasure6()  == "null"){
            measure6.setText("");
            ingregients6.setText("");
        }
        else{
            measure6.setText(pieceRecipe.getMeasure6());
            ingregients6.setText(pieceRecipe.getIngredients6());
        }

        if (pieceRecipe.getMeasure7()  == "null"){
            measure7.setText("");
            ingregients7.setText("");
        }
        else{
            measure7.setText(pieceRecipe.getMeasure7());
            ingregients7.setText(pieceRecipe.getIngredients7());
        }

        if (pieceRecipe.getMeasure8()  == "null"){
            measure8.setText("");
            ingregients8.setText("");
        }
        else {
            measure8.setText(pieceRecipe.getMeasure8());
            ingregients8.setText(pieceRecipe.getIngredients8());
        }

        if (pieceRecipe.getMeasure9()  == "null"){
            measure9.setText("");
            ingregients9.setText("");
        }
        else {
            measure9.setText(pieceRecipe.getMeasure9());
            ingregients9.setText(pieceRecipe.getIngredients9());
        }

        if (pieceRecipe.getMeasure10()  == "null"){
            measure10.setText("");
            ingregients10.setText("");
        }
        else {
            measure10.setText(pieceRecipe.getMeasure10());
            ingregients10.setText(pieceRecipe.getIngredients10());
        }
        if (pieceRecipe.getMeasure11()  == "null"){
            measure11.setText("");
            ingregients11.setText("");
        }
        else {
            measure11.setText(pieceRecipe.getMeasure11());
            ingregients11.setText(pieceRecipe.getIngredients11());
        }
        if (pieceRecipe.getMeasure12()  == "null"){
            measure12.setText("");
            ingregients12.setText("");
        }
        else {
            measure12.setText(pieceRecipe.getMeasure12());
            ingregients12.setText(pieceRecipe.getIngredients12());
        }

        if (pieceRecipe.getMeasure13()  == "null"){
            measure13.setText("");
            ingregients13.setText("");
        }
        else {
            measure13.setText(pieceRecipe.getMeasure13());
            ingregients13.setText(pieceRecipe.getIngredients13());
        }

        if (pieceRecipe.getMeasure14()  == "null"){
            measure14.setText("");
            ingregients14.setText("");
        }
        else {
            measure14.setText(pieceRecipe.getMeasure14());
            ingregients14.setText(pieceRecipe.getIngredients14());
        }

        if (pieceRecipe.getMeasure15()  == "null"){
            measure15.setText("");
            ingregients15.setText("");
        }
        else {
            measure15.setText(pieceRecipe.getMeasure15());
            ingregients15.setText(pieceRecipe.getIngredients15());
        }

        // download pictue en set image
        DownloadImageTask Image = new DownloadImageTask(picture);
        Image.execute(pieceRecipe.getPicture());

        // get youtubelink
        url = pieceRecipe.getYoutubelink();
    }

    /**
     * Error message, recipe request went wrong.
     *
     * @param message    Error- message.
     */
    @Override
    public void gotRecipeError(String message) {
        Toast.makeText(this, "Please try again", Toast.LENGTH_SHORT).show();
    }


}
