package com.quyvu.dao;

import com.quyvu.daoimp.SanPhamImp;
import com.quyvu.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS) /*When using implements and @Transacsion this class is known that, it is a Proxy class
So we need to fix it by using @Scope(proxyMode= ScopeProxyMode.TAGET_CLASS)*/
public class SanPhamDAO implements SanPhamImp {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<SanPham> LayDanhSachSanPhamLimit(int sanphambatdau, int sanphamsize) {

        Session session=sessionFactory.getCurrentSession();
        return session.createQuery("from SanPham ").setFirstResult(sanphambatdau).setMaxResults(sanphamsize).list();
    }

    @Override
    @Transactional
    public SanPham LaySanPhamTheoMa(int masanpham) {
        Session session=sessionFactory.getCurrentSession();
        SanPham sanPham = (SanPham)session.createQuery("from SanPham where masanpham='"+masanpham+"'").getSingleResult();
        return sanPham;
    }

    @Override
    @Transactional
    public DanhMucSanPham LayDanhMucSanPham(int madanhmuc) {
        Session session=sessionFactory.getCurrentSession();
        return (DanhMucSanPham) session.createQuery("from DanhMucSanPham where madanhmuc='"+madanhmuc+"'").getSingleResult();
    }
    
    @Override
    @Transactional
    public void XoaSanPham(int masanpham) {
        Session session =sessionFactory.getCurrentSession();
        SanPham sanPham = session.get(SanPham.class, masanpham=masanpham);
        Set<ChiTietSanPham> setChiTietSanPham=sanPham.getSetChiTietSanPham();
        for (ChiTietSanPham chiTietSanPham:setChiTietSanPham){
            session.createQuery("delete ChiTietHoaDon where machitietsanpham='"+chiTietSanPham.getMachitietsanpham()+"'").executeUpdate();
        }
        session.createQuery("delete chitietsanpham where masanpham='"+masanpham+"'").executeUpdate();
        session.createQuery("delete ChiTietKhuyenMai where masanpham ='"+masanpham+"'").executeUpdate();
        session.createQuery("delete SanPham where masanpham='"+masanpham+"'").executeUpdate();
    }

    @Override
    @Transactional
    public int TongSoSanPhaM() {
        Session session=sessionFactory.getCurrentSession();
        return session.createQuery("from SanPham").list().size();
    }

}
