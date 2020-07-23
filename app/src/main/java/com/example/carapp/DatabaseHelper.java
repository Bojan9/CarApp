package com.example.carapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String DATABASE_NAME = "car.db";
    private static final String TABLE_NAME = "car_table";
    public static final String COL0 = "ID";
    public static final String COL1 = "NAME";
    public static final String COL2 = "DISTANCE";
//    public static final String COL3 = "FUEL";
//    public static final String COL4 = "CONSUMPTION";
//    public static final String COL5 = "PHOTO";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " ( " +
                COL0 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1 + " TEXT , " +
                COL2 + " TEXT )";
//                COL3 + " TEXT, " +
//                COL4 + " TEXT, " +
//                COL5 + " TEXT )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, item);
        contentValues.put(COL2, item);

        Log.d(TAG, "addData: Adding" + item + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1){
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

}
