package com.m2i.cda.product.utils;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceHibernate {


    private Session session;

    public ServiceHibernate(){
        try{
            session = HibernateUtils.getSessionFactory().openSession();
        }catch (HibernateException e){
            throw new RuntimeException();
        }
    }

    public Session getSession() {
        return HibernateUtils.getSessionFactory().openSession();
    }
}
