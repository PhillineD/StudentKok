package com.example.phill.studentcheff;

import android.content.Context;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

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
    String add;

    public interface Callback{
        void gotMeals(ArrayList<MealItem> meals);
        void gotMealsError(String message);
    }

    public MealsRequest(Context context){
        this.context = context;
    }

    public void getMeals(Callback activity, String message){
        this.activity =activity;
        RequestQueue queue = Volley.newRequestQueue(this.context);
        Log.d("foutje", "onResponse: " + message);
        // create a JsonObjectRequest
        String url = "https://www.themealdb.com/api/json/v1/1/filter.php?c="+ message;
        Log.d("foutje", "onResponse: " + url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        this.activity.gotMealsError(error.getMessage());
    }

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<MealItem> mealsview = new ArrayList<MealItem>();
        Log.d("gotmeals", "aaa");
        try {
            JSONArray meal = response.getJSONArray("meals");

            for(int i =0;i<meal.length();i++){
                Log.d("gotmeals", "gotMeals: we zijn er "+ meal.get(i));

                JSONObject mealitems = meal.getJSONObject(i);

                // get title, id and picture
                String titlerecipe = mealitems.getString("strMeal");
                String id = mealitems.getString("idMeal");
                String picture = mealitems.getString("strMealThumb");

                // new Mealitem
                MealItem item = new MealItem(id,picture,titlerecipe);

                Log.d("gotmeals", "joejoe: we zijn er "+ item.getId() + item.getitle() + item.getPicture());
                mealsview.add(item);
            }

            this.activity.gotMeals(mealsview);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
