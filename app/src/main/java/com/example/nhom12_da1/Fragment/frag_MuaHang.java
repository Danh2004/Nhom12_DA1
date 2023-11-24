package com.example.nhom12_da1.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhom12_da1.Adapter.SanPhamAdapter;
import com.example.nhom12_da1.DTO.Sanpham;
import com.example.nhom12_da1.GioHangActivity;
import com.example.nhom12_da1.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class frag_MuaHang extends Fragment {
    private static final int MENU_ITEM_GIOHANG = 1;
    private ArrayList<Sanpham> list = new Sanpham().getAll();
    private SanPhamAdapter sanPhamAdapter;
    private RecyclerView recyclerView;
    private TextInputEditText find;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_giohang, container, false);
        setHasOptionsMenu(true); // Indicate that this fragment has its own options menu
        init(view);
        setTitle("TRANG CHỦ");
        setFindNews();
        return view;
    }

    private void setFindNews() {
        recyclerView.setFilterTouchesWhenObscured(true);
        find.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count < before) {
                    System.out.println("Text [" + s + "] - Start [" + start + "] - Before [" + before + "] - Count [" + count + "]");
                    sanPhamAdapter.resetData();
                }
                sanPhamAdapter.getFilter().filter(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void init(View view) {
        find = view.findViewById(R.id.tvFind);
        recyclerView = view.findViewById(R.id.rcvListNews);
        LinearLayoutManager layoutManager = new GridLayoutManager(requireContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        sanPhamAdapter = new SanPhamAdapter(requireContext(), list);
        recyclerView.setAdapter(sanPhamAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_giohang, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.giohang) {
            startActivity(new Intent(requireContext(), GioHangActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void setTitle(String title) {
        requireActivity().setTitle(title);
    }
}
