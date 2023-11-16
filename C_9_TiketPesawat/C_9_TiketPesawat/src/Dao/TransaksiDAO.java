/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.Statement;
import Connection.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.*;

/**
 *
 * @author tinar
 */
public class TransaksiDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    //Insert Transaksi Pemesanan value pemesanan saja
    public void insertPemesanan(Pemesanan p,int userId){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO PEMESANAN(STATUSPEMESANAN,JUMLAHPESANAN,TOTALTAGIHAN,USERID) VALUES ('" 
                + p.getStatusPemesanan() + "', " + p.getJumlahPesanan() + ", " + p.getTotalTagihan() + ", " + userId + ")";
        
        System.out.println("Adding Pemesanan..."); 
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
 
            System.out.println("Added " + result + " Pemesanan");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Pemesanan...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    //show pemesanam berdasarkan id userb 
    public List<Pemesanan> showPesananUser(int userId){
        
        con = dbCon.makeConnection();
        String sql;
        sql = "SELECT * FROM PEMESANAN WHERE USERID LIKE " + userId;
        List<Pemesanan> list = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Show Data Pemesanan....");
            if(rs!=null){
                while(rs.next()){
                    //String statusPemesanan, double totalTagihan, int transaksiId
                    Pemesanan p = new Pemesanan(
                            rs.getString("statusPemesanan"),
                            Double.parseDouble(rs.getString("totalTagihan")),
                            Integer.parseInt(rs.getString("pemesananId"))
                    );
                    list.add(p);
                } 
            }
            System.out.println("Jumlah : " + list.size());
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Pemesanan...");
            System.out.println(e);
        }
        dbCon.closeConnection();    
        return list;
    }
    
    //mencari data PEMESANAN TERAKHIR DARI USER
    public int searchIdTerakhir(int userId){
        
        con = dbCon.makeConnection();
        String sql;
        sql = "SELECT * FROM PEMESANAN WHERE USERID LIKE " + userId;
        List<Pemesanan> list = new ArrayList<>();
        int id = 0;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Show Data Pemesanan terakhir....");
            if(rs!=null){
                while(rs.next()){
                    //String statusPemesanan, double totalTagihan, int transaksiId
                    Pemesanan p = new Pemesanan(
                            rs.getString("statusPemesanan"),
                            Double.parseDouble(rs.getString("totalTagihan")),
                            Integer.parseInt(rs.getString("pemesananId"))
                    );
                    list.add(p);
                    id = p.getTransaksiId();
                }  
                
            }
            System.out.println("Jumlah : " + list.size());
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Pemesanan terakhir");
            System.out.println(e);
        }
        dbCon.closeConnection();    
        return id;
    }

    
    //update data pemesanan dengan atribut statusPemesanan berdasarkan inputan user
    public void updateDataPesanan(int pemesananId,String statusPemesanan){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE PEMESANAN SET STATUSPEMESANAN = '" + statusPemesanan + "' WHERE PEMESANANID LIKE " + pemesananId;

        System.out.println("Updating Status Pemesanan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Update " + result + " Status Pemesanan");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Status Pemesanan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    //update totalHarga
    public void updateTotalHarga(int pemesananId,double harga){
         con = dbCon.makeConnection();
        
        String sql = "UPDATE PEMESANAN SET TOTALTAGIHAN= (TOTALTAGIHAN + " + harga + ") WHERE PEMESANANID LIKE " + pemesananId;

        System.out.println("Updating harga pesanan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Update " + result + " harga");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating harga...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void addTiket(int pemesananId){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE PEMESANAN SET JUMLAHPESANAN = JUMLAHPESANAN+1 WHERE PEMESANANID LIKE " + pemesananId;

        System.out.println("Updating harga pesanan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Update " + result + " harga");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating harga...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    //menari data pemesamnan berdasarkan id
    public Pemesanan searchPemesanan(int pemesananId){
        
        con = dbCon.makeConnection();
        String sql;
        sql = "SELECT * FROM PEMESANAN WHERE PEMESANANID LIKE " + pemesananId;
        List<Pemesanan> list = new ArrayList<>();
        int id = 0;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("Show Data Pemesanan terakhir....");
            if(rs!=null){
                while(rs.next()){
                    //String statusPemesanan, double totalTagihan, int transaksiId
                    Pemesanan p = new Pemesanan(
                            rs.getString("statusPemesanan"),
                            Double.parseDouble(rs.getString("totalTagihan")),
                            Integer.parseInt(rs.getString("pemesananId"))
                    );
                    list.add(p);
                }  
                
            }
            System.out.println("Jumlah : " + list.size());
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Pemesanan terakhir");
            System.out.println(e);
        }
        dbCon.closeConnection();    
        return list.get(0);
    }
}
