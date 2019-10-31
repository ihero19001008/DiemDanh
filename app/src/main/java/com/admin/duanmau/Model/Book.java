package com.admin.duanmau.Model;

public class Book {

    public String masach;
    public String matheloai;
    public String tensach;
    public String giabia;
    public String soluong;

    public Book(String masach, String matheloai, String tensach, String giabia, String soluong) {
        this.masach = masach;
        this.matheloai = matheloai;
        this.tensach = tensach;
        this.giabia = giabia;
        this.soluong = soluong;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(String matheloai) {
        this.matheloai = matheloai;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getGiabia() {
        return giabia;
    }

    public void setGiabia(String giabia) {
        this.giabia = giabia;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }
}
