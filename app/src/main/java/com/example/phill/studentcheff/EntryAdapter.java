package com.example.phill.studentcheff;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.RatingBar;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EntryAdapter extends ResourceCursorAdapter {
    public EntryAdapter(Context context, int layout, Cursor cursor) {
        super(context, layout, cursor);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView title = view.findViewById(R.id.historytitle);
        int indextitle = cursor.getColumnIndex("title");
        String texttitle = cursor.getString(indextitle);
        title.setText(texttitle);

        RatingBar rating = view.findViewById(R.id.historyrating);
        int indexrating = cursor.getColumnIndex("rating");
        Float floatrating = cursor.getFloat(indexrating);
        rating.setRating(floatrating);


    }
}