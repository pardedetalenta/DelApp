package com.example.talenta.delappproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Talenta on 5/23/2017.
 */

public class ControllerFasilitas {
    private DBHelper dbHelper;
    private SQLiteDatabase database;
    public static final String TABLE_NAME = "fasilitas";
    public static final String ID = "id";
    public static final String NAMA_FASILITAS = "nama_fasilitas";
    public static final String GAMBAR_FASILITAS = "gambar_fasilitas";
    public static final String KETERANGAN = "keterangan";
    public static final String CREATE_FASILITAS = "CREATE TABLE "+TABLE_NAME+" "+ "("+ID+" integer primary key, "+ NAMA_FASILITAS+" TEXT, "+ GAMBAR_FASILITAS+" TEXT, "+  KETERANGAN+" TEXT)";
    private String[] TABLE_COLUMNS = {ID, NAMA_FASILITAS, GAMBAR_FASILITAS, KETERANGAN};
    public ControllerFasilitas(Context context) {
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
    public void insertData(int id, String nama_fasilitas, String gambar_fasilitas, String keterangan){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(NAMA_FASILITAS, nama_fasilitas);
        contentValues.put(GAMBAR_FASILITAS, gambar_fasilitas);
        contentValues.put(KETERANGAN, keterangan);
        database.insert(TABLE_NAME, null, contentValues);
    }
    public ArrayList<ModelFasilitas> getData() {
        ArrayList<ModelFasilitas> allData = new ArrayList<ModelFasilitas>();
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
    private ModelFasilitas parseData(Cursor cursor){
        ModelFasilitas curData = new ModelFasilitas();
        curData.setId(cursor.getInt(0));
        curData.setNama_fasilitas(cursor.getString(1));
        curData.setGambar_fasilitas(cursor.getString(2));
        curData.setKeterangan(cursor.getString(3));
        return curData;
    }
}
