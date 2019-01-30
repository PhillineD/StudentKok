/**
 * Get meals from meals request, set them, search in them and click on them.
 *
 *
 * @author      Philline Dikker
 * @version
 *
 *
 * This work complies with the JMU Honor Code.
 */

package com.example.phill.studentcheff.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.phill.studentcheff.Adapters.MealAdapter;
import com.example.phill.studentcheff.Models.MealItem;
import com.example.phill.studentcheff.R;
import com.example.phill.studentcheff.Requests.MealsRequest;

import java.util.ArrayList;


public class MealsActivity extends Activity implements MealsRequest.Callback{
    SearchView textBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meals_activity);
        Intent intent = getIntent();
        String message = intent.getStringExtra("categorie");
        Toast.makeText(this, "Categorie: " + message, Toast.LENGTH_LONG).show();
        MealsRequest requestmeals = new MealsRequest(this);
        requestmeals.getMeals(this, message);

    }

    /**
     * Go the recipe if clicked on a meal item.
     */
    private class Clicked implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            MealItem chooseRecipe = (MealItem) parent.getItemAtPosition(position);
            Intent choosenRecipe = new Intent(getApplicationContext(), RecipeActivity.class);
            choosenRecipe.putExtra("id", chooseRecipe.getId());
            choosenRecipe.putExtra("picture", chooseRecipe.getPicture());
            startActivity(choosenRecipe);
            finish();
        }
    }

    /**
     *  Set meals and  set on query listener.
     *
     * @param  "ArrayList<MealItem> meals"  List of meal items.
     * @return  false
     */
    @Override
    public void gotMeals(final ArrayList<MealItem> meals) {

        MealAdapter adapter = new MealAdapter(this, meals);
        ListView listView = findViewById(R.id.MealsListView);
        listView.setAdapter(adapter);
        listView.getAdapter();
        listView.setOnItemClickListener(new Clicked());

        // find searchview
        textBox = (SearchView) findViewById(R.id.editText);

        // search meal in adapter and filter it
        textBox.setOnQueryTextListener(new searchMeal());
    }

    /**
     * Error message, meals request went wrong.
     *
     * @param message    Error- message.
     */
    @Override
    public void gotMealsError(String message) {
        Toast.makeText(this, "Something went wrong, try again", Toast.LENGTH_SHORT).show();
    }

    /**
     * Search meal in adapter and filter it.
     *
     */
    public class searchMeal implements SearchView.OnQueryTextListener{

        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            ListView list = (ListView) findViewById(R.id.MealsListView);
            MealAdapter adapter = (MealAdapter) list.getAdapter();
            adapter.getFilter().filter(newText);
            return false;
        }
    }
}
