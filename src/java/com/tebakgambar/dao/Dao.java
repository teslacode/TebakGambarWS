package com.tebakgambar.dao;

import com.tebakgambar.hibernate.HibernateUtil;
import org.hibernate.Session;

/**
 * Parent Semua DAO
 * 
 * @author Ade Fruandta
 */
public class Dao {
    
    //protected Session session;
    
    /**
     * Open Connection
     * 
     * @return Session
     * @throws java.lang.Exception
     */
    public Session Open() throws Exception {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
}
