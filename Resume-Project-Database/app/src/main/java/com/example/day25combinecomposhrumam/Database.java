package com.example.day25combinecomposhrumam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String dbname = "Basic.db";

    public Database(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS Queries (mailid TEXT PRIMARY KEY, password TEXT)");
        } catch (SQLException e) {
            Log.e("Database", "Error creating database: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("DROP TABLE IF EXISTS Queries");
            onCreate(db); // Recreate the table
        } catch (SQLException e) {
            Log.e("Database", "Error upgrading database: " + e.getMessage());
        }
    }

    public Boolean insert(String mailid, String password) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mailid", mailid);
        contentValues.put("password", password);

        try {
            long result = database.insert("Queries", null, contentValues);
            if (result == -1) {
                Log.e("Database", "Insert failed");
                return false;
            } else {
                Log.d("Database", "Insert succeeded");
                return true;
            }
        } catch (SQLException e) {
            Log.e("Database", "Error inserting data: " + e.getMessage());
            return false;
        }
    }

//    public Boolean checkUser(String mailid)
//    {
//        SQLiteDatabase database=this.getWritableDatabase();
//        Cursor cursor=database.rawQuery("select * from users where mailid=?" , new String[]{mailid});
//        int count=cursor.getCount();
//        cursor.close();
//        return count>0;
//    }

    public Boolean checkUserPass(String mailid, String password)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("select * from Queries where mailid = ? and password=?", new String[]{mailid,password});
        int count=cursor.getCount();
        cursor.close();
        return count>0;
    }
    }