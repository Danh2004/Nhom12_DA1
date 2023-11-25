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

import com.example.nhom12_da1.DTO.DonHang;
import com.example.nhom12_da1.DTO.ThanhVien;
import com.example.nhom12_da1.Fragment.frag_DonHang;
import com.example.nhom12_da1.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class DonHangAdapter extends ArrayAdapter<DonHang> {
    private Context context;
    frag_DonHang fragment;
    private ArrayList< DonHang> list;

    TextView tvMadh, tvTengiay,tvPhanloai,tvSoluong,tvGia,tvHang,tvngay;
    ImageView imgDelete;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");


    public DonHangAdapter(@NonNull Context context ,frag_DonHang fragment,ArrayList<DonHang> list) {
        super(context,0,list);
        this.context=context;
        this.fragment=fragment;
        this.list=list;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v=convertView;
        if(v==null){
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.item_donhang,null);
        }
        final DonHang item=list.get(position);
        if (item!=null){
            tvMadh=v.findViewById(R.id.tv_ma);
            tvMadh.setText("Mã đơn hàng:"+item.getMaDon());

            tvTengiay=v.findViewById(R.id.tv_ten);
            tvTengiay.setText("Tên giày:"+item.getTenDon());

            tvPhanloai=v.findViewById(R.id.tv_phanloai);
            tvPhanloai.setText("Phân loại:"+item.getSizeGiayDon());

            tvSoluong=v.findViewById(R.id.tv_soluong);
            tvSoluong.setText("Số lượng đơn:"+item.getSoLuongDon());

            tvGia=v.findViewById(R.id.tv_gia);
            tvGia.setText("Giá:"+item.getGiaDon());

            tvHang=v.findViewById(R.id.tv_hang);
            tvHang.setText("Hãng:"+item.getHangDon());

            tvngay = v.findViewById(R.id.tv_ngay);
            tvngay.setText("Ngày mua: "+sdf.format(item.getNgay()));

            imgDelete=v.findViewById(R.id.img_delete_pm);

        }
        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gọi ra phương thức xóa
                fragment.xoa(String.valueOf(item.getMaDon()));
            }
        });

        return v;
    }

}
