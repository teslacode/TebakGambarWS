package com.tebakgambar.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model RfTema dari table rf_tema
 * 
 * @author Ade Fruandta
 */
@Entity
@Table(name="rf_tema")
public class RfTema implements Serializable {
    
    @Id @Column(name = "id") private int id;
    @Column(name = "description") private String description;
    @Column(name = "deleted") private Boolean deleted;

    public RfTema() {
        this.id = 0;
        this.description = "";
        this.deleted = false;
    }

    public RfTema(int id, String description, Boolean deleted) {
        this.id = id;
        this.description = description;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
    
}
