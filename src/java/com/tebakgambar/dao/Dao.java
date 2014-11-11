package com.tebakgambar.dao;

import com.tebakgambar.hibernate.HibernateUtil;
import org.hibernate.Session;

/**
 * Parent Semua DAO
 * 
 * @author Ade Fruandta
 */
public class Dao {
    
    protected Session session;
    
    /**
     * Open Connection
     * 
     * @throws java.lang.Exception
     */
    public void Open() throws Exception {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
}
