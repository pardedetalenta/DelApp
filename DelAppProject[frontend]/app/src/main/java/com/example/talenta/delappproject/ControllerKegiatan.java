package com.example.talenta.delappproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Talenta on 5/21/2017.
 */

public class ControllerKegiatan {
    private DBHelper dbHelper;
    private SQLiteDatabase database;
    public static final String TABLE_NAME = "kegiatan";
    public static final String ID = "id";
    public static final String NAMA_KEGIATAN = "nama_kegiatan";
    public static final String GAMBAR_KEGIATAN = "gambar_kegiatan";
    public static final String KETERANGAN = "keterangan";
    public static final String CREATE_KEGIATAN = "CREATE TABLE "+TABLE_NAME+" "+ "("+ID+" integer primary key, "+ NAMA_KEGIATAN+" TEXT, "+ GAMBAR_KEGIATAN+" TEXT, "+  KETERANGAN+" TEXT)";
    private String[] TABLE_COLUMNS = {ID, NAMA_KEGIATAN, GAMBAR_KEGIATAN, KETERANGAN};
    public ControllerKegiatan(Context context) {
        dbHelper = new DBHelper(context);
    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    public void close() {
        dbHelper.close();
    }
    public void deleteData (){
        database.delete(TABLE_NAME, null, null);
    }
    public void insertData(int id, String nama_kegiatan, String gambar_kegiatan, String keterangan){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(NAMA_KEGIATAN, nama_kegiatan);
        contentValues.put(GAMBAR_KEGIATAN, gambar_kegiatan);
        contentValues.put(KETERANGAN, keterangan);
        database.insert(TABLE_NAME, null, contentValues);
    }
    public ArrayList<ModelKegiatan> getData() {
        ArrayList<ModelKegiatan> allData = new ArrayList<ModelKegiatan>();
        Cursor cursor = null;
        cursor = database.query(TABLE_NAME, TABLE_COLUMNS,null,null,null,null,ID+" ASC");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            allData.add(parseData(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return allData;
    }
    private ModelKegiatan parseData(Cursor cursor){
        ModelKegiatan curData = new ModelKegiatan();
        curData.setId(cursor.getInt(0));
        curData.setNama_kegiatan(cursor.getString(1));
        curData.setGambar_kegiatan(cursor.getString(2));
        curData.setKeterangan(cursor.getString(3));
        return curData;
    }
}
