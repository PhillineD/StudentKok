package com.example.phill.studentcheff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MeatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meat_activity);
    }

    public void clickbeef(View view) {
        Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
        intent.putExtra("categorie", "Beef");
        startActivity(intent);
        finish();
    }

    public void clickchicken(View view) {
        Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
        intent.putExtra("categorie", "Chicken");
        startActivity(intent);
        finish();
    }

    public void clicklam(View view) {
        Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
        intent.putExtra("categorie", "Lamb");
        startActivity(intent);
        finish();
    }


    public void clickpork(View view) {
        Intent intent = new Intent(getApplicationContext(), MealsActivity.class);
        intent.putExtra("categorie", "Pork");
        startActivity(intent);
        finish();
    }
}
