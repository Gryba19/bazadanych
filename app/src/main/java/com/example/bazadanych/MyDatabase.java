package com.example.bazadanych;

import androidx.annotation.Nullable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {

    public MyDatabase(@Nullable Context context, @Nullable String name,@Nullable SQLiteDatabase.CursorFactory factory,int version)
    {
        super(context, "cars.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table cars(id integer primary key autoincrement,"
                +"name text,"
                +"model text);"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}