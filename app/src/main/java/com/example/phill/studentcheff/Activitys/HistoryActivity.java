/**
 * Get the history items form database, search in items and click on them to go to recipe.
 *
 *
 * @author      Philline Dikker
 * @version     1
 *
 *
 * This work complies with the JMU Honor Code.
 */

package com.example.phill.studentcheff.Activitys;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.phill.studentcheff.Adapters.EntryAdapter;
import com.example.phill.studentcheff.Requests.EntryDatabase;
import com.example.phill.studentcheff.R;

public class HistoryActivity extends AppCompatActivity {

    private EntryDatabase db;
    private EntryAdapter adapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);

        ListView history = findViewById(R.id.listviewhistory);
        db = EntryDatabase.getInstance(getApplicationContext());
        Cursor cursor = EntryDatabase.selectAll(db);
        adapter = new EntryAdapter(this, R.layout.history_item, cursor);

        history.setOnItemClickListener( new ToRecipe());
        history.setAdapter(adapter);

    }

    /**
     * When the activity resumes from the background.
     */
    protected void onResume(){
        super.onResume();
        updateData();
    }

    /**
     * Search in history.
     *
     * @param view    Represents a view of the history.
     */
    public void search(View view) {

        EditText findItem = findViewById(R.id.searchbox);

        // user typed nothing, set adapter normal
        if (findItem.getText().toString().equals("")) {
            Cursor cursor = EntryDatabase.selectAll(db);
            adapter.swapCursor(cursor);
            adapter = new EntryAdapter(this, R.layout.history_item, cursor);
            ListView history = findViewById(R.id.listviewhistory);
            history.setAdapter(adapter);

        }

        // user typed , call filter and set adapter
        else{

            String searchTerm = findItem.getText().toString();
            Cursor cursor = EntryDatabase.filterData(db , searchTerm);
            adapter.swapCursor(cursor);

            adapter = new EntryAdapter(this, R.layout.history_item, cursor);
            ListView history = findViewById(R.id.listviewhistory);
            history.setAdapter(adapter);

        }
    }

    /**
     * Update data.
     */
    public void updateData(){

        // get new cursor
        Cursor ncursor = EntryDatabase.selectAll(db);

        //  put in a new cursor for the updated data
        adapter.swapCursor(ncursor);
    }

    /**
     * Navigation to RecipeActivity, if clicked on item.
     */
    private class ToRecipe implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Cursor clicked = (Cursor) parent.getItemAtPosition(position);

            String number = clicked.getString(clicked.getColumnIndex("_id"));
            String url = clicked.getString(clicked.getColumnIndex("picture"));

            Intent intent = new Intent(getApplicationContext(), RecipeActivity.class);
            intent.putExtra("id", number);
            intent.putExtra("picture", url);

            startActivity(intent);
            finish();
        }
    }
}
