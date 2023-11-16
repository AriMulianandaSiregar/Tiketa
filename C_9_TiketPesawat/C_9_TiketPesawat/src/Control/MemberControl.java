
package Control;
import Dao.UserDAO;
import Model.Member;



public class MemberControl {
    
    private UserDAO dDao = new UserDAO();

    public void insertMember(Member m){
        dDao.insertMember(m);
    }
    
    public boolean isAccountExists(String username, String password){
        
        if(dDao.isAccountExists(username, password)){
            return true;
        }else{
            return false;
        }
        
    }
    
    public Member authentication(String username, String password){
        Member m = null;
        m = dDao.authentication(username,password);
        System.out.println(username + "             " + password);
        return m;
    }
    
    public void updateSaldo(Member m, double saldo){
        //double saldoUpdate = m.getTwallet().getSaldo() + saldo;
        dDao.updateSaldo(m, saldo);
    }
    
    public Member searchMember(int userId){
        return dDao.searchMember(userId);
    }
    
    public void UpdateDataMember(Member thisMember, Member newMember){
        dDao.updateDataMember(thisMember, newMember);
    }
    
}
