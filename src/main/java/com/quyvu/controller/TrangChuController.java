package com.quyvu.controller;


import com.quyvu.entity.NhanVien;
import com.quyvu.entity.SanPham;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.EnhancedProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.awt.image.SampleModel;
import java.util.*;


@Controller
@RequestMapping("/")
public class TrangChuController {

	@Autowired
	SessionFactory sessionFactory;
	@GetMapping
	@Transactional
	public String Default(ModelMap modelMap) {
		Session session=sessionFactory.getCurrentSession();

		NhanVien nv=new NhanVien();
		nv.setTenNhanVien("KinaSuKi Koto");
		nv.setTuoi(50);

		SanPham sp1=new SanPham();
		sp1.setTenSanPham("Com rang dua bo");
		sp1.setGiaTien("50.000");

		SanPham sp2=new SanPham();
		sp2.setTenSanPham("Pho bo");
		sp2.setGiaTien("35.000");

//		Set<SanPham> sanPhams=new HashSet<>();
//		sanPhams.add(sp1);
//		sanPhams.add(sp2);
//		nv.setSanPhams(sanPhams);

		((List<SanPham>)session.createQuery("from SanPham ").list()).forEach(p->System.out.println(p.getTenSanPham()));
		session.save(nv);

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
