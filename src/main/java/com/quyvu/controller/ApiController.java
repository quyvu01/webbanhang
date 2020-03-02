package com.quyvu.controller;

import com.quyvu.entity.GioHang;
import com.quyvu.entity.SanPham;
import com.quyvu.service.NhanVienService;
import com.quyvu.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("api/")
@SessionAttributes({"email","giohang"})
public class ApiController {
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    ServletContext servletContext;

    private int PRODUCT_PER_PAGE=5;
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
    
    @GetMapping("themgiohang")
    @ResponseBody
    public String ThemGioHang(@ModelAttribute GioHang gioHang, HttpSession httpSession){
        if(httpSession.getAttribute("giohang")==null){
            List<GioHang> listGioHang=new ArrayList<>();
            listGioHang.add(gioHang);
            httpSession.setAttribute("giohang", listGioHang);
        }
        else {
            List<GioHang> GioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
            int vitri=KiemTranSanPhamTonTai(GioHangs,gioHang.getMasanpham(), gioHang.getMamau(), gioHang.getMasize());
            if(vitri==-1){
                GioHangs.add(gioHang);
            }
            else {
                int newsoluong=GioHangs.get(vitri).getSoluong()+1;
                GioHangs.get(vitri).setSoluong(newsoluong);
            }
            httpSession.setAttribute("giohang", GioHangs);
        }
        return ((List<GioHang>)httpSession.getAttribute("giohang")).size()+"";
    }
    @GetMapping("xoasanpham")
    @ResponseBody
    public String XoaSanPham(@ModelAttribute GioHang gioHang, ModelMap modelMap, HttpSession httpSession){
        List<GioHang> listGioHang=(List<GioHang>)httpSession.getAttribute("giohang");
        int VitriRemove = KiemTranSanPhamTonTai(listGioHang, gioHang.getMasanpham(), gioHang.getMamau(), gioHang.getMasize());
        listGioHang.remove(VitriRemove);
        return listGioHang.size()+"";
    } 
    
    @GetMapping("updategiohang")
    @ResponseBody
    public String UpdateGioHang(@ModelAttribute GioHang gioHang, HttpSession httpSession){
        List<GioHang> listGioHang=(List<GioHang>)httpSession.getAttribute("giohang");
        int viTri=KiemTranSanPhamTonTai(listGioHang, gioHang.getMasanpham(), gioHang.getMamau(), gioHang.getMasize());
        listGioHang.get(viTri).setSoluong(gioHang.getSoluong());
        return null;
    }

    @GetMapping(path = "themsanpham/{page}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String ThemSanPham(@PathVariable int page, ModelMap modelMap, HttpSession httpSession){
        float tongsosanpham= (float)sanPhamService.TongSoSanPhaM();
        int tongsotrang= (int)Math.ceil(tongsosanpham/PRODUCT_PER_PAGE);
        modelMap.addAttribute("tongsotrang", tongsotrang);

        int sanphamsize=sanPhamService.TongSoSanPhaM();
        if(page<sanphamsize) {
            List<SanPham> listSanPham = sanPhamService.LayDanhSachSanPhamLimit((page-1)*PRODUCT_PER_PAGE, PRODUCT_PER_PAGE);
            return HTML(listSanPham);
        }
        else {
            List<SanPham> listSanPham = sanPhamService.LayDanhSachSanPhamLimit((page - 1) * PRODUCT_PER_PAGE, sanphamsize-(page-1)*PRODUCT_PER_PAGE);
            return HTML(listSanPham);
        }
    }
    
    @GetMapping("removeproduct")
    @ResponseBody
    public String RemoveProduct(@RequestParam int productId){
        sanPhamService.XoaSanPham(productId);
        return ""+productId;
    }
    
    @PostMapping("uploadFile")
    @ResponseBody
    public String UploadAfile(MultipartHttpServletRequest request){
        String path_Save_File = servletContext.getRealPath("/resource/Image/Product/"); //servletContext mặc định trỏ tới webapp
        Iterator<String> listName=request.getFileNames();
        
        MultipartFile multipartFile=request.getFile(listName.next());
        
        File file_Save= new File(path_Save_File+multipartFile.getOriginalFilename());
        try{
            multipartFile.transferTo(file_Save);
        }catch (IOException ex){
            ex.printStackTrace();
        }catch (IllegalStateException ex){
            ex.printStackTrace();
        }
        System.out.println("Path file: "+path_Save_File);
        return "null";
    }
    
    
    private String HTML(List<SanPham> listSanPham){
        String html="";
        if(listSanPham==null)
            return null;
        String checkbox="checkbox";
        for(SanPham sanPham:listSanPham){
            html+="<tr><td><div><input value= '"+sanPham.getMasanpham()+"' type='"+checkbox+"'></div></td>";
            html+="<td>"+sanPham.getTensanpham()+"</td>"+
                    "<td>"+sanPham.getGiatien()+"</td>"+
                    "<td>"+sanPham.getDanhcho()+"</td>";
            html+="</tr>";
        }
        return html;
    }
    
    private int KiemTranSanPhamTonTai(List<GioHang> listGioHang,int masanpham, int mamau, int masize){
        for (int i=0; i<listGioHang.size(); i++){
            if(listGioHang.get(i).getMasanpham()==masanpham && listGioHang.get(i).getMasize()==masize && listGioHang.get(i).getMamau()==mamau)
                return i;
        }
        return -1;
    }
}
