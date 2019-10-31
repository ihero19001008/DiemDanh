package com.admin.duanmau.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.admin.duanmau.DAO.UserDAO;
import com.admin.duanmau.Fragment.DanhSachNguoiDungFragment;
import com.admin.duanmau.Model.User;
import com.admin.duanmau.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    Context context;
    List<User> userList;
    DanhSachNguoiDungFragment fragment;
    UserDAO userDAO;

    public UserAdapter(Context context, List<User> userList, UserDAO userDAO) {
        this.context = context;
        this.userList = userList;
        this.userDAO = userDAO;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item_nguoi_dung,viewGroup,false);

        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder,  int position) {
        final int i= position;
        final User user = userList.get(i);
        holder.txtHoTenNguoiDung.setText(user.getFullname());
        holder.txtWorked.setText(user.getWorked());
        holder.txtCheck.setText("Chưa điểm danh");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.setTitle(userList.get(i).getUsername());
                dialog.setContentView(R.layout.dialog_edit_user);
                final EditText edtUsername;
                final   EditText edtPassword;
                final  EditText edtFullname;
                final  EditText edtPhone;
                final EditText edtDoB;
                final EditText edtAddress;
                final EditText edtFinelv;
                final EditText edtComlv;
                final EditText edtWorked;

                String username,password,phone,fullname,dob,address,finelv,comlv,worked,check;
                edtUsername = dialog.findViewById(R.id.edtUsernameMoi);
                edtFullname = dialog.findViewById(R.id.edtHoTenMoi);
                edtPassword = dialog.findViewById(R.id.edtPasswordMoi);
                edtAddress = dialog.findViewById(R.id.edtNewAdđress);
                edtPhone = dialog.findViewById(R.id.edtPhoneMoi);
                edtDoB = dialog.findViewById(R.id.edtDatemoi);
                edtComlv = dialog.findViewById(R.id.edtCommoi);
                edtFinelv = dialog.findViewById(R.id.edtFinemoi);
                edtWorked = dialog.findViewById(R.id.edtWorkedmoi);


                edtUsername.setText(userList.get(i).getUsername());
                edtPassword.setText(userList.get(i).getPassword());
                edtFullname.setText(userList.get(i).getFullname());
                edtPhone.setText(userList.get(i).getPhone());
                edtAddress.setText(userList.get(i).getAddress());
                edtDoB.setText(userList.get(i).getDob());
                edtComlv.setText(userList.get(i).getComlevel());
                edtFinelv.setText(userList.get(i).getFinelevel());
                edtWorked.setText(userList.get(i).getWorked());

                dialog.findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        User nuser = new User();
                        nuser.setUsername(edtUsername.getText().toString());
                        nuser.setPassword(edtPassword.getText().toString());
                        nuser.setPhone(edtPhone.getText().toString());
                        nuser.setAddress(edtAddress.getText().toString());
                        nuser.setFullname(edtFullname.getText().toString());
                        nuser.setDob(edtDoB.getText().toString());
                        nuser.setFinelevel(edtFinelv.getText().toString());
                        nuser.setComlevel(edtComlv.getText().toString());
                        nuser.setWorked(edtWorked.getText().toString());
                        userDAO.updateUser(nuser);
                        // cap nhat thay doi tren giao dien
                        userList.get(i).setFullname(edtFullname.getText().toString().trim());
                        userList.get(i).setWorked(edtWorked.getText().toString().trim());
                        userList.get(i).setUsername(edtUsername.getText().toString().trim());
                        userList.get(i).setPassword(edtPassword.getText().toString().trim());
                        userList.get(i).setPhone(edtPhone.getText().toString().trim());
                        userList.get(i).setAddress(edtAddress.getText().toString().trim());
                        userList.get(i).setFinelevel(edtFinelv.getText().toString().trim());
                        userList.get(i).setComlevel(edtComlv.getText().toString().trim());
                        userList.get(i).setDob(edtDoB.getText().toString().trim());

                        notifyDataSetChanged();
                        Toast.makeText(context,"Sửa thành công",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }

                });
                dialog.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        holder.imgCloseUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDAO.removeUser(userList.get(i).getUsername());
                userList.remove(i);
                notifyDataSetChanged();
                //fragment.removeUser(user.getUsername(), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {
        TextView txtHoTenNguoiDung;
        ImageView imgCloseUser;
        TextView txtWorked,txtCheck;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            txtHoTenNguoiDung = itemView.findViewById(R.id.txtHoTenNguoiDung);
            txtCheck = itemView.findViewById(R.id.txtCheck);
            imgCloseUser = itemView.findViewById(R.id.imgCloseUser);
            txtWorked = itemView.findViewById(R.id.txtWorked);
        }
    }
}
