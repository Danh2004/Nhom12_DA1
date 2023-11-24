package com.example.nhom12_da1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.nhom12_da1.DTO.Hang;
import com.example.nhom12_da1.R;

import java.util.ArrayList;

public class HangSpinner extends ArrayAdapter<Hang> {
    private Context context;
    private ArrayList<Hang> list;
    TextView tvMaHang, tvTenHang;

    public HangSpinner(@NonNull Context context, ArrayList<Hang> list) {
        super(context, 0,list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_hang_spinner,null);
        }
        final Hang item = list.get(position);
        if (item != null){
            tvMaHang = v.findViewById(R.id.tvMaHang);
            tvMaHang.setText(item.getMaHang() + ". ");

            tvTenHang = v.findViewById(R.id.tvTenHang);
            tvTenHang.setText(item.getTenHang());
        }
        return v;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_hang_spinner,null);
        }
        final Hang item = list.get(position);
        if(item != null){
            tvMaHang = v.findViewById(R.id.tvMaHang);
            tvMaHang.setText(item.getMaHang() + ". ");

            tvTenHang = v.findViewById(R.id.tvTenHang);
            tvTenHang.setText(item.getTenHang());
        }
        return v;

    }
}
