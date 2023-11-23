package com.example.nhom12_da1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.nhom12_da1.DAO.ChuHangDAO;
import com.example.nhom12_da1.DTO.ChuHang;
import com.example.nhom12_da1.Fragment.fragment_add_user;
import com.example.nhom12_da1.R;

import java.util.ArrayList;

public class ChuHangAdapter extends ArrayAdapter<ChuHang> {
    private Context context;

    fragment_add_user fragment;
    private ArrayList<ChuHang> list;
    TextView tvMaTT,tvTenTT,tvMatKhau;
    ImageView imgDel;
    ChuHangDAO dao;

    public ChuHangAdapter(@NonNull Context context, fragment_add_user fragment, ArrayList<ChuHang> list) {
        super(context, 0,list);
        this.context = context;
        this.list = list;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        dao = new ChuHangDAO(getContext());
        if (v == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_add_user,null);

        }

        final ChuHang item = list.get(position);
        if (item != null){
            tvMaTT = v.findViewById(R.id.tvMaTT);
            tvMaTT.setText("Mã TT: "+item.getMaCH());
            tvTenTT = v.findViewById(R.id.tvTenTT);
            tvTenTT.setText("Họ tên: "+item.getHoTen());
            tvMatKhau = v.findViewById(R.id.tvMatKhau);
            tvMatKhau.setText("Mật khẩu: "+item.getMatKhau());


            imgDel = v.findViewById(R.id.imgDeleteLS);
        }

        imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pt xoa
                fragment.xoa(item.getMaCH());
            }
        });
        return v;
    }
}
