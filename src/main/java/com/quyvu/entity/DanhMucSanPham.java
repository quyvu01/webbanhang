package com.quyvu.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="DanhMucSanPham")
public class DanhMucSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int madanhmuc;
    String tendanhmuc;
    String hinhdanhmuc;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="madanhmuc")
    Set<SanPham> danhSachSanPham;

    public Set<SanPham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void setDanhSachSanPham(Set<SanPham> danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }

    public int getMadanhmuc() {
        return madanhmuc;
    }

    public void setMadanhmuc(int madanhmuc) {
        this.madanhmuc = madanhmuc;
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

    public String getHinhdanhmuc() {
        return hinhdanhmuc;
    }

    public void setHinhdanhmuc(String hinhdanhmuc) {
        this.hinhdanhmuc = hinhdanhmuc;
    }
}
