package com.quyvu.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "NhanVien")
public class NhanVien {
	@Id
	int idNhanVien;
	String tenNhanVien;
	int tuoi;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	Set<SanPham> sanPhams;

	public Set<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(Set<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}

	public NhanVien(String tenNhanVien, int tuoi){
		this.tenNhanVien=tenNhanVien;
		this.tuoi=tuoi;
	}
	public  NhanVien(){

	}
	public int getIdNhanVien() {
		return idNhanVien;
	}
	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
}
