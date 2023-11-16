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

public class TransaksiControl {
    TransaksiDAO tDAO = new TransaksiDAO();
    
    //control insert pemesanan saja
    public void insertPemesanan(Pemesanan p,int userId){
        tDAO.insertPemesanan(p, userId);
    }
    
    //mencari value pemesanan berdasarkan user id
    public List<Pemesanan> showPesananUser(int userId){
        return tDAO.showPesananUser(userId);
    }
    
    //update status pemesanan
    public void updateStatusPemesanan(int pemesananId,String statusPemesanan){
       tDAO.updateDataPesanan(pemesananId, statusPemesanan);
    }
    //mencari yang belom selesai diinputkan
    
    public int getIdTerakhirPemesananTerakhir(int userId){
        return tDAO.searchIdTerakhir(userId);
    }
    
    public void updateTotalHargaPesanan(int pemesananId,double tambah){
        tDAO.updateTotalHarga(pemesananId, tambah);
    }
    
    //search pemesanan berdasarkan id pemesanan
    public Pemesanan searchPemesanan(int pemesananId){
        return tDAO.searchPemesanan(pemesananId);
    }
    
    public void addTiket(int pemesananId){
        tDAO.addTiket(pemesananId);
    }
}
