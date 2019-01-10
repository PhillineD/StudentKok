package com.example.phill.studentcheff;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

public class HistoryActivity extends AppCompatActivity {

    private EntryDatabase db;
    private EntryAdapter adapter;
    String id;
    float stars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);

        // get id from de meal you chosen
//        Intent intent = getIntent();
//        id = intent.getStringExtra("id");
//        stars = intent.getFloatExtra("rating",0.0f);
//
//
//        Log.d("de id", "history: " + id +" "+ stars);

        ListView history = findViewById(R.id.listviewhistory);
        db = EntryDatabase.getInstance(getApplicationContext());

        Cursor cursor = EntryDatabase.selectAll(db);
        adapter = new EntryAdapter(this, R.layout.history_item, cursor);
        history.setAdapter(adapter);

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



}
