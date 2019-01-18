package com.example.phill.studentcheff;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MealsActivity extends Activity implements MealsRequest.Callback{
    SearchView textBox;
    List<String> searchlist= new ArrayList<>();
    String lijstje[];
    ArrayAdapter adapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meals_activity);
        Intent intent = getIntent();
        String message = intent.getStringExtra("categorie");

        MealsRequest requestmeals = new MealsRequest(this);
        requestmeals.getMeals(this, message);

    }

    @Override
    public void gotMeals(final ArrayList<MealItem> meals) {
        Log.d("gotmeals", "gotMeals: we zijn er " + meals);

        final MealAdapter adapter = new MealAdapter(this, meals);
        GridView listView = findViewById(R.id.MealsListView);
        listView.setAdapter(adapter);
//
//
//        Log.d("gotmeals", "hhh" + searchlist);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            // when  clicked on item, go to recipe activity and so recipe
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MealItem chooserecipe = (MealItem) parent.getItemAtPosition(position);
                Intent choosen = new Intent(getApplicationContext(), RecipeActivity.class);
                choosen.putExtra("id", chooserecipe.getId());
                choosen.putExtra("picture", chooserecipe.getPicture());

                // alle waardes moeten doorgegeven worden, dan hoeven ze alleen geplaatst te worden.
                startActivity(choosen);
                finish();
            }
        });

        textBox = (SearchView) findViewById(R.id.editText);
        textBox.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String arg0) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                Log.d("typppeeenn", "onQueryTextChange: " + query);
                adapter.getFilter().filter(query);
                return false;
            }
        });

    }



    @Override
    public void gotMealsError(String message) {
        Log.d("gotmealserror", "gotMeals: we zijn er dus niet "+ message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void clicksearch(View view) {

    }
}
