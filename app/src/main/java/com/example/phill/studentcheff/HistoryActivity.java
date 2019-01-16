package com.example.phill.studentcheff;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

public class HistoryActivity extends AppCompatActivity {

    private EntryDatabase db;
    private EntryAdapter adapter;
    String id;
    float stars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);

        ListView history = findViewById(R.id.listviewhistory);
        history.setOnItemClickListener( new ToRecipe());
        SearchView textbox2 = findViewById(R.id.textbox2);

        db = EntryDatabase.getInstance(getApplicationContext());

        Cursor cursor = EntryDatabase.selectAll(db);
        adapter = new EntryAdapter(this, R.layout.history_item, cursor);
        history.setAdapter(adapter);

        textbox2.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newtext ) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                Log.d("morgen", "onQueryTextChange: " + query);
                adapter.getFilter().filter(query);
                return false;
            }
        });

    }

    // method to update every time we save something
    public void updateData(){

        // get new cursor
        Cursor ncursor = EntryDatabase.selectAll(db);

        //  put in a new cursor for the updated data
        adapter.swapCursor(ncursor);
    }

    protected void onResume(){
        super.onResume();
        updateData();
    }

    private class ToRecipe implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor clicked = (Cursor) parent.getItemAtPosition(position);
            String idee = clicked.getString(clicked.getColumnIndex("_id"));
            String url = clicked.getString(clicked.getColumnIndex("picture"));
            Intent intent = new Intent(getApplicationContext(), RecipeActivity.class);
            intent.putExtra("id", idee);
            intent.putExtra("picture", url);
            startActivity(intent);
        }
    }


}
