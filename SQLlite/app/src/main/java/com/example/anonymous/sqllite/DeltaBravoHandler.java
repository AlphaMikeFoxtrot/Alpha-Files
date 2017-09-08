package com.example.anonymous.sqllite;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

/**
 * Created by ANONYMOUS on 04-Sep-17.
 */

public class DeltaBravoHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "amounts.db";
    private static final String TABLE_AMOUNTS = "amount";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_AMOUNT = "amount";

    public DeltaBravoHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_AMOUNTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_AMOUNT + " INTEGER " +
                ")";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AMOUNTS);
        onCreate(db);

    }

    // this method adds new row(amount) to the existing database

    public void addToDB(Amount amount){

        ContentValues values = new ContentValues();
        values.put(COLUMN_AMOUNT, amount.getAmount());
        SQLiteDatabase db = this.getReadableDatabase();
        db.insert(TABLE_AMOUNTS, null, values);
        db.close();

    }

    // this method deletes the row(amount) from the database:

    public void deleteFromDB(int amount){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_AMOUNTS + " WHERE " + COLUMN_AMOUNT + " = \"" + amount + "\";");

    }

    // this method converts the database values to string

    public String databaseToString(){

        SQLiteDatabase db = this.getWritableDatabase();
        String databaseString = "";
        String query = "SELECT * FROM " + TABLE_AMOUNTS + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast()){

            if(c.getString(c.getColumnIndex("amount")) != null){

                databaseString += c.getString(c.getColumnIndex("amount"));
                databaseString += "\n";

            }

        }

        db.close();
        return databaseString;
    }

}
