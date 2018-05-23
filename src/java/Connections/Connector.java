
package Connections;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {
    
    private static final String URL = "jdbc:mysql://localhost:3306/TODO";
    private static final String UID = "root";
    private static final String UPassword = "";
    
    private Connection c;
    
    public void getConnected() throws ClassNotFoundException{
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            setConnection(DriverManager.getConnection(URL,UID,UPassword));
        } catch (SQLException ex) {
            System.err.println("An Error ocured during DB connect: "+ ex);
           Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public Connection getConnection() throws ClassNotFoundException {
       if(c == null) 
           getConnected();
       
       
        return c;
    }

    
    public void setConnection(Connection c) {
        this.c = c;
    }

}

    
