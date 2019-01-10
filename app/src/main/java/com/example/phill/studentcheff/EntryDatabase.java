package com.example.phill.studentcheff;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EntryDatabase extends SQLiteOpenHelper {
    public EntryDatabase( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static EntryDatabase instance;

    @Override
    public void onCreate(SQLiteDatabase db) {
        String  message = "CREATE TABLE " + "Studentchef" + "(id INTEGER PRIMARY KEY , title TEXT, rating FLOAT , " +
                "timestamp DATETIME default (datetime('now','localtime'))) ";
        db.execSQL(message);

        // create a new ContentValues object
        ContentValues contentvalue = new ContentValues();

        contentvalue.put("id", "Hallo");
        contentvalue.put("title", "Hallo");
        contentvalue.put("rating", 2);

        // call insert and add the right parameters
        db.insert("Studentchef", null, contentvalue);

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


}
