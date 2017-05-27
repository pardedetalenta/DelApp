package com.example.talenta.delappproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Talenta on 5/13/2017.
 */


public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "del.db";
    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub
        db.execSQL(ControllerKegiatan.CREATE_KEGIATAN);
        db.execSQL(ControllerFasilitas.CREATE_FASILITAS);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
// TODO Auto-generated method stub
    }
}