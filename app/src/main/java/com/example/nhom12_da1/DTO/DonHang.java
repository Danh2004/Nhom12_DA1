package com.example.nhom12_da1.DTO;

import java.util.Date;

public class DonHang {
    private int maDon;
    private int maHang;
    private String tenDon ;
    private String sizeGiayDon;
    private String soLuongDon;
    private int giaDon;
    private String hangDon;
    private Date ngay;

    public DonHang() {
    }

    public DonHang(int maDon, int maHang, String tenDon, String sizeGiayDon, String soLuongDon, int giaDon, String hangDon, Date ngay) {
        this.maDon = maDon;
        this.maHang = maHang;
        this.tenDon = tenDon;
        this.sizeGiayDon = sizeGiayDon;
        this.soLuongDon = soLuongDon;
        this.giaDon = giaDon;
        this.hangDon = hangDon;
        this.ngay = ngay;
    }

    public int getMaDon() {
        return maDon;
    }

    public void setMaDon(int maDon) {
        this.maDon = maDon;
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public String getTenDon() {
        return tenDon;
    }

    public void setTenDon(String tenDon) {
        this.tenDon = tenDon;
    }

    public String getSizeGiayDon() {
        return sizeGiayDon;
    }

    public void setSizeGiayDon(String sizeGiayDon) {
        this.sizeGiayDon = sizeGiayDon;
    }

    public String getSoLuongDon() {
        return soLuongDon;
    }

    public void setSoLuongDon(String soLuongDon) {
        this.soLuongDon = soLuongDon;
    }

    public int getGiaDon() {
        return giaDon;
    }

    public void setGiaDon(int giaDon) {
        this.giaDon = giaDon;
    }

    public String getHangDon() {
        return hangDon;
    }

    public void setHangDon(String hangDon) {
        this.hangDon = hangDon;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
}
