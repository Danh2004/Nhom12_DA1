package com.example.nhom12_da1;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nhom12_da1.Adapter.ShowDialog;
import com.example.nhom12_da1.DAO.GioHangDao;
import com.example.nhom12_da1.DTO.GioHang;
import com.example.nhom12_da1.DTO.Sanpham;


public class MoTaSP extends AppCompatActivity {
    private static final int MENU_ITEM_GIOHANG = 1;
    private Sanpham sanpham;
    private ImageView imageView;
    private TextView name, price, mota;
    private Button add;

    private GioHangDao gioHangDao;
    private ShowDialog showDialog;
    private GioHang gioHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_ta_sp);
        sanpham = (Sanpham) getIntent().getSerializableExtra("sp");
        //Khai báo
        init();

        //Set tiêu đề
        setTitle("CHI TIẾT SẢN PHẨM");
        //set Data
        try {
            name.setText(sanpham.getTenSanPham());
            price.setText(sanpham.getGiaSanPham());
            mota.setText(sanpham.getMoTa());
            imageView.setImageResource(sanpham.getImage());
        } catch (Exception e) {

        }

        //Khi bấm nút để thêm vào giỏ hàng
        add.setOnClickListener(view -> {
            gioHang = new GioHang(sanpham.getId(), sanpham.getTenSanPham(), sanpham.getMoTa(), sanpham.getGiaSanPham(), sanpham.getLoaiSanPham(), sanpham.getImage(), 1);
            if (gioHangDao.them(gioHang)) {
                showDialog.show("Thêm vào giỏ hàng thành công!");
            } else {
                gioHang = gioHangDao.getGioHang(sanpham.getId());
                gioHangDao.themSoluong(gioHang);
                showDialog.show("Thêm vào giỏ hàng thành công!");
            }
        });
    }

    private void init() {
        imageView = findViewById(R.id.ivNewsList);
        name = findViewById(R.id.one_name);
        price = findViewById(R.id.one_price);
        mota = findViewById(R.id.tv_mota);
        add = findViewById(R.id.btn_add);
        gioHangDao = new GioHangDao(this);
        showDialog = new ShowDialog(this);
    }

    //icon giỏ hàng
//Set menu cho action bar
    //icon giỏ hàng
//Set menu cho action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_giohang, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ITEM_GIOHANG:
                startActivity(new Intent(this, GioHangActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

