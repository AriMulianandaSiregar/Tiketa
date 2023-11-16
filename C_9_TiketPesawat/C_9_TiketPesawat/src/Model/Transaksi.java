package Model;


public abstract class Transaksi {
    protected int transaksiId;

    public Transaksi(int transaksiId) {
        this.transaksiId = transaksiId;
    }
    
    public int getTransaksiId() {
        return transaksiId;
    }

    public void setTransaksiId(int transaksiId) {
        this.transaksiId = transaksiId;
    }
    
    public abstract void show();
}
