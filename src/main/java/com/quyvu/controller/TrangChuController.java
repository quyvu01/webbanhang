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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;


@Controller
@RequestMapping("/")
public class TrangChuController {
	private int PRODUCT_PER_PAGE=16;
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
		modelMap.addAttribute("pageProduct", sanPhamService.LayDanhSachSanPhamLimit(0,16));
		
		float tongsosanpham= (float)sanPhamService.TongSoSanPhaM();
		int tongsotrang= (int)Math.ceil(tongsosanpham/PRODUCT_PER_PAGE);
		modelMap.addAttribute("tongsotrang", tongsotrang);
		modelMap.addAttribute("currentPage", 1);
		
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
	@GetMapping("/{idpage}")
	public String Home_Page(@PathVariable int idpage, ModelMap modelMap, HttpSession httpSession){
		modelMap.addAttribute("pageProduct", sanPhamService.LayDanhSachSanPhamLimit((idpage-1)*PRODUCT_PER_PAGE,PRODUCT_PER_PAGE));
		float tongsosanpham= (float)sanPhamService.TongSoSanPhaM();
		int tongsotrang= (int)Math.ceil(tongsosanpham/PRODUCT_PER_PAGE);
		modelMap.addAttribute("tongsotrang", tongsotrang);
		modelMap.addAttribute("currentPage", idpage);
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
