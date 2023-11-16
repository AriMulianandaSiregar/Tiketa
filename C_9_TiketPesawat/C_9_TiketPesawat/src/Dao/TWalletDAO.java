 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Connection.DbConnection;
import Model.TWallet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Model.*;


/**
 *
 * @author tinar
 */
public class TWalletDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertTWallet(TWallet t){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO TWALLET(TWALLETID,SALDO) VALUES (" + t.getTWalletID()+ ", " + t.getSaldo() + ")";

        
        System.out.println("Adding TWallet...");

        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
 
            System.out.println("Added " + result + " TWallet");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding TWallet...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
     
    public TWallet searchTWalletTerakhir(){
        con = dbCon.makeConnection();
        String sql;
        
        sql = "SELECT * FROM TWALLET";
        TWallet tW = null; 
        System.out.println("Searh TWallet..");
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    
                    tW = new TWallet(Integer.parseInt(rs.getString("twalletId")),Double.parseDouble(rs.getString("saldo")));
                }
            } 
            System.out.println("Jumlah : " + 1);
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Show tWallet...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return tW;
     }
    
     public TWallet searchTWallet(int tWalletId){
        con = dbCon.makeConnection();
        String sql;
        
        sql = "SELECT * FROM TWALLET WHERE TWALLETID LIKE " + tWalletId;
        TWallet tW = null; 
        System.out.println("Searh TWallet..");
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                while(rs.next()){
                    
                    tW = new TWallet(Integer.parseInt(rs.getString("twalletId")),Double.parseDouble(rs.getString("saldo")));
                }
            } 
            System.out.println("Jumlah : " + 1);
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Show tWallet...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return tW;
     }
     
     public void updateSaldo(int tWalletId,double saldo){
       con = dbCon.makeConnection();
       
       String sql = "UPDATE TWALLET SET SALDO = " + saldo 
               + " WHERE TWALLETID = " + tWalletId;
        
       System.out.println("Updating SeatPerjalanan...");

        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
 
            System.out.println("Update " + result + " SeatPerjalanan");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Update SeatPerjalanan...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
        
    }
}
