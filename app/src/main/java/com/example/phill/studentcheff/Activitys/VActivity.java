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
     * Navigation to MeatActivity, parse the categorie.
     *
     * @param view    Represents a view of the button "Meat".
     */
    public void clickMeat(View view) {
        Intent intent = new Intent(getApplicationContext(), MeatActivity.class);
        intent.putExtra("categorie", "meat");
        startActivity(intent);
        finish();
    }

    /**
     * Navigation to MealsActivity, parse the categorie.
     *
     * @param view    Represents a view of the button "Fish".
     */
    public void clickFish(View view) {
        Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
        intent.putExtra("categorie", "seafood");
        startActivity(intent);
        finish();
    }

    /**
     * Navigation to MealsActivity, parse the categorie.
     *
     * @param view    Represents a view of the button "Vega".
     */
    public void clickVega(View view) {
        Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
        intent.putExtra("categorie", "Vegetarian");
        startActivity(intent);
    }

    /**
     * Navigation to MealsActivity, parse the categorie.
     *
     * @param view    Represents a view of the button "Vegan".
     */
    public void clickVegan(View view) {
        Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
        intent.putExtra("categorie", "Vegan");
        startActivity(intent);
    }

    /**
     * Navigation to random Activity, parse the categorie.
     *
     * @param view    Represents a view of the buttons.
     */
    public void randomV(View view) {
        List<String> givenList = Arrays.asList("meat", "seafood", "Vegetarian","Vegan");
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
}
