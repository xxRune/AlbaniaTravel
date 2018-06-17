
package Beans;

import static Beans.Manager.conn;
import static Beans.Manager.pstmt;
import static Beans.Manager.rs;
import Connections.Connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="travel")
@SessionScoped
public class Traveller {
    
    Connector cn = new Connector();
    public static Connection conn=null;
    public static PreparedStatement pstmt=null;
    public static ResultSet rs=null;
    private String str="";
    
   
    private List<String> t = new ArrayList<String>();
    private List<String> c = new ArrayList<String>();
    private String actual;
    
    public Traveller(){
        
    }
    
    
    
    public List<String> getC() {
        return c;
    }

    public void setC(List<String> c) {
        this.c = c;
    }
    
     public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }
    
    
    
    
    public List<Traveller> process() throws ClassNotFoundException{
        
          List<Traveller> res = new ArrayList<Traveller>();
        Manager mg = new Manager();
        Tags tg = new Tags();
        t.addAll(tg.getStg());
        c.addAll(tg.getCat());
        System.out.println("t from process "+t.toString());
        System.out.println("c from process "+c.toString());
        
        for(int i=0;i<c.size();i++){
            for(int j=0;i<t.size();i++){
                String category=c.get(i);
                String tag=t.get(j);
                
                System.out.println("Inside loop i "+i);
                System.out.println("Inside loop j "+j);
                
                str="SELECT places.name FROM places WHERE categ.name FROM categ LIKE '"+category+"' AND tgs.name FROM tgs LIKE '"+tag+"'";
                
                try {
             Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AlbaniaTravel","root","");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(str);
            
            while(rs.next()){
                Traveller tr = new Traveller();
                tr.setActual(rs.getString("name"));
                res.add(tr);
                
            }  
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
        finally{
            cn.closeAll(conn, pstmt, rs);
            System.out.println("Finally block closed the connection OK from getAllMembers");
        }
                
            }
        }
    return res;
    }
}
