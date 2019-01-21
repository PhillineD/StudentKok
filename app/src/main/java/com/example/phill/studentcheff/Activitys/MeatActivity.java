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

    public void clickBeef(View view) {
        Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
        intent.putExtra("categorie", "Beef");
        startActivity(intent);
        finish();
    }

    public void clickChicken(View view) {
        Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
        intent.putExtra("categorie", "Chicken");
        startActivity(intent);
        finish();
    }

    public void clickLam(View view) {
        Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
        intent.putExtra("categorie", "Lamb");
        startActivity(intent);
        finish();
    }


    public void clickPork(View view) {
        Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
        intent.putExtra("categorie", "Pork");
        startActivity(intent);
        finish();
    }


    public void randomClick(View view) {
        List<String> givenList = Arrays.asList("Beef", "Chicken", "Lamb", "Pork");
        Random rand = new Random();
        String randomElement = givenList.get(rand.nextInt(givenList.size()));
        if (randomElement == "Beef") {
            Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
            intent.putExtra("categorie", "Beef");
            startActivity(intent);
            finish();
        }
        else if (randomElement == "Chicken"){
            Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
            intent.putExtra("categorie", "Chicken");
            startActivity(intent);
            finish();
        }
        else if (randomElement == "Lamb"){
            Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
            intent.putExtra("categorie", "Lamb");
            startActivity(intent);
            finish();
        }
        else if (randomElement == "Pork"){
            Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
            intent.putExtra("categorie", "Pork");
            startActivity(intent);
            finish();
        }
    }

}
