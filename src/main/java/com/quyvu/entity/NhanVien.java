package com.quyvu.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "NhanVien")
public class NhanVien {
	@Id
	int idNhanVien;
	
	String tenNhanVien;
	int tuoi;
	
	@OneToMany
	@JoinColumn(name="idNhanVien")
	Set<SanPham> sanPhamSet;

	public void setSanPhamSet(Set<SanPham> sanPhamSet) {
		this.sanPhamSet = sanPhamSet;
	}
	public Set<SanPham> getSanPhamSet(){
		return sanPhamSet;
	}

	public NhanVien(String tenNhanVien, int tuoi){
		this.tenNhanVien=tenNhanVien;
		this.tuoi=tuoi;
	}
	public NhanVien(){

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
