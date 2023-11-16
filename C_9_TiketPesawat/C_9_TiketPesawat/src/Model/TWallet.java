
package Model;


public class TWallet {
    private int TWalletID;
    private double saldo;

    public TWallet(int TWalletID, double saldo) {
        this.TWalletID = TWalletID;
        this.saldo = saldo;
    }

    
    
    public TWallet(double saldo) {
        this.saldo = saldo;
    }
    
    public int getTWalletID() {
        return TWalletID;
    }

    public void setTWalletID(int TWalletID) {
        this.TWalletID = TWalletID;
    }

    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}
