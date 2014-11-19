package com.tebakgambar.dao;

import com.tebakgambar.model.RfTema;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * DAO RfTema
 * 
 * @author Ade Fruandta
 */
public class RfTemaDao extends Dao {
    
    /**
     * Get RfTema By Id
     * 
     * @param id
     * @return List RfTema
     * @throws java.lang.Exception
     */
    public RfTema getById(int id) throws Exception {
        System.out.println("INVOKED RfTemaDao.getById");
        
        //Open Connection & Begin Transaction
        Session session = this.Open();
        session.beginTransaction();
        //Open Connection & Begin Transaction
        
        //Logic
        RfTema result = new RfTema(0, "Acak", Boolean.TRUE);
        Criteria criteria = session.createCriteria(RfTema.class);
        criteria.add(Restrictions.eq("id", id));
        if(!criteria.list().isEmpty()){
            result = (RfTema) criteria.list().get(0);
        }
        //Logic
        
        //Close Connection & Commit Transaction
        session.getTransaction().commit();
        //Close Connection & Commit Transaction
        
        System.out.println("RETURN RfTemaDao.getById: result " + result.toString());
        return result;
    }
    
    /**
     * Get RfTema Active
     * 
     * @return List RfTema
     * @throws java.lang.Exception
     */
    public List<RfTema> getActive() throws Exception {
        System.out.println("INVOKED RfTemaDao.getActive");
        
        //Open Connection & Begin Transaction
        Session session = this.Open();
        session.beginTransaction();
        //Open Connection & Begin Transaction
        
        //Logic
        List result;
        Criteria criteria = session.createCriteria(RfTema.class);
        criteria.add(Restrictions.eq("deleted", false));
        criteria.addOrder(Order.asc("description"));
        result = criteria.list();
        result.add(0, new RfTema(0, "Acak", Boolean.FALSE));
        //Logic
        
        //Close Connection & Commit Transaction
        session.getTransaction().commit();
        //Close Connection & Commit Transaction
        
        System.out.println("RETURN RfTemaDao.getActive: result " + result.size() + " row");
        return result;
    }
    
}
