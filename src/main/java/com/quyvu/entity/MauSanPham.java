package com.quyvu.entity;

import javax.persistence.*;

@Entity(name="mausanpham")
public class MauSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int mamau;
    String tenmau;
    
    public int getMamau() {
        return mamau;
    }

    public void setMamau(int mamau) {
        this.mamau = mamau;
    }

    public String getTenmau() {
        return tenmau;
    }

    public void setTenmau(String tenmau) {
        this.tenmau = tenmau;
    }
}
