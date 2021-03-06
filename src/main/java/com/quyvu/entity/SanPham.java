package com.quyvu.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="SanPham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int masanpham;
    String tensanpham;
    String giatien;
    String mota;
    String hinhsanpham;
    String danhcho;

    public String getDanhcho() {
        return danhcho;
    }

    public void setDanhcho(String danhcho) {
        this.danhcho = danhcho;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="madanhmuc")
    DanhMucSanPham danhMucSanPham;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // => Bảng chứa khóa ngoại thì xài casacadeType.ALL, không thì thôi
    @JoinColumn(name="masanpham")
    Set<ChiTietSanPham> setChiTietSanPham;

    @ManyToMany
    @JoinTable(name="chitietkhuyenmai",
            joinColumns = {@JoinColumn(name="masanpham", referencedColumnName = "masanpham")},
            inverseJoinColumns = {@JoinColumn(name="makhuyenmai", referencedColumnName = "makhuyenmai")})
    Set<KhuyenMai> danhSachKhuyenMai;

    public Set<KhuyenMai> getDanhSachKhuyenMai() {
        return danhSachKhuyenMai;
    }

    public void setDanhSachKhuyenMai(Set<KhuyenMai> danhSachKhuyenMai) {
        this.danhSachKhuyenMai = danhSachKhuyenMai;
    }

    public Set<ChiTietSanPham> getSetChiTietSanPham() {
        return setChiTietSanPham;
    }

    public void setSetChiTietSanPham(Set<ChiTietSanPham> setChiTietSanPham) {
        this.setChiTietSanPham = setChiTietSanPham;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHinhsanpham() {
        return hinhsanpham;
    }

    public void setHinhsanpham(String hinhsanpham) {
        this.hinhsanpham = hinhsanpham;
    }

    public DanhMucSanPham getDanhMucSanPham() {
        return danhMucSanPham;
    }

    public void setDanhMucSanPham(DanhMucSanPham danhMucSanPham) {
        this.danhMucSanPham = danhMucSanPham;
    }
}
