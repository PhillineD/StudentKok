/**
 * Navigation class, choose the kinds of meat or choose random.
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

public class MeatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meat_activity);
    }

    /**
     * Navigation to right activity, parse the categorie.
     *
     * @param v    Represents a view of the buttons.
     */
    public void onClick(View v) {
        switch (v.getId()) {

            // get random meat element and navigate
            case R.id.randommeat:
                // list with all posible categories
                List<String> givenList = Arrays.asList("Beef", "Chicken", "Lamb", "Pork");

                // get a random element from the list
                Random rand = new Random();
                String randomElement = givenList.get(rand.nextInt(givenList.size()));

                // dependent on random element, navigate to MealsActivity with right categorie
                Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
                intent.putExtra("categorie", randomElement);
                startActivity(intent);
                finish();
                break;

            // navigate to MealsActivity parse categorie
            case R.id.Lam:
                Intent intent1 = new Intent(getApplicationContext(), MealsActivity.class);
                intent1.putExtra("categorie", "Lamb");
                startActivity(intent1);
                finish();
                break;

            // navigate to MealsActivity parse categorie
            case R.id.Chicken:
                Intent intent2 = new Intent(getApplicationContext(), MealsActivity.class);
                intent2.putExtra("categorie", "Chicken");
                startActivity(intent2);
                finish();
                break;

            // navigate to MealsActivity parse categorie
            case R.id.Pork:
                Intent intent3 = new Intent(getApplicationContext(), MealsActivity.class);
                intent3.putExtra("categorie", "Pork");
                startActivity(intent3);
                finish();
                break;

            // navigate to MealsActivity parse categorie
            case R.id.Beef:
                Intent intent4 = new Intent(getApplicationContext(), MealsActivity.class);
                intent4.putExtra("categorie", "Beef");
                startActivity(intent4);
                finish();
                break;

        }
    }
}
