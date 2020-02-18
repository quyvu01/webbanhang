package com.quyvu.daoimp;

import com.quyvu.entity.NhanVien;

public interface NhanVienImp {
    boolean KiemTraDangNhap(String email, String password);
    boolean SignUp(NhanVien nhanVien);
    boolean KiemTraTonTai(String email);
}
