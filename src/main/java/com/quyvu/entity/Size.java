package com.quyvu.entity;

import javax.persistence.*;

@Entity(name="size")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int masize;
    String size;

    public int getMasize() {
        return masize;
    }

    public void setMasize(int masize) {
        this.masize = masize;
    }

    public String getTenkichthuoc() {
        return size;
    }

    public void setTenkichthuoc(String size) {
        this.size = size;
    }
}
