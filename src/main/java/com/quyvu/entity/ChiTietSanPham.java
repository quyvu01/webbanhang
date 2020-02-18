package com.quyvu.entity;

import javax.persistence.*;

@Entity(name="chitietsanpham")
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int machitietsanpham;
    int soluong;
    String ngaynhap;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="masanpham")
    SanPham sanPham;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="masize")
    Size size;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="mamau")
    MauSanPham mauSanPham;

    public int getMachitietsanpham() {
        return machitietsanpham;
    }

    public void setMachitietsanpham(int machitietsanpham) {
        this.machitietsanpham = machitietsanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public MauSanPham getMauSanPham() {
        return mauSanPham;
    }

    public void setMauSanPham(MauSanPham mauSanPham) {
        this.mauSanPham = mauSanPham;
    }
}
