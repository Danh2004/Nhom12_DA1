package com.example.nhom12_da1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nhom12_da1.DAO.ChuHangDAO;
import com.example.nhom12_da1.DTO.ChuHang;
import com.example.nhom12_da1.Fragment.frag_DonHang;
import com.example.nhom12_da1.Fragment.frag_Hang;
import com.example.nhom12_da1.Fragment.frag_MuaHang;
import com.example.nhom12_da1.Fragment.frag_ThanhVien;
import com.example.nhom12_da1.Fragment.frag_ThongKe;
import com.example.nhom12_da1.Fragment.fragment_add_user;
import com.example.nhom12_da1.Fragment.fragment_change_pass;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawer;
    Toolbar toolbar;
    View mHeaderView;
    TextView tvUser;
    NavigationView nv;

    ChuHangDAO chuHangDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // anh xa
        drawer = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar1);
        nv = findViewById(R.id.nvView);
        // set toolbar thay actionbar
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        ActionBar ab = getSupportActionBar();

        ab.setHomeAsUpIndicator(R.drawable.menu);
        ab.setDisplayHomeAsUpEnabled(true);
        // set mau icon ve ban goc
        nv.setItemIconTintList(null);

        // show user trên header
        mHeaderView = nv.getHeaderView(0);
        tvUser = mHeaderView.findViewById(R.id.tvUser);
        Intent i = getIntent();
        String user = i.getStringExtra("user");
        chuHangDAO = new ChuHangDAO(this);
        ChuHang chuHang = chuHangDAO.getID(user);
        String username = chuHang.getHoTen();
        tvUser.setText("Welcome " + username + "!");

        // admin co quyen add user
        Intent intent = getIntent();
        String logUser = intent.getStringExtra("user");
        Menu menu = nv.getMenu();
        MenuItem quanLydonHang = menu.findItem(R.id.nav_donHang);
        MenuItem quanLythongKe = menu.findItem(R.id.nav_thongKe);
        MenuItem quanLythanhVien = menu.findItem(R.id.nav_ThanhVien);
        MenuItem themNguoiDung = menu.findItem(R.id.sub_AddUser);
        if (!"admin".equals(logUser)) {
            quanLydonHang.setVisible(false);
            quanLythongKe.setVisible(false);
            quanLythanhVien.setVisible(false);
            themNguoiDung.setVisible(false);
        }




//        if (user.equalsIgnoreCase("admin")) {
//            nv.getMenu().findItem(R.id.sub_AddUser).setVisible(true);
//            nv.getMenu().findItem(R.id.nav_donHang).setVisible(true);
//            nv.getMenu().findItem(R.id.nav_thongKe).setVisible(true);
//            nv.getMenu().findItem(R.id.nav_ThanhVien).setVisible(true);
//        }
        frag_DonHang fragDonHang = new frag_DonHang();
        replaceFrg(fragDonHang);


        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.nav_donHang) {
                    setTitle("Quản lý đơn hàng");
                    replaceFrg(fragDonHang);

                } else if (id == R.id.nav_muaHang) {
                    setTitle("Mua hàng");
                    frag_MuaHang fragMuaHang = new frag_MuaHang();
                    replaceFrg(fragMuaHang);

                } else if (id == R.id.nav_thongKe) {
                    setTitle("Thống kê doanh thu");
                    frag_ThongKe fragThongKe = new frag_ThongKe();
                    replaceFrg(fragThongKe);

                } else if (id == R.id.nav_ThanhVien) {
                    setTitle("Quản lý Thành Viên");
                    frag_ThanhVien frthanhvien = new frag_ThanhVien();
                    replaceFrg(frthanhvien);

                } else if (id == R.id.nav_doiMK) {
                    setTitle("Đổi mật khẩu");
                    fragment_change_pass fragmentChangePass = new fragment_change_pass();
                    replaceFrg(fragmentChangePass);

                } else if (id == R.id.nav_Hang) {
                    setTitle("Hãng");
                    frag_Hang fradhang=new frag_Hang();
                    replaceFrg(fradhang);
                } else if (id == R.id.sub_AddUser) {
                    setTitle("Thêm người dùng");
                    fragment_add_user fad =new fragment_add_user();
                    replaceFrg(fad);


                } else if (id == R.id.nav_dangXuat) {
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Đăng xuất");
                    builder.setMessage("Bạn có muốn đăng xuất không?");
                    builder.setCancelable(true);

                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(MainActivity.this, Login_Activity.class);
                            Toast.makeText(MainActivity.this, "Đã đăng xuất", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            Toast.makeText(MainActivity.this, "Không đăng xuất", Toast.LENGTH_SHORT).show();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                    }
                drawer.closeDrawers();
                return true;
            }
        });
    }

    private void replaceFrg(Fragment frg) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.flContent,frg).commit();
    }
}