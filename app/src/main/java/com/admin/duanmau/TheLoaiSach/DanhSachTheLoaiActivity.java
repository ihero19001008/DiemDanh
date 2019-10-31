package com.admin.duanmau.TheLoaiSach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.admin.duanmau.Adapter.CategoryAdapter;
import com.admin.duanmau.Base.BaseActivity;
import com.admin.duanmau.DAO.CategoryDAO;
import com.admin.duanmau.Model.Category;
import com.admin.duanmau.R;

import java.util.ArrayList;
import java.util.List;

public class DanhSachTheLoaiActivity extends BaseActivity {

    private RecyclerView rvTheLoai;
    private CategoryDAO categoryDAO;
    private List<Category> list;
    private CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_the_loai);

        rvTheLoai = (RecyclerView) findViewById(R.id.rvTheLoai);
        categoryDAO = new CategoryDAO(this);

        list = new ArrayList<>();
        list = categoryDAO.getAllCategory();
        adapter = new CategoryAdapter(this,list,categoryDAO);
        rvTheLoai.setLayoutManager(new LinearLayoutManager(this));
        rvTheLoai.setAdapter(adapter);

    }

    public void removeCategory(String categoryID, int position){
        categoryDAO.removeCategory(categoryID);
        list.remove(position);
        adapter.notifyDataSetChanged();
        showMessage("Xóa nội quy thành công");
    }

}
