package com.quyvu.controller;

import com.quyvu.entity.DanhMucSanPham;
import com.quyvu.entity.GioHang;
import com.quyvu.entity.SanPham;
import com.quyvu.service.DanhMucSanPhamService;
import com.quyvu.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
    @Autowired
    DanhMucSanPhamService danhMucSanPhamService;
    @Autowired
    SanPhamService sanPhamService;
    @GetMapping("{id}")
    public String Default(@PathVariable int id, ModelMap modelMap, HttpSession httpSession){

        List<DanhMucSanPham> listDanhMucSanPham = danhMucSanPhamService.ListSanPham();
        List<GioHang> listGioHang= (List<GioHang>) httpSession.getAttribute("giohang");

        DanhMucSanPham danhMucSanPham=sanPhamService.LayDanhMucSanPham(id);
        Set<SanPham> setSanPham=danhMucSanPham.getDanhSachSanPham();
        modelMap.addAttribute("tendanhmuc", danhMucSanPham.getTendanhmuc());
        modelMap.addAttribute("setSanPham", setSanPham);
        if(listGioHang!=null){
            modelMap.addAttribute("countSanpham", listGioHang.size());
        }
        else
            modelMap.addAttribute("countSanpham", 0);
        modelMap.addAttribute("danhmuc", listDanhMucSanPham);
        return "sanpham";
    }
}
