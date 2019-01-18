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

public class RecipeRequest implements Response.Listener<JSONObject>, Response.ErrorListener {

    private Callback activity;
    private Context context;

    public interface Callback{
        void gotRecipe(ArrayList<Meal> meals);
        void gotRecipeError(String message);
    }

    public RecipeRequest(Context context){
        this.context = context;
    }

    public void getRecipe(Callback activity, String id){
        this.activity = activity;
        RequestQueue queue = Volley.newRequestQueue(this.context);
        Log.d("foutje", "onResponse: " + id);

        // create a JsonObjectRequest
        String url = "https://www.themealdb.com/api/json/v1/1/lookup.php?i="+ id;
        Log.d("foutje", "onResponse: " + url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        this.activity.gotRecipeError(error.getMessage());
    }

    @Override
    public void onResponse(JSONObject response) {
        ArrayList<Meal> recipeview = new ArrayList<Meal>();
        Log.d("gotmeals", "aaa");
        try {
            JSONArray meal = response.getJSONArray("meals");

            for(int i =0;i<meal.length();i++){
                Log.d("gotmeals", "gotMeals: we zijn er "+ meal.get(i));

                JSONObject mealitems = meal.getJSONObject(i);

                // get title, id and picture
                String id = mealitems.getString("idMeal");
                String titlerecipe = mealitems.getString("strMeal");
                String instructions = mealitems.getString("strInstructions");
                String hit = mealitems.getString("strCategory");

                String youtube = mealitems.getString("strYoutube");
                String picture = mealitems.getString("strMealThumb");
                String measure1 = mealitems.getString("strMeasure1");
                String measure2 = mealitems.getString("strMeasure2");
                String measure3 = mealitems.getString("strMeasure3");
                String measure4 = mealitems.getString("strMeasure4");
                String measure5 = mealitems.getString("strMeasure5");
                String measure6 = mealitems.getString("strMeasure6");
                String measure7 = mealitems.getString("strMeasure7");
                String measure8 = mealitems.getString("strMeasure8");


                String ingredient1 = mealitems.getString("strIngredient1");
                String ingredient2 = mealitems.getString("strIngredient2");
                String ingredient3 = mealitems.getString("strIngredient3");
                String ingredient4 = mealitems.getString("strIngredient4");
                String ingredient5 = mealitems.getString("strIngredient5");
                String ingredient6 = mealitems.getString("strIngredient6");
                String ingredient7 = mealitems.getString("strIngredient7");
                String ingredient8 = mealitems.getString("strIngredient8");


                Log.d("meten", "onResponse: " + measure1);

                // new Mealitem
                Meal item = new Meal(id,ingredient1,instructions,youtube,picture, titlerecipe,
                        measure1,ingredient2 , measure2, ingredient3 , measure3, ingredient4 , measure4,
                        ingredient5 , measure5, ingredient6 , measure6, ingredient7 , measure7, ingredient8 , measure8, hit);

                Log.d("gotmeals", "joejoe: we zijn er "+ item.getHint() + item.getitle() + item.getPicture() + item.getMeasure1());
                recipeview.add(item);
            }

            this.activity.gotRecipe(recipeview);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
