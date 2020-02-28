package com.quyvu.service;

import com.quyvu.dao.DanhMucSanPhamDAO;
import com.quyvu.daoimp.DanhMucSanPhamImp;
import com.quyvu.entity.DanhMucSanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DanhMucSanPhamService implements DanhMucSanPhamImp {
    @Autowired
    DanhMucSanPhamDAO danhMucSanPhamDAO;
    @Override
    public List<DanhMucSanPham> ListSanPham() {
        return danhMucSanPhamDAO.ListSanPham();
    }
}
