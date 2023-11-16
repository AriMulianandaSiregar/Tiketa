/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Testing;

import Model.*;
import Control.*;

public class SeatTesting {
    public static void main(String[] args) {
        SeatControl sCon= new SeatControl();
        KendaraanControl kCon = new KendaraanControl();
        int jumlah;
        
        // String fasilitas, int kelasId, String jenisKelas
//        KelasPenerbangan k = new KelasBisnis("Kelas Bisnis", 1, "Bisnis");


//String jenisKendaraan, int jumlahSeat, String namaKendaraan

        Kendaraan k = new Pesawat("Pesawat", 15, "Test");
        kCon.insertDataKendaraan(k);
    }
}
