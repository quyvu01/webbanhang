package com.quyvu.dao;

import com.quyvu.daoimp.MauSanPhamImp;
import com.quyvu.entity.MauSanPham;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS) /*When using implements and @Transacsion this class is known that, it is a Proxy class
So we need to fix it by using @Scope(proxyMode= ScopeProxyMode.TAGET_CLASS)*/
public class MauSanPhamDAO implements MauSanPhamImp {
    
    @Autowired
    SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<MauSanPham> listMauSanPham() {
        Session session = sessionFactory.getCurrentSession();
        return (List<MauSanPham>) session.createQuery("from mausanpham ").list();
    }
}
