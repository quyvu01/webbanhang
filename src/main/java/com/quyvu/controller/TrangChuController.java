package com.quyvu.controller;

import com.quyvu.entity.NhanVien;
import com.quyvu.service.NhanVienService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;


@Controller
@RequestMapping("/")
public class TrangChuController {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	NhanVienService nhanVienService;
	@GetMapping
	@Transactional
	public String Default(ModelMap modelMap, HttpSession httpSession) {
		Session session=sessionFactory.getCurrentSession();
		if(httpSession.getAttribute("email")!=null)
			modelMap.addAttribute("firt-Char", httpSession.getAttribute("email").toString().substring(0,1).toUpperCase());
		return "trangchu";
	}
}
