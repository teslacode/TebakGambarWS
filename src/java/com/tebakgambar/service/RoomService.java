package com.tebakgambar.service;

import com.tebakgambar.dao.RoomDao;
import com.tebakgambar.dao.RoomUserDao;
import com.tebakgambar.model.Room;
import com.tebakgambar.model.RoomUser;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * Service Room
 * 
 * @author Ade Fruandta
 */
@WebService(serviceName = "RoomService")
public class RoomService {

    private final RoomDao roomDao = new RoomDao();
    private final RoomUserDao roomUserDao = new RoomUserDao();
    
    /**
     * Service Cari room kosong / masih ada slot.
     * 
     * @param temaId
     * @param player
     * @return 
     */
    @WebMethod(operationName = "searchRoom")
    public RoomUser searchRoom(@WebParam(name = "temaId") int temaId, @WebParam(name = "player") String player) {
        System.out.println("INVOKED RoomService.searchRoom");
        
        RoomUser result = new RoomUser();
        try{
            Room room = roomDao.searchRoom(temaId);
            RoomUser roomUser = new RoomUser(room.getId(), player, new Date(), false, false);
            roomUser = roomUserDao.save(roomUser);
            roomUser.setRoom(room);
            result = roomUser;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        System.out.println("INVOKED RoomService.searchRoom: result = " + result.toString());
        return result;
    }
    
    /**
     * Cari Player lain di 1 Room selain roomUserId.
     * 
     * @param roomId
     * @param roomUserId
     * @return 
     */
    @WebMethod(operationName = "getAnotherPlayer")
    public List<RoomUser> getAnotherPlayer(@WebParam(name = "roomId") int roomId, @WebParam(name = "roomUserId") int roomUserId) {
        System.out.println("INVOKED RoomService.searchRoom");
        
        List<RoomUser> result = new ArrayList();
        try{
            result = roomUserDao.getAnotherPlayer(roomId, roomUserId);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        System.out.println("INVOKED RoomService.searchRoom: result " + result.size() + " row");
        return result;
    }
}
