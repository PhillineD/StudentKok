/**
 * Make database for history, select items, insert items and upgrade.
 *
 *
 * @author      Philline Dikker
 * @version
 *
 *
 * This work complies with the JMU Honor Code.
 */

package com.example.phill.studentcheff.Requests;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class EntryDatabase extends SQLiteOpenHelper {

    private static EntryDatabase instance;

    public EntryDatabase( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // create database for history
        String  message = "CREATE TABLE " + "Studentchef" + "( _id STRING PRIMARY KEY, title TEXT, picture STRING,hint STRING ,rating FLAOT,time FLOAT, " +
                "timestamp DATETIME default (datetime('now','localtime'))) ";
        db.execSQL(message);

    }


    /**
     * Get instance from database.
     *
     * @param context    Description of the first parameter
     * @return          Description of what is returned
     */
    public static EntryDatabase getInstance(Context context){

        if(EntryDatabase.instance == null){
            EntryDatabase.instance = new EntryDatabase(context,"Studentchef", null ,1);
        }
        return EntryDatabase.instance;

    }

    /**
     * Select all info from database, order by rating.
     *
     * @param instance    Instance from the history database.
     * @return  database
     */
    public static Cursor selectAll(EntryDatabase instance){
        SQLiteDatabase database = instance.getWritableDatabase();

        // order database by rating
        return database.rawQuery("SELECT * FROM "+ "Studentchef "+" ORDER BY "+"rating "+
                "DESC" , null );
    }

    /**
     * Filter history if user search.
     *
     * @param instance    Instance from the history database.
     * @param woord         Serach on woord typed in by user.
     * @return  database
     */
    public static  Cursor filterData (EntryDatabase instance, String woord){
        SQLiteDatabase database = instance.getWritableDatabase();

        // filter data by title, timestamp, hint or time
        return database.rawQuery("SELECT * FROM  Studentchef WHERE  title  = '"+woord+"' " +
                "OR timestamp ='"+woord+"' " + "OR hint= '"+woord+"'" +  "OR time < '"+woord+"'"
                + "OR time = '"+woord+"'", null );

    }


    /**
     * Method to insert a history item.
     *
     * @param id    Instance from the history database.
     * @param title        Serach on woord typed in by user.
     * @param rating       given rating for recipe
     * @param picture       Picture from recipe.
     * @param Catergorie    The caterogie from recipe.
     * @param time          Cooked time for recipe.
     */
    public void insert(String id, String title, Float rating, String picture, String Catergorie, Float time){
        // open a connection to the database
        SQLiteDatabase db = instance.getWritableDatabase();

        // create a new ContentValues object
        ContentValues contentvalue = new ContentValues();

        // if recipe is alreaedy in database, delete it
        String sort = "DELETE FROM Studentchef WHERE _id = '"+id+"'";
        db.execSQL(sort);


        // add values
        contentvalue.put("_id", id);
        contentvalue.put("title", title);
        contentvalue.put("rating", rating);
        contentvalue.put("picture",picture );
        contentvalue.put("hint", Catergorie);
        contentvalue.put("time", time);

        // call insert and add the right parameters
        db.insert("Studentchef", null, contentvalue);

    }

    /**
     * Upgrade History database.
     *
     * @param db   ``       History database.
     * @param oldVersion    Oldversion from database.
     * @param newVersion    NewVersion from database.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // drops the entries table
        db.execSQL("DROP TABLE IF EXISTS "+ "Studentchef");

        // sort by rating
        String sort = "SELECT * FROM "+" Studentchef "+" ORDER BY "+"rating "+"DESC";
        db.execSQL(sort);

        // recreates it by calling
        onCreate(db );
    }

}
