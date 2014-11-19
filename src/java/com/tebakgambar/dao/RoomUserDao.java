package com.tebakgambar.dao;

import com.tebakgambar.model.RoomUser;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * DAO RoomUserUser
 * 
 * @author Ade Fruandta
 */
public class RoomUserDao extends Dao {
    
    /**
     * Save RoomUser
     * 
     * @param object
     * @return List RoomUser
     * @throws java.lang.Exception
     */
    public RoomUser save(RoomUser object) throws Exception {
        System.out.println("INVOKED RoomUserDao.save");
        
        //Open Connection & Begin Transaction
        Session session = this.Open();
        session.beginTransaction();
        //Open Connection & Begin Transaction
        
        //Logic
        session.persist(object);
        object.getId();
        //Logic
        
        //Close Connection & Commit Transaction
        session.getTransaction().commit();
        //Close Connection & Commit Transaction
        
        System.out.println("RETURN RoomUserDao.save: result = " + object.toString());
        return object;
    }
    
    /**
     * Cari room yang masih kosong / masih ada slot.
     * 
     * @param roomId
     * @return List RfSoal
     * @throws java.lang.Exception
     */
    public List<RoomUser> getByRoomId(int roomId) throws Exception {
        System.out.println("INVOKED RoomUserDao.searchRoomUser");
        
        //Open Connection & Begin Transaction
        Session session = this.Open();
        session.beginTransaction();
        //Open Connection & Begin Transaction
        
        //Logic
        List<RoomUser> result;
        Criteria criteria = session.createCriteria(RoomUser.class);
        criteria.add(Restrictions.eq("roomId", roomId));
        result = criteria.list();
        //Logic
        
        //Close Connection & Commit Transaction
        session.getTransaction().commit();
        //Close Connection & Commit Transaction
        
        System.out.println("RETURN RoomUserDao.searchRoomUser: result " + result.size() + " row");
        return result;
    }
    
    /**
     * Cari Player lain di 1 Room.
     * 
     * @param roomId
     * @param roomUserId
     * @return List RfSoal
     * @throws java.lang.Exception
     */
    public List<RoomUser> getAnotherPlayer(int roomId, int roomUserId) throws Exception {
        System.out.println("INVOKED RoomUserDao.searchRoomUser");
        
        //Open Connection & Begin Transaction
        Session session = this.Open();
        session.beginTransaction();
        //Open Connection & Begin Transaction
        
        //Logic
        List<RoomUser> result;
        Criteria criteria = session.createCriteria(RoomUser.class);
        criteria.add(Restrictions.eq("roomId", roomId));
        criteria.add(Restrictions.ne("id", roomUserId));
        criteria.add(Restrictions.eq("deleted", false));
        result = criteria.list();
        //Logic
        
        //Close Connection & Commit Transaction
        session.getTransaction().commit();
        //Close Connection & Commit Transaction
        
        System.out.println("RETURN RoomUserDao.searchRoomUser: result " + result.size() + " row");
        return result;
    }
    
}
