package com.admin.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.admin.duanmau.Model.Category;
import com.admin.duanmau.Model.User;
import com.admin.duanmau.SQLite.Database;

import java.util.ArrayList;
import java.util.List;

import static com.admin.duanmau.SQLite.Constants.category_describe;

import static com.admin.duanmau.SQLite.Constants.category_id;
import static com.admin.duanmau.SQLite.Constants.id;
import static com.admin.duanmau.SQLite.Constants.category_name;
import static com.admin.duanmau.SQLite.Constants.category_position;
import static com.admin.duanmau.SQLite.Constants.category_table;
import static com.admin.duanmau.SQLite.Constants.user_address;
import static com.admin.duanmau.SQLite.Constants.user_comlevel;
import static com.admin.duanmau.SQLite.Constants.user_dob;
import static com.admin.duanmau.SQLite.Constants.user_finelevel;
import static com.admin.duanmau.SQLite.Constants.user_fullname;
import static com.admin.duanmau.SQLite.Constants.user_password;
import static com.admin.duanmau.SQLite.Constants.user_phone;
import static com.admin.duanmau.SQLite.Constants.user_table;
import static com.admin.duanmau.SQLite.Constants.user_username;
import static com.admin.duanmau.SQLite.Constants.user_worked;

public class CategoryDAO {

    Database database;

    public CategoryDAO(Context context) {
        this.database = new Database(context);
    }

    public long insertCategory(Category category){
        long result = -1;

        ContentValues c = new ContentValues();
        c.put(id,category.id);
        c.put(category_id, category.matheloai);
        c.put(category_name, category.tentheloai);
        c.put(category_position, category.vitri);
        c.put(category_describe , category.mota);


        SQLiteDatabase db = database.getWritableDatabase();
        result = db.insert(category_table, null, c);
        db.close();

        return result;
    }

    public long removeCategory(String categoryID){
        long result = -1;

        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        result = sqLiteDatabase.delete(category_table, id+"=?", new String[]{categoryID});
        sqLiteDatabase.close();

        return result;
    }

    public long updateCategory(Category category) {
        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues c = new ContentValues();
        c.put(id,category.id);
        c.put(category_id, category.matheloai);
        c.put(category_name, category.tentheloai);
        c.put(category_position, category.vitri);
        c.put(category_describe , category.mota);
        // updating row
        return db.update(category_table, c, id + " = ?",
                new String[]{String.valueOf(category.matheloai)});
    }
    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<>();

        String query = "select * from "+category_table;
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);

        if(c != null){
            if(c.getCount() > 0){
                while (c.moveToNext()){
                    String matheloai = c.getString(1);
                    String tentheloai = c.getString(2);
                    String vitri = (c.getString(3));
                    String mota = c.getString(4);
                    String id = (c.getString(0));
                    Category category = new Category(id,matheloai,tentheloai,vitri,mota);
                    list.add(category);
                }
                c.close();
                db.close();
            }
        }

        return list;
    }

}
