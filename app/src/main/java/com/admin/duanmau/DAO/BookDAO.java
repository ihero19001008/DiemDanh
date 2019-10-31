package com.admin.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.admin.duanmau.Model.Book;
import com.admin.duanmau.Model.User;
import com.admin.duanmau.SQLite.Database;

import java.util.ArrayList;
import java.util.List;

import static com.admin.duanmau.SQLite.Constants.book_amount;
import static com.admin.duanmau.SQLite.Constants.book_category_id;
import static com.admin.duanmau.SQLite.Constants.book_id;
import static com.admin.duanmau.SQLite.Constants.book_name;
import static com.admin.duanmau.SQLite.Constants.book_price;
import static com.admin.duanmau.SQLite.Constants.book_table;
import static com.admin.duanmau.SQLite.Constants.category_id;
import static com.admin.duanmau.SQLite.Constants.category_table;
import static com.admin.duanmau.SQLite.Constants.user_fullname;
import static com.admin.duanmau.SQLite.Constants.user_password;
import static com.admin.duanmau.SQLite.Constants.user_phone;
import static com.admin.duanmau.SQLite.Constants.user_table;
import static com.admin.duanmau.SQLite.Constants.user_username;

public class BookDAO {

    Database database;

    public BookDAO(Context context) {
        this.database = new Database(context);
    }

    public long insertBook(Book book){
        long result = -1;

        ContentValues c = new ContentValues();
        c.put(book_id, book.masach);
        c.put(book_category_id, book.matheloai);
        c.put(book_name, book.tensach);
        c.put(book_price , book.giabia);
        c.put(book_amount , book.soluong);

        SQLiteDatabase db = database.getWritableDatabase();
        result = db.insert(book_table, null, c);
        db.close();

        return result;
    }

    public long removeBook(String bookID){
        long result = -1;

        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        result = sqLiteDatabase.delete(book_table, book_id+"=?", new String[]{bookID});
        sqLiteDatabase.close();

        return result;
    }


    public List<Book> getAllBook(){
        List<Book> list = new ArrayList<>();

        String query = "select * from "+book_table;
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);

        if(c != null){
            if(c.getCount() > 0){
                while (c.moveToNext()){
                    String masach = c.getString(0);
                    String matheloai = c.getString(1);
                    String tensach = c.getString(2);
                    String giabia = (c.getString(3));
                    String soluong = (c.getString(4));

                    Book book = new Book(masach,matheloai,tensach,giabia,soluong);
                    list.add(book);
                }
                c.close();
                db.close();
            }
        }

        return list;
    }

}
