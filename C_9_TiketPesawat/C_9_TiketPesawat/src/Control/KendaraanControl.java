/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Control;

import Dao.KendaraanDAO;
import java.util.List;
import Model.Kendaraan;
import Table.TableKendaraan;

public class KendaraanControl {
    private KendaraanDAO kDao = new KendaraanDAO();
    
    public void insertDataKendaraan(Kendaraan k){
        kDao.insertKendaraan(k);
    }
    
    public List<Kendaraan> showKendaraan(String query){
        List<Kendaraan> dataKendaraan = kDao.showKendaraan(query);
        
        
        return dataKendaraan;
    }
    
    public List<Kendaraan> showDataKendaraan(String jenisKendaraan){
        List<Kendaraan> dataKendaraan = kDao.showDataKendaraan(jenisKendaraan);
        
        return dataKendaraan;
    }
    
    public Kendaraan searchKendaraan(int kendaraanID){
        Kendaraan k = null;
        k = kDao.searchKendaraan(kendaraanID);
        return k;
    }
    
    public void updateDataKendaraan(Kendaraan k, int id){
        kDao.updateKendaraan(k, id);
    }
    
    public void deleteDataKendaraan(int id){
        kDao.deleteKendaraan(id);
    }
    
    public List<Kendaraan> showAllDataKendaraan(){
        return kDao.showAllKendaraan();
    }
    
    public int showDataTerakhir(){
        return kDao.showDataTerakhir();
    }
    
    
}
