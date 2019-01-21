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

    public void clickMeat(View view) {
        Intent intent = new Intent(getApplicationContext(), MeatActivity.class);
        intent.putExtra("categorie", "meat");
        startActivity(intent);
        finish();
    }

    public void clickFish(View view) {
        Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
        intent.putExtra("categorie", "seafood");
        startActivity(intent);
        finish();
    }

    public void clickVega(View view) {
        Intent intent = new Intent(getApplicationContext(), VegaActivity.class);
        intent.putExtra("categorie", "vega");
        startActivity(intent);
        finish();
    }

    public void randomV(View view) {
        List<String> givenList = Arrays.asList("meat", "seafood", "vega");
        Random rand = new Random();
        String randomElement = givenList.get(rand.nextInt(givenList.size()));
        if (randomElement == "meat") {
            Intent intent = new Intent(getApplicationContext(), MeatActivity.class);
            intent.putExtra("categorie", "meat");
            startActivity(intent);
            finish();
        }
        else if (randomElement == "seafood"){
            Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
            intent.putExtra("categorie", "seafood");
            startActivity(intent);
            finish();
        }
        else if (randomElement == "vega"){
            Intent intent = new Intent(getApplicationContext(), VegaActivity.class);
            intent.putExtra("categorie", "vega");
            startActivity(intent);
            finish();
        }


    }
}
