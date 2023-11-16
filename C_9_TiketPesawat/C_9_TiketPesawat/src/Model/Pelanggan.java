/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author tinar
 */
public class Pelanggan {
    private String namaPelanggan;
    private String email;
    private String kewarganegaraan;
    private String idCard;
    
    
    //contructor kosong
    public Pelanggan() {
        
    }
    //constructor value lengkap
    public Pelanggan(String namaPelanggan, String email, String kewarganegaraan, String idCard) {
        this.namaPelanggan = namaPelanggan;
        this.email = email;
        this.kewarganegaraan = kewarganegaraan;
        this.idCard = idCard;
    }
    
    public void showDataPelanggan(){
        System.out.println("Nama Pemesan    : " + namaPelanggan);
        System.out.println("Email           : " + email);
        System.out.println("Kewarganegaraan : " + kewarganegaraan);
        System.out.println("idCard          : " + idCard);
    }

    public String getNamaPemesan() {
        return namaPelanggan;
    }

    public void setNamaPemesan(String namaPemesan) {
        this.namaPelanggan= namaPemesan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    
    
}
