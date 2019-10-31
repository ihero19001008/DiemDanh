package com.admin.duanmau.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.admin.duanmau.DAO.UserDAO;
import com.admin.duanmau.Model.User;
import com.admin.duanmau.R;

public class ThemNguoiDungFragment extends Fragment implements View.OnClickListener {

    private View rootview;
    private EditText edtHoTenMoi;
    private EditText edtUsernameMoi;
    private EditText edtPasswordMoi;
    private EditText edtPhoneMoi;
    private EditText edtDatemoi;
    private EditText edtFinemoi;
    private EditText edtCommoi;
    private EditText edtAddressmoi;
    private EditText edtWorkedmoi;
    private Button btnXacNhanMoi;
    private UserDAO userDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_them_nguoi_dung,container,false);

        userDAO = new UserDAO(getContext());
        edtHoTenMoi = (EditText) rootview.findViewById(R.id.edtHoTenMoi);
        edtUsernameMoi = (EditText) rootview.findViewById(R.id.edtUsernameMoi);
        edtPasswordMoi = (EditText) rootview.findViewById(R.id.edtPasswordMoi);
        edtPhoneMoi = (EditText) rootview.findViewById(R.id.edtPhoneMoi);
        btnXacNhanMoi = (Button) rootview.findViewById(R.id.btnXacNhanMoi);
        edtDatemoi = (EditText) rootview.findViewById(R.id.edtDatemoi);
        edtAddressmoi = (EditText) rootview.findViewById(R.id.edtNewAdđress);
        edtFinemoi = (EditText) rootview.findViewById(R.id.edtFinemoi);
        edtCommoi = (EditText) rootview.findViewById(R.id.edtCommoi);
        edtWorkedmoi = (EditText) rootview.findViewById(R.id.edtWorkedmoi);

        btnXacNhanMoi.setOnClickListener(this);

        return rootview;
    }

    public void validateForm(){
        String username = edtUsernameMoi.getText().toString();
        String password = edtPasswordMoi.getText().toString();
        String phone = edtPhoneMoi.getText().toString();
        String fullname = edtHoTenMoi.getText().toString();
        String dob = edtDatemoi.getText().toString();
        String address = edtAddressmoi.getText().toString();
        String fine = "0";
        String com = "0";
        String worked = "0";
        //String check = "Chưa điểm danh";
        if(username.length() < 5){
            this.showMessage("Vui lòng nhập username lớn hơn 5 ký tự");
        }
        else if(password.length() < 5){
            this.showMessage("Vui lòng nhập password lớn hơn 5 ký tự");
        }
        else if(phone.isEmpty()){
            showMessage("Vui lòng nhập số điện thoại");
        }
        else if(fullname.isEmpty()){
            showMessage("Vui lòng nhập họ tên");
        }
        else if(userDAO.insertUser(new User(username,password,phone,fullname,dob,address,fine,com,worked)) > 0){
            showMessage("Thêm người dùng thành công");
            this.cancelAllView();
        }
        else if(userDAO.insertUser(new User(username,password,phone,fullname,dob,address,fine,com,worked)) <= 0){
            showMessage("Thêm người dùng thất bại do trùng username");
        }
    }

    public void cancelAllView(){
        edtUsernameMoi.setText("");
        edtPasswordMoi.setText("");
        edtPhoneMoi.setText("");
        edtHoTenMoi.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v == btnXacNhanMoi){
            this.validateForm();
        }
    }

    public void showMessage(String message){
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

}
