package com.m2i.cda.product.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory buildSessionFactory(){
        try{
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }catch (HibernateException h){
            throw h;
        }
    }

    public static SessionFactory getSessionFactory(){
        return  buildSessionFactory();
    }


}
