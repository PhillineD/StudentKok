package com.example.phill.studentcheff;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MealsActivity extends AppCompatActivity implements MealsRequest.Callback{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meals_activity);

        MealsRequest ArrayAdapter = new MealsRequest(this);
        ArrayAdapter.getMeals(this);

    }

    @Override
    public void gotMeals(ArrayList<String> meals) {
        Toast.makeText(this, meals.get(0),Toast.LENGTH_LONG).show();
        Log.d("gotmeals", "gotMeals: we zijn er ");
    }

    @Override
    public void gotMealsError(String message) {
        Log.d("gotmealserror", "gotMeals: we zijn er dus niet ");
    }
}
