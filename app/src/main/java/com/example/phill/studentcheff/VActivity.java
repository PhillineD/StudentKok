package com.example.phill.studentcheff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class VActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.v_activity);
    }

    public void clickmeat(View view) {
        Intent intent = new Intent(getApplicationContext(), MeatActivity.class);
        intent.putExtra("categorie", "meat");
        startActivity(intent);
    }

    public void clickfish(View view) {
        Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
        intent.putExtra("categorie", "seafood");

        startActivity(intent);
    }

    public void clickvega(View view) {
        Intent intent = new Intent(getApplicationContext(), VegaActivity.class);
        intent.putExtra("categorie", "vega");
        startActivity(intent);
    }

}
