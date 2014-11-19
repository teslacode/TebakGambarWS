package com.tebakgambar.dao;

import com.tebakgambar.model.RfSoal;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * DAO RfSoal
 * 
 * @author Ade Fruandta
 */
public class RfSoalDao extends Dao {    
    
    /**
     * Get RfSoal Random 5 Row By Tema Id
     * 
     * @param temaId
     * @return List RfSoal
     * @throws java.lang.Exception
     */
    public List<RfSoal> getRandom(int temaId) throws Exception {
        System.out.println("INVOKED RfSoalDao.getRandom");
        
        //Open Connection & Begin Transaction
        Session session = this.Open();
        session.beginTransaction();
        //Open Connection & Begin Transaction
        
        //Logic
        List result;
        Criteria criteria = session.createCriteria(RfSoal.class);
        criteria.createAlias("rfTema", "rfTema");
        criteria.add(Restrictions.eq("rfTema.deleted", false));
        if(temaId != 0){
            criteria.add(Restrictions.eq("temaId", temaId));
        }
        criteria.add(Restrictions.sqlRestriction("1=1 order by RAND()"));
        criteria.setFirstResult(0);
        criteria.setMaxResults(5);
        result = criteria.list();
        //Logic
        
        //Close Connection & Commit Transaction
        session.getTransaction().commit();
        //Close Connection & Commit Transaction
        
        System.out.println("RETURN RfSoalDao.getRandom: result " + result.size() + " row");
        return result;
    }
    
    /**
     * Get RfSoal By Id
     * 
     * @param id
     * @return RfSoal
     * @throws java.lang.Exception
     */
    public RfSoal getById(int id) throws Exception {
        System.out.println("INVOKED RfSoalDao.getById: id = " + id);
        
        //Open Connection & Begin Transaction
        Session session = this.Open();
        session.beginTransaction();
        //Open Connection & Begin Transaction
        
        //Logic
        RfSoal result;
        Criteria criteria = session.createCriteria(RfSoal.class);
        criteria.add(Restrictions.eq("id", id));
        result = (!criteria.list().isEmpty()? (RfSoal) criteria.list().get(0) : new RfSoal());
        //Logic
        
        //Close Connection & Commit Transaction
        session.getTransaction().commit();
        //Close Connection & Commit Transaction
        
        System.out.println("RETURN RfSoalDao.getById: " + result.toString());
        return result;
    }
    
}
