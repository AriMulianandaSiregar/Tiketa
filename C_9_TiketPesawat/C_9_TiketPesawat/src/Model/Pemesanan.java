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
public class Pemesanan extends Transaksi{
    private String statusPemesanan;
    private int jumlahPesanan;
    private double totalTagihan;
    private List<Tiket> tiket;
    
    public Pemesanan(String statusPemesanan, double totalTagihan, int transaksiId) {
        super(transaksiId);
        this.statusPemesanan = statusPemesanan;
        this.totalTagihan = totalTagihan;
        this.jumlahPesanan = 0;
        this.tiket = new ArrayList();
    }
    
    
     
    @Override
    public void show(){
        System.out.println("Transaksi Id     : " + super.transaksiId);
        System.out.println("Jumlah Pesanan   : " + jumlahPesanan);
        System.out.println("Total Tagihan    : " + totalTagihan);
        System.out.println("Status Pemesanan : " + statusPemesanan);
    }
    
    //add tiket langsung obeknya di dalam transaksi karena memakai komposit
    public void addTiket(Tiket t){
        tiket.add(t);
        jumlahPesanan++;
    }

    public String getStatusPemesanan() {
        return statusPemesanan;
    }

    public void setStatusPemesanan(String statusPemesanan) {
        this.statusPemesanan = statusPemesanan;
    }

    public int getJumlahPesanan() {
        return jumlahPesanan;
    }

    public void setJumlahPesanan(int jumlahPesanan) {
        this.jumlahPesanan = jumlahPesanan;
    }

    public double getTotalTagihan() {
        return totalTagihan;
    }

    public void setTotalTagihan(double totalTagihan) {
        this.totalTagihan = totalTagihan;
    }
    
    public void tambahTotalTagihan(double jumlahTambahan){
        this.totalTagihan += jumlahTambahan;
    }

    public List<Tiket> getTiket() {
        return tiket;
    }

    public void setTiket(List<Tiket> tiket) {
        this.tiket = tiket;
    }

    public int getTransaksiId() {
        return transaksiId;
    }

    public void setTransaksiId(int transaksiId) {
        this.transaksiId = transaksiId;
    }
    
    
}
