
package Beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.component.behavior.AjaxBehavior;

@ManagedBean(name="tgbean")
public class Tags implements Serializable{
    
    private static final long s = 100000000000000000L;
    
    private String tag;
    private String[] cat; 

   
    
    private static String currentselected;
    private static Set<String> stg = new HashSet<>();
    
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
    public  Set<String> getStg() {
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

    
    public Set<String> display(){
        return stg;
    }
    
    public void addtoList(){
        
        System.out.println("Something"+stg);
        
        this.stg.add(currentselected);
        
       
    }
    
     /*
      public Set<Tags> toaddT(){
            Set<Tags> td = new HashSet<Tags>();
            //td.addAll(stg);
            
            for(int i=0;i==stg.size()-1;i++){
                   Tags t= new Tags();
                 //  t.setCurrentselected(stg.);
                   td.add(t);
            }
    
        Tags t= new Tags();
        t.setTag(stg.get(stg.size()-1));
        stg.remove(stg.size()-1);
        
            return td;
        }   */
    
      
    public String delAll(){
        stg.clear();
        return "/tags.xhtml";
    }
    
    
    public void listener(AjaxBehavior event){
        addtoList();
    }
    
}
