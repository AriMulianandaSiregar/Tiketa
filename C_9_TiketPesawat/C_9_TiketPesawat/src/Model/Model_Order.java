
package Model;

import javax.swing.Icon;

public class Model_Order {
    private String noHP;
    private double saldo;

    public Model_Order() {
    }

    public Model_Order(String noHP, double saldo) {
        
        this.noHP = noHP;
        this.saldo = saldo;
    }
    
    public Model_Order(double saldo) {
        this.saldo = saldo;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
}
