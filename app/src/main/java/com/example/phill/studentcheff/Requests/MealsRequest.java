package com.example.phill.studentcheff.Requests;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.phill.studentcheff.Models.MealItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MealsRequest implements Response.Listener<JSONObject>, Response.ErrorListener{


    private Callback activity;
    private Context context;


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
        String url = "https://www.themealdb.com/api/json/v1/1/filter.php?c="+ message;
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
        try {
            JSONArray meal = response.getJSONArray("meals");

            for(int i =0;i<meal.length();i++){

                JSONObject mealitems = meal.getJSONObject(i);

                // get title, id and picture
                String titlerecipe = mealitems.getString("strMeal");
                String id = mealitems.getString("idMeal");
                String picture = mealitems.getString("strMealThumb");

                // new Mealitem
                MealItem item = new MealItem(id,picture,titlerecipe);
                mealsview.add(item);
            }

            this.activity.gotMeals(mealsview);

        } catch (JSONException e) {
            e.printStackTrace();

        }

    }
}
