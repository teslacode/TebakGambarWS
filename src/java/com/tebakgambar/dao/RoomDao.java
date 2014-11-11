package com.tebakgambar.dao;

import com.tebakgambar.model.Room;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * DAO Room
 *
 * @author Ade Fruandta
 */
public class RoomDao extends Dao {

    /**
     * Save Room
     *
     * @param object
     * @return List Room
     * @throws java.lang.Exception
     */
    public Room save(Room object) throws Exception {
        System.out.println("INVOKED RoomDao.save");

        //Open Connection & Begin Transaction
        this.Open();
        this.session.beginTransaction();
        //Open Connection & Begin Transaction

        //Logic
        this.session.persist(object);
        object.getId();
        //Logic

        //Close Connection & Commit Transaction
        this.session.getTransaction().commit();
        //Close Connection & Commit Transaction

        System.out.println("RETURN RoomDao.save: result = " + object.toString());
        return object;
    }
    
    /**
     * Save Room
     *
     * @param object
     * @return List Room
     * @throws java.lang.Exception
     */
    public Room update(Room object) throws Exception {
        System.out.println("INVOKED RoomDao.update");

        //Open Connection & Begin Transaction
        this.Open();
        this.session.beginTransaction();
        //Open Connection & Begin Transaction

        //Logic
        this.session.update(object);
        //Logic

        //Close Connection & Commit Transaction
        this.session.getTransaction().commit();
        //Close Connection & Commit Transaction

        System.out.println("RETURN RoomDao.update: result = " + object.toString());
        return object;
    }

    /**
     * Cari room yang masih kosong / masih ada slot.
     *
     * @param temaId
     * @return List RfSoal
     * @throws java.lang.Exception
     */
    public Room searchRoom(int temaId) throws Exception {
        System.out.println("INVOKED RoomDao.searchRoom");

        //Open Connection & Begin Transaction
        this.Open();
        this.session.beginTransaction();
        //Open Connection & Begin Transaction

        //Logic
        Room result;
        Criteria criteria = this.session.createCriteria(Room.class);
        criteria.add(Restrictions.lt("totalPlayer", 2));
        criteria.add(Restrictions.eq("temaId", temaId));
        result = (criteria.list().isEmpty() ? null : (Room) criteria.list().get(0));
        //Logic

        //Close Connection & Commit Transaction
        this.session.getTransaction().commit();
        //Close Connection & Commit Transaction

        //Jika room tidak ketemu buat baru
        if (result == null) {
            result = new Room(1, new Date(), new Date(), temaId);
            result = save(result);
        } else {
            result.setTotalPlayer(result.getTotalPlayer() + 1);
            result.setUpdateDate(new Date());
            update(result);
        }
        //Jika room tidak ketemu buat baru

        System.out.println("RETURN RoomDao.searchRoom: result = " + result.toString());
        return result;
    }

}
