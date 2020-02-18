package com.quyvu.controller;

import com.quyvu.entity.NhanVien;
import com.quyvu.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
@RequestMapping("api/")
@SessionAttributes("email")
public class ApiController {
    @Autowired
    NhanVienService nhanVienService;
    
    @GetMapping("dangnhap")
    @ResponseBody
    public String KiemTraDangNhap(@RequestParam String email, @RequestParam String password, ModelMap modelMap){
        try{
            boolean isLogin=nhanVienService.KiemTraDangNhap(email, password);
            if(isLogin)
                modelMap.addAttribute("email", email);
            
            return isLogin+"";
            
        }catch (Exception e)
        {
            return "Query loi";
        }
    }
}
