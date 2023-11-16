/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author tinar
 */
public class Seat {
    private int seatId;
    private String nomorSeat;
    private double harga;
    private boolean statusSeat;
    private KelasPenerbangan kelas;
    
    
    //constructor kosong
    public Seat() {
    }
    
    //constructor value lengkap
    public Seat(int seatId, String nomorSeat, double harga, boolean statusSeat, KelasPenerbangan kelas) {
        this.seatId = seatId;
        this.nomorSeat = nomorSeat;
        this.harga = harga;
        this.statusSeat = statusSeat;
        this.kelas = kelas;
    }
    
    
    //constructor tanpa value 
    public Seat(int seatId, String nomorSeat, double harga, boolean statusSeat) {
        this.seatId = seatId;
        this.nomorSeat = nomorSeat;
        this.harga = harga;
        this.statusSeat = statusSeat;
    }
    
    public void show(){
        System.out.println("\tSeat Id     : " + this.seatId);
        System.out.println("\tNomor Seat  : " + this.nomorSeat);
        System.out.println("\tHarga       : " + this.harga);
        System.out.println("\tStatus Seat : " + this.statusSeat);
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getNomorSeat() {
        return nomorSeat;
    }

    public void setNomorSeat(String nomorSeat) {
        this.nomorSeat = nomorSeat;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public boolean isStatusSeat() {
        return statusSeat;
    }

    public void setStatusSeat(boolean statusSeat) {
        this.statusSeat = statusSeat;
    }

    public KelasPenerbangan getKelas() {
        return kelas;
    }

    public void setKelas(KelasPenerbangan k) {
        this.kelas = k;
    }
    
    public String toString(){
        return nomorSeat;
    }
}
