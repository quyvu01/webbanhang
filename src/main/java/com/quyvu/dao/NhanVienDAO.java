package com.quyvu.dao;

import com.quyvu.daoimp.NhanVienImp;
import com.quyvu.entity.NhanVien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/* @Repository is known that this class is used to connect to database, by register @Repository, this class
can be use SessionFactory, @Transaction */
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS) /*When using implements and @Transacsion this class is known that, it is a Proxy class
So we need to fix it by using @Scope(proxyMode= ScopeProxyMode.TAGET_CLASS)*/
public class NhanVienDAO implements NhanVienImp {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean KiemTraDangNhap(String email, String password) {
        Session session=sessionFactory.getCurrentSession();
        return (session.createQuery("from NhanVien where tendangnhap = '" + email + "' and matkhau = '"+ password + "'")
                .uniqueResult()!=null);
        
    }

    @Override
    @Transactional
    public boolean SignUp(NhanVien nhanVien) {
        Session session=sessionFactory.getCurrentSession();
        try {
            session.save(nhanVien);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    @Transactional
    public boolean KiemTraTonTai(String email) {
        Session session =sessionFactory.getCurrentSession();
        return (session.createQuery("from NhanVien where email='"+email+"'").getSingleResult()!=null);
    }
}
