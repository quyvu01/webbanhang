package com.quyvu.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "ChiTietKhuyenMai")
public class ChiTietKhuyenMai implements Serializable {
    @Id
    int makhuyenmai;
    @Id
    int masanpham;
    String giagiam;

    public int getMakhuyenmai() {
        return makhuyenmai;
    }

    public void setMakhuyenmai(int makhuyenmai) {
        this.makhuyenmai = makhuyenmai;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public String getGiagiam() {
        return giagiam;
    }

    public void setGiagiam(String giagiam) {
        this.giagiam = giagiam;
    }
}
