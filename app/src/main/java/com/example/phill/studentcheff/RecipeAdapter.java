package com.example.phill.studentcheff;

import android.content.ClipData;
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

public class RecipeAdapter extends  ArrayAdapter<Meal> {
    ArrayList<Meal> recipe;

    public RecipeAdapter(Context context, int resource, ArrayList<Meal> objects) {
        super(context, resource, objects);
        recipe = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.recipe_activity, parent, false);
        }

        TextView title = convertView.findViewById(R.id.viewRecipeTitle);
        TextView ingregients = convertView.findViewById(R.id.viewIngredients1);
        TextView instructions = convertView.findViewById(R.id.viewinstructions);
        ImageView picture = convertView.findViewById(R.id.picturerecipe);

        Meal piece = getItem(position);

        title.setText(piece.getitle());
        ingregients.setText(piece.getIngredients1());
        instructions.setText(piece.getInstruction());


        DownloadImageTask Image = new DownloadImageTask(picture);
        String url = piece.getPicture();
        Image.execute(url);

//          recipe.setText(piece.getPicture());
        Log.d("MenuItemAdapter", "Piece = " + piece.getitle());

        return convertView;


    }

}
