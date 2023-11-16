package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

 /// test

public class DbConnection {
    public static Connection CON;
    public static final String URL = "jdbc:mysql://";
    public static final String PATH = "localhost:3306/C_9_TiketPesawat";
    //public static final String PATH = "localhost:3306/tiketa";

    public Connection makeConnection(){
        System.out.println("Opening database...");
        try{
            CON = DriverManager.getConnection(URL + PATH, "root", "");
            System.out.println("Success!");
        }catch(Exception e){
            System.out.println("Error opening database...");
            System.out.println(e);
        }
        return CON;
    }
    
    public void closeConnection(){
        System.out.println("Closing Database...");
        try{
            CON.close();
            System.out.println("Succes!");
        }catch(Exception e){
            System.out.println("Error closing database...");
            System.out.println(e);
        }
    }
}