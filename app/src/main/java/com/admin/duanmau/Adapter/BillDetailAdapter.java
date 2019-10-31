package com.admin.duanmau.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.admin.duanmau.Model.BillDetail;
import com.admin.duanmau.Model.Invoice;
import com.admin.duanmau.R;

import java.util.List;

public class BillDetailAdapter extends RecyclerView.Adapter<BillDetailAdapter.BillDetailHolder> {

    Context context;
    List<BillDetail> list;

    public BillDetailAdapter(Context context, List<BillDetail> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BillDetailHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_chi_tiet_hoa_don,viewGroup,false);
        return new BillDetailHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillDetailHolder holder, int i) {
        BillDetail billDetail = list.get(i);
        holder.txtIDSach.setText(billDetail.getTensach());
        holder.txtIDHoaDon.setText(billDetail.getMahoadon());
        holder.txtGiaBia.setText(Double.toString(billDetail.getGiabia()));
        holder.txtSoLuongMua.setText(String.valueOf(billDetail.getSoluongmua()));
        holder.txtThanhTien.setText(Double.toString(billDetail.getThanhtien()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class BillDetailHolder extends RecyclerView.ViewHolder {

        TextView txtIDSach;
        TextView txtIDHoaDon;
        TextView txtSoLuongMua;
        TextView txtGiaBia;
        TextView txtThanhTien;

        public BillDetailHolder(@NonNull View itemView) {
            super(itemView);

            txtIDSach = (TextView) itemView.findViewById(R.id.txtIDSach);
            txtIDHoaDon = (TextView) itemView.findViewById(R.id.txtIDHoaDon);
            txtSoLuongMua = (TextView) itemView.findViewById(R.id.txtSoLuongMua);
            txtGiaBia = (TextView) itemView.findViewById(R.id.txtGiaBia);
            txtThanhTien = (TextView) itemView.findViewById(R.id.txtThanhTien);

        }
    }
}
