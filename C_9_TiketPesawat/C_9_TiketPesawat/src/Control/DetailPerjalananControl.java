
package Control;

import Model.*;
import Dao.*;
import java.util.List;

public class DetailPerjalananControl {
    DetailPerjalananDAO dPDAO = new DetailPerjalananDAO();
    
    //control input detail perjalanan dengan value detail perjanan saja
    public void insertDetailPerjalanan(DetailPerjalanan dP){
        dPDAO.insertDetailPerjalanan(dP);
    }
    
    // mendapatkan data detail perjalanan berdasarkan destinas dan tanggal keberangkatan
    public List<DetailPerjalanan> showlistDataDetailPerjalanan(String dari, String ke,String waktuBerangkat){
        return dPDAO.showlistDataDetailPerjalanan(dari, ke, waktuBerangkat);
    }
    
    public DetailPerjalanan showDataDetailPerjalanan(int detailPerjalananId){
        return dPDAO.showDataDetailPerjalanan(detailPerjalananId);
    }
    // tambahan
    public DetailPerjalanan showDetailPerjalanan(int detailPerjalananId){
        return dPDAO.showDetailPerjalanan(detailPerjalananId);
    }
    
    
    public DetailPerjalanan showDataDetailPerjalanan(String nomorPenerbangan){
        return dPDAO.showDataDetailPerjalanan(nomorPenerbangan);
    }
    
    public List<DetailPerjalanan> showAllDetailPerjalanan(){
        List<DetailPerjalanan> dataDetailPerjalanan = dPDAO.showAllDetailPerjalanan();
        return dataDetailPerjalanan;
    }
    
    public String searchNomorPenerbanganTerakhir(){
        return dPDAO.searchNomorPenerbanganTerakhir();
    }
    
    public void updateDetailPerjalanan(DetailPerjalanan dP){
        dPDAO.updateDetailPerjalanan(dP);
    }
    
    public List<DetailPerjalanan> searchingDetailPerjalanan(String search){
        return dPDAO.searchingDetailPerjalanan(search);
    }
    
    public void deteleDetailPerjalanan(int detailPerjalananId){
        dPDAO.deleteDetailPerjalanan(detailPerjalananId);
    }
    
    public List<DetailPerjalanan> searchDetailPerjalananBerdasarkanKendaraan(int kendaraanId){
        return dPDAO.searchDetailPerjalananKendaraanid(kendaraanId);
    }
}
