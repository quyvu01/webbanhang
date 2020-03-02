package com.quyvu.daoimp;

import com.quyvu.entity.DanhMucSanPham;
import com.quyvu.entity.SanPham;

import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface SanPhamImp {
    List<SanPham> LayDanhSachSanPhamLimit(int sanphambatdau, int sanphamsize);
    SanPham LaySanPhamTheoMa(int masanpham);
    DanhMucSanPham LayDanhMucSanPham(int madanhmuc);
    void XoaSanPham(int masanpham);
    int TongSoSanPhaM();
}
