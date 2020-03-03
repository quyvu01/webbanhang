package com.quyvu.service;

import com.quyvu.dao.SizeSanPhamDAO;
import com.quyvu.daoimp.SizeSanPhamImp;
import com.quyvu.entity.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SizeSanPhamService implements SizeSanPhamImp {
    @Autowired
    SizeSanPhamDAO sizeSanPhamDAO;
    @Override
    public List<Size> listSize() {
        return sizeSanPhamDAO.listSize();
    }

    @Override
    public Size SizeSanPham(int masize) {
        return sizeSanPhamDAO.SizeSanPham(masize);
    }
}
