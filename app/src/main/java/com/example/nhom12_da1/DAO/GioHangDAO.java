package com.example.nhom12_da1.DAO;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nhom12_da1.DTO.DonHang;
import com.example.nhom12_da1.DTO.GioHang;
import com.example.nhom12_da1.DbHelper.MyDbHelper;

import java.util.ArrayList;
import java.util.List;

public class GioHangDAO {
    private SQLiteDatabase db;

    public GioHangDAO(Context context){
        MyDbHelper dbHelper = new MyDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public long delete(String id) {
        return db.delete("GioHang", "maGio = ?", new String[]{String.valueOf(id)});
    }

    public List<GioHang> getAll(){
        String sql = "select * from GioHang";
        return getData(sql);
    }

    public GioHang getID(String id){
        String sql = "select * from GioHang where maGio = ?";
        List<GioHang> list = getData(sql,id);
        return list.get(0);
    }

    @SuppressLint("Range")
    private List<GioHang> getData(String sql, String... selectionArgs){
        List<GioHang> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()){
            GioHang obj = new GioHang();
            obj.setMaGio(Integer.parseInt(cursor.getString(cursor.getColumnIndex("maGio"))));
            obj.setTenGioHang(cursor.getString(cursor.getColumnIndex("ten")));
            obj.setSizeGiayGio(cursor.getString(cursor.getColumnIndex("size")));
            obj.setGiaGiayGio(Integer.parseInt(cursor.getString(cursor.getColumnIndex("gia"))));
            list.add(obj);
        }
        return list;
    }

}
