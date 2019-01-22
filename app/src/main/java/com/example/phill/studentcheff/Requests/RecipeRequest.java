/**
 * Request for recipe form: The MealDatabase.
 *
 *
 * @author      Philline Dikker
 * @version
 *
 *
 * This work complies with the JMU Honor Code.
 */

package com.example.phill.studentcheff.Requests;
import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.phill.studentcheff.Models.Meal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RecipeRequest implements Response.Listener<JSONObject>, Response.ErrorListener {

    private Callback activity;
    private Context context;

    public RecipeRequest(Context context){
        this.context = context;
    }

    public interface Callback{
        void gotRecipe(ArrayList<Meal> meals);
        void gotRecipeError(String message);
    }

    /**
     * Request for recipe with right id.
     *
     * @param activity   The right Activity.
     * @param id        the chosen recipe has an id.
     */
    public void getRecipe(Callback activity, String id){
        this.activity = activity;
        RequestQueue queue = Volley.newRequestQueue(this.context);

        // create a JsonObjectRequest
        String url = "https://www.themealdb.com/api/json/v1/1/lookup.php?i="+ id;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);
    }


    /**
     * Send error message if requst went wrong.
     *
     * @param error  Error why request went wrong.
     */
    @Override
    public void onErrorResponse(VolleyError error) {
        this.activity.gotRecipeError(error.getMessage());
    }



    /**
     * Get recipe items from API.
     *
     * @param response Response from API.
     */
    @Override
    public void onResponse(JSONObject response) {
        ArrayList<Meal> recipeview = new ArrayList<Meal>();

        try {
            JSONArray meal = response.getJSONArray("meals");

            for(int i =0;i<meal.length();i++){

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
                String measure9 = mealitems.getString("strMeasure9");
                String measure10 = mealitems.getString("strMeasure10");
                String measure11 = mealitems.getString("strMeasure11");
                String measure12 = mealitems.getString("strMeasure12");
                String measure13 = mealitems.getString("strMeasure13");
                String measure14 = mealitems.getString("strMeasure14");
                String measure15 = mealitems.getString("strMeasure15");

                String ingredient1 = mealitems.getString("strIngredient1");
                String ingredient2 = mealitems.getString("strIngredient2");
                String ingredient3 = mealitems.getString("strIngredient3");
                String ingredient4 = mealitems.getString("strIngredient4");
                String ingredient5 = mealitems.getString("strIngredient5");
                String ingredient6 = mealitems.getString("strIngredient6");
                String ingredient7 = mealitems.getString("strIngredient7");
                String ingredient8 = mealitems.getString("strIngredient8");
                String ingredient9 = mealitems.getString("strIngredient9");
                String ingredient10 = mealitems.getString("strIngredient10");
                String ingredient11 = mealitems.getString("strIngredient11");
                String ingredient12 = mealitems.getString("strIngredient12");
                String ingredient13 = mealitems.getString("strIngredient13");
                String ingredient14 = mealitems.getString("strIngredient14");
                String ingredient15 = mealitems.getString("strIngredient15");


                Log.d("hallo", "onResponse: " + ingredient11 + measure12);
                // new Mealitem
                Meal item = new Meal(id,ingredient1,instructions,youtube,picture, titlerecipe,
                        measure1,ingredient2 , measure2, ingredient3 , measure3, ingredient4 , measure4,
                        ingredient5 , measure5, ingredient6 , measure6, ingredient7 , measure7, ingredient8 , measure8,
                        ingredient9 , measure9,ingredient10 , measure10, ingredient11 , measure11 , ingredient12 , measure12,
                        ingredient13 , measure13, ingredient14 , measure14, ingredient15 , measure15, hit);
                recipeview.add(item);
            }

            this.activity.gotRecipe(recipeview);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
