package com.admin.duanmau;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.admin.duanmau.DAO.CategoryDAO;
import com.admin.duanmau.Model.Category;
import com.admin.duanmau.SQLite.Database;
import com.admin.duanmau.TheLoaiSach.DanhSachTheLoaiActivity;

import java.util.List;

import static com.admin.duanmau.SQLite.Constants.category_describe;
import static com.admin.duanmau.SQLite.Constants.category_id;
import static com.admin.duanmau.SQLite.Constants.category_name;
import static com.admin.duanmau.SQLite.Constants.category_position;
import static com.admin.duanmau.SQLite.Constants.category_table;

public class SuaNoiQuyActivity extends AppCompatActivity {
    private EditText edtHinhthuc,edtMucdo,edtCachthuc,edtGhichu;
    private Button btnSave, btnNull;
    CategoryDAO categoryDAO;
    List<Category> categoryList;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_noi_quy);
        edtHinhthuc= (EditText)findViewById(R.id.edtHinhthucmoi);
        edtCachthuc= (EditText)findViewById(R.id.edtCachthucmoi);
        edtMucdo= (EditText)findViewById(R.id.edtMucdomoi);
        edtGhichu= (EditText)findViewById(R.id.edtGhichumoi);
        btnNull = (Button) findViewById(R.id.btnNull);
        btnSave = (Button) findViewById(R.id.btnChange);


        Intent intent = getIntent();
//get the attached extras from the intent
//we should use the same key as we used to attach the data.
        String hinhThuc = intent.getStringExtra("Hinh_Thuc");
        String mucdo= intent.getStringExtra("Muc_Do");
        String cachthuc= intent.getStringExtra("Cach_Thuc");
        String ghichu= intent.getStringExtra("Ghi_Chu");
        String vitri =intent.getStringExtra("position");
       final int i= Integer.valueOf(vitri);
        edtHinhthuc.setText(hinhThuc);
        edtMucdo.setText(mucdo);
        edtCachthuc.setText(cachthuc);
        edtGhichu.setText(ghichu);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Category category = new Category();
                category.setMatheloai(edtHinhthuc.getText().toString());
                category.setTentheloai(edtMucdo.getText().toString());
                category.setVitri(edtCachthuc.getText().toString());
                category.setMota(edtGhichu.getText().toString());
                //SQLiteDatabase db = database.getWritableDatabase();

//                ContentValues c = new ContentValues();
//                c.put(category_id, category.matheloai);
//                c.put(category_name, category.tentheloai);
//                c.put(category_position, category.vitri);
//                c.put(category_describe , category.mota);
//                // updating row
//                db.update(category_table, c, category_id + " = ?",
//                        new String[]{String.valueOf(category.matheloai)});
                categoryList.get(i).setMatheloai(edtHinhthuc.getText().toString().trim());
                categoryList.get(i).setTentheloai(edtMucdo.getText().toString().trim());
                categoryList.get(i).setVitri(edtCachthuc.getText().toString().trim());
                categoryList.get(i).setMota(edtGhichu.getText().toString().trim());

                Toast.makeText(SuaNoiQuyActivity.this,"Sửa thành công",Toast.LENGTH_SHORT).show();
                Intent intList = new Intent(SuaNoiQuyActivity.this, DanhSachTheLoaiActivity.class);
                startActivity(intList);
            }
        });

    }
}
