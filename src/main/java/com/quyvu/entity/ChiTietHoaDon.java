package com.quyvu.entity;

import javax.persistence.*;

@Entity
public class ChiTietHoaDon {
    @EmbeddedId ChiTietHoaDonId chiTietHoaDon;
    int soluong;
    String giatien;

    public ChiTietHoaDonId getChiTietHoaDon() {
        return chiTietHoaDon;
    }

    public void setChiTietHoaDon(ChiTietHoaDonId chiTietHoaDon) {
        this.chiTietHoaDon = chiTietHoaDon;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }
}
