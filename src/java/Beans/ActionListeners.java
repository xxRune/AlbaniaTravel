
package Beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="actions")
public class ActionListeners {
    
    private String tag;
    
    List<String> selected_tags;
    
    public ActionListeners() {
        selected_tags= new ArrayList<>();
    }
    
    public List<String> getSelected_tags() {
        return selected_tags;
    }
    
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    
    
    
}
