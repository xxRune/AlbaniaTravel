
package Beans;

import Connections.Connect;
import Connections.Connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="manager")
@SessionScoped
public class Manager {
    
    Connector cn = new Connector();
    public static Connection conn=null;
    public static PreparedStatement pstmt=null;
    public static ResultSet rs=null;
    private String str="";
  
    private String tg;

   
    
    List<String> selectedt = new ArrayList<>();
 
    public Manager(String tg){
        this.tg=tg;
    }
   
    public Manager() { 
    }
    
   /*
    @PostConstruct
    public void init(){
        selectedt= new ArrayList<>();

    }
    */
    
     public List<String> getSelectedt() {
        return selectedt;
    }

    /**
     * @return the tg
     */
    public String getTg() {
        return tg;
    }

    /**
     * @param tg the tg to set
     */
    public void setTg(String tg) {
        this.tg = tg;
    }
    
     public void setSelectedt(List<String> selectedt) {
        this.selectedt = selectedt;
    }
     
     public void addseltoList(String tag){
         selectedt.add(tag);
     }
    
    
    public List<Manager> tags() throws ClassNotFoundException{
        
        List<Manager> arr = new ArrayList<Manager>();
        str = "select name from tgs";
        System.out.println(str);
          
        try {
             Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AlbaniaTravel","root","");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(str);
            //pstmt= conn.prepareStatement(str);
            //rs=pstmt.executeQuery();
            while(rs.next()){
                Manager mmb = new Manager();
                mmb.setTg(rs.getString("name"));
                arr.add(mmb);
                
            }  
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
        finally{
            cn.closeAll(conn, pstmt, rs);
            System.out.println("Finally block closed the connection OK from getAllMembers");
        }
        return arr;
    }
    
         
    
        public void addTgs() throws ClassNotFoundException{
             
        cn.getConnection();
        String sql ="Insert into tgs(name) values(?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,this.getTg());
            
            int executeUpdate = pstmt.executeUpdate();
            if(executeUpdate >0){
                System.out.println("Add method Successfull");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            cn.closeAll(conn, pstmt, rs);
            System.out.println("Finally block closed the connection OK from ADD()");
        }
        
    }
        
        public List<String> search(String name) throws ClassNotFoundException{
            List<String> arr = new ArrayList<String>();
            for(Manager m : tags())
                if(m.getTg().toLowerCase().startsWith(name.toLowerCase()))
                    arr.add(m.getTg());
                return arr;
            
                
        }
    
        
}
