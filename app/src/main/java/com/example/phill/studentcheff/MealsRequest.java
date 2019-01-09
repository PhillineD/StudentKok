package com.example.phill.studentcheff;

import android.content.Context;
import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


import org.json.JSONObject;

import javax.security.auth.callback.Callback;

public class MealsRequest implements Response.Listener<JSONObject>, Response.ErrorListener{

    private Callback activity;
    private Context context;

    public interface Callback{
        void gotMeals(ArrayList<String> categories);
        void gotMealsError(String message);
    }

    public MealsRequest(Context context){
        this.context = context;
    }

    public void getMeals(Callback activity){
        this.activity =activity;

        RequestQueue queue = Volley.newRequestQueue(this.context);

        // create a JsonObjectRequest
        String url = "https://www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
        queue.add(jsonObjectRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        this.activity.gotMealsError(error.getMessage());
    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
