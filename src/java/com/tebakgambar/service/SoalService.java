package com.tebakgambar.service;

import com.tebakgambar.dao.RfSoalDao;
import com.tebakgambar.dao.RfTemaDao;
import com.tebakgambar.model.Gambar;
import com.tebakgambar.model.RfSoal;
import com.tebakgambar.model.RfTema;
import com.tebakgambar.model.Room;
import com.tebakgambar.model.Soal;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * Service Soal
 *
 * @author Ade Fruandta
 */
@WebService(serviceName = "SoalService")
public class SoalService {

    private final RfSoalDao rfSoalDao = new RfSoalDao();
    private final RfTemaDao rfTemaDao = new RfTemaDao();

    /**
     * Web service Get Soal operation
     *
     * @param temaId (0: random all, else: random berdasarkan tema yang di
     * pilih)
     * @return
     */
    @WebMethod(operationName = "getSoal")
    public List<Soal> getSoal(@WebParam(name = "temaId") int temaId) {
        System.out.println("INVOKED SoalService.getSoal: temaId = " + temaId);

        List<Soal> listSoal = new ArrayList();
        try {
            List<RfSoal> listRfSoal = rfSoalDao.getRandom(temaId);
            int i = 0;
            for (RfSoal rfSoal : listRfSoal) {
                listSoal.add(new Soal(i++, rfSoal.getId(), rfSoal.getLink(), rfSoal.getRfTema()));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("RETURN SoalService.getSoal: listSoal " + listSoal.size() + " row");
        return listSoal;
    }

    /**
     * Web service operation
     *
     * @param id
     * @param jawaban
     * @return True or False
     */
    @WebMethod(operationName = "checkJawaban")
    public Boolean checkJawaban(@WebParam(name = "id") int id, @WebParam(name = "jawaban") String jawaban) {
        System.out.println("INVOKED SoalService.checkJawaban: id = " + id + ", jawaban = " + jawaban);

        Boolean result = false;
        try {
            RfSoal rfSoal = rfSoalDao.getById(id);
            if (rfSoal.getJawaban().equalsIgnoreCase(jawaban)) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("RETURN SoalService.checkJawaban: " + result.toString());
        return result;
    }

    /**
     * Web service Get Soal operation
     *
     * @return
     */
    @WebMethod(operationName = "getTemaActive")
    public List<RfTema> getTemaActive() {
        System.out.println("INVOKED SoalService.getTemaActive");

        List<RfTema> listRfTema = new ArrayList();
        try {
            listRfTema = rfTemaDao.getActive();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("RETURN SoalService.getTemaActive: listRfTema " + listRfTema.size() + " row");
        return listRfTema;
    }

    /**
     * Web service Get Soal operation
     *
     * @param temaId
     * @return
     */
    @WebMethod(operationName = "getTema")
    public RfTema getTema(@WebParam(name = "temaId") int temaId) {
        System.out.println("INVOKED SoalService.getTema: temaId = " + temaId);

        RfTema rfTema = new RfTema();
        try {
            rfTema = rfTemaDao.getById(temaId);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("RETURN SoalService.getTema: RfTema " + rfTema.toString());
        return rfTema;
    }

    /**
     * Web service operation. Get Potongan Gambar
     * 
     * @param id
     * @param x
     * @param y
     * @return 
     */
    @WebMethod(operationName = "getPotonganGambar")
    public byte[] getPotonganGambar(@WebParam(name = "id") int id, @WebParam(name = "x") int x, @WebParam(name = "y") int y) {
        System.out.println("INVOKED SoalService.getPotonganGambar: id = " + id + ", x = " + x + ", y = " + y);
        
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        try {
            RfSoal rfSoal = rfSoalDao.getById(id);
            Soal soal = new Soal(0, rfSoal.getId(), rfSoal.getLink(), rfSoal.getRfTema());
            soal.setResource(this.getClass().getResource(rfSoal.getLink()));
            soal.setBytes(soal.getBytes(soal.getResource()));

            int width = 200;
            int height = 150;
            int cropStartX = x * width;
            int cropStartY = y * height;
            
            Gambar gambar = new Gambar(soal.getBytes(), false);
            BufferedImage cropImage = Gambar.cropMyImage((BufferedImage) gambar.getImage(), width, height, cropStartX, cropStartY);
            ImageIO.write((RenderedImage) cropImage, "jpg", bao);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("INVOKED SoalService.getPotonganGambar: bao = " + bao.toString());
        return bao.toByteArray();
    }

}
