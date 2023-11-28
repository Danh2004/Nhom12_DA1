package com.example.nhom12_da1.Fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.example.nhom12_da1.Adapter.DonHangAdapter;
import com.example.nhom12_da1.Adapter.HangAdapter;
import com.example.nhom12_da1.Adapter.HangSpinner;
import com.example.nhom12_da1.DAO.DonHangDAO;
import com.example.nhom12_da1.DAO.HangDAO;
import com.example.nhom12_da1.DTO.DonHang;
import com.example.nhom12_da1.DTO.Hang;
import com.example.nhom12_da1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class frag_DonHang extends Fragment {
    ListView lvDonHang;
    ArrayList<DonHang> list;
    static DonHangDAO dao;
    DonHangAdapter adapter;
    DonHang item;
    Spinner spHang;

    FloatingActionButton fab;
    Dialog dialog;

    EditText edMadh,edTendh,edPhanloai,edSoluong,edGia,edHang;
    TextView edNgay;
    Button btnsave,btnCancel;
    int maHang;
    private SearchView searchView;
    HangSpinner hangSpinner;
    HangDAO hangDAO;
    Hang hang;
    ArrayList<Hang> listHang;
    int positionHang;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    int mYear,mMonth,mDay;

    public frag_DonHang() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.draw_view1, menu);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchItem = menu.findItem(R.id.search);
        searchView = (SearchView) searchItem.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                handleSearch(newText);
                return true;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.frag_donhang,container,false);
        lvDonHang=v.findViewById(R.id.lvDonHang);

        dao=new DonHangDAO(getActivity());
        capNhatLv();
        fab=v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(getActivity(),0);

            }
        });
        lvDonHang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item=list.get(position);
                openDialog(getActivity(),1);
                return ;
            }
        });

        return v;
    }
    void capNhatLv() {
        list = (ArrayList<DonHang>) dao.getAll();
        adapter = new DonHangAdapter(getActivity(), this, list);
        lvDonHang.setAdapter(adapter);
    }
    public void xoa(final String Id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Delete");
        builder.setMessage("Bạn có muốn xóa không?");
        builder.setCancelable(true);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dao.delete(Id);
                capNhatLv();
                dialog.cancel();
                Toast.makeText(getContext(), "Đã xóa", Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Toast.makeText(getContext(), "Không xóa", Toast.LENGTH_SHORT).show();

            }
        });
        AlertDialog alert = builder.create();
        builder.show();
    }


    protected void openDialog(final Context context,final int type){

        dialog =new Dialog(context);
        dialog.setContentView(R.layout.dialog_donhang);
        edMadh=dialog.findViewById(R.id.edMadh);
        edTendh=dialog.findViewById(R.id.edTengiay);
        edPhanloai=dialog.findViewById(R.id.edPhanloai);
        edSoluong=dialog.findViewById(R.id.edSoluong);
        edGia=dialog.findViewById(R.id.edGia);
        btnCancel=dialog.findViewById(R.id.btnCancelTT);
        btnsave=dialog.findViewById(R.id.btnSaveTT);

        edNgay=dialog.findViewById(R.id.edNgay);
        edNgay.setText("Ngay: "+sdf.format(new Date()));
        edMadh.setEnabled(false);

        //spinner
        hangDAO = new HangDAO(context);
        listHang = new ArrayList<Hang>();
        listHang = (ArrayList<Hang>) hangDAO.getAll();

        spHang = dialog.findViewById(R.id.spHang);
        hangSpinner = new HangSpinner(context,listHang);
        spHang.setAdapter(hangSpinner);
        spHang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maHang = listHang.get(position).getMaHang();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (type != 0) {
            edMadh.setText(String.valueOf(item.getMaDon()));
            for (int i = 0; i < listHang.size(); i++)
                if (item.getMaHang() == (listHang.get(i).getMaHang())) {
                    positionHang = i;
                }
            spHang.setSelection(positionHang);

            edNgay.setText("Ngày: "+sdf.format(item.getNgay()));

        }




        if (type !=0){
            edMadh.setText(String.valueOf(item.getMaDon()));
            edTendh.setText(item.getTenDon());
            edPhanloai.setText(item.getSizeGiayDon());
            edSoluong.setText(item.getSoLuongDon());
            edGia.setText(String.valueOf(item.getGiaDon()));
//            edHang.setText(item.getHangDon());
        }
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item=new DonHang();
                item.setTenDon(edTendh.getText().toString());
                item.setSizeGiayDon(edPhanloai.getText().toString());
                item.setSoLuongDon(edSoluong.getText().toString());
                item.setGiaDon(parseInt(edGia.getText().toString(),0));
                item.setNgay(new Date());
                if (validate() > 0) {
                    if (type == 0) {
                        if (dao.insert(item) > 0) {
                            Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        item.setMaDon(Integer.parseInt(edMadh.getText().toString()));
                        if (dao.update(item) > 0) {
                            Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Sửa thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                    capNhatLv();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();

    }




    public int validate() {
        int check = 1;
        if (edTendh.getText().length() == 0 || edPhanloai.getText().length() == 0 || edSoluong.getText().length() == 0 ||edGia.getText().length() == 0) {
            Toast.makeText(getContext(), "Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;

        }
        return check;

    }
//    ||edHang.getText().length() == 0
    public static int parseInt(String string, int defaultValue) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    private void handleSearch(String query) {
        List<DonHang> listSe = new ArrayList<>();
        for (DonHang donhang : list) {
            if (donhang.getTenDon().toLowerCase().contains(query.toLowerCase())) {
                listSe.add(donhang);
            }
        }
        adapter=new DonHangAdapter((getActivity()),this, (ArrayList<DonHang>) listSe);
                //        adapter = new DonHangAdapter(getActivity(), this, listSe);
        lvDonHang.setAdapter(adapter);

    }
    // Sắp xếp sách theo tên tăng dần
    private void sortBooksByNameAscending() {
        Collections.sort(list, new Comparator<DonHang>() {
            @Override
            public int compare(DonHang dh1, DonHang dh2) {
                return dh1.getTenDon().compareTo(dh2.getTenDon());

            }
        });
        adapter.notifyDataSetChanged();
    }

    // Sắp xếp sách theo tên giảm dần
    private void sortBooksByNameDescending() {
        Collections.sort(list, new Comparator<DonHang>() {
            @Override
            public int compare(DonHang dh1, DonHang dh2) {
                return dh2.getTenDon().compareTo(dh1.getTenDon());

            }
        });
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.asc){
            sortBooksByNameAscending();
            return true;
        }else if(id == R.id.desc){
            sortBooksByNameDescending();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
