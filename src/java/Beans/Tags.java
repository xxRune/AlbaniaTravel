
package Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="tgbean")
public class Tags implements Serializable{
    
    private static final long s = 100000000000000000L;
    
    private String tag;
    private String[] cat; 

   
    
    private static String currentselected;
    private static List<String> stg = new ArrayList<>();
    
    public Tags(){
        
    }
    
    public Tags(String tag){
        this.tag=tag;
    }

    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * @return the stg
     */
    public  List<String> getStg() {
        return stg;
    }

    /**
     * @return the cat
     */
    public String[] getCat() {
        return cat;
    }

    /**
     * @param cat the cat to set
     */
    public void setCat(String[] cat) {
        this.cat = cat;
    }

    /**
     * @param stg the stg to set
     */
    /*
    public  void setStg(List<String> aStg) {
        stg = aStg;
    } */
    
     public String getCurrentselected() {
        return currentselected;
    }

    public void setCurrentselected(String currentselected) {
        this.currentselected = currentselected;
    }

    
    public List<String> display(){
        return stg;
    }
    
    public void addtoList(){
        
        System.out.println("Something"+stg);
        
        this.stg.add(currentselected);
        
        //stg.add(s);
        
        //to remove duplicates
       // Set<String> hs = new HashSet<>();
       // hs.addAll(stg);
       // stg.clear();
       // stg.addAll(hs);
        
       // return "/tags.xhtml";
       
       //return stg;
    }
    
      public List<Tags> toaddT(){
            List<Tags> td = new ArrayList<Tags>();
            //td.addAll(stg);
            
            for(int i=0;i==stg.size()-1;i++){
                   Tags t= new Tags();
                   t.setCurrentselected(stg.get(i));
                   td.add(t);
            }
         /*   
        Tags t= new Tags();
        t.setTag(stg.get(stg.size()-1));
        stg.remove(stg.size()-1);
        */
            return td;
        }
      
    public String delAll(){
        stg.clear();
        return "/tags.xhtml";
    }
    
}
