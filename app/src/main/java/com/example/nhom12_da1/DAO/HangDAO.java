package com.example.nhom12_da1.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nhom12_da1.DTO.Hang;
import com.example.nhom12_da1.DbHelper.MyDbHelper;

import java.util.ArrayList;
import java.util.List;

public class HangDAO {
    private SQLiteDatabase db;

    public HangDAO(Context context) {
        MyDbHelper dbHelper = new MyDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(Hang obj) {
        ContentValues values = new ContentValues();
        values.put("tenHang", obj.getTenHang());
        return db.insert("Hang", null, values);
    }

    public long update(Hang obj) {
        ContentValues values = new ContentValues();
        values.put("tenHang", obj.getTenHang());
        return db.update("Hang", values, "maHang = ?", new String[]{String.valueOf(obj.getMaHang())});
    }

    public long delete(String id) {
        return db.delete("Hang", "maHang = ?", new String[]{String.valueOf(id)});
    }

    public List<Hang> getAll() {
        String sql = "SELECT * FROM Hang";
        return getData(sql);
    }

    public Hang getID(String id) {
        String sql = "SELECT * FROM Hang WHERE maHang=?";
        List<Hang> list = getData(sql, id);
        return list.get(0);
    }

    @SuppressLint("Range")
    private List<Hang> getData(String sql, String... selectionArgs) {
        List<Hang> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            Hang obj = new Hang();
            obj.setMaHang(Integer.parseInt(cursor.getString(cursor.getColumnIndex("maHang"))));
            obj.setTenHang(cursor.getString(cursor.getColumnIndex("tenHang")));
            list.add(obj);
        }
        return list;
    }

}
