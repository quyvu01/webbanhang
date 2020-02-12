package com.quyvu.entity;

import javax.persistence.*;

@Entity(name="SanPham")
public class SanPham {
    @Id
    int idSanPham;
    String tenSanPham;
    String giaTien;
    int idNhanVien;

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }
//    @OneToOne()
//    @JoinColumn() // Know as FK if the FK name is same with @Id, don't need to Declare @JoinColumn(name = "id...")
//    NhanVien nhanVien;
//
//    public NhanVien getNhanVien() {
//        return nhanVien;
//    }
//
//    public void setNhanVien(NhanVien nhanVien) {
//        this.nhanVien = nhanVien;
//    }


    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }

}
