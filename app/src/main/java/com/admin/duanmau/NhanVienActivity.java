package com.admin.duanmau;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.admin.duanmau.Base.BaseActivity;
import com.admin.duanmau.DAO.UserDAO;
import com.admin.duanmau.DangNhap.DangNhapActivity;
import com.admin.duanmau.Model.User;
import com.admin.duanmau.NguoiDungActivity.NguoiDungActivity;

import java.util.ArrayList;
import java.util.List;

public class NhanVienActivity extends BaseActivity implements View.OnClickListener {
    private UserDAO userDAO;
    private TextView tvdob,tvname,tvsdt,tvdiachi,tvngaycong,tvmucphat,tvmucthuong,tvdiemdanh,tvlogout;
    private String username,password;
    private List<User> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);
        tvname = (TextView) findViewById(R.id.tvname);
        tvsdt = (TextView) findViewById(R.id.tvsdt);
        tvdiachi = (TextView) findViewById(R.id.tvdiachi);
        tvdob = (TextView) findViewById(R.id.tvdob);

        tvngaycong = (TextView) findViewById(R.id.tvngaycong);
        tvmucphat = (TextView) findViewById(R.id.tvmucphat);
        tvmucthuong = (TextView) findViewById(R.id.tvthuong);
        tvdiemdanh = (TextView) findViewById(R.id.tvDiemdanh);
        tvlogout = (TextView) findViewById(R.id.tvLogout);

        Intent intent = getIntent();
        username= intent.getStringExtra("username");
        password= intent.getStringExtra("password");

       userDAO = new UserDAO(this);


      User user = userDAO.getUsers(username);
       // Log.e("euu",user.getFullname());
      // tvname.setText(user.getFullname());
       tvsdt.setText(user.getPhone());
       tvdiachi.setText(user.getAddress());
       tvngaycong.setText(user.getWorked());
       tvmucphat.setText(user.getFinelevel());
       tvmucthuong.setText(user.getComlevel());
        tvname.setText(user.getFullname());
        tvdob.setText(user.getDob());
        tvdiemdanh.setOnClickListener(this);
        tvlogout.setOnClickListener(this);

    }

    private void Diemdanh(){
        Integer ngaycong = Integer.valueOf(tvngaycong.getText().toString().trim());
        ngaycong++;
        tvngaycong.setText(String.valueOf(ngaycong));
        Toast.makeText(this, "Điểm danh thành công", Toast.LENGTH_SHORT).show();
        User nuser = new User();
        nuser.setUsername(username);
        nuser.setPassword(password);
        nuser.setFullname(tvname.getText().toString().trim());
        nuser.setPhone(tvsdt.getText().toString().trim());
        nuser.setDob(tvdob.getText().toString().trim());
        nuser.setAddress(tvdiachi.getText().toString().trim());
        nuser.setFinelevel(tvmucphat.getText().toString().trim());
        nuser.setComlevel(tvmucthuong.getText().toString().trim());
        nuser.setWorked(tvngaycong.getText().toString().trim());
        userDAO.updateUser(nuser);
        tvdiemdanh.setText("Bạn đã điểm danh");
        tvdiemdanh.setEnabled(false);
    }
    @Override
    public void onClick(View view) {
        if(view == tvdiemdanh){
            Diemdanh();
        }
        else if(view == tvlogout) {
            changeClass(DangNhapActivity.class);
        }

    }
    public void Danhsach(View view) {
        changeClass(DanhSachActivity.class);
    }

    public void Noiquy(View view) {
        changeClass(NoiQuyDSActivity.class);
    }
}
