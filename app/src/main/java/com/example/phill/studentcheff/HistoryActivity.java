package com.example.phill.studentcheff;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private EntryDatabase db;
    private EntryAdapter adapter;
    String id;
    ArrayList< String> listItem;
    float stars;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);

        ListView history = findViewById(R.id.listviewhistory);
        history.setOnItemClickListener( new ToRecipe());
        SearchView textbox2 = findViewById(R.id.searchbox);

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
                Log.d("morgen", "onQueryTextChange: " + query + db.getWritableDatabase());
//                adapter.getFilter().filter(query);
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

    // filter adapter
    public void search(View view) {

        SearchView zoeken = findViewById(R.id.searchbox);
        if (zoeken != null) {
            String searchTerm = zoeken.getQuery().toString();
            EntryDatabase.filteren(searchTerm);
            Cursor cursor = EntryDatabase.selectAll(db);
            adapter.swapCursor(cursor);

            adapter = new EntryAdapter(this, R.layout.history_item, cursor);
            ListView history = findViewById(R.id.listviewhistory);
            history.setAdapter(adapter);

            //  put in a new cursor for the updated data
            Log.d("Philline", "search: " + zoeken.getQuery().toString());
        }
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
