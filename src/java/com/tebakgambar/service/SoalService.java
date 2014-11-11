package com.tebakgambar.service;

import com.tebakgambar.dao.RfSoalDao;
import com.tebakgambar.dao.RfTemaDao;
import com.tebakgambar.model.RfSoal;
import com.tebakgambar.model.RfTema;
import com.tebakgambar.model.Soal;
import java.util.ArrayList;
import java.util.List;
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
     * @param temaId (0: random all, else: random berdasarkan tema yang di pilih)
     * @return
     */
    @WebMethod(operationName = "getSoal")
    public List<Soal> getSoal(@WebParam(name = "temaId") int temaId) {
        System.out.println("INVOKED SoalService.getSoal");
        
        List<Soal> listSoal = new ArrayList();
        try {
            List<RfSoal> listRfSoal = (temaId == 0? rfSoalDao.getRandom() : rfSoalDao.getRandom(temaId));
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
            if(rfSoal.getJawaban().equalsIgnoreCase(jawaban)){
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
        System.out.println("INVOKED SoalService.getTema");
        
        RfTema rfTema = new RfTema();
        try {
            rfTema = rfTemaDao.getById(temaId);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        System.out.println("RETURN SoalService.getTema: RfTema " + rfTema.toString());
        return rfTema;
    }

}
