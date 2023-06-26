package com.example.correctiontodolist.tool;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

/*@Component
@RequestScope*/
@Service
public class ServiceHibernate {
    private Session _session;
    public ServiceHibernate()  {
        try {
            _session = HibernateUtil.getSessionFactory().openSession();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
