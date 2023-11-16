/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author tinar
 */
import Model.KelasPenerbangan;
import Dao.*;
import Model.*;
import java.util.List;
public class KelasControl {
    private KelasDAO kDAO = new KelasDAO();
    
    public KelasPenerbangan showKelas(String jenis){
       KelasPenerbangan k = kDAO.showDataKelas(jenis).get(0);
       return k;
    }
    
    public List<KelasPenerbangan> showAllKelas(){
        return kDAO.showAllDataKelas();
    }
    
}
