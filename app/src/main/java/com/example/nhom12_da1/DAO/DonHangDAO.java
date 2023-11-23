package com.example.nhom12_da1.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nhom12_da1.DTO.ChuHang;
import com.example.nhom12_da1.DTO.DonHang;
import com.example.nhom12_da1.DbHelper.MyDbHelper;

import java.util.ArrayList;
import java.util.List;

public class DonHangDAO {
    private SQLiteDatabase db;

    public DonHangDAO(Context context){
        MyDbHelper dbHelper = new MyDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(DonHang obj){
        ContentValues values = new ContentValues();
        values.put("ten",obj.getTenDon());
        values.put("size",obj.getSizeGiayDon());
        values.put("soLuong",obj.getSoLuongDon());
        values.put("gia",obj.getGiaDon());
        values.put("hang",obj.getHangDon());
        return db.insert("DonHang",null,values);
    }

    public long update(DonHang obj){
        ContentValues values = new ContentValues();
        values.put("ten",obj.getTenDon());
        values.put("size",obj.getSizeGiayDon());
        values.put("soLuong",obj.getSoLuongDon());
        values.put("gia",obj.getGiaDon());
        values.put("hang",obj.getHangDon());
        return db.update("DonHang",values,"maDon = ?",new String[]{String.valueOf(obj.getMaDon())});
    }

    public long delete(String id) {
        return db.delete("DonHang", "maDon = ?", new String[]{String.valueOf(id)});
    }

    public List<DonHang> getAll(){
        String sql = "select * from DonHang";
        return getData(sql);
    }

    public DonHang getID(String id){
        String sql = "select * from DonHang where maDon = ?";
        List<DonHang> list = getData(sql,id);
        return list.get(0);
    }

    @SuppressLint("Range")
    private List<DonHang> getData(String sql, String... selectionArgs){
        List<DonHang> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()){
            DonHang obj = new DonHang();
            obj.setMaDon(Integer.parseInt(cursor.getString(cursor.getColumnIndex("maDon"))));
            obj.setTenDon(cursor.getString(cursor.getColumnIndex("ten")));
            obj.setSizeGiayDon(cursor.getString(cursor.getColumnIndex("size")));
            obj.setSoLuongDon(cursor.getString(cursor.getColumnIndex("soLuong")));
            obj.setGiaDon(Integer.parseInt(cursor.getString(cursor.getColumnIndex("gia"))));
            obj.setHangDon(cursor.getString(cursor.getColumnIndex("hang")));
            list.add(obj);
        }
        return list;
    }

    // thống kê doanh thu
    @SuppressLint("Range")
    public int getDoanhThu(String tuNgay, String denNgay) {
        String sqlDoanhThu = "SELECT SUM(gia) as doanhThu FROM DonHang WHERE ngay BETWEEN ? AND ?";
        List<Integer> list = new ArrayList<Integer>();
        Cursor cursor = db.rawQuery(sqlDoanhThu, new String[]{tuNgay, denNgay});
        while (cursor.moveToNext()) {
            try {
                list.add(Integer.parseInt(cursor.getString(cursor.getColumnIndex("doanhThu"))));

            } catch (Exception e) {
                list.add(0);
            }
        }
        return list.get(0);
    }

}
