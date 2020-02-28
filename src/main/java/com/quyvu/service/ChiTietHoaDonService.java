package com.quyvu.service;

import com.quyvu.dao.ChiTietHoaDonDAO;
import com.quyvu.daoimp.ChiTietHoaDonImp;
import com.quyvu.entity.ChiTietHoaDon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonImp {
    @Autowired
    ChiTietHoaDonDAO chiTietHoaDonDAO;
    @Override
    public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        return chiTietHoaDonDAO.ThemChiTietHoaDon(chiTietHoaDon);
    }
}
