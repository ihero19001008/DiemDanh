package com.admin.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.admin.duanmau.Model.User;
import com.admin.duanmau.SQLite.Database;

import java.util.ArrayList;
import java.util.List;

import static com.admin.duanmau.SQLite.Constants.category_id;
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
import static com.admin.duanmau.SQLite.Constants.user_check;

public class UserDAO {

    Database database;

    public UserDAO(Context context) {
        this.database = new Database(context);
    }

    public long insertUser(User user){
        long result = -1;

        ContentValues c = new ContentValues();
        c.put(user_username, user.getUsername());
        c.put(user_password, user.getPassword());
        c.put(user_phone, user.getPhone());
        c.put(user_fullname , user.getFullname());
        c.put(user_address, user.getAddress());
        c.put(user_dob, user.getDob());
        c.put(user_finelevel,user.getFinelevel());
        c.put(user_comlevel,user.getComlevel());
        c.put(user_worked,user.getWorked());
      //  c.put(user_check,user.getCheck());

        SQLiteDatabase db = database.getWritableDatabase();
        result = db.insert(user_table, null, c);
        db.close();

        return result;
    }

    public long updateUser(User user) {
        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues c = new ContentValues();
        c.put(user_username, user.getUsername());
        c.put(user_password, user.getPassword());
        c.put(user_phone, user.getPhone());
        c.put(user_fullname , user.getFullname());
        c.put(user_address, user.getAddress());
        c.put(user_dob, user.getDob());
        c.put(user_finelevel,user.getFinelevel());
        c.put(user_comlevel,user.getComlevel());
        c.put(user_worked,user.getWorked());
       // c.put(user_check,user.getCheck());

        // updating row
        return db.update(user_table, c, user_username + " = ?",
                new String[]{String.valueOf(user.username)});
    }
    public long removeUser(String userID){
        long result = -1;

        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        result = sqLiteDatabase.delete(user_table, user_username+"=?", new String[]{userID});
        sqLiteDatabase.close();

        return result;
    }

    public List<User> getAllUser(){
        List<User> list = new ArrayList<>();

        String query = "select * from  "+user_table;
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);

        if(c != null){
            if(c.getCount() > 0){
                while (c.moveToNext()){
                    String username = c.getString(0);
                    String password = c.getString(1);
                    String phone = c.getString(2);
                    String fullname = c.getString(3);

                    String dob = c.getString(4);
                    String address = c.getString(5);

                    String finelevel = c.getString(6);
                    String comlevel = c.getString(7);
                    String worked = c.getString(8);
                  //  String check = c.getString(9);
                    User user = new User(username,password,phone,fullname,dob,address,finelevel,comlevel,worked);
                    list.add(user);
                }
                c.close();
                db.close();
            }
        }

        return list;
    }

    public boolean checkLogin(String username,String password){
        boolean result = false;

        String query = "select * from nguoidung where username like '"+username+"' and password like '"+password+"' ";
        SQLiteDatabase sqLiteDatabase = database.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery(query,null);

        if(c.getCount() > 0){
            result = true;
        }
        else{
            result = false;
        }

        return  result;
    }
 public  User getUsers(String name){
        User user=new User();
     SQLiteDatabase sqLiteDatabase = database.getReadableDatabase();
     Cursor c = sqLiteDatabase.rawQuery("select * from nguoidung where username ='"+name+"' ",null);
     c.moveToNext();
   //  String name1 = c.getString(c.getColumnIndex("fullname"));
    // String  = c.getString(c.getColumnIndex("fullname"));
     String username = c.getString(0);
     String password = c.getString(1);
     String phone = c.getString(2);
     String fullname = c.getString(3);

     String dob = c.getString(4);
     String address = c.getString(5);

     String finelevel = c.getString(6);
     String comlevel = c.getString(7);
     String worked = c.getString(8);
    // String check = c.getString(9);
     user= new User(username,password,phone,fullname,dob,address,finelevel,comlevel,worked);
        return user;
 }

}
