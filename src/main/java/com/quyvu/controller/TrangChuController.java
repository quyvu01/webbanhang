package com.quyvu.controller;


import com.quyvu.entity.NhanVien;
import com.quyvu.entity.SanPham;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/")
public class TrangChuController {

	@Autowired
	SessionFactory sessionFactory;
	
	@GetMapping
	@Transactional
	public String Default(ModelMap modelMap) {
		Session session=sessionFactory.getCurrentSession();
		
		SanPham sanPham1=new SanPham();
		sanPham1.setTenSanPham("Ga ran nua con");
		sanPham1.setGiaTien("150.000");
		
		SanPham sanPham2=new SanPham();
		sanPham1.setTenSanPham("Ga ran ca con");
		sanPham1.setGiaTien("300.000");
		
		SanPham sanPham3=new SanPham();
		sanPham1.setTenSanPham("Ga ran 2 con");
		sanPham1.setGiaTien("450.000");

		Set<SanPham> sanPhamSet=new HashSet<>();
		sanPhamSet.add(sanPham1);
		sanPhamSet.add(sanPham2);
		sanPhamSet.add(sanPham3);
		
		NhanVien nhanVien=session.get(NhanVien.class, 4);
		//nhanVien.setSanPhamSet(sanPhamSet);
		
		((List<NhanVien>)session.createQuery("from NhanVien ").list()).forEach(p->System.out.println(p.getTenNhanVien()));
		
		session.save(nhanVien);
		
		return "trangchu";
	}

	@PostMapping
	@Transactional
	public String ThemNhanVien(@RequestParam String tenNhanVien, int tuoi){
		Session session=sessionFactory.getCurrentSession();
		NhanVien nv=new NhanVien(tenNhanVien, tuoi);
		session.save(nv);
		return "trangchu";
	}
}
