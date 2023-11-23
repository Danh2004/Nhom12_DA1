package com.example.nhom12_da1.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.nhom12_da1.DTO.ChuHang;
import com.example.nhom12_da1.DTO.DonHang;
import com.example.nhom12_da1.DTO.ThanhVien;
import com.example.nhom12_da1.DbHelper.MyDbHelper;

import java.util.ArrayList;
import java.util.List;

public class ThanhVienDAO {
    private SQLiteDatabase db;

    public ThanhVienDAO(Context context){
        MyDbHelper dbHelper = new MyDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(ThanhVien obj){
        ContentValues values = new ContentValues();
        values.put("hoten",obj.getHoTen());
        values.put("dienThoai",obj.getDienThoai());
        values.put("diaChi",obj.getDiaChi());
        return db.insert("ThanhVien",null,values);
    }

    public long update(ThanhVien obj){
        ContentValues values = new ContentValues();
        values.put("hoten",obj.getHoTen());
        values.put("dienThoai",obj.getDienThoai());
        values.put("diaChi",obj.getDiaChi());
        return db.update("ThanhVien",values,"maTV = ?",new String[]{String.valueOf(obj.getMaTV())});
    }

    public long delete(String id) {
        return db.delete("ThanhVien", "maTV = ?", new String[]{String.valueOf(id)});
    }

    public List<ThanhVien> getAll(){
        String sql = "select * from ThanhVien";
        return getData(sql);
    }

    public ThanhVien getID(String id){
        String sql = "select * from ThanhVien where maTV = ?";
        List<ThanhVien> list = getData(sql,id);
        return list.get(0);
    }

    @SuppressLint("Range")
    private List<ThanhVien> getData(String sql, String... selectionArgs){
        List<ThanhVien> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()){
            ThanhVien obj = new ThanhVien();
            obj.setMaTV(Integer.parseInt(cursor.getString(cursor.getColumnIndex("maTV"))));
            obj.setHoTen(cursor.getString(cursor.getColumnIndex("hoten")));
            obj.setDienThoai(cursor.getString(cursor.getColumnIndex("dienThoai")));
            obj.setDiaChi(cursor.getString(cursor.getColumnIndex("diaChi")));
            Log.i("//==", obj.toString());

            list.add(obj);
        }
        return list;
    }
}
