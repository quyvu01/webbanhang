package com.quyvu.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="hoadon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int mahoadon;
    String tenkhachhang;
    String sodt;
    String diachigiaohang;
    Boolean tinhtranghoadon;
    String ngaylap;
    String ghichu;
    

    @OneToMany
    @JoinColumn(name="mahoadon")
    Set<ChiTietHoaDon> danhSachChiTietHoaDon;

    public Set<ChiTietHoaDon> getDanhSachChiTietHoaDon() {
        return danhSachChiTietHoaDon;
    }

    public void setDanhSachChiTietHoaDon(Set<ChiTietHoaDon> danhSachChiTietHoaDon) {
        this.danhSachChiTietHoaDon = danhSachChiTietHoaDon;
    }

    public int getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(int mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getDiachigiaohang() {
        return diachigiaohang;
    }

    public void setDiachigiaohang(String diachigiaohang) {
        this.diachigiaohang = diachigiaohang;
    }

    public Boolean getTinhtranghoadon() {
        return tinhtranghoadon;
    }

    public void setTinhtranghoadon(Boolean tinhtranghoadon) {
        this.tinhtranghoadon = tinhtranghoadon;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }
    
    public String getGhichu() { return ghichu;  }

    public void setGhichu(String ghichu) { this.ghichu = ghichu; }
}
