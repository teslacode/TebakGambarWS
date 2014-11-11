package com.tebakgambar.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Model Relasi Room & User
 * 
 * @author Ade Fruandta
 */
@Entity
@Table(name="room_user")
public class RoomUser implements Serializable {
    
    @Id @Column(name = "id") 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name = "room_id") private int roomId;
    @Column(name = "player") private String player;
    @Column(name = "create_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createDate;
    @Column(name = "deleted") private Boolean deleted;
    @Column(name = "ready") private Boolean ready;
    
    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private Room room;

    public RoomUser() {
        this.id = 0;
        this.roomId = 0;
        this.player = "";
        this.createDate = new Date();
        this.deleted = false;
        this.ready = false;
    }

    public RoomUser(int roomId, String player, Date createDate, Boolean deleted, Boolean ready) {
        this.roomId = roomId;
        this.player = player;
        this.createDate = createDate;
        this.deleted = deleted;
        this.ready = ready;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    
}
