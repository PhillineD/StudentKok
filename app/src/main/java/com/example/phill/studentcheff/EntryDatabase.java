package com.example.phill.studentcheff;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class EntryDatabase extends SQLiteOpenHelper {

    public EntryDatabase( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static EntryDatabase instance;
    // elke keer als je iets aanpas de app leeg maken.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String  message = "CREATE TABLE " + "Studentchef" + "( _id STRING, title TEXT, picture STRING, rating FLOAT , " +
                "timestamp DATETIME default (datetime('now','localtime'))) ";
        db.execSQL(message);

//        INTEGER PRIMARY KEY AUTOINCREMENT
        // create a new ContentValues object
        ContentValues contentvalue = new ContentValues();

        // example for history
        contentvalue.put("_id", 1234);
        contentvalue.put("title", "Hallo");
        contentvalue.put("rating", 2);
        contentvalue.put("picture","https://www.themealdb.com//images//media//meals//1525873040.jpg");


        // call insert and add the right parameters
        db.insert("Studentchef", null, contentvalue);

        Log.d("databse", "onCreate: " + db);

    }

    public static EntryDatabase getInstance(Context context){

        if(EntryDatabase.instance == null){
            EntryDatabase.instance = new EntryDatabase(context,"Studentchef", null ,1);
        }
        return EntryDatabase.instance;

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //          drops the entries table
        db.execSQL("DROP TABLE IF EXISTS "+ "Studentchef");

//        recreates it by calling
        onCreate(db );
    }

    // select all info from database
    public static Cursor selectAll(EntryDatabase instance){
        SQLiteDatabase database = instance.getWritableDatabase();
        return database.rawQuery("SELECT * FROM "+ "Studentchef", null );
    }


    // method to insert a history item
    public void insert(String id, String title, Float rating, String picture){
        // open a connection to the database
        SQLiteDatabase db = instance.getWritableDatabase();

        // create a new ContentValues object
        ContentValues contentvalue = new ContentValues();

        // check if the recipe is alreaedy in database
//        db.rawQuery( "SELECT * from Studentchef WHERE _id LIKE'%"+id+"%'",null) ;


        // add values for title, content and mood.
        contentvalue.put("_id", id);
        contentvalue.put("title", title);
        contentvalue.put("rating", rating);
        contentvalue.put("picture",picture );

        // call insert and add the right parameters
        db.insert("Studentchef", null, contentvalue);

    }



}
