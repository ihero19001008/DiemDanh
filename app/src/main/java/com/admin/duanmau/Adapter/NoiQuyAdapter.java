package com.admin.duanmau.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.admin.duanmau.DAO.CategoryDAO;
import com.admin.duanmau.Model.Category;
import com.admin.duanmau.R;
import com.admin.duanmau.SuaNoiQuyActivity;
import com.admin.duanmau.TheLoaiSach.DanhSachTheLoaiActivity;

import java.util.List;

public class NoiQuyAdapter extends RecyclerView.Adapter<NoiQuyAdapter.NoiQuyViewHolder> {

    Context context;
    DanhSachTheLoaiActivity danhSachTheLoaiActivity;
    List<Category> categoryList;
    private CategoryDAO categoryDAO;
    DanhSachTheLoaiActivity danhsach;
    public NoiQuyAdapter(Context context, List<Category> categoryList,CategoryDAO categoryDAO) {
        this.context = context;
        this.categoryList = categoryList;
        this.categoryDAO = categoryDAO;
    }

    @NonNull
    @Override
    public NoiQuyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.noi_quy_nv,viewGroup,false);

        return new NoiQuyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoiQuyViewHolder holder, final int i) {

        final Category category = categoryList.get(i);
        holder.txtIdTheLoai.setText(category.matheloai);
        holder.txtTenTheLoai.setText(category.tentheloai);
        holder.txtGiatri.setText(category.vitri);
        holder.txtGhichu.setText(category.mota);




    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class NoiQuyViewHolder extends RecyclerView.ViewHolder {

        TextView txtIdTheLoai,txtTenTheLoai,txtGiatri,txtGhichu;



        public NoiQuyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtIdTheLoai= itemView.findViewById(R.id.txtIdTheLoai);
            txtTenTheLoai = itemView.findViewById(R.id.txtTenTheLoai);

            txtGiatri= itemView.findViewById(R.id.txtGiatri);
            txtGhichu= itemView.findViewById(R.id.txtGhichu);
            // tvEdit = itemView.findViewById(R.id.tvEdit);


        }
    }
}

