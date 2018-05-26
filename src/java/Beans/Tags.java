
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
    static List<String> stg = new ArrayList<>();
    
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
    public static List<String> getStg() {
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
    public static void setStg(List<String> aStg) {
        stg = aStg;
    }
    
    public String addtoList(String s){
        stg.add(s);
        
        //to remove duplicates
        Set<String> hs = new HashSet<>();
        hs.addAll(stg);
        stg.clear();
        stg.addAll(hs);
        
        return "/tags.xhtml";
    }
    
    public List<String> toaddT(){
            List<String> td = new ArrayList<String>();
            td.addAll(stg);
            return td;
        }
    
    public String delAll(){
        stg.clear();
        return "/tags.xhtml";
    }
    
}
