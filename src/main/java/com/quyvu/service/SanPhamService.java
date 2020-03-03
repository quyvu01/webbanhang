package com.quyvu.service;

import com.quyvu.dao.SanPhamDAO;
import com.quyvu.daoimp.SanPhamImp;
import com.quyvu.entity.DanhMucSanPham;
import com.quyvu.entity.MauSanPham;
import com.quyvu.entity.SanPham;
import com.quyvu.entity.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SanPhamService implements SanPhamImp {
    @Autowired
    SanPhamDAO sanPhamDAO;
    
    @Override
    public List<SanPham> LayDanhSachSanPhamLimit(int sanphambatdau, int sanphamsize) {
        return sanPhamDAO.LayDanhSachSanPhamLimit(sanphambatdau, sanphamsize);
    }

    @Override
    public SanPham LaySanPhamTheoMa(int masanpham) {
        return sanPhamDAO.LaySanPhamTheoMa(masanpham);
    }

    @Override
    public DanhMucSanPham LayDanhMucSanPham(int madanhmuc) {
        return sanPhamDAO.LayDanhMucSanPham(madanhmuc);
    }

    @Override
    public void XoaSanPham(int masanpham) {
        sanPhamDAO.XoaSanPham(masanpham);
    }

    @Override
    public int TongSoSanPhaM() {
        return sanPhamDAO.TongSoSanPhaM();
    }

    @Override
    public boolean ThemSanPham(SanPham sanPham) {
        return sanPhamDAO.ThemSanPham(sanPham);
    }

    @Override
    public boolean UpdateSanPham(SanPham sanPham) {
        return sanPhamDAO.UpdateSanPham(sanPham);
    }

}
