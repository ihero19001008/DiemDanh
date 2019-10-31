package com.admin.duanmau.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.admin.duanmau.Model.User;

import java.util.ArrayList;
import java.util.List;

import static com.admin.duanmau.SQLite.Constants.bill_table;
import static com.admin.duanmau.SQLite.Constants.book_table;
import static com.admin.duanmau.SQLite.Constants.category_table;
import static com.admin.duanmau.SQLite.Constants.create_bill_detail_table;
import static com.admin.duanmau.SQLite.Constants.create_bill_table;
import static com.admin.duanmau.SQLite.Constants.create_book_table;
import static com.admin.duanmau.SQLite.Constants.create_category_table;
import static com.admin.duanmau.SQLite.Constants.create_user_table;
import static com.admin.duanmau.SQLite.Constants.detail_bill_table;
import static com.admin.duanmau.SQLite.Constants.user_fullname;
import static com.admin.duanmau.SQLite.Constants.user_password;
import static com.admin.duanmau.SQLite.Constants.user_phone;
import static com.admin.duanmau.SQLite.Constants.user_table;
import static com.admin.duanmau.SQLite.Constants.user_username;

public class Database extends SQLiteOpenHelper {

    public Database(Context context) {
        super(context, "asign34.sql",null,3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_user_table);
        db.execSQL(create_category_table);
        db.execSQL(create_book_table);
        db.execSQL(create_bill_table);
        db.execSQL(create_bill_detail_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+user_table);
        db.execSQL("drop table if exists "+category_table);
        db.execSQL("drop table if exists "+book_table);
        db.execSQL("drop table if exists "+bill_table);
        db.execSQL("drop table if exists "+detail_bill_table);
        onCreate(db);
    }

}
