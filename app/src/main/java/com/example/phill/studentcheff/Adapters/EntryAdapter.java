/**
 * Fill the history items in the listview.
 *
 *
 * @author      Philline Dikker
 * @version     1
 *
 *
 * This work complies with the JMU Honor Code.
 */

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

    /**
     * Set history item in listview.
     *
     * @param view    Description of the first parameter
     * @param context    Description of the second parameter
     * @param cursor    Description of the second parameter
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // set title
        TextView title = view.findViewById(R.id.historytitle);
        int indexTitle = cursor.getColumnIndex("title");
        String textTitle = cursor.getString(indexTitle);
        title.setText(textTitle);

        // set rating
        RatingBar rating = view.findViewById(R.id.historyrating);
        int indexRating = cursor.getColumnIndex("rating");
        Float floatRating = cursor.getFloat(indexRating);
        rating.setRating(floatRating);

        //  set date
        TextView history = view.findViewById(R.id.historydate);
        int indexRate = cursor.getColumnIndex("timestamp");
        String date = cursor.getString(indexRate);
        history.setText(date);

        // set picture
        ImageView picture = view.findViewById(R.id.picturehistory);
        DownloadImageTask Image = new DownloadImageTask(picture);
        int indexPicture = cursor.getColumnIndex("picture");
        String url = cursor.getString(indexPicture);
        Image.execute(url);

        // set time cooked
        TextView time = view.findViewById(R.id.cookstime);
        int indexTime = cursor.getColumnIndex("time");
        Float timeCook = cursor.getFloat( indexTime);
        int timeCooking = timeCook.intValue();
        String cooked = Integer.toString(timeCooking);
        time.setText(cooked);
    }
}





