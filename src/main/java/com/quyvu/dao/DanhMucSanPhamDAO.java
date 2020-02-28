package com.quyvu.dao;

import com.quyvu.daoimp.DanhMucSanPhamImp;
import com.quyvu.entity.DanhMucSanPham;
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
public class DanhMucSanPhamDAO implements DanhMucSanPhamImp {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<DanhMucSanPham> ListSanPham() {
        Session session=sessionFactory.getCurrentSession();
        return (List<DanhMucSanPham>) session.createQuery("from DanhMucSanPham").list();
    }
}
