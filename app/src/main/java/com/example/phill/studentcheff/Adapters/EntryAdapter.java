package com.example.phill.studentcheff.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import com.example.phill.studentcheff.Extra.DownloadImageTask;
import com.example.phill.studentcheff.R;


public class EntryAdapter extends ResourceCursorAdapter implements Filterable{
    public EntryAdapter(Context context, int layout, Cursor cursor) {
        super(context, layout, cursor);
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // set title
        TextView title = view.findViewById(R.id.historytitle);
        int indextitle = cursor.getColumnIndex("title");
        String texttitle = cursor.getString(indextitle);
        title.setText(texttitle);

        // set rating
        RatingBar rating = view.findViewById(R.id.historyrating);
        int indexrating = cursor.getColumnIndex("rating");
        Float floatrating = cursor.getFloat(indexrating);
        rating.setRating(floatrating);

        //  set date
        TextView history = view.findViewById(R.id.historydate);
        int indexdate = cursor.getColumnIndex("timestamp");
        String date = cursor.getString(indexdate);
        history.setText(date);

        // set picture
        ImageView picture = view.findViewById(R.id.picturehistory);
        DownloadImageTask Image = new DownloadImageTask(picture);
        int indexpicture = cursor.getColumnIndex("picture");
        String url = cursor.getString(indexpicture);
        Image.execute(url);

        // set cooks  in time
        TextView time = view.findViewById(R.id.cookstime);
        int indextime = cursor.getColumnIndex("time");
        Float timecook = cursor.getFloat( indextime);
        int timecooking = timecook.intValue();
        String cooked = Integer.toString(timecooking);
        time.setText(cooked);

    }


}





