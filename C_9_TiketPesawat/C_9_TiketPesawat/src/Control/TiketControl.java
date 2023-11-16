/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author tinar
 */
import Model.*;
import Dao.*;
import java.util.List;

public class TiketControl {
    TiketDAO tDao = new TiketDAO();
    
    //insert Tiket Data Lengkap
    public void insertTiket(Tiket t,int pemesananId){
        tDao.insertTiket(t, pemesananId);
    }
    
    //show data Tiket Berdasarkan id user
    public List<Tiket> showDataTiketUser(int userId){
        return tDao.showDataTiket(userId);
    }
    
    //show data tiket berdasarkan pemesanan 
    public List<Tiket> showDataTiketPesanan(int pemesananId){
        return tDao.showDataTiketPesanan(pemesananId);
    }
    
    //update status tiket
    public void updateStatusTiket(String statusTiket,int tiketId){
        tDao.updateStatusTiket(statusTiket, tiketId);
    }
    
    public Tiket showDataTiketPesananTerakhir(int pemesananId){
        return tDao.showDataTiketPesananTerakhir(pemesananId);
    }
    
    public void deteleTiket(int detailPerjalananId){
        tDao.deleteTiket(detailPerjalananId);
    }
}
