package com.example.phill.studentcheff;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MealAdapter extends ArrayAdapter<MealItem> {
    ArrayList<MealItem> meals;

    public MealAdapter(Context context, int resource, ArrayList<MealItem> objects) {
        super(context, resource, objects);
        meals = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.meals_item, parent, false);
        }

        ImageView picture = convertView.findViewById(R.id.Picture);
        TextView recipe = convertView.findViewById(R.id.Recipe);


        MealItem piece = getItem(position);
        recipe.setText(piece.getitle());
//        recipe.setText(piece.getPicture());
        Log.d("MenuItemAdapter", "Piece = " + piece.getitle());

        DownloadImageTask Image = new DownloadImageTask(picture);
        Image.execute(piece.getPicture());

        return convertView;


    }
}
