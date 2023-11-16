/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author tinar
 */
public abstract class Kendaraan {
    protected int kendaraanID;
    protected String jenisKendaraan;
    protected int jumlahSeat;
    protected String namaKendaraan;
    
    // constructor kendaraan null value
    public Kendaraan(){
        
    }

    // constructor kendaraan without id
    public Kendaraan(String jenisKendaraan, int jumlahSeat, String namaKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
        this.jumlahSeat = jumlahSeat;
        this.namaKendaraan = namaKendaraan;
    }
    
    //constructor kendaraan with id
    public Kendaraan(int kendaraanID, String jenisKendaraan, int jumlahSeat, String namaKendaraan) {
        this.kendaraanID = kendaraanID;
        this.jenisKendaraan = jenisKendaraan;
        this.jumlahSeat = jumlahSeat;
        this.namaKendaraan = namaKendaraan;
    }
    
    public abstract void show();

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public int getJumlahSeat() {
        return jumlahSeat;
    }

    public int getKendaraanID() {
        return this.kendaraanID;
    }

    public String getNamaKendaraan() {
        return namaKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public void setJumlahSeat(int jumlahSeat) {
        this.jumlahSeat = jumlahSeat;
    }

    public void setKendaraanID(int kendaraanID) {
        this.kendaraanID = kendaraanID;
    }

    public void setNamaKendaraan(String namaKendaraan) {
        this.namaKendaraan = namaKendaraan;
    }
    
    
    
    @Override
    public String toString(){
        return this.namaKendaraan;
    }
}
