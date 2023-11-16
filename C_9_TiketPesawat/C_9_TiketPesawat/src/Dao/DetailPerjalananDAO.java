 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Connection.DbConnection;
import Model.DetailPerjalanan;
import Model.Kendaraan;
import Model.Pesawat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.*;
/**
 *
 * @author tinar
 */
public class DetailPerjalananDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    //insert semau value detail perjalanan 
    //id kendaraan belom diganti
    public void insertDetailPerjalanan(DetailPerjalanan dP){
        con = dbCon.makeConnection();
        
        
        String sql = "INSERT INTO DETAILPERJALANAN(NOMORKEBERANGKATAN,KOTAKEBERANGKATAN,KOTAKEDATANGAN,TANGGALKEBERANGKATAN"
                + ",TANGGALKEDATANGAN,KENDARAANID,WAKTUKEBERANGKATAN,WAKTUKEDATANGAN) VALUES ("
                + "'" + dP.getNomorKeberangkatan() + "', '" + dP.getKotaKeberangkatan() + "', '" + dP.getKotaKedatangan() + "', '"
                + dP.getTanggalKeberangkatan() + "', '" + dP.getTanggalKedatangan() + "', " + dP.getKendaraan().getKendaraanID() +", '" + dP.getWaktuKeberangkatan() + "', '" + dP.getWaktuKedatangan() +"')";
        
        System.out.println("Adding Detail Perjalanan..."); 
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
 
            System.out.println("Added " + result + " Detail Perjalanan");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Detail Perjalanan...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    //show detailperjalanan berdasarkan tanggal, dan destinasi
    public List<DetailPerjalanan> showlistDataDetailPerjalanan(String dari,String ke, String waktuBerangkat){
        con = dbCon.makeConnection();
        String sql;
        sql = "SELECT d.*, k.* FROM DETAILPERJALANAN d JOIN KENDARAAN k ON (d.kendaraanid = k.kendaraanId) WHERE d.KOTAKEBERANGKATAN LIKE '" + dari + "' AND d.KOTAKEDATANGAN LIKE '" + ke + "' AND d.TANGGALKEBERANGKATAN LIKE '" + waktuBerangkat + "'";
        List<DetailPerjalanan> list = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    Kendaraan k = null;
                    //int kendaraanID, String jenisKendaraan, int jumlahSeat, String namaKendaraan
                    System.out.println("Jenis        : " + rs.getString("jenisKendaraan"));
                    if(rs.getString("jenisKendaraan").equalsIgnoreCase("Pesawat")){
                        k = new Pesawat(
                                    rs.getInt("kendaraanId"),
                                    rs.getString("jenisKendaraan"),
                                    rs.getInt("jumlahSeat"),    
                                    rs.getString("namaKendaraan")
                            );
                    }    
                    System.out.println("           " + k.getNamaKendaraan());
                    DetailPerjalanan dP = new DetailPerjalanan(
                            Integer.parseInt(rs.getString("detailPerjalananId")),
                            rs.getString("nomorKeberangkatan"),
                            rs.getString("kotaKeberangkatan"),
                            rs.getString("kotaKedatangan"),
                            rs.getString("tanggalKeberangkatan"),
                            rs.getString("tanggalKedatangan"),
                            rs.getString("waktuKeberangkatan"),
                            rs.getString("waktuKedatangan"));
                    dP.setKendaraan(k);
                    list.add(dP);
                } 
            }
            System.out.println("Jumlah : " + list.size());
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Detail Perjalanan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return list;
    }
    
    public List<DetailPerjalanan> searchDetailPerjalananKendaraanid(int kendaraanId){
        con = dbCon.makeConnection();
        String sql;
        sql = "SELECT D.*,K.* FROM DETAILPERJALANAN D JOIN KENDARAAN K ON (D.KENDARAANID=K.KENDARAANID)"
                + " WHERE D.KENDARAANID LIKE " + kendaraanId;
        List<DetailPerjalanan> list = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    Kendaraan k = null;
                    //int kendaraanID, String jenisKendaraan, int jumlahSeat, String namaKendaraan
                    System.out.println("Jenis        : " + rs.getString("jenisKendaraan"));
                    if(rs.getString("jenisKendaraan").equalsIgnoreCase("Pesawat")){
                        k = new Pesawat(
                                    rs.getInt("kendaraanId"),
                                    rs.getString("jenisKendaraan"),
                                    rs.getInt("jumlahSeat"),    
                                    rs.getString("namaKendaraan")
                            );
                    }    
                    System.out.println("           " + k.getNamaKendaraan());
                    DetailPerjalanan dP = new DetailPerjalanan(
                            Integer.parseInt(rs.getString("detailPerjalananId")),
                            rs.getString("nomorKeberangkatan"),
                            rs.getString("kotaKeberangkatan"),
                            rs.getString("kotaKedatangan"),
                            rs.getString("tanggalKeberangkatan"),
                            rs.getString("tanggalKedatangan"),
                            rs.getString("waktuKeberangkatan"),
                            rs.getString("waktuKedatangan"));
                    dP.setKendaraan(k);
                    list.add(dP);
                } 
            }
            System.out.println("Jumlah : " + list.size());
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Detail Perjalanan berdsarakan id kendaraan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return list;
    }
    
    //show berdasarkan id
    public DetailPerjalanan showDataDetailPerjalanan(int idDetailPerjalanan){
        con = dbCon.makeConnection();
        String sql;
        System.out.println("Showing detail Perjalanan berdasarkan id");
        sql = "SELECT d.*, k.* FROM DETAILPERJALANAN d JOIN KENDARAAN k on (d.kendaraanID = k.kendaraanID) WHERE d.DETAILPERJALANANID LIKE " + idDetailPerjalanan;
        DetailPerjalanan dP = null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    Kendaraan k = null;
                    if(rs.getString("jenisKendaraan").equalsIgnoreCase("Pesawat")){
                        k = new Pesawat(
                                    rs.getInt("kendaraanId"),
                                    rs.getString("jenisKendaraan"),
                                    rs.getInt("jumlahSeat"),    
                                    rs.getString("namaKendaraan")
                            );
                    } 
                    dP = new DetailPerjalanan(
                            Integer.parseInt(rs.getString("detailPerjalananId")),
                            rs.getString("nomorKeberangkatan"),
                            rs.getString("kotaKeberangkatan"),
                            rs.getString("kotaKedatangan"),
                            rs.getString("tanggalKeberangkatan"),
                            rs.getString("tanggalKedatangan"),
                            rs.getString("waktuKeberangkatan"),
                            rs.getString("waktuKedatangan")
                    );
                    dP.setKendaraan(k);
                            
                } 
            }
            //System.out.println("Jumlah : " + 1);
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Detail Perjalanan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        System.out.println("id detail perjalann testtt = " + dP.getDetailPerjalanId());
//        System.out.println("kota keberangkatan testttt = " + dP.getKotaKeberangkatan());
        
        return dP;
    }
    // biar gk banyak ubah di code lain
    public DetailPerjalanan showDetailPerjalanan(int idDetailPerjalanan){
        con = dbCon.makeConnection();
        String sql;
        System.out.println("Showing detail Perjalanan berdasarkan id");
        sql = "SELECT d.*, k.* FROM DETAILPERJALANAN d JOIN KENDARAAN k ON (d.kendaraanid = k.kendaraanId) WHERE DETAILPERJALANANID LIKE " + idDetailPerjalanan;
        DetailPerjalanan dP = null;
        Pesawat k = null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    if(rs.getString("jenisKendaraan").equalsIgnoreCase("Pesawat")){
                        k = new Pesawat(
                                    rs.getInt("kendaraanId"),
                                    rs.getString("jenisKendaraan"),
                                    rs.getInt("jumlahSeat"),    
                                    rs.getString("namaKendaraan")
                            );
                    } 
                    
                    dP = new DetailPerjalanan(
                            Integer.parseInt(rs.getString("detailPerjalananId")),
                            rs.getString("nomorKeberangkatan"),
                            rs.getString("kotaKeberangkatan"),
                            rs.getString("kotaKedatangan"),
                            rs.getString("tanggalKeberangkatan"),
                            rs.getString("tanggalKedatangan"),
                            rs.getString("waktuKeberangkatan"),
                            rs.getString("waktuKedatangan"));
                    dP.setKendaraan(k);
                } 
            }
            //System.out.println("Jumlah : " + 1);
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Detail Perjalanan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        System.out.println("id detail perjalann testtt = " + dP.getDetailPerjalanId());
//        System.out.println("kota keberangkatan testttt = " + dP.getKotaKeberangkatan());
        
        return dP;
    }
    // biar gk banyak ubah di code lain
    public DetailPerjalanan showDataDetailPerjalanan(String nomorPenerbangan){
        con = dbCon.makeConnection();
        String sql;
        System.out.println("Showing detail Perjalanan berdasarkan id");
        sql = "SELECT d.*, k.* FROM DETAILPERJALANAN d JOIN KENDARAAN k ON (d.kendaraanid = k.kendaraanId) WHERE NOMORKEBERANGKATAN LIKE " + nomorPenerbangan;
        DetailPerjalanan dP = null;
        Pesawat k = null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    
                    System.out.println("Jenis        : " + rs.getString("jenisKendaraan"));
                    if(rs.getString("jenisKendaraan").equalsIgnoreCase("Pesawat")){
                        k = new Pesawat(
                                    rs.getInt("kendaraanId"),
                                    rs.getString("jenisKendaraan"),
                                    rs.getInt("jumlahSeat"),    
                                    rs.getString("namaKendaraan")
                            );
                    } 
                    //int detailPerjalanId, String nomorKeberangkatan, String kotaKeberangkatan, String kotaKedatangan, 
            //String tanggalKeberangkatan, String tanggalKedatangan, String waktuKeberangkatan, String waktuKedatangan
                    dP = new DetailPerjalanan(
                            Integer.parseInt(rs.getString("detailPerjalananId")),
                            rs.getString("nomorKeberangkatan"),
                            rs.getString("kotaKeberangkatan"),
                            rs.getString("kotaKedatangan"),
                            rs.getString("tanggalKeberangkatan"),
                            rs.getString("tanggalKedatangan"),
                            rs.getString("waktuKeberangkatan"),
                            rs.getString("waktuKedatangan"));
                    dP.setKendaraan(k);
                } 
            }
            System.out.println("Jumlah : " + 1);
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Detail Perjalanan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return dP;
    }
    
    //show semua detail perjalanan
    public List <DetailPerjalanan> showAllDetailPerjalanan(){
        con = dbCon.makeConnection();
        
        String sql = "Select d.*,k.* from detailperjalanan d join kendaraan k on (d.kendaraanid = k.kendaraanid)";
        System.out.println("Mengambil seluruh data detail perjalanan...");
        
        List<DetailPerjalanan> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            
            if(rs!= null){
                while(rs.next()){
                    Kendaraan k = null;
                    if(rs.getString("jenisKendaraan").equalsIgnoreCase("Pesawat")){
                        k = new Pesawat(
                                    rs.getInt("kendaraanId"),
                                    rs.getString("jenisKendaraan"),
                                    rs.getInt("jumlahSeat"),    
                                    rs.getString("namaKendaraan")
                            );
                    } 
                    DetailPerjalanan dP = new DetailPerjalanan(Integer.parseInt(rs.getString("detailPerjalananID")), 
                                    rs.getString("nomorKeberangkatan"), 
                                    rs.getString("kotaKeberangkatan"), 
                                    rs.getString("kotaKedatangan"),
                                    rs.getString("tanggalKeberangkatan"), 
                                    rs.getString("tanggalKedatangan"),
                                    rs.getString("waktuKeberangkatan"),
                                    rs.getString("waktuKedatangan"));
                    dP.setKendaraan(k);
                    list.add(dP);
                    
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error mengambil seluruh data detail perjalanan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    public String searchNomorPenerbanganTerakhir(){
        con = dbCon.makeConnection();
        
        String sql = "SELECT MAX(NOMORKEBERANGKATAN) FROM DETAILPERJALANAN ";
        System.out.println("Mengambil seluruh data detail perjalanan...");
        
        String max = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    max = rs.getString("MAX(NOMORKEBERANGKATAN)");
                }
            }
            
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error mengambil seluruh data detail perjalanan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return max;
    }
    
    public void updateDetailPerjalanan(DetailPerjalanan dP){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE DETAILPERJALANAN SET "
                + "KOTAKEBERANGKATAN = '" + dP.getKotaKeberangkatan() + "', KOTAKEDATANGAN = '" + dP.getKotaKedatangan()
                + "', TANGGALKEBERANGKATAN = '" + dP.getTanggalKeberangkatan() + "', TANGGALKEDATANGAN = '" + dP.getTanggalKedatangan()
                + "', KENDARAANID = '" + dP.getKendaraan().getKendaraanID() + "', WAKTUKEDATANGAN = '" 
                + dP.getWaktuKedatangan() + "', WAKTUKEBERANGKATAN = '" + dP.getWaktuKeberangkatan() + "' "
                + "WHERE DETAILPERJALANANID = " + dP.getDetailPerjalanId()
                ;
     
        System.out.println("detailPerjalanan id = " + dP.getDetailPerjalanId());
        System.out.println("Updating DetailPerjalanan ...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Update " + result + " DetailPerjalanan");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating DetailPerjalanan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<DetailPerjalanan> searchingDetailPerjalanan(String search){
        con = dbCon.makeConnection();
        String sql;
        System.out.println("Searching Detail Perjalanan");
        sql = "SELECT D.*,K.* FROM DETAILPERJALANAN D JOIN KENDARAAN K ON (D.KENDARAANID = K.KENDARAANID) WHERE D.NOMORKEBERANGKATAN LIKE '%" + search
                + "%' OR D.KOTAKEBERANGKATAN LIKE '%" + search
                + "%' OR D.KOTAKEDATANGAN LIKE '%" + search
                + "%' OR D.TANGGALKEBERANGKATAN LIKE '%" + search
                + "%' OR K.NAMAKENDARAAN LIKE '%" + search
                + "%' OR K.JENISKENDARAAN LIKE '%" + search + "%'";
               
        
        List<DetailPerjalanan> listDp = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Search");
            if(rs!=null){
                while(rs.next()){
                    Kendaraan k = null;
                    if(rs.getString("jenisKendaraan").equalsIgnoreCase("Pesawat")){

                        k = new Pesawat(
                                    rs.getInt("kendaraanId"),
                                    rs.getString("jenisKendaraan"),
                                    rs.getInt("jumlahSeat"),    
                                    rs.getString("namaKendaraan")
                            );
                    } 

                    DetailPerjalanan dP = new DetailPerjalanan(
                            Integer.parseInt(rs.getString("detailPerjalananId")),
                            rs.getString("nomorKeberangkatan"),
                            rs.getString("kotaKeberangkatan"),
                            rs.getString("kotaKedatangan"),
                            rs.getString("tanggalKeberangkatan"),
                            rs.getString("tanggalKedatangan"),
                            rs.getString("waktuKeberangkatan"),
                            rs.getString("waktuKedatangan")
                    );

                    dP.setKendaraan(k);
                    listDp.add(dP);
                   
                } 
            }

            //System.out.println("Jumlah : " + 1);
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Searching Detail Perjalanan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
       
//        System.out.println("kota keberangkatan testttt = " + dP.getKotaKeberangkatan());
        
        return listDp;
    }
    
    public void deleteDetailPerjalanan(int detailPerjalananId){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM DETAILPERJALANAN WHERE DETAILPERJALANANID LIKE " + detailPerjalananId;
     
        System.out.println("detailPerjalanan id = " + detailPerjalananId);
        System.out.println("Delete DetailPerjalanan ...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " DetailPerjalanan");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Deleting DetailPerjalanan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
}
