/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dao;

import Connection.DbConnection;
import Model.Kendaraan;
import Model.Pesawat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class KendaraanDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    //insert data kendaraan
    public void insertKendaraan(Kendaraan k){
        con = dbCon.makeConnection();
        
        // int kendaraanID, String jenisKendaraan, int jumlahSeat, String namaKendaraan
        
        String sql = "";
        
        if(k.getJenisKendaraan().equalsIgnoreCase("Pesawat")){
            sql = "insert into kendaraan(jenisKendaraan, jumlahSeat, namaKendaraan) values('"
                    + k.getJenisKendaraan()  + "', '" + k.getJumlahSeat() + "', '" + k.getNamaKendaraan() + "')";
        }
        
        System.out.println("Adding Kendaraan..."); 
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
 
            System.out.println("Added " + result + " Kendaraan");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Kendaraan...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    public int showDataTerakhir(){
        con = dbCon.makeConnection();
        String sql;
        sql = "select MAX(KENDARAANID) from kendaraan";
        int id = 0;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    id = rs.getInt("MAX(KENDARAANID)");
                } 
            }
            
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show ID TERAKHIR...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return id;
    }
    
    // show data kendaraan
    public List<Kendaraan> showDataKendaraan(String jenisKendaraan){
        con = dbCon.makeConnection();
        String sql;
        sql = "select * from kendaraan where jenisKendaraan = '" + jenisKendaraan + "'";
        List<Kendaraan> list = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    Kendaraan k = null;
                    
                    // int kendaraanID, String jenisKendaraan, int jumlahSeat, String namaKendaraan
                    if(jenisKendaraan.equalsIgnoreCase("Pesawat")){
                        k = new Pesawat (rs.getInt("kendaraanID"),
                                rs.getString("jenisKendaraan"),
                                rs.getInt("jumlahSeat"),
                                rs.getString("namaKendaraan")
                        );
                    } else {
                       // TODO
                    }
                    
                    list.add(k);
                } 
            }
            System.out.println("Jumlah : " + list.size());
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Kendaraan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    public List<Kendaraan> showKendaraan(String query){
        con = dbCon.makeConnection();
        String sql;
        sql = "select * from kendaraan where (kendaraanID like '%" + query + "%'"
                + " or namaKendaraan like '%" + query + "%'"
                + " or jenisKendaraan like '%" + query + "%')";
        List<Kendaraan> list = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    Kendaraan k = null;
                    // int kendaraanID, String jenisKendaraan, int jumlahSeat, String namaKendaraan
                    k = new Pesawat (rs.getInt("kendaraanID"),
                            rs.getString("jenisKendaraan"),
                            rs.getInt("jumlahSeat"),
                            rs.getString("namaKendaraan"));
                    list.add(k);
                } 
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Kendaraan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    public List<Kendaraan> showAllKendaraan(){
        con = dbCon.makeConnection();
        String sql;
        sql = "SELECT * FROM KENDARAAN";
        List<Kendaraan> list = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    Kendaraan k = null;
                    // int kendaraanID, String jenisKendaraan, int jumlahSeat, String namaKendaraan
                    k = new Pesawat (rs.getInt("kendaraanID"),
                            rs.getString("jenisKendaraan"),
                            rs.getInt("jumlahSeat"),
                            rs.getString("namaKendaraan"));
                    list.add(k);
                } 
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Kendaraan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    // update data kendaraan
    public void updateKendaraan(Kendaraan k, int id){
        con = dbCon.makeConnection();
        
        String sql = "update kendaraan set jenisKendaraan = '" + k.getJenisKendaraan()
                + "', jumlahSeat = '" + k.getJumlahSeat() + "', namaKendaraan = '" + k.getNamaKendaraan() + "' "
                + "where kendaraanID like '" + id + "'";
        
        //nt kendaraanID, String jenisKendaraan, int jumlahSeat, String namaKendaraan
        
        System.out.println("Editing Kendaraan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Kendaraan " + id);
            statement.close();
        } catch (Exception e){
            System.out.println("Error Editing Kendaraan...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    // delete data kendaraan
    public void deleteKendaraan(int kendaraanID){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM kendaraan WHERE kendaraanID = '" + kendaraanID + "'";
        System.out.println("Deleting Kendaraan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Kendaraan " + kendaraanID);
            statement.close();
        } catch(Exception e){
            System.out.println("Error Deleting Kendaraan...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    // Search data kendaraan
    public Kendaraan searchKendaraan(int kendaraanID){
        con = dbCon.makeConnection();
        
        String sql = "select * from kendaraan where kendaraanID = '" + kendaraanID + "'";
        System.out.println("Searching Kendaraan...");
        Kendaraan k = null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    if(rs.getString("jenisKendaraan").equalsIgnoreCase("Pesawat")){
                        k = new Pesawat(rs.getInt("kendaraanID"), rs.getString("jenisKendaraan"), 
                        rs.getInt("jumlahSeat"), rs.getString("namaKendaraan"));
                    } else {
                        k = null;
                    }
                } 
            }
            System.out.println("Searching Kendaraan " + kendaraanID);
            statement.close();
        } catch (Exception e){
            System.out.println("Data Kendaraan Tidak Ditemukan...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
        System.out.println("hahaha : " + k.getNamaKendaraan());
        return k;
    }
}
