/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Connection.DbConnection;
import Model.KelasPenerbangan;
import Model.Seat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.*;
/**
 *
 * @author tinar
 */
public class SeatDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    //insert data seat
    public void insertSeat(Seat s,int detailPerjalananId){
        con = dbCon.makeConnection();
        
        
        String sql = "INSERT INTO SEAT(NOSEAT,HARGA,STATUSSEAT,DETAILPERJALANANID,KELASID) VALUES ('" +
                s.getNomorSeat() + "', " + s.getHarga() + ", " + s.isStatusSeat() + ", " 
                + detailPerjalananId + ", " + s.getKelas().getKelasId() + ")";
        
        System.out.println("Adding Seat..."); 
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
 
            System.out.println("Added " + result + " Seat");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Seat...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    //update status seat ketika ada user melakukan booking tiket
    public void updateStatusSeat(int seatId,boolean status){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE SEAT SET STATUSSEAT = " + status + " WHERE SEATID LIKE " + seatId;

        System.out.println("Updating Status Seat...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Update " + result + " Seat");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Status Seat...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    //show seat berdasarkan id perjalanan
    public List<Seat> showSeatDetailPerjalanan(int detailPerjalananId){
        con = dbCon.makeConnection();
        String sql;
        System.out.println("Showing Seat Berdasarkan Id Perjalanan = " + detailPerjalananId);
        sql = "SELECT S.*,K.* FROM SEAT S JOIN KELAS K ON(S.KELASID=K.KELASID)  WHERE S.DETAILPERJALANANID = " + detailPerjalananId;
        List<Seat> list = new ArrayList();
        KelasPenerbangan k = null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                
                while(rs.next()){
                    
                    //String fasilitas, int kelasId, String jenisKelas
                    if(rs.getString("JENISKELAS").equalsIgnoreCase("BISNIS")){
                         k = new KelasBisnis(rs.getString("Fasilitas"),rs.getInt("kelasid"),rs.getString("jenisKelas"));
                    } else {
                         k = new KelasEkonomi(rs.getString("Fasilitas"),rs.getInt("kelasid"),rs.getString("jenisKelas"));
                    }
                    
                    //int seatId, String nomorSeat, double harga, boolean statusSeat, Kelas kelas
                    Seat s = new Seat(
                            rs.getInt("SEATID"),
                            rs.getString("noSeat"),
                            rs.getDouble("harga"),
                            rs.getBoolean("statusSeat"),
                            k
                    );
                    
                    list.add(s);
                } 
            }
            System.out.println("Show Seat Jumlah : " + list.size());
         
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Seat Bedasarkan detailPerjalananID...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
        
    }
    
    public int cekJumlahSeat(int detailPerjalananID){
        con = dbCon.makeConnection();
        String sql;
        System.out.println("Counting Seat kosong Berdasarkan Id Perjalanan = " + detailPerjalananID);
        sql = "SELECT * FROM SEAT WHERE statusSeat LIKE 0 AND detailPerjalananID = " + detailPerjalananID;
        int temp=0;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){              
                while(rs.next()){
                    temp++;                 
                } 
            }       
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Counting Seat Berdasarkan status seat 0 dan detailPerjalananID...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return temp;
    }
    
    public double getHargaSeat(String nomorSeat,int detailPerjalananId){
        con = dbCon.makeConnection();
        String sql;
        //SELECT HARGA FROM SEAT WHERE NOSEAT = 'A13' AND detailPerjalananId = 2;
        sql = "SELECT HARGA FROM SEAT WHERE NOSEAT LIKE '" + nomorSeat + "' AND DETAILPERJALANANID = " + detailPerjalananId;
        
        double harga = 0;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Show Data harga seat....");
            if(rs!=null){
                while(rs.next()){
                    //String statusPemesanan, double totalTagihan, int transaksiId
                    harga = rs.getDouble("harga");
                    
                } 
                
            }
            System.out.println("Jumlah : " + 1);
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show harga seat");
            System.out.println(e);
        }
        dbCon.closeConnection();    
        return harga;
    }
    
    
    public List<Seat> showSeatBedasarkanId(String nomorSeat,int detailPerjalananId){
        con = dbCon.makeConnection();
        String sql;
        System.out.println("Showing Seat Berdasarkan Id Perjalanan = " + detailPerjalananId);
        sql = "SELECT S.*,K.* FROM SEAT S JOIN KELAS K ON(S.KELASID=K.KELASID)  WHERE S.DETAILPERJALANANID = " + detailPerjalananId + " AND NOSEAT LIKE '" + nomorSeat + "'";
        List<Seat> list = new ArrayList();
        KelasPenerbangan k = null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                
                while(rs.next()){
                    
                    if(rs.getString("JENISKELAS").equalsIgnoreCase("BISNIS")){
                         k = new KelasBisnis(rs.getString("Fasilitas"),rs.getInt("kelasid"),rs.getString("jenisKelas"));
                    } else {
                         k = new KelasEkonomi(rs.getString("Fasilitas"),rs.getInt("kelasid"),rs.getString("jenisKelas"));
                    }
                    //int seatId, String nomorSeat, double harga, boolean statusSeat, Kelas kelas
                    Seat s = new Seat(
                            rs.getInt("SEATID"),
                            rs.getString("noSeat"),
                            rs.getDouble("harga"),
                            rs.getBoolean("statusSeat"),
                            k
                    );
                    
                    list.add(s);
                } 
            }
            System.out.println("Show Seat Jumlah : " + list.size());
         
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Seat Bedasarkan detailPerjalananID...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
        
    }
    
    //delete berdasarkan detailPerjalananId
    public void deleteSeaat(int detailPerjalananId){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM SEAT WHERE DETAILPERJALANANID LIKE " + detailPerjalananId;
     
        System.out.println("detailPerjalanan id = " + detailPerjalananId);
        System.out.println("Delete Seat ...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Seat");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Deleting Seat");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
}
