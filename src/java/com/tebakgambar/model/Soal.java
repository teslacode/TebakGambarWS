package com.tebakgambar.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Model Soal
 *
 * @author Ade Fruandta
 */
public class Soal {

    private int index;
    private int id;
    private URL resource;
    private byte[] bytes;
    private RfTema rfTema;

    public Soal() {
        this.index = 0;
        this.id = 0;
        this.resource = null;
        this.bytes = null;
        this.rfTema = null;
    }

    public Soal(int index, int id, String resource, RfTema rfTema) {
        try {
            this.index = index;
            this.id = id;
            //this.resource = this.getClass().getResource(resource);
            //this.bytes = this.getBytes(this.resource);
            this.rfTema = rfTema;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public URL getResource() {
        return resource;
    }

    public void setResource(URL resource) {
        this.resource = resource;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getBytes(URL resource) throws IOException {
        InputStream in = resource.openStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        for (int read; (read = in.read(buf)) != -1;) {
            bos.write(buf, 0, read);
        }
        return bos.toByteArray();
    }

    public RfTema getRfTema() {
        return rfTema;
    }

    public void setRfTema(RfTema rfTema) {
        this.rfTema = rfTema;
    }

}
