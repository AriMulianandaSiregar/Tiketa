/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testing;

/**
 *
 * @author tinar
 */
import Control.*;
import Dao.*;
import Model.*;
public class TestingTiket {
    public static void main(String[] args) {
        TiketControl tCon = new TiketControl();
        //String namaPelanggan, String email, String kewarganegaraan, String idCard
        //int detailPerjalanId, String nomorKeberangkatan, String kotaKeberangkatan, String kotaKedatangan, 
            //String tanggalKeberangkatan, String tanggalKedatangan, String waktuKeberangkatan, String waktuKedatangan
        Tiket t = new Tiket(0,"Belum Bayar","A2",new Pelanggan("Tinar","dsgs","sdf","324"),new DetailPerjalanan(401,"dsf","sdf","sedf","sdf","sdf","sdf","sf"));
        tCon.insertTiket(t, 301);
    }
}
