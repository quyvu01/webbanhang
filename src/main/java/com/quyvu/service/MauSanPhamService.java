package com.quyvu.service;

import com.quyvu.dao.MauSanPhamDAO;
import com.quyvu.daoimp.MauSanPhamImp;
import com.quyvu.entity.MauSanPham;
import com.quyvu.entity.Size;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class MauSanPhamService implements MauSanPhamImp{
    @Autowired
    MauSanPhamDAO mauSanPhamDAO;
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<MauSanPham> listMauSanPham() {
        return mauSanPhamDAO.listMauSanPham();
    }
}
