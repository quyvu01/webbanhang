package com.quyvu.service;

import com.quyvu.dao.HoaDonDAO;
import com.quyvu.daoimp.HoaDonImp;
import com.quyvu.entity.HoaDon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoaDonService implements HoaDonImp {

    @Autowired
    HoaDonDAO hoaDonDAO;
    @Override
    public int ThemHoaDon(HoaDon hoaDon) {
        return hoaDonDAO.ThemHoaDon(hoaDon);
    }
}
