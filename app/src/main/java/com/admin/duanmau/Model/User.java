package com.admin.duanmau.Model;

public class User {
    public String username;
    public String password;
    public String phone;
    public String fullname;
    public String address;
    public String finelevel;
    public String comlevel;
    public String worked;
    public String dob;
  //  public String check;

    public User(String username, String password, String phone, String fullname,String dob, String address, String finelevel, String comlevel, String worked) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.fullname = fullname;
        this.dob = dob;
        this.address = address;
        this.finelevel = finelevel;
        this.comlevel = comlevel;
        this.worked = worked;
       // this.check = check;
    }
    public User(){

    }

   // public String getCheck() {
    //    return check;
   // }

   // public void setCheck(String check) {
     //   this.check = check;
   // }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFinelevel() {
        return finelevel;
    }

    public void setFinelevel(String finelevel) {
        this.finelevel = finelevel;
    }

    public String getComlevel() {
        return comlevel;
    }

    public void setComlevel(String comlevel) {
        this.comlevel = comlevel;
    }

    public String getWorked() {
        return worked;
    }

    public void setWorked(String worked) {
        this.worked = worked;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
