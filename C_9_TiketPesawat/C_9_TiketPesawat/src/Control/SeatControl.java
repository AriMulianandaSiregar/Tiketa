/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author tinar
 */
import Dao.*;
import java.util.List;
import Model.*;
public class SeatControl {
    private SeatDAO sDao = new SeatDAO();
    
    //insert seat all value
    public void insertSeat(Seat s,int detailPerjalananId){
        sDao.insertSeat(s,detailPerjalananId);
    }
    
    //ketika seat di booking
    public void inSeat(int seatId){
        sDao.updateStatusSeat(seatId, true);
    }
    
    //ketika seat di dikosongkan
    public void outSeat(int seatId){
        sDao.updateStatusSeat(seatId, false);
    }
    
    public List<Seat> showSeatPerjalanan(int detailPerjalananId){     
        return sDao.showSeatDetailPerjalanan(detailPerjalananId);
    }
    
 
    public int cekJumlahSeat(int detailPerjalananID){
        int temp = 0;
        System.out.println("testtt000");
        temp = sDao.cekJumlahSeat(detailPerjalananID);
        System.out.println("testtt1111");
        return temp;
        
    }
    
    public double getHargaSeat(String noSeat,int detailPerjalananId){
        return sDao.getHargaSeat(noSeat, detailPerjalananId);
    }
    
    public Seat showSeat(String nomorSeat,int detailPerjalananId){
        return sDao.showSeatBedasarkanId(nomorSeat, detailPerjalananId).get(0);
    }
    
    public void deleteSeatPerjalanan(int detailPerjalanan){
        sDao.deleteSeaat(detailPerjalanan);
    }
}
