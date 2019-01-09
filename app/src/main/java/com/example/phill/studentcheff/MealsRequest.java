package com.example.phill.studentcheff;

import android.content.Context;
import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


import org.json.JSONObject;

import javax.security.auth.callback.Callback;

public class MealsRequest implements Response.Listener<JSONObject>, Response.ErrorListener{

    private Callback activity;
    private Context context;

    public interface Callback{
        void gotMeals(ArrayList<String> meals);
        void gotMealsError(String message);
    }

    public MealsRequest(Context context){
        this.context = context;
    }

    public void getMeals(Callback activity){
        this.activity =activity;

        RequestQueue queue = Volley.newRequestQueue(this.context);
        Log.d("foutje", "onResponse: ");
        // create a JsonObjectRequest
        String url = "https://www.themealdb.com/api/json/v1/1/filter.php?c=Seafood";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        this.activity.gotMealsError(error.getMessage());
    }

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<String> mealsview = new ArrayList<String>();
        Log.d("gotmeals", "aaa");
        try {
            JSONArray meal = response.getJSONArray("meals");

//            Log.d("gotmeals", "npway "+ meal.length());
            for(int i =0;i<meal.length();i++){
                Log.d("gotmeals", "gotMeals: we zijn er "+ meal.get(i));
                String MealString = (String) meal.get(i);
                mealsview.add(MealString);
            }

            this.activity.gotMeals(mealsview);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
