package com.admin.duanmau.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.admin.duanmau.DAO.CategoryDAO;
import com.admin.duanmau.Model.Category;
import com.admin.duanmau.R;
import com.admin.duanmau.SuaNoiQuyActivity;
import com.admin.duanmau.TheLoaiSach.DanhSachTheLoaiActivity;
import com.admin.duanmau.TheLoaiSach.TheLoaiSachActivity;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    Context context;
    DanhSachTheLoaiActivity danhSachTheLoaiActivity;
    List<Category> categoryList;
    private CategoryDAO categoryDAO;
    DanhSachTheLoaiActivity danhsach;

    public CategoryAdapter(Context context, List<Category> categoryList,CategoryDAO categoryDAO) {
        this.context = context;
        this.categoryList = categoryList;
        this.categoryDAO = categoryDAO;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_the_loai,viewGroup,false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder,final int i) {

        final Category category = categoryList.get(i);
        holder.txtIdTheLoai.setText(category.matheloai);
        holder.txtTenTheLoai.setText(category.tentheloai);
        holder.txtGiatri.setText(category.vitri);
        holder.txtGhichu.setText(category.mota);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hinh_thuc = categoryList.get(i).getMatheloai();
                String muc_do = categoryList.get(i).getTentheloai();
                String cach_thuc = categoryList.get(i).getVitri();
                String ghi_chu = categoryList.get(i).getMota();
                String vitri = String.valueOf(i);
                Intent intent = new Intent(context, SuaNoiQuyActivity.class);
                intent.putExtra("Hinh_Thuc",hinh_thuc);
                intent.putExtra("Muc_Do",muc_do);
                intent.putExtra("Cach_Thuc",cach_thuc);
                intent.putExtra("Ghi_Chu",ghi_chu);
                intent.putExtra("position",vitri);
                context.startActivity(intent);
//                final Dialog ndialog = new Dialog(context);
//                ndialog.setTitle(categoryList.get(i).getMatheloai());
//                ndialog.setContentView(R.layout.dialog_edit_category);
//                final EditText edtHinhthuc;
//                final EditText edtMucdo;
//                final EditText edtCachthuc;
//                final EditText edtGhichu;


//                 edtHinhthuc = (EditText) ndialog.findViewById(R.id.edtHinhthucmoi);
//                 edtMucdo=(EditText) ndialog.findViewById(R.id.edtMucdomoi);
//                 edtCachthuc=(EditText) ndialog.findViewById(R.id.edtCachthucmoi);
//                 edtGhichu=(EditText) ndialog.findViewById(R.id.edtGhichumoi);
//
//                edtHinhthuc.setText(categoryList.get(i).getMatheloai());
//                edtMucdo.setText(categoryList.get(i).getTentheloai());
//                edtCachthuc.setText(categoryList.get(i).getVitri());
//                edtGhichu.setText(categoryList.get(i).getMota());
//
//
//                ndialog.findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Category ncategory = new Category();
//                        ncategory.setMatheloai(edtHinhthuc.getText().toString());
//                        ncategory.setTentheloai(edtMucdo.getText().toString());
//                        ncategory.setVitri(edtCachthuc.getText().toString());
//                        ncategory.setMota(edtGhichu.getText().toString());
//                        categoryDAO.updateCategory(ncategory);
//                        categoryList.get(i).setMatheloai(edtHinhthuc.getText().toString().trim());
//                        categoryList.get(i).setTentheloai(edtMucdo.getText().toString().trim());
//                        categoryList.get(i).setVitri(edtCachthuc.getText().toString().trim());
//                        categoryList.get(i).setMota(edtGhichu.getText().toString().trim());
//                        notifyDataSetChanged();
//                        Toast.makeText(context,"Sửa thành công",Toast.LENGTH_SHORT).show();
//                        ndialog.dismiss();
//                    }
//                });
//                ndialog.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        ndialog.dismiss();
//                    }
//                });
//
//                Toast.makeText(context,"Sửa thành công",Toast.LENGTH_SHORT).show();
            }
        });


        holder.imgCloseTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryDAO.removeCategory(categoryList.get(i).getMatheloai());
                categoryList.remove(i);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView txtIdTheLoai,txtTenTheLoai,txtGiatri,txtGhichu;
        ImageView imgCloseTheLoai;


        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            txtIdTheLoai= itemView.findViewById(R.id.txtIdTheLoai);
            txtTenTheLoai = itemView.findViewById(R.id.txtTenTheLoai);
            imgCloseTheLoai = itemView.findViewById(R.id.imgCloseTheLoai);
            txtGiatri= itemView.findViewById(R.id.txtGiatri);
            txtGhichu= itemView.findViewById(R.id.txtGhichu);
           // tvEdit = itemView.findViewById(R.id.tvEdit);


        }
    }
}
