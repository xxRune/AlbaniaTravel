
package Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="tgbean")
public class Tags implements Serializable{
    
    private static final long s = 100000000000000000L;
    private String tag;
    private List<String> stg = new ArrayList<>();
    
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
    public List<String> getStg() {
        return stg;
    }

    /**
     * @param stg the stg to set
     */
    public void setStg(List<String> stg) {
        this.stg = stg;
    }
    
    public void addtoList(){
        stg.add(getTag());
        stg.add("one");
    }
    
}
