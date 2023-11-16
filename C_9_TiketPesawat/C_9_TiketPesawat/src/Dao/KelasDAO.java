/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import Connection.DbConnection;
import Model.KelasPenerbangan;
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
public class KelasDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public List<KelasPenerbangan> showDataKelas(String jenisKelas){
        con = dbCon.makeConnection();
        String sql;
        sql = "SELECT * FROM KELAS WHERE JENISKELAS = '" + jenisKelas + "'";
        List<KelasPenerbangan> list = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    KelasPenerbangan k = null;
                    if(jenisKelas.equals("Bisnis")){
                        k = new KelasBisnis(
                            rs.getString("fasilitas"),
                            rs.getInt("kelasId"),
                            rs.getString("jenisKelas")
                        );
                    } else {
                       k = new KelasEkonomi(
                            rs.getString("fasilitas"),
                            rs.getInt("kelasId"),
                            rs.getString("jenisKelas")
                        ); 
                    }
                    //String fasilitas, int kelasId, String jenisKelas
                    
                    list.add(k);
                } 
            }
            System.out.println("Jumlah : " + list.size());
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Kelas...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    public List<KelasPenerbangan> showAllDataKelas(){
        con = dbCon.makeConnection();
        String sql;
        sql = "SELECT * FROM KELAS";
        List<KelasPenerbangan> list = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    KelasPenerbangan k = null;
                    if(rs.getString("jenisKelas").equals("Bisnis")){
                        k = new KelasBisnis(
                            rs.getString("fasilitas"),
                            rs.getInt("kelasId"),
                            rs.getString("jenisKelas")
                        );
                    } else {
                       k = new KelasEkonomi(
                            rs.getString("fasilitas"),
                            rs.getInt("kelasId"),
                            rs.getString("jenisKelas")
                        ); 
                    }
                    //String fasilitas, int kelasId, String jenisKelas
                    
                    list.add(k);
                } 
            }
            System.out.println("Jumlah : " + list.size());
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Kelas...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
}
