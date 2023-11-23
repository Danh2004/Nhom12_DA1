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

import com.example.nhom12_da1.DTO.ThanhVien;
import com.example.nhom12_da1.Fragment.frag_ThanhVien;
import com.example.nhom12_da1.R;

import java.util.ArrayList;

public class ThanhVienAdapter extends ArrayAdapter<ThanhVien> {
    private Context context;
    frag_ThanhVien fragment;
    private ArrayList<ThanhVien> list;
    TextView tvMaTV, tvTenTV, tvSdt,tvdiachi;
    ImageView imgDel;

    public ThanhVienAdapter(@NonNull Context context, frag_ThanhVien fragment, ArrayList<ThanhVien> list) {
        super(context, 0, list);
        this.context = context;
        this.fragment = fragment;
        this.list = list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_thanhvien, null);
        }
        final ThanhVien item = list.get(position);
        if (item != null) {
           tvMaTV=v.findViewById(R.id.tvMaTV);
           tvMaTV.setText("Mã thành viên:"+item.getMaTV());

           tvTenTV=v.findViewById(R.id.tvTenTV);
           tvTenTV.setText("Họ tên:"+item.getHoTen());

           tvSdt=v.findViewById(R.id.tvSdtTV);
           tvSdt.setText("Số điện thoại:"+item.getDienThoai());

           tvdiachi=v.findViewById(R.id.tvDiachiTV);
           tvdiachi.setText("Địa chỉ:"+item.getDiaChi());

            imgDel = v.findViewById(R.id.imgDeleteLS);
        }

        imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // gọi phương thức xóa
                fragment.xoa(String.valueOf(item.getMaTV()));

            }
        });
        return v;
    }
}
