package com.quyvu.entity;

import javax.persistence.*;

@Entity
public class ChiTietHoaDon {
    @EmbeddedId ChiTietHoaDonId chiTietHoaDon;
    int soluong;
    String giatien;
    
}
