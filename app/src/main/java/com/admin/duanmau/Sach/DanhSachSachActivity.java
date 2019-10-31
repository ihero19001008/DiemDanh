package com.admin.duanmau.Sach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.admin.duanmau.Adapter.BookAdapter;
import com.admin.duanmau.Base.BaseActivity;
import com.admin.duanmau.DAO.BookDAO;
import com.admin.duanmau.Model.Book;
import com.admin.duanmau.R;

import java.util.ArrayList;
import java.util.List;

public class DanhSachSachActivity extends BaseActivity {

    private RecyclerView rvSach;
    private List<Book> list;
    private BookAdapter adapter;
    private BookDAO bookDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_sach);

        rvSach = (RecyclerView) findViewById(R.id.rvSach);
        bookDAO = new BookDAO(this);

        list = new ArrayList<>();
        list = bookDAO.getAllBook();
        adapter = new BookAdapter(this,list);
        rvSach.setLayoutManager(new LinearLayoutManager(this));
        rvSach.setAdapter(adapter);
    }

    public void removeBook(String bookID, int position){
        bookDAO.removeBook(bookID);
        list.remove(position);
        adapter.notifyDataSetChanged();
        showMessage("Xóa sách thành công");
    }

}
