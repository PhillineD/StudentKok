package com.example.phill.studentcheff.Requests;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Time;

public class EntryDatabase extends SQLiteOpenHelper {

    private static EntryDatabase instance;

    public EntryDatabase( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String  message = "CREATE TABLE " + "Studentchef" + "( _id STRING PRIMARY KEY, title TEXT, picture STRING,hint STRING ,rating FLAOT,time FLOAT, " +
                "timestamp DATETIME default (datetime('now','localtime'))) ";
        db.execSQL(message);

    }

    public static EntryDatabase getInstance(Context context){

        if(EntryDatabase.instance == null){
            EntryDatabase.instance = new EntryDatabase(context,"Studentchef", null ,1);
        }
        return EntryDatabase.instance;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // drops the entries table
        db.execSQL("DROP TABLE IF EXISTS "+ "Studentchef");

        String sort = "SELECT * FROM "+" Studentchef "+" ORDER BY "+"rating "+"DESC";
        db.execSQL(sort);

        // recreates it by calling
        onCreate(db );
    }

    // select all info from database
    public static Cursor selectAll(EntryDatabase instance){
        SQLiteDatabase database = instance.getWritableDatabase();
        return database.rawQuery("SELECT * FROM "+ "Studentchef "+" ORDER BY "+"rating "+
                "DESC" , null );
    }

    public static  Cursor filterData (EntryDatabase instance, String woord){
        SQLiteDatabase database = instance.getWritableDatabase();
        Log.d("loggen ", "filteren:" + woord);
        return database.rawQuery("SELECT * FROM  Studentchef WHERE  title  = '"+woord+"' " +
                "OR timestamp ='"+woord+"' " + "OR hint= '"+woord+"'" +  "OR time < '"+woord+"'"
                + "OR time = '"+woord+"'", null );

    }

    // method to insert a history item
    public void insert(String id, String title, Float rating, String picture, String Catergorie, Float time){
        // open a connection to the database
        SQLiteDatabase db = instance.getWritableDatabase();

        // create a new ContentValues object
        ContentValues contentvalue = new ContentValues();

        // check if the recipe is alreaedy in database
        String sort = "DELETE FROM Studentchef WHERE _id = '"+id+"'";
        db.execSQL(sort);

//        String time1 = time.toString();
        // add values for title, content and mood.
        contentvalue.put("_id", id);
        contentvalue.put("title", title);
        contentvalue.put("rating", rating);
        contentvalue.put("picture",picture );
        contentvalue.put("hint", Catergorie);
        contentvalue.put("time", time);

        Log.d("het duurt te lang", "insert: " + time);

        // call insert and add the right parameters
        db.insert("Studentchef", null, contentvalue);

    }

}
