
package Control;
import Dao.TWalletDAO;
import Model.TWallet;


public class TWalletControl {
    private TWalletDAO tDao = new TWalletDAO();
    
    public void insertTWallet(TWallet tw){
        tDao.insertTWallet(tw);
    } 
    
    //untuk menambhakan saldo di tWallet
    public double debit(int tWalletId,double debit){
        TWallet tw = tDao.searchTWallet(tWalletId);
        double saldo = tw.getSaldo() + debit;
        tDao.updateSaldo(tWalletId, saldo);
        return saldo; //sisa saldo sekarang
    }
    //untuk mengurangi saldo di tWallet
    public double kredit(int tWalletId,double kredit){
        TWallet tw = tDao.searchTWallet(tWalletId);
        double saldo = tw.getSaldo() - kredit;
        if(tw.getSaldo() >= kredit){
            tDao.updateSaldo(tWalletId, saldo);
        }
        return saldo; //sisa saldo
        
    }
    
    public TWallet searchTWallet(int tWalletId){
        return tDao.searchTWallet(tWalletId);
    }
    
    public TWallet searchWalletTerakhir(){
        return tDao.searchTWalletTerakhir();
    }
    
   
}
