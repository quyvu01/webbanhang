package com.quyvu.dao;

import com.quyvu.daoimp.HoaDonImp;
import com.quyvu.entity.HoaDon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS) /*When using implements and @Transacsion this class is known that, it is a Proxy class
So we need to fix it by using @Scope(proxyMode= ScopeProxyMode.TAGET_CLASS)*/
public class HoaDonDAO implements HoaDonImp {

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public int ThemHoaDon(HoaDon hoaDon) {
        Session session = sessionFactory.getCurrentSession();
        return (Integer) session.save(hoaDon);
    }
}
