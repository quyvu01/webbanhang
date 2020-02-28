package com.quyvu.controller;

import com.quyvu.entity.DanhMucSanPham;
import com.quyvu.entity.GioHang;
import com.quyvu.entity.SanPham;
import com.quyvu.service.DanhMucSanPhamService;
import com.quyvu.service.SanPhamService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/chitiet")
public class ChiTietController {
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    DanhMucSanPhamService danhMucSanPhamService;
    @GetMapping("/{masanpham}")
    @Transactional
    public String Default(@PathVariable int masanpham, ModelMap modelMap, HttpSession httpSession){
        Session session=sessionFactory.getCurrentSession();
        SanPham sanPham = sanPhamService.LaySanPhamTheoMa(masanpham);
        //sanPham.getSetChiTietSanPham().forEach(p->System.out.println("Ma mau san pham la: "+p.getSoluong()));
        sanPham.getSetChiTietSanPham();
        List<DanhMucSanPham> listDanhMucSanPham = danhMucSanPhamService.ListSanPham();
        
        List<GioHang> listGioHang= (List<GioHang>) httpSession.getAttribute("giohang");
        if(listGioHang!=null){
            modelMap.addAttribute("countSanpham", listGioHang.size());
        }
        else
            modelMap.addAttribute("countSanpham", 0);
        modelMap.addAttribute("sanpham", sanPham);
        modelMap.addAttribute("danhsach", listDanhMucSanPham);
        
        return "chitiet";
    }
}
