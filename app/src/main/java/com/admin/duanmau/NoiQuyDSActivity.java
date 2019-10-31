package com.admin.duanmau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.admin.duanmau.Adapter.NoiQuyAdapter;
import com.admin.duanmau.DAO.CategoryDAO;
import com.admin.duanmau.Model.Category;

import java.util.ArrayList;
import java.util.List;

public class NoiQuyDSActivity extends AppCompatActivity {

    private RecyclerView rvTheLoai;
    private CategoryDAO categoryDAO;
    private List<Category> list;
    private NoiQuyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noi_quy_ds);
        rvTheLoai = (RecyclerView) findViewById(R.id.rvTheLoai);
        categoryDAO = new CategoryDAO(this);

        list = new ArrayList<>();
        list = categoryDAO.getAllCategory();
        adapter = new NoiQuyAdapter(this,list,categoryDAO);
        rvTheLoai.setLayoutManager(new LinearLayoutManager(this));
        rvTheLoai.setAdapter(adapter);
    }
}
