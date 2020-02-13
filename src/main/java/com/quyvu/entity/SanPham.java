package com.quyvu.entity;

import javax.persistence.*;

@Entity(name="SanPham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idSanPham;
    String tenSanPham;
    String giaTien;
//    int idNhanVien;
//    public void setIdNhanVien(int idNhanVien){
//        this.idNhanVien=idNhanVien;
//    }
//    public int getIdNhanVien(){
//        return idNhanVien;
//    }
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idNhanVien")
    NhanVien nhanVien;

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }


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
