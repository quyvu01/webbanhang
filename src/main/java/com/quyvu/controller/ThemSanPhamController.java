package com.quyvu.controller;

import com.quyvu.entity.SanPham;
import com.quyvu.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/themsanpham")
@SessionAttributes("tongsosanpham")
public class ThemSanPhamController {
    private int PRODUCT_PER_PAGE=5;
    @Autowired
    SanPhamService sanPhamService;

    @GetMapping()
    public String Default(ModelMap modelMap, HttpSession httpSession){
        
        if(httpSession.getAttribute("tongsosanpham")==null)
        {
            float tongsosanpham= (float)sanPhamService.TongSoSanPhaM();
            httpSession.setAttribute("tongsosanpham", tongsosanpham);
            int tongsotrang= (int)Math.ceil(tongsosanpham/PRODUCT_PER_PAGE);
            modelMap.addAttribute("tongsotrang", tongsotrang);
        }
        else {
            float tongsosanpham=(float)httpSession.getAttribute("tongsosanpham");
            int tongsotrang= (int)Math.ceil(tongsosanpham/PRODUCT_PER_PAGE);
            modelMap.addAttribute("tongsotrang", tongsotrang);
        }
        
        List<SanPham> listSanPham = sanPhamService.LayDanhSachSanPhamLimit(0, PRODUCT_PER_PAGE);
        modelMap.addAttribute("danhsachsanpham", listSanPham);
        return "themsanpham";
    }
}
