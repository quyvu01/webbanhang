package com.quyvu.service;

import com.quyvu.dao.NhanVienDAO;
import com.quyvu.daoimp.NhanVienImp;
import com.quyvu.entity.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienService implements NhanVienImp {
    @Autowired
    NhanVienDAO nhanVienDAO;

    @Override
    public boolean KiemTraDangNhap(String email, String password) {
        if(nhanVienDAO.KiemTraDangNhap(email, password)) {
            System.out.println("Dang nhap thanh cong");
            return true;
        }
        else {
            System.out.println("Dang nhap that bai");
            return false;
        }
    }

    @Override
    public boolean SignUp(NhanVien nhanVien) {
        if(nhanVienDAO.SignUp(nhanVien)){
            System.out.println("Dang ky thanh cong");
            return true;
        }
        return false;
    }

    @Override
    public boolean KiemTraTonTai(String email) {
        if(nhanVienDAO.KiemTraTonTai(email)){
            System.out.println("Ten dang ky da ton tai");
            return true;
        }
        return false;
    }
}
