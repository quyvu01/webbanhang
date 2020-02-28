package com.quyvu.controller;

import com.quyvu.entity.DanhMucSanPham;
import com.quyvu.entity.GioHang;
import com.quyvu.entity.NhanVien;
import com.quyvu.service.DanhMucSanPhamService;
import com.quyvu.service.NhanVienService;
import com.quyvu.service.SanPhamService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;


@Controller
@RequestMapping("/")
public class TrangChuController {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	NhanVienService nhanVienService;
	
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;
	@GetMapping
	@Transactional
	public String Default(ModelMap modelMap, HttpSession httpSession) {
		Session session=sessionFactory.getCurrentSession();
		if(httpSession.getAttribute("email")!=null)
			modelMap.addAttribute("firt-Char", httpSession.getAttribute("email").toString().substring(0,1).toUpperCase());
		modelMap.addAttribute("firstProducts", sanPhamService.LayDanhSachSanPhamLimit(0,20));
		
		List<DanhMucSanPham> listDanhMucSanPham = danhMucSanPhamService.ListSanPham();
		List<GioHang> listGioHang= (List<GioHang>) httpSession.getAttribute("giohang");
		if(listGioHang!=null){
			modelMap.addAttribute("countSanpham", listGioHang.size());
		}
		else
			modelMap.addAttribute("countSanpham", 0);
		modelMap.addAttribute("danhmuc", listDanhMucSanPham);
		return "trangchu";
	}
}
