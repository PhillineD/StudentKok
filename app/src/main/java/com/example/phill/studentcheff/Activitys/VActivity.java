/**
 * Navigation class choose between meat, fish, vega or random.
 *
 *
 * @author      Philline Dikker
 * @version     1
 *
 *
 * This work complies with the JMU Honor Code.
 */

package com.example.phill.studentcheff.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.phill.studentcheff.R;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.v_activity);
    }

    /**
     * Navigation to the right Activity, parse the categorie.
     *
     * @param v   Represents a view of the button "Meat".
     */
    public void onClick(View v) {

        // get random categorie and navigate
        if (v.getId() == R.id.randomv){
            List<String> givenList = Arrays.asList("meat", "seafood", "Vegetarian","Vegan");

            // get random categorie
            Random rand = new Random();
            String randomElement = givenList.get(rand.nextInt(givenList.size()));

            if (randomElement == "meat") {
                Intent intent = new Intent(getApplicationContext(), MeatActivity.class);
                intent.putExtra("categorie", "meat");
                startActivity(intent);
                finish();
            }
            else{
                Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
                intent.putExtra("categorie", randomElement);
                startActivity(intent);
                finish();
            }
        }

        // navigate to MeatActivity parse categorie
        else if (v.getId() == R.id.meat){
            Intent intentMeat = new Intent(getApplicationContext(), MeatActivity.class);
            intentMeat.putExtra("categorie", "meat");
            startActivity(intentMeat);
            finish();
        }

        // navigate to MealsActivity parse categorie
        else if (v.getId() == R.id.seafood){
            Intent intentSeafood = new Intent(getApplicationContext(), MealsActivity.class);
            intentSeafood.putExtra("categorie", "seafood");
            startActivity(intentSeafood);
            finish();
        }

        // navigate to MealsActivity parse categorie
        else if (v.getId() == R.id.Vegan){
            Intent intentVegan = new Intent(getApplicationContext(), MealsActivity.class);
            intentVegan.putExtra("categorie", "Vegan");
            startActivity(intentVegan);
            finish();
        }

        // navigate to MealsActivity parse categorie
        else if (v.getId() == R.id.Vegetarian){
            Intent intentVegetarian = new Intent(getApplicationContext(), MealsActivity.class);
            intentVegetarian.putExtra("categorie", "Vegetarian");
            startActivity(intentVegetarian);
            finish();
        }
    }
}
