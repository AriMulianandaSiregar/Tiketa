/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author tinar
 */
public class Pesawat extends Kendaraan{

    public Pesawat(String jenisKendaraan, int jumlahSeat, String namaKendaraan) {
        super(jenisKendaraan, jumlahSeat, namaKendaraan);
    }
    
    public Pesawat(int kendaraanID, String jenisKendaraan, int jumlahSeat, String namaKendaraan) {
        super(kendaraanID, jenisKendaraan, jumlahSeat, namaKendaraan);
    }
    
    @Override
    public void show(){
        System.out.println("ID Kendaraan : " + kendaraanID);
        System.out.println("Jenis Kendaraan : " + jenisKendaraan);
        System.out.println("Jumlah Seat : " + jumlahSeat);
        System.out.println("Nama Kendaraan : " + namaKendaraan);
    }
    
    public String toString(){
        return this.namaKendaraan;
    }
}
