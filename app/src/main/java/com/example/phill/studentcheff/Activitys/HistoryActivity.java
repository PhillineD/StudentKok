/**
 * Get the history items form database, search in items and click on them to go to recipe.
 *
 *
 * @author      Philline Dikker
 * @version
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
        history.setOnItemClickListener( new ToRecipe());
        db = EntryDatabase.getInstance(getApplicationContext());

        Cursor cursor = EntryDatabase.selectAll(db);
        adapter = new EntryAdapter(this, R.layout.history_item, cursor);
        history.setAdapter(adapter);

    }

    /**
     * This is where the description of the method goes.
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

        EditText zoeken = findViewById(R.id.searchbox);

        // if edittext is empthy
        if (zoeken.getText().toString().equals("")) {
            Cursor cursor = EntryDatabase.selectAll(db);
            adapter.swapCursor(cursor);
            adapter = new EntryAdapter(this, R.layout.history_item, cursor);
            ListView history = findViewById(R.id.listviewhistory);
            history.setAdapter(adapter);

        }
        else{

            String searchTerm = zoeken.getText().toString();
            Cursor cursor = EntryDatabase.filterData(db , searchTerm);
            adapter.swapCursor(cursor);

            adapter = new EntryAdapter(this, R.layout.history_item, cursor);
            ListView history = findViewById(R.id.listviewhistory);
            history.setAdapter(adapter);

        }
    }

    /**
     * This is where the description of the method goes.
     */
    public void updateData(){

        // get new cursor
        Cursor ncursor = EntryDatabase.selectAll(db);

        //  put in a new cursor for the updated data
        adapter.swapCursor(ncursor);
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
            finish();
        }
    }


}
