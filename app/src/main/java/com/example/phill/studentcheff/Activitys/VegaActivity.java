package com.example.phill.studentcheff.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.phill.studentcheff.R;

public class VegaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vegan_activity);
    }

    public void clickVega(View view) {
        Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
        intent.putExtra("categorie", "Vegetarian");
        startActivity(intent);
    }

    public void clickVegan(View view) {
        Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
        intent.putExtra("categorie", "Vegan");
        startActivity(intent);
    }
}
