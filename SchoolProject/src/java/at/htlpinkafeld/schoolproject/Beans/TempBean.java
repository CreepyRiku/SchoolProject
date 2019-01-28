/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schoolproject.Beans;

import at.htlpinkafeld.schoolproject.POJO.Schools;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

public class TempBean {
    private List<SelectItem> schoolList = new ArrayList<>();
    private String selectedSchool,
                   user;
    
    public TempBean() {
        selectedSchool = Schools.values()[0].getName();
    }
    
    public List<SelectItem> getSchoolList(){
        List<SelectItem> tmp = new ArrayList<>();
        for(Schools each : Schools.values())
            tmp.add(new SelectItem(each.getName(),each.name()));
        return tmp;
    }

    public String getSelectedSchool() {
        return selectedSchool;
    }

    public void setSelectedSchool(String selectedSchool) {
        this.selectedSchool = selectedSchool;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public void authenticate(String pwd){
        
    }
}
