package com.tebakgambar.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Model Room
 * 
 * @author Ade Fruandta
 */
@Entity
@Table(name="room")
public class Room implements Serializable {
    
    @Id @Column(name = "id") 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name = "total_player") private int totalPlayer;
    @Column(name = "create_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createDate;
    @Column(name = "update_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updateDate;
    @Column(name = "tema_id") private int temaId;

    public Room() {
        this.totalPlayer = 0;
        this.createDate = new Date();
        this.updateDate = new Date();
        this.temaId = 0;
    }
    
    public Room(int totalPlayer, Date createDate, Date updateDate, int temaId) {
        this.totalPlayer = totalPlayer;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.temaId = temaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalPlayer() {
        return totalPlayer;
    }

    public void setTotalPlayer(int totalPlayer) {
        this.totalPlayer = totalPlayer;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getTemaId() {
        return temaId;
    }

    public void setTemaId(int temaId) {
        this.temaId = temaId;
    }
    
}
