package com.quyvu.controller;

import com.quyvu.entity.*;
import com.quyvu.service.ChiTietHoaDonService;
import com.quyvu.service.DanhMucSanPhamService;
import com.quyvu.service.HoaDonService;
import com.quyvu.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/giohang")
public class GioHangController {
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    ChiTietHoaDonService chiTietHoaDonService;
    @Autowired
    DanhMucSanPhamService danhMucSanPhamService;
    @GetMapping
    public String Default(ModelMap modelMap, HttpSession httpSession) {

        List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("giohang");
        if (listGioHang != null)
            modelMap.addAttribute("countSanpham", listGioHang.size());
        else
            modelMap.addAttribute("countSanpham", 0);
        modelMap.addAttribute("listGioHang", listGioHang);
        List<DanhMucSanPham> listDanhMucSanPham=danhMucSanPhamService.ListSanPham();
        modelMap.addAttribute("danhmuc", listDanhMucSanPham);
        return "giohang";
    }
    
    @PostMapping
    public String CompleteBills(@ModelAttribute HoaDon hoaDon, HttpSession httpSession) {
        List<GioHang> listGioHang;
        if ((listGioHang = (List<GioHang>) httpSession.getAttribute("giohang")) != null) {
            if (!hoaDon.getTenkhachhang().isEmpty() && !hoaDon.getSodt().isEmpty() && !hoaDon.getDiachigiaohang().isEmpty()) {
                hoaDon.setNgaylap(LocalDate.now().toString());
                if (hoaDonService.ThemHoaDon(hoaDon) > 0) {
                    Set<ChiTietHoaDon> setChiTietHoaDon = new HashSet<>();
                    for (GioHang gioHang : listGioHang) {
                        ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
                        chiTietHoaDonId.setMachitietsanpham(gioHang.getMachitietsanpham());
                        chiTietHoaDonId.setMahoadon(hoaDon.getMahoadon());

                        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                        chiTietHoaDon.setChiTietHoaDon(chiTietHoaDonId);
                        chiTietHoaDon.setGiatien(gioHang.getGiatien());
                        chiTietHoaDon.setSoluong(gioHang.getSoluong());
                        
                        chiTietHoaDonService.ThemChiTietHoaDon(chiTietHoaDon);
                    }
                    System.out.println("Them thanh cong");
                    listGioHang.clear();
                }
                else 
                    System.out.println("Them That bai");
            }
        }
        return "trangchu";
    }
}
