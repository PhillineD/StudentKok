package com.example.phill.studentcheff;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.icu.text.MessagePattern.ArgType.SELECT;

public class EntryDatabase extends SQLiteOpenHelper {

    public EntryDatabase( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static EntryDatabase instance;
    // elke keer als je iets aanpas de app leeg maken.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String  message = "CREATE TABLE " + "Studentchef" + "( _id STRING PRIMARY KEY, title TEXT, picture STRING, rating FLAOT, " +
                "timestamp DATETIME default (datetime('now','localtime'))) ";
        db.execSQL(message);

//        INTEGER PRIMARY KEY AUTOINCREMENT
        // create a new ContentValues object
        ContentValues contentvalue = new ContentValues();

        // example for history
//        contentvalue.put("_id", 1234);
//        contentvalue.put("title", "Hallo");
//        contentvalue.put("rating", 2);
//        contentvalue.put("picture","https://www.themealdb.com//images//media//meals//1525873040.jpg");

        // call insert and add the right parameters
//        db.insert("Studentchef", null, contentvalue);

//        Log.d("databse", "onCreate: " + db);

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


    // method to insert a history item
    public void insert(String id, String title, Float rating, String picture){
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

        // call insert and add the right parameters
        db.insert("Studentchef", null, contentvalue);


    }


    public List<HistoryItem> gettitle(String name){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"title"};
        String tablename = "Studentchef";

        qb.setTables(tablename);
        Cursor cursor = qb.query(db,sqlSelect,"title LIKE '?'",new String[]{"%"+name+"%"},null, null, null);
        List<HistoryItem> result = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                HistoryItem title = new HistoryItem(null,null,null);
                title.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                title.setPicture(cursor.getString(cursor.getColumnIndex("picture")));
                title.setId(cursor.getString(cursor.getColumnIndex("_id")));

                result.add(title);
            }while (cursor.moveToNext());
        }
        return result;
    }



}
