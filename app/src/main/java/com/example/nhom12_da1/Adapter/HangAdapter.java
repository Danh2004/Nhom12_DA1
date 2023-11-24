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

import com.example.nhom12_da1.DAO.HangDAO;
import com.example.nhom12_da1.DTO.Hang;
import com.example.nhom12_da1.Fragment.frag_Hang;
import com.example.nhom12_da1.R;

import java.util.ArrayList;

public class HangAdapter extends ArrayAdapter<Hang> {
    private Context context;
    frag_Hang fragment;
    private ArrayList<Hang> list;
    TextView tvMaHang, tvTenHang;
    HangDAO hangDAO;
    ImageView imgDel;

    public HangAdapter(@NonNull Context context, frag_Hang fragment, ArrayList<Hang> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_hang, null);
        }
        final Hang item = list.get(position);
        if (item != null) {
            tvMaHang = v.findViewById(R.id.tvMaHang);
            tvMaHang.setText("Mã Hãng: " + item.getMaHang());
//            tvTenHang = v.findViewById(R.id.tvTenLoaiHang);
//            tvTenHang.setText("Tên Loại Hãng: " + item.getTenHang());
            hangDAO = new HangDAO(context);
            Hang hang = hangDAO.getID(String.valueOf(item.getMaHang()));
            tvTenHang = v.findViewById(R.id.tvTenLoaiHang);
            tvTenHang.setText("Tên Hang: " + hang.getTenHang());

            imgDel = v.findViewById(R.id.imgDeleteLS);
        }

        imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // gọi phương thức xóa
                fragment.xoa(String.valueOf(item.getMaHang()));
            }
        });
        return v;
    }
}
