/**
 * Fill the meals items in the listview.
 *
 *
 * @author      Philline Dikker
 * @version
 *
 *
 * This work complies with the JMU Honor Code.
 */


package com.example.phill.studentcheff.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phill.studentcheff.Extra.DownloadImageTask;
import com.example.phill.studentcheff.Models.MealItem;
import com.example.phill.studentcheff.R;

import java.util.ArrayList;


public class MealAdapter extends BaseAdapter implements Filterable {
    ArrayList<MealItem> meals;
    ArrayList<MealItem> filterList;
    CustomFilter filter;
    Context c;


    public MealAdapter(Context context, ArrayList<MealItem> meals   ) {
        this.meals = meals;
        this.c = context;
        this.filterList=meals;
    }

    /**
     * Inner class to filter the meals on what is typed.
     *
     */
    class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {


                ArrayList<MealItem> filters = new ArrayList<MealItem>();

                // get specific items
                for (int i = 0; i < filterList.size(); i++) {
                    if (filterList.get(i).getitle().contains(constraint)) {
                        MealItem p = new MealItem(filterList.get(i).getId(),  filterList.get(i).getPicture(),filterList.get(i).getitle()) {
                        };

                        filters.add(p);
                    }
                }

                results.count = filters.size();
                results.values = filters;
            } else {
                results.count = filterList.size();
                results.values = filterList;

            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            meals = (ArrayList<MealItem>) results.values;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return meals.size();
    }

    @Override
    public Object getItem(int position) {
        return meals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return meals.indexOf(getItem(position));
    }

    /**
     * Dependent on view set meal.
     *
     * @param position      Position from view.
     * @param convertView    View from layout.
     * @param parent
     * @return  convertView
     *
     **/
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater =(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.meals_item, parent, false);
        }

        // set picture en title
        ImageView picture = convertView.findViewById(R.id.Picture);
        TextView recipe = convertView.findViewById(R.id.Recipe);
        recipe.setText(meals.get(position).getitle());

        DownloadImageTask Image = new DownloadImageTask(picture);
        Image.execute(meals.get(position).getPicture());

        return convertView;

    }

    /**
     * Make custom filter if something is typed.
     *
     **/
    public Filter getFilter(){

        if(filter == null)
        {
            filter=new CustomFilter();
        }

        return filter;

    }


}
