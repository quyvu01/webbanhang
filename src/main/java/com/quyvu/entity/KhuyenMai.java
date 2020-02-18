package com.quyvu.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="khuyenmai")
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int makhuyenmai;
    String tenkhuyenmai;
    String thoigianbatdau;
    String thoigianketthuc;
    String mota;
    int giagiam;
    
    @ManyToMany
    @JoinTable(name="chitietkhuyenmai", 
            joinColumns = {@JoinColumn(name="makhuyenmai", referencedColumnName = "makhuyenmai")}, 
            inverseJoinColumns = {@JoinColumn(name="masanpham", referencedColumnName = "masanpham")})
    Set<SanPham> danhsachsanpham;

    public Set<SanPham> getDanhsachsanpham() {
        return danhsachsanpham;
    }

    public void setDanhsachsanpham(Set<SanPham> danhsachsanpham) {
        this.danhsachsanpham = danhsachsanpham;
    }

    public int getGiagiam() {
        return giagiam;
    }

    public void setGiagiam(int giagiam) {
        this.giagiam = giagiam;
    }

    String hinhkhuyenmai;

    public int getMakhuyenmai() {
        return makhuyenmai;
    }

    public void setMakhuyenmai(int makhuyenmai) {
        this.makhuyenmai = makhuyenmai;
    }

    public String getTenkhuyenmai() {
        return tenkhuyenmai;
    }

    public void setTenkhuyenmai(String tenkhuyenmai) {
        this.tenkhuyenmai = tenkhuyenmai;
    }

    public String getThoigianbatdau() {
        return thoigianbatdau;
    }

    public void setThoigianbatdau(String thoigianbatdau) {
        this.thoigianbatdau = thoigianbatdau;
    }

    public String getThoigianketthuc() {
        return thoigianketthuc;
    }

    public void setThoigianketthuc(String thoigianketthuc) {
        this.thoigianketthuc = thoigianketthuc;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHinhkhuyenmai() {
        return hinhkhuyenmai;
    }

    public void setHinhkhuyenmai(String hinhkhuyenmai) {
        this.hinhkhuyenmai = hinhkhuyenmai;
    }
}
