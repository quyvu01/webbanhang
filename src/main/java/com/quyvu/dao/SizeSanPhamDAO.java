package com.quyvu.dao;

import com.quyvu.daoimp.SizeSanPhamImp;
import com.quyvu.entity.Size;
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
public class SizeSanPhamDAO implements SizeSanPhamImp {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<Size> listSize() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Size>) session.createQuery("from size ").list();
    }

    @Override
    @Transactional
    public Size SizeSanPham(int masize) {
        Session session = sessionFactory.getCurrentSession();
        return (Size) session.get(Size.class, masize);
    }
}
