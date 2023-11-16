/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author USER
 */
public abstract class KelasPenerbangan {
    protected int kelasId;
    protected String jenisKelas;

    public KelasPenerbangan(int kelasId, String jenisKelas) {
        this.kelasId = kelasId;
        this.jenisKelas = jenisKelas;
    }
    
    public abstract void show();

    public int getKelasId() {
        return kelasId;
    }

    public void setKelasId(int kelasId) {
        this.kelasId = kelasId;
    }

    public String getJenisKelas() {
        return jenisKelas;
    }

    public void setJenisKelas(String jenisKelas) {
        this.jenisKelas = jenisKelas;
    } 
    
    public String toString(){
        return jenisKelas;
    }
}
