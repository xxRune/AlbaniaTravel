
package Beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="manager")
public class Manager {
   
   private int id; 
   private String tg;

    public Manager(int id, String tg) {
        this.id = id;
        this.tg = tg;
    }
   List<String> selectedt= new ArrayList<>();
   List<String> tags;
    
    public Manager() {
        tags= new ArrayList<>();
        
        tags.add("Beach");
        tags.add("City");
        tags.add("Village");
    }

    public List<String> getTags() {
        return tags;
    }
    
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
    
    public void addSelectedt(){
        selectedt.add(tg);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
}
