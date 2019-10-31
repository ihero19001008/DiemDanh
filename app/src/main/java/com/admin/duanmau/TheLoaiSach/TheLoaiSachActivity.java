package com.admin.duanmau.TheLoaiSach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.admin.duanmau.Base.BaseActivity;
import com.admin.duanmau.DAO.CategoryDAO;
import com.admin.duanmau.Model.Category;
import com.admin.duanmau.R;

public class TheLoaiSachActivity extends BaseActivity implements View.OnClickListener {

    private EditText edtMaTheLoai;
    private EditText edtTenTheLoai;
    private EditText edtViTriTheLoai;
    private EditText edtMoTaTheLoai,edtManoiquy;
    private Button btnThemTheLoai;
    private Button btnHuyBoTheLoai;
    private Button btnDanhSachTheLoai;
    private CategoryDAO categoryDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai_sach);

        this.initView();

    }

    public void validateForm(){
        try {
            String matheloai = edtMaTheLoai.getText().toString();
            String tentheloai = edtTenTheLoai.getText().toString();
            String vitri = (edtViTriTheLoai.getText().toString());
            String mota = edtMoTaTheLoai.getText().toString();
            String id =( edtManoiquy.getText().toString());

//            if(matheloai.length() != 5){
//                showMessage("Vui lòng nhập mã thể loại 5 ký tự");
//            }
//            else
        if(categoryDAO.insertCategory(new Category(id,matheloai,tentheloai,vitri,mota)) > 0){
                showMessage("Thêm nội quy thành công");
                this.cancelAllView();
            }
            else if(categoryDAO.insertCategory(new Category(id,matheloai,tentheloai,vitri,mota)) <= 0){
                showMessage("Thêm nội quy thất bại ");
            }

        }catch (NumberFormatException e){
            this.showMessage("Vui lòng nhập vị trí là số");
        }
    }

    public void initView(){
        categoryDAO = new CategoryDAO(this);
        edtMaTheLoai = (EditText) findViewById(R.id.edtMaTheLoai);
        edtTenTheLoai = (EditText) findViewById(R.id.edtTenTheLoai);
        edtViTriTheLoai = (EditText) findViewById(R.id.edtViTriTheLoai);
        edtMoTaTheLoai = (EditText) findViewById(R.id.edtMoTaTheLoai);
        btnThemTheLoai = (Button) findViewById(R.id.btnThemTheLoai);
        btnHuyBoTheLoai = (Button) findViewById(R.id.btnHuyBoTheLoai);
        btnDanhSachTheLoai = (Button) findViewById(R.id.btnDanhSachTheLoai);
        edtManoiquy = (EditText)findViewById(R.id.edtMaNoiquy);
        btnThemTheLoai.setOnClickListener(this);
        btnHuyBoTheLoai.setOnClickListener(this);
        btnDanhSachTheLoai.setOnClickListener(this);
    }

    public void cancelAllView(){
        edtMaTheLoai.setText("");
        edtTenTheLoai.setText("");
        edtViTriTheLoai.setText("");
        edtMoTaTheLoai.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v == btnDanhSachTheLoai){
            changeClass(DanhSachTheLoaiActivity.class);
        }
        else if(v == btnHuyBoTheLoai){
            this.cancelAllView();
        }
        else if(v == btnThemTheLoai){
            this.validateForm();
        }
    }
}
