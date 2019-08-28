package com.fieldbear.androidtutorial190826.T13_SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TestDBHelper {
    TestSQLiteOpenHelper mOpenHelper;

    public TestDBHelper(Context context) {
        mOpenHelper = new TestSQLiteOpenHelper(context, "people.db",
                null, 1);
    }

    public void insert(String name, int age, String address){
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        values.put("address", address);
        db.insert("student", null, values);
    }

    public void delete(String name){
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        db.delete("student", "name = ?",
                new String[]{name});
    }

    public void update(String name, int newAge){
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("age", newAge);
        db.update("student", values, "name = ?",
                new String[]{name});
    }

    public String selectAll(){
        String res = "";
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        Cursor c = db.query("student", null, null, null,
                null, null, null);

        while(c.moveToNext()){
            String name = c.getString( c.getColumnIndex("name") );
            int age = c.getInt( c.getColumnIndex("age") );
            String address = c.getString( c.getColumnIndex("address") );

            res += "name : "+name+" age: "+age+" address: "+address+"\n";
        }

        return res;
    }




}
