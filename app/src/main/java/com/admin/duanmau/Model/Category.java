package com.admin.duanmau.Model;

public class Category {

    public String matheloai;
    public String tentheloai;
    public String vitri;
    public String mota;
    public String id;

    public String getId() {
        return id;
    }

    public void setId(String i) {
        this.id = i;
    }

    public String getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(String matheloai) {
        this.matheloai = matheloai;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }



    public Category(String id,String matheloai, String tentheloai, String vitri, String mota) {
        this.id = id;
        this.matheloai = matheloai;
        this.tentheloai = tentheloai;
        this.vitri = vitri;
        this.mota = mota;

    }
    public  Category(){}
}
