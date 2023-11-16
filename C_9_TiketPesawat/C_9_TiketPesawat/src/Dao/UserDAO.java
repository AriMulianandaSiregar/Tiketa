/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.*;
import Connection.DbConnection;
import Model.Member;
import Model.TWallet;
/**
 *
 * @author tinar
 */
public class UserDAO {
    
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
     public void insertMember(Member m){
        con = dbCon.makeConnection();   
            
        m.getTwallet().setTWalletID(generateTWalletID());
        String sql = "INSERT INTO user(username, password, nama, email, noHP, gender, twalletID) VALUES ('" 
                     + m.getUsername() + "', '" + m.getPassword() + "', '" + m.getNama() + "', '" + m.getEmail() + "', '" + m.getNoHp() + "', '" + m.getGender() + "', " + m.getTwallet().getTWalletID()+ ")";

        
        System.out.println("Adding Member...");

        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            
            
            System.out.println("Added " + result + " Member");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Member...");
            System.out.println(m.getTwallet().getTWalletID());
            System.out.println(e);
        }
       
        dbCon.closeConnection();       
    }
     
     public Member searchMember(int userId){
        con = dbCon.makeConnection();
        String sql = "SELECT us.*, tw.* FROM user as us JOIN twallet as tw ON us.twalletID = tw.twalletID WHERE US.USERID LIKE " + userId;
        System.out.println("Search User Berdasarkan User Id..");
        Member m = null;
            try{
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                
                    while (rs.next()) {
                        System.out.println(rs);
                         TWallet tw = new TWallet(
                            
                            Integer.parseInt(rs.getString("tw.twalletID")),                            
                            Double.parseDouble(rs.getString("tw.saldo"))
                    );
                    
                            m = new Member(
                            Integer.parseInt(rs.getString("us.userID")),
                            rs.getString("us.nama"),
                            rs.getString("us.email"),
                            rs.getString("us.noHP"),
                            rs.getString("us.gender"),
                            rs.getString("us.username"),
                            rs.getString("us.password"),
                            tw
                    );
                    }              
                                    
            }catch(Exception e){  
                System.out.println("Error Search User");
                System.out.println(e.getMessage());
            }    
            
            return m;
        
     }
     
     
    public int generateTWalletID(){
        con = dbCon.makeConnection();
        String sqlGetLastId = "SELECT * FROM twallet";
            try{
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sqlGetLastId);
                int idTerakhir = 0;
                    while (rs.next()) {
                        System.out.println(rs);
                            idTerakhir = rs.getInt("twalletID"); 
                    }              
                return idTerakhir;                      
            }catch(Exception e){  
                System.out.println("Gagal Mengambil ID Terbaru");
                System.out.println(e.getMessage());
            }    
        return 1;
    } 
    
    public boolean isAccountExists(String username, String password){
        con = dbCon.makeConnection();      
        String sql = "Select * from user";
        System.out.println("Mengecek Data User...");             
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);                       
            if(rs!= null){
                while(rs.next()){
                    if(rs.getString("username").equals(username) && rs.getString("password").equals(password)){
                        return true;
                    }                  
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error reading databse...");
            System.out.println(e);
        }      
        dbCon.closeConnection();
        return false;
    }
     
     public Member authentication(String username, String password){
         System.out.println(username + " = " + password);
        con = dbCon.makeConnection();
        
        String sql = "SELECT us.*, tw.* FROM user as us JOIN twallet as tw ON us.twalletID = tw.twalletID WHERE"
        + " us.username LIKE " + "'%" + username + "%'"
        + "AND us.password LIKE '%" + password + "%'";

         
        System.out.println("Searching User.....");
        
        Member m = null;
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);           
            if(rs != null){
                while(rs.next()){
                    TWallet tw = new TWallet(
                            
                            Integer.parseInt(rs.getString("tw.twalletID")),                            
                            Double.parseDouble(rs.getString("tw.saldo"))
                    );
                    
                            m = new Member(
                            Integer.parseInt(rs.getString("us.userID")),
                            rs.getString("us.nama"),
                            rs.getString("us.email"),
                            rs.getString("us.noHP"),
                            rs.getString("us.gender"),
                            rs.getString("us.username"),
                            rs.getString("us.password"),
                            tw
                    );
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error searching database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return m;
    }
    
    
    public void updateSaldo(Member m, double saldoUpdate){
        con = dbCon.makeConnection();
        System.out.println("saldo harusnya = " + saldoUpdate);
        String sql = "UPDATE twallet SET saldo = " + saldoUpdate                  
                    + " WHERE twalletID = " + m.getTwallet().getTWalletID()+ ";";

        System.out.println("Editing Saldo...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            statement.close();
        }catch(Exception e){
            System.out.println("Error editing saldo...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void updateDataMember(Member thisMember,Member newMember){
        con = dbCon.makeConnection();
        

        String sql = "UPDATE USER SET username = '" + newMember.getUsername()
                    + "', password = '" + newMember.getPassword()
                    + "', nama = '" + newMember.getNama()
                    + "', email = '" + newMember.getEmail()
                    + "', noHP = '" + newMember.getNoHp()
                    + "', gender = '" + newMember.getGender()
                    + "' WHERE userID = " + thisMember.getUserID();
        
        System.out.println("Updating Data Member...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Update " + result + " Data Member");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Data Member...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    

}
