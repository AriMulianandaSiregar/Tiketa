
package Model;
import Interface.ICreate;
import Interface.ILogin;

public class Member extends User implements ICreate, ILogin{
    private String nama;
    private String email;
    private String noHp;
    private String gender;
    private TWallet twallet;

    public Member(String nama, String email, String noHp, String gender, String username, String password, TWallet twallet) {
        super(username, password);
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.gender = gender;
        this.twallet = twallet;
    }
    
    public Member(int userID, String nama, String email, String noHp, String gender, String username, String password, TWallet twallet) {
        super(userID, username, password);
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.gender = gender;
        this.twallet = twallet;
    }
    
    public Member(String nama, String email, String noHp, String gender, String username, String password) {
        super(username, password);
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.gender = gender;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public TWallet getTwallet() {
        return twallet;
    }

    public void setTwallet(TWallet twallet) {
        this.twallet = twallet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    

    public void login(){
        
    }
    
    public void create(){
        
    }
    
    @Override
    public void showData(){
        
    }

    @Override
    public void create(float jumlah) {
    }

    @Override
    public void login(float jumlah) {
    }
    
            
}
