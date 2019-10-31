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

import com.admin.duanmau.Model.Book;
import com.admin.duanmau.R;
import com.admin.duanmau.Sach.DanhSachSachActivity;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{

    public DanhSachSachActivity context;
    public List<Book> bookList;

    public BookAdapter(DanhSachSachActivity context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_sach,viewGroup,false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int i) {
        final int position = i;
        final Book book = bookList.get(i);
        holder.txtTenSach.setText(book.tensach);
        holder.txtSoLuongSach.setText(String.valueOf(book.soluong));
        holder.imgCloseSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.removeBook(book.masach, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        TextView txtTenSach,txtSoLuongSach;
        ImageView imgCloseSach;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTenSach = itemView.findViewById(R.id.txtTenSach);
            txtSoLuongSach = itemView.findViewById(R.id.txtSoLuongSach);
            imgCloseSach = itemView.findViewById(R.id.imgCloseSach);

        }
    }
}
