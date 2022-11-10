package com.example.bazadanych;

import androidx.annotation.Nullable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase<admin> extends SQLiteOpenHelper {

    public MyDatabase(@Nullable Context context, @Nullable String name,@Nullable SQLiteDatabase.CursorFactory factory,int version)
    {
        super(context, "people.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table people(id integer primary key autoincrement,"
                +"name text,"
                +"surname text,"
                +"password text,"
                +"admin number);"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void registerPerson(String name, String surname, String password, Integer admin)
    {
        SQLiteDatabase db= getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("surname",surname);
        values.put("password",password);
        values.put("admin",admin);
        db.insertOrThrow("people",null,values);
    }
    public Cursor getAllPeople(){
        String[] columns ={"id","name","surname","admin","password"};
        SQLiteDatabase db = getReadableDatabase();
        return db.query("people",columns,null,null,null,null,null);
    }
    public Cursor checkPerson(String name, String password){
        SQLiteDatabase db = getReadableDatabase();
        String[] columns={"name", "admin"};
 //       return db.query("people", columns, "name=? and password=? and admin=?", new String[] {String.valueOf(name),String.valueOf(password)}, null ,null, null);
        return db.query("people", columns, "name=? and password=?", new String[] {"a","a"}, null ,null, null);
    }
}