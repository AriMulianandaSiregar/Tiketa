package Model;


public class Tiket {
    private int tiketId;
    private String statusTiket;
    private String nomorSeat;
    private Pelanggan dataPelanggan;
    private DetailPerjalanan detailPerjalanan;
    
    
    //tiket kosong
    public Tiket() {
    }
 
    //constructor untuk full value
    public Tiket(int tiketId, String statusTiket, String nomorSeat, Pelanggan dataPelanggan, DetailPerjalanan detailPerjalanan) {
        this.tiketId = tiketId;
        this.statusTiket = statusTiket;
        this.nomorSeat = nomorSeat;
        this.dataPelanggan = dataPelanggan;
        this.detailPerjalanan = detailPerjalanan;
    }
    
    //constructor kurang vallue detailPerjalanan
    public Tiket(int tiketId, String statusTiket, String nomorSeat, Pelanggan dataPelanggan) {
        this.tiketId = tiketId;
        this.statusTiket = statusTiket;
        this.nomorSeat = nomorSeat;
        this.dataPelanggan = dataPelanggan;
    }
    
    public void showDataTiket(){
        System.out.println("Tiket Id     : " + this.tiketId);
        System.out.println("Status Tiket : " + this.statusTiket);
        System.out.println("Nomor Seat   : " + this.nomorSeat);
        dataPelanggan.showDataPelanggan();
    }
    
    

    public int getTiketId() {
        return tiketId;
    }

    public void setTiketId(int tiketId) {
        this.tiketId = tiketId;
    }

    public String getStatusTiket() {
        return statusTiket;
    }

    public void setStatusTiket(String statusTiket) {
        this.statusTiket = statusTiket;
    }

    public String getNomorSeat() {
        return nomorSeat;
    }

    public void setNomorSeat(String nomorSeat) {
        this.nomorSeat = nomorSeat;
    }

    public Pelanggan getDataPelanggan() {
        return dataPelanggan;
    }

    public void setDataPelanggan(Pelanggan dataPelanggan) {
        this.dataPelanggan = dataPelanggan;
    }

    public DetailPerjalanan getdetailPerjalanan() {
        return detailPerjalanan;
    }

    public void setdP(DetailPerjalanan dP) {
        this.detailPerjalanan = detailPerjalanan;
    }
    
    
    
    
}
