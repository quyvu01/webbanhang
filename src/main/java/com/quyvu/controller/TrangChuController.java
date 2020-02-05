package com.quyvu.controller;


import com.quyvu.entity.NhanVien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;


@Controller
@RequestMapping("/")
public class TrangChuController {

	@Autowired
	SessionFactory sessionFactory;
	@GetMapping
	@Transactional
	public String Default() {
		Session session=sessionFactory.getCurrentSession();
		String sql="from NhanVien";
		List<NhanVien> listNhanVien =  session.createQuery(sql).getResultList();
		listNhanVien.forEach(nv->System.out.println("Name is: "+nv.getTenNhanVien()));
		return "trangchu";
	}

}
