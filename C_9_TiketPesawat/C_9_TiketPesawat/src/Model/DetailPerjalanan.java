/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tinar
 */
public class DetailPerjalanan {
    private int detailPerjalanId;
    private String nomorKeberangkatan;
    private String kotaKeberangkatan;
    private String kotaKedatangan;
    private String tanggalKeberangkatan;
    private String tanggalKedatangan;
    private String waktuKeberangkatan;
    private String waktuKedatangan;
    private Kendaraan kendaraan;
    private List<Seat> seatPerjalanan ;

    public DetailPerjalanan(int detailPerjalanId, String nomorKeberangkatan, String kotaKeberangkatan, String kotaKedatangan, 
            String tanggalKeberangkatan, String tanggalKedatangan, String waktuKeberangkatan, String waktuKedatangan) {
        this.detailPerjalanId = detailPerjalanId;
        this.nomorKeberangkatan = nomorKeberangkatan;
        this.kotaKeberangkatan = kotaKeberangkatan;
        this.kotaKedatangan = kotaKedatangan;
        this.tanggalKeberangkatan = tanggalKeberangkatan;
        this.tanggalKedatangan = tanggalKedatangan;
        this.waktuKeberangkatan = waktuKeberangkatan;
        this.waktuKedatangan = waktuKedatangan;
        seatPerjalanan = new ArrayList();
    }
    
    
    // constructor full
    public DetailPerjalanan(int detailPerjalanId, String nomorKeberangkatan, String kotaKeberangkatan, String kotaKedatangan, 
            String tanggalKeberangkatan, String tanggalKedatangan, String waktuKeberangkatan, String waktuKedatangan, Kendaraan kendaraan) {
        this.detailPerjalanId = detailPerjalanId;
        this.nomorKeberangkatan = nomorKeberangkatan;
        this.kotaKeberangkatan = kotaKeberangkatan;
        this.kotaKedatangan = kotaKedatangan;
        this.tanggalKeberangkatan = tanggalKeberangkatan;
        this.tanggalKedatangan = tanggalKedatangan;
        this.waktuKeberangkatan = waktuKeberangkatan;
        this.waktuKedatangan = waktuKedatangan;
        this.kendaraan = kendaraan;
        seatPerjalanan = new ArrayList();
    }

    public DetailPerjalanan() {
        
    }
    
    
    
    //show sementara
    public void showDetailPerjalanan(){
        System.out.println("Detail Perjalanan Id   : " + this.detailPerjalanId);
        System.out.println("Nomor Keberangkatan    : " + this.nomorKeberangkatan);
        System.out.println("Kota Keberangkatan     : " + this.kotaKeberangkatan);
        System.out.println("Kota Kedatangan        : " + this.kotaKedatangan);
        System.out.println("Tanggal Keberangakatan : " + this.tanggalKeberangkatan);
        System.out.println("Tanggal Kedatangan     : " + this.tanggalKedatangan);
        System.out.println("Waktu Keberangkatan    : " + this.waktuKeberangkatan);
        System.out.println("Waktu Kedatangan       : " + this.waktuKedatangan);
    }
    
    public void addSeat(){
        
    }
    

    public int getDetailPerjalanId() {
        return this.detailPerjalanId;
    }

    public void setDetailPerjalanId(int detailPerjalanId) {
        this.detailPerjalanId = detailPerjalanId;
    }

    public String getNomorKeberangkatan() {
        return nomorKeberangkatan;
    }

    public void setNomorKeberangkatan(String nomorKeberangkatan) {
        this.nomorKeberangkatan = nomorKeberangkatan;
    }

    public String getKotaKeberangkatan() {
        return kotaKeberangkatan;
    }

    public void setKotaKeberangkatan(String kotaKeberangkatan) {
        this.kotaKeberangkatan = kotaKeberangkatan;
    }

    public String getKotaKedatangan() {
        return kotaKedatangan;
    }

    public void setKotaKedatangan(String kotaKedatangan) {
        this.kotaKedatangan = kotaKedatangan;
    }

    public String getTanggalKeberangkatan() {
        return tanggalKeberangkatan;
    }

    public void setTanggalKeberangkatan(String tanggalKeberangkatan) {
        this.tanggalKeberangkatan = tanggalKeberangkatan;
    }

    public String getTanggalKedatangan() {
        return tanggalKedatangan;
    }

    public void setTanggalKedatangan(String tanggalKedatangan) {
        this.tanggalKedatangan = tanggalKedatangan;
    }

    public String getWaktuKeberangkatan() {
        return waktuKeberangkatan;
    }

    public void setWaktuKeberangkatan(String waktuKeberangkatan) {
        this.waktuKeberangkatan = waktuKeberangkatan;
    }

    public String getWaktuKedatangan() {
        return waktuKedatangan;
    }

    public void setWaktuKedatangan(String waktuKedatangan) {
        this.waktuKedatangan = waktuKedatangan;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public List<Seat> getSeatPerjalanan() {
        return seatPerjalanan;
    }

    public void setSeatPerjalanan(List<Seat> seatPerjalanan) {
        this.seatPerjalanan = seatPerjalanan;
    }
    
    
    
    
}
