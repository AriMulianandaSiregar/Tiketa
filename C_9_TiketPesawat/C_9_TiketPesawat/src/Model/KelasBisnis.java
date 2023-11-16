
package Model;


public class KelasBisnis extends KelasPenerbangan{
    private String fasilitas;

    public KelasBisnis(String fasilitas, int kelasId, String jenisKelas) {
        super(kelasId, jenisKelas);
        this.fasilitas = fasilitas;
    }
    
    public void show(){
        System.out.println("Kelas Id     : " + this.kelasId);
        System.out.println("Jenis Kelas  : " + this.jenisKelas);
        System.out.println("Fsilitas     : " + this.fasilitas);
    }
    
    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

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
        return super.jenisKelas;
    }
}
