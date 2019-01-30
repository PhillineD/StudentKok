/**
 * Request for recipe form: The MealDatabase.
 *
 *
 * @author      Philline Dikker
 * @version     1
 *
 *
 * This work complies with the JMU Honor Code.
 */

package com.example.phill.studentcheff.Requests;

import android.content.Context;

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
        ArrayList<Meal> recipeView = new ArrayList<Meal>();
        int i;

        try {
            JSONArray meal = response.getJSONArray("meals");

            for(i =0;i<meal.length();i++){

                JSONObject mealItems = meal.getJSONObject(i);

                // get title, id and picture
                String id = mealItems.getString("idMeal");
                String titlerecipe = mealItems.getString("strMeal");
                String instructions = mealItems.getString("strInstructions");
                String hit =mealItems.getString("strCategory");

                String youtube = mealItems.getString("strYoutube");
                String picture = mealItems.getString("strMealThumb");
                String measure1 = mealItems.getString("strMeasure1");
                String measure2 = mealItems.getString("strMeasure2");
                String measure3 = mealItems.getString("strMeasure3");
                String measure4 = mealItems.getString("strMeasure4");
                String measure5 = mealItems.getString("strMeasure5");
                String measure6 = mealItems.getString("strMeasure6");
                String measure7 = mealItems.getString("strMeasure7");
                String measure8 = mealItems.getString("strMeasure8");
                String measure9 = mealItems.getString("strMeasure9");
                String measure10 = mealItems.getString("strMeasure10");
                String measure11 = mealItems.getString("strMeasure11");
                String measure12 = mealItems.getString("strMeasure12");
                String measure13 = mealItems.getString("strMeasure13");
                String measure14 = mealItems.getString("strMeasure14");
                String measure15 = mealItems.getString("strMeasure15");
                String measure16 = mealItems.getString("strMeasure16");
                String measure17 = mealItems.getString("strMeasure17");
                String measure18 = mealItems.getString("strMeasure18");

                String ingredient1 = mealItems.getString("strIngredient1");
                String ingredient2 = mealItems.getString("strIngredient2");
                String ingredient3 = mealItems.getString("strIngredient3");
                String ingredient4 = mealItems.getString("strIngredient4");
                String ingredient5 = mealItems.getString("strIngredient5");
                String ingredient6 = mealItems.getString("strIngredient6");
                String ingredient7 = mealItems.getString("strIngredient7");
                String ingredient8 = mealItems.getString("strIngredient8");
                String ingredient9 = mealItems.getString("strIngredient9");
                String ingredient10 = mealItems.getString("strIngredient10");
                String ingredient11 = mealItems.getString("strIngredient11");
                String ingredient12 = mealItems.getString("strIngredient12");
                String ingredient13 = mealItems.getString("strIngredient13");
                String ingredient14 = mealItems.getString("strIngredient14");
                String ingredient15 = mealItems.getString("strIngredient15");
                String ingredient16 = mealItems.getString("strIngredient16");
                String ingredient17 = mealItems.getString("strIngredient17");
                String ingredient18 = mealItems.getString("strIngredient18");


                // new Mealitem
                Meal item = new Meal(id,ingredient1,instructions,youtube,picture, titlerecipe,
                        measure1,ingredient2 , measure2, ingredient3 , measure3, ingredient4 , measure4,
                        ingredient5 , measure5, ingredient6 , measure6, ingredient7 , measure7, ingredient8 , measure8,
                        ingredient9 , measure9,ingredient10 , measure10, ingredient11 , measure11 , ingredient12 , measure12,
                        ingredient13 , measure13, ingredient14 , measure14, ingredient15 , measure15, ingredient16 , measure16
                        , ingredient17 , measure17, ingredient18 , measure18, hit);
                recipeView.add(item);
            }

            this.activity.gotRecipe(recipeView);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
