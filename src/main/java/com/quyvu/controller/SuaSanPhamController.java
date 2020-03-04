package com.quyvu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quyvu.entity.*;
import com.quyvu.service.DanhMucSanPhamService;
import com.quyvu.service.MauSanPhamService;
import com.quyvu.service.SanPhamService;
import com.quyvu.service.SizeSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequestMapping("/suasanpham")
@Controller
public class SuaSanPhamController {
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    DanhMucSanPhamService danhMucSanPhamService;
    @Autowired
    SizeSanPhamService sizeSanPhamService;
    @Autowired
    MauSanPhamService mauSanPhamService;
    
    @GetMapping("/{dataId}")
    public String Default(@PathVariable int dataId, ModelMap modelMap){
        SanPham sanPham=sanPhamService.LaySanPhamTheoMa(dataId);
        
        modelMap.addAttribute("sanPham", sanPham);
        List<DanhMucSanPham> listDanhMucSanPham=danhMucSanPhamService.ListSanPham();
        modelMap.addAttribute("listDanhMuc", listDanhMucSanPham);
        Set<ChiTietSanPham> listChiTietSanPham= sanPham.getSetChiTietSanPham();
        modelMap.addAttribute("listChiTietSanPham", listChiTietSanPham);
        List<Size> listSize=sizeSanPhamService.listSize();
        modelMap.addAttribute("listSize", listSize);
        List<MauSanPham> listMauSanPham=mauSanPhamService.listMauSanPham();
        modelMap.addAttribute("listMauSanPham", listMauSanPham);
        return "suasanpham";
    }
    @PostMapping("/api/{dataId}")
    @ResponseBody
    public String UpdateProduct(@PathVariable int dataId,@RequestParam String dataJson, ModelMap modelMap) throws JsonProcessingException {
        System.out.println("DataJSOn is: "+dataJson);
        sanPhamService.UpdateSanPham(dataJsonToSanPham(dataJson));
        
        SanPham sanPham=sanPhamService.LaySanPhamTheoMa(dataId);
        modelMap.addAttribute("sanPham", sanPham);
        List<DanhMucSanPham> listDanhMucSanPham=danhMucSanPhamService.ListSanPham();
        modelMap.addAttribute("listDanhMuc", listDanhMucSanPham);
        Set<ChiTietSanPham> listChiTietSanPham= sanPham.getSetChiTietSanPham();
        modelMap.addAttribute("listChiTietSanPham", listChiTietSanPham);
        List<Size> listSize=sizeSanPhamService.listSize();
        modelMap.addAttribute("listSize", listSize);
        List<MauSanPham> listMauSanPham=mauSanPhamService.listMauSanPham();
        modelMap.addAttribute("listMauSanPham", listMauSanPham);
        return "../themsanpham";
    }

    private SanPham dataJsonToSanPham(String dataJson) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jsonNode=objectMapper.readTree(dataJson);
        JsonNode jsonChiTiet= jsonNode.get("setChiTietSanPham");
        Set<ChiTietSanPham> setChiTietSanPham=new HashSet<>();
        for (JsonNode obj:jsonChiTiet){
            Size size=new Size();
            size.setMasize(obj.get("masize").asInt());
            MauSanPham mauSanPham=new MauSanPham();
            mauSanPham.setMamau(obj.get("mamau").asInt());
            ChiTietSanPham chiTietSanPham=new ChiTietSanPham();
            chiTietSanPham.setSize(size);
            chiTietSanPham.setSoluong(obj.get("soluong").asInt());
            chiTietSanPham.setNgaynhap(LocalDate.now().toString());
            chiTietSanPham.setMauSanPham(mauSanPham);
            if(obj.get("machitietsanpham")!=null)
                chiTietSanPham.setMachitietsanpham(obj.get("machitietsanpham").asInt());
            setChiTietSanPham.add(chiTietSanPham);
        }
        SanPham sanPham=new SanPham();
        sanPham.setSetChiTietSanPham(setChiTietSanPham);
        DanhMucSanPham danhMucSanPham=new DanhMucSanPham();
        danhMucSanPham.setMadanhmuc(jsonNode.get("madanhmuc").asInt());
        sanPham.setDanhMucSanPham(danhMucSanPham);
        sanPham.setTensanpham(jsonNode.get("tensanpham").asText());
        sanPham.setGiatien(jsonNode.get("giatien").asText());
        sanPham.setDanhcho(jsonNode.get("danhcho").asText());
        sanPham.setMota(jsonNode.get("mota").asText());
        sanPham.setMasanpham(jsonNode.get("masanpham").asInt());
        String hinhsanpham=jsonNode.get("hinhsanpham").asText();
        sanPham.setHinhsanpham(hinhsanpham);
        return sanPham;
    }
    
}
