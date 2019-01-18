package com.example.phill.studentcheff;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

import static android.icu.text.MessagePattern.ArgType.SELECT;

public class EntryDatabase extends SQLiteOpenHelper {

    ArrayList<HistoryItem> filterList;

    public EntryDatabase( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    private static EntryDatabase instance;



    // elke keer als je iets aanpas de app leeg maken.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String  message = "CREATE TABLE " + "Studentchef" + "( _id STRING PRIMARY KEY, title TEXT, picture STRING,hint STRING ,rating FLAOT, " +
                "timestamp DATETIME default (datetime('now','localtime'))) ";
        db.execSQL(message);

//        INTEGER PRIMARY KEY AUTOINCREMENT
        // create a new ContentValues object
        ContentValues contentvalue = new ContentValues();

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

        String sort = "SELECT * FROM "+" Studentchef "+" ORDER BY "+"rating "+"DESC";
        db.execSQL(sort);

//        recreates it by calling
        onCreate(db );
    }

    // select all info from database
    public static Cursor selectAll(EntryDatabase instance){
        SQLiteDatabase database = instance.getWritableDatabase();
        return database.rawQuery("SELECT * FROM "+ "Studentchef "+" ORDER BY "+"rating "+"DESC" , null );
    }

    public static  Cursor filteren (EntryDatabase instance, String woord){
        SQLiteDatabase database = instance.getWritableDatabase();
        return database.rawQuery("SELECT * FROM  Studentchef WHERE  title  = '"+woord+"' OR timestamp ='"+woord+"' OR hint= '"+woord+"'", null );
    }



    // method to insert a history item
    public void insert(String id, String title, Float rating, String picture, String Catergorie){
        // open a connection to the database
        SQLiteDatabase db = instance.getWritableDatabase();

        // create a new ContentValues object
        ContentValues contentvalue = new ContentValues();

        // check if the recipe is alreaedy in database
        String sort = "DELETE FROM Studentchef WHERE _id = '"+id+"'";
        db.execSQL(sort);

        // add values for title, content and mood.
        contentvalue.put("_id", id);
        contentvalue.put("title", title);
        contentvalue.put("rating", rating);
        contentvalue.put("picture",picture );
        contentvalue.put("hint", Catergorie);

        // call insert and add the right parameters
        db.insert("Studentchef", null, contentvalue);

        Log.d("filterjij", "insert: " + contentvalue);


    }


}
