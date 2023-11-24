package com.example.nhom12_da1.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public Database(Context context) {
        super(context, "Ecommerce", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tạo bảng để thêm vô giỏ hàng
        String sql = "CREATE TABLE giohang(" +
                "idSanPham integer PRIMARY KEY, " +
                "tenSanPham text," +
                "moTa text," +
                "giaSanPham text," +
                "loaiSanPham text," +
                "image integer," +
                "soLuong integer)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
