/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author tinar
 */
import Connection.DbConnection;
import Model.DetailPerjalanan;
import Model.Pelanggan;
import Model.Tiket;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TiketDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    //insert tiket dengan data lengkap
    public void insertTiket(Tiket t,int pemesananId){
        con = dbCon.makeConnection();
        
        
        String sql = "INSERT INTO TIKET(NAMAPEMESAN,IDCARD,EMAIL,STATUSTIKET,KEWARGANEGARAAN,NOMORSEAT,PEMESANANID,DETAILPERJALANANID)"
                + " VALUES ('" + t.getDataPelanggan().getNamaPemesan() + "', '" + t.getDataPelanggan().getIdCard() + "', '" 
                + t.getDataPelanggan().getEmail() + "', '" + t.getStatusTiket() + "', '" + t.getDataPelanggan().getKewarganegaraan()
                + "', '" + t.getNomorSeat() + "', " + pemesananId + ", " + t.getdetailPerjalanan().getDetailPerjalanId() + ")";
        
        System.out.println("Adding Tiket..."); 
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
 
            System.out.println("Added " + result + " Tiket");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Tiket...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    //show data Tiket berdasarkan User id
    public List<Tiket> showDataTiket(int userId){
        con = dbCon.makeConnection();
        String sql;
        System.out.println("Showing detail Tiket berdasarkan id = " + userId);
        sql = "SELECT T.TIKETID,T.NAMAPEMESAN,T.IDCARD,T.EMAIL,T.STATUSTIKET,T.KEWARGANEGARAAN,T.NOMORSEAT,T.PEMESANANID,T.DETAILPERJALANANID "
                + " FROM PEMESANAN P JOIN TIKET T ON (P.PEMESANANID = T.PEMESANANID) WHERE USERID = " + userId;
        List<Tiket> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                //int tiketId, String statusTiket, String nomorSeat, Pelanggan dataPelanggan, DetailPerjalanan detailPerjalanan
                while(rs.next()){
                    
                    //String namaPelanggan, String email, String kewarganegaraan, String idCard
                    
                    Pelanggan p = new Pelanggan(
                            rs.getString("namaPemesan"),
                            rs.getString("email"),
                            rs.getString("kewarganegaraan"),
                            rs.getString("idCard")
                    );
                    
                    Tiket t = new Tiket(
                            rs.getInt("tiketId"),
                            rs.getString("statusTiket"),
                            rs.getString("nomorSeat"),
                            p
                    );
                    
                    list.add(t);
                } 
            }
            System.out.println("Show Tiket Jumlah : " + list.size());
         
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Tiket...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    //show berdasarkan pemesanan id
    public List<Tiket> showDataTiketPesanan(int pemesananId){
        con = dbCon.makeConnection();
        String sql;
        System.out.println("Showing detail Tiket berdasarkan idPemesanan = " + pemesananId);
        sql = "SELECT T.*,D.* FROM TIKET T JOIN DETAILPERJALANAN D ON (T.DETAILPERJALANANID = D.DETAILPERJALANANID) WHERE PEMESANANID = " + pemesananId;
        List<Tiket> list = new ArrayList();
        
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                //int tiketId, String statusTiket, String nomorSeat, Pelanggan dataPelanggan, DetailPerjalanan detailPerjalanan
                while(rs.next()){
                    
                    //String namaPelanggan, String email, String kewarganegaraan, String idCard
                    //int detailPerjalanId, String nomorKeberangkatan, String kotaKeberangkatan, String kotaKedatangan, 
            //String tanggalKeberangkatan, String tanggalKedatangan, String waktuKeberangkatan, String waktuKedatangan
                    DetailPerjalanan dP = new DetailPerjalanan(
                            rs.getInt("detailPerjalananId"),
                            rs.getString("nomorKeberangkatan"),
                            rs.getString("kotaKeberangkatan"),
                            rs.getString("kotaKedatangan"),
                            rs.getString("tanggalKeberangkatan"),
                            rs.getString("tanggalKedatangan"),
                            rs.getString("waktuKeberangkatan"),
                            rs.getString("waktuKedatangan")
                    );
                    
                    
                    Pelanggan p = new Pelanggan(
                            rs.getString("namaPemesan"),
                            rs.getString("email"),
                            rs.getString("kewarganegaraan"),
                            rs.getString("idCard")
                    );
                    
                    Tiket t = new Tiket(
                            rs.getInt("tiketId"),
                            rs.getString("statusTiket"),
                            rs.getString("nomorSeat"),
                            p,
                            dP
                    );
                    
                    list.add(t);
                } 
            }
            System.out.println("Show Tiket Jumlah : " + list.size());
         
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show Tiket Berdasarkan Pemesanan Id...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    public Tiket showDataTiketPesananTerakhir(int pemesananId){
        con = dbCon.makeConnection();
        String sql;
        System.out.println("Showing detail Tiket data terakhir = " + pemesananId);
        sql = "SELECT T.*,D.* FROM TIKET T JOIN DETAILPERJALANAN D ON (T.DETAILPERJALANANID = D.DETAILPERJALANANID) WHERE PEMESANANID = " + pemesananId;
        List<Tiket> list = new ArrayList();
        Tiket tiket = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs!=null){
                //int tiketId, String statusTiket, String nomorSeat, Pelanggan dataPelanggan, DetailPerjalanan detailPerjalanan
                while(rs.next()){
                    
                    //String namaPelanggan, String email, String kewarganegaraan, String idCard
                    //int detailPerjalanId, String nomorKeberangkatan, String kotaKeberangkatan, String kotaKedatangan, 
            //String tanggalKeberangkatan, String tanggalKedatangan, String waktuKeberangkatan, String waktuKedatangan
                    DetailPerjalanan dP = new DetailPerjalanan(
                            rs.getInt("detailPerjalananId"),
                            rs.getString("nomorKeberangkatan"),
                            rs.getString("kotaKeberangkatan"),
                            rs.getString("kotaKedatangan"),
                            rs.getString("tanggalKeberangkatan"),
                            rs.getString("tanggalKedatangan"),
                            rs.getString("waktuKeberangkatan"),
                            rs.getString("waktuKedatangan")
                    );
                    
                    
                    Pelanggan p = new Pelanggan(
                            rs.getString("namaPemesan"),
                            rs.getString("email"),
                            rs.getString("kewarganegaraan"),
                            rs.getString("idCard")
                    );
                    
                    Tiket t = new Tiket(
                            rs.getInt("tiketId"),
                            rs.getString("statusTiket"),
                            rs.getString("nomorSeat"),
                            p,
                            dP
                    );
                    list.add(t);
                    tiket = t;
                } 
            }
            System.out.println("Show Tiket Jumlah : " + list.size());
         
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error show data tiket terakhir...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return tiket;
    }
    
    public void updateStatusTiket(String statusTiket,int tiketId){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE TIKET SET STATUSTIKET = '" + statusTiket + "' WHERE TIKETID LIKE " + tiketId;

        System.out.println("Updating Tiket...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Update " + result + " Tiket");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Tiket...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void deleteTiket(int detailPerjalananId){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM TIKET WHERE DETAILPERJALANANID LIKE " + detailPerjalananId;
     
        System.out.println("detailPerjalanan id = " + detailPerjalananId);
        System.out.println("Delete Tiket ...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Tiket");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Deleting Tiket");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
}
