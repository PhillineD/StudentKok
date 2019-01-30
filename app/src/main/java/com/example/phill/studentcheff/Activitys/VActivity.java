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
            Intent intent = new Intent(getApplicationContext(), MeatActivity.class);
            intent.putExtra("categorie", "meat");
            startActivity(intent);
            finish();
        }

        // navigate to MealsActivity parse categorie
        else if (v.getId() == R.id.seafood){
            Intent intent1 = new Intent(getApplicationContext(), MealsActivity.class);
            intent1.putExtra("categorie", "seafood");
            startActivity(intent1);
            finish();
        }

        // navigate to MealsActivity parse categorie
        else if (v.getId() == R.id.Vegan){
            Intent intent3 = new Intent(getApplicationContext(), MealsActivity.class);
            intent3.putExtra("categorie", "Vegan");
            startActivity(intent3);
            finish();
        }

        // navigate to MealsActivity parse categorie
        else if (v.getId() == R.id.Vegetarian){
            Intent intent2 = new Intent(getApplicationContext(), MealsActivity.class);
            intent2.putExtra("categorie", "Vegetarian");
            startActivity(intent2);
            finish();
        }
    }
}
