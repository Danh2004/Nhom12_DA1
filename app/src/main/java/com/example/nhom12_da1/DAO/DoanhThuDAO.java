package com.example.nhom12_da1.DAO;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nhom12_da1.DbHelper.MyDbHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DoanhThuDAO {
    private SQLiteDatabase db;
    private Context context;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public DoanhThuDAO(Context context) {
        this.context = context;
        MyDbHelper dbHelper = new MyDbHelper(context);
        db = dbHelper.getWritableDatabase();
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
