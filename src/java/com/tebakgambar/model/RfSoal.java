package com.tebakgambar.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Model RfSoal Mapping dengan table RF_SOAL
 * 
 * @author Ade Fruandta
 */
@Entity
@Table(name="rf_soal")
public class RfSoal implements Serializable {
    
    @Id @Column(name = "id") private int id;
    @Column(name = "link") private String link;
    @Column(name = "jawaban") private String jawaban;
    @Column(name = "tema_id") private int temaId;
    
    @ManyToOne
    @JoinColumn(name = "tema_id", insertable = false, updatable = false)
    private RfTema rfTema;

    public RfSoal() {
        this.id = 0;
        this.link = "";
        this.jawaban = "";
        this.temaId = 0;
    }

    public RfSoal(int id, String link, String jawaban, int temaId) {
        this.id = id;
        this.link = link;
        this.jawaban = jawaban;
        this.temaId = temaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    public int getTemaId() {
        return temaId;
    }

    public void setTemaId(int temaId) {
        this.temaId = temaId;
    }

    public RfTema getRfTema() {
        return rfTema;
    }

    public void setRfTema(RfTema rfTema) {
        this.rfTema = rfTema;
    }
    
}
