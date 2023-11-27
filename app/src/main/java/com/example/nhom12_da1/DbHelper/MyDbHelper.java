package com.example.nhom12_da1.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {
    static final String dbName = "GiaySneaker";
    static  final  int  version=16;
    public MyDbHelper(Context context){
        super(context,dbName,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // tao bang Chu hang
        String tbAdmin = "create table ChuHang("+
                " maCH text primary key, " +
                "hoten text not null," +
                "matkhau text not null)";
        db.execSQL(tbAdmin);

        // tao bang thanh vien
        String tbThanhVien = "create table ThanhVien(" +
                "maTV INTEGER primary key," +
                "hoten text not null," +
                "dienThoai text not null," +
                "diaChi text not null )";
        db.execSQL(tbThanhVien);

        // tao bang don hang
        String tbDonHang = "create table DonHang("+
                "maDon integer primary key," +
                "maHang integer REFERENCES Hang(maHang), "+
                "ten text not null," +
                "size text not null," +
                "soLuong text not null," +
                "gia INTEGER not null," +
                "hang  text not null," +
                "ngay DATE NOT NULL)";
        db.execSQL(tbDonHang);

        // tao bang gio hang
        String tbGioHang = "create table GioHang(" +
                "maGio integer primary key,"+
                "ten text not null," +
                "size text not null," +
                "gia INTEGER not null)";
        db.execSQL(tbGioHang);

        //tạo bảng hãng
        String tbHang = "create table Hang(" +
                "maHang integer  primary key,"+
                "tenHang text not null )";
        db.execSQL(tbHang);

        // Data mau
        db.execSQL("insert into ChuHang values('admin','Admin','admin')," +
                "('duyanh','Vo Duy Anh','2004')");
        db.execSQL("insert into ThanhVien values('1','Vo Duy Anh','01234567890','Ha Noi')," +
                "('2','Vu Xuan Giap','01234567891','Ha Noi')," +
                "('3','Le Minh Chien','01234567892','Ha Noi')");
        db.execSQL("insert into DonHang values('1','1','AirJordan','39','1','40000','Nike','2023/04/20')," +
                "('2','2','AirForce','43','4','160000','Adidas','2023/04/20')" );
        db.execSQL("insert into GioHang values('1','AirJordan','39','40000')," +
                "('2','AirForce','43','160000')");

        db.execSQL("insert into Hang values(1,'AirJordan')," +
                "(2,'AirForce')");
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("drop table if exists ChuHang");
            db.execSQL("drop table if exists ThanhVien");
            db.execSQL("drop table if exists DonHang");
            db.execSQL("drop table if exists GioHang");
            db.execSQL("drop table if exists Hang");
            onCreate(db);
        }
    }
}
