package com.example.user.simplejournal.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.simplejournal.data.Contract.DiaryEntry;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "diary.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_DIARY_TABLE = " CREATE TABLE " + DiaryEntry.TABLE_NAME + "("
                + DiaryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DiaryEntry.COLUMN_TITLE + " TEXT, "
                + DiaryEntry.COLUMN_CONTENT + " TEXT);";

        db.execSQL(SQL_CREATE_DIARY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + DiaryEntry.TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String title, String content) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DiaryEntry.COLUMN_TITLE, title);
        values.put(DiaryEntry.COLUMN_CONTENT, content);

        long result = database.insert(DiaryEntry.TABLE_NAME, null, values);

        if (result == -1) {
            return false;
        } else
            return true;
    }

    public Cursor loadData() {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor res = database.rawQuery(" SELECT * FROM " + DiaryEntry.TABLE_NAME, null);
        return res;
    }
}
