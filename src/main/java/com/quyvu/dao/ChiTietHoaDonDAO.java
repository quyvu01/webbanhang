package com.quyvu.dao;

import com.quyvu.daoimp.ChiTietHoaDonImp;
import com.quyvu.entity.ChiTietHoaDon;
import com.quyvu.entity.ChiTietHoaDonId;
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
public class ChiTietHoaDonDAO implements ChiTietHoaDonImp {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    @Transactional
    public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        Session session=sessionFactory.getCurrentSession();
        return ((ChiTietHoaDonId)session.save(chiTietHoaDon)).getMahoadon() > 0;
    }
}
