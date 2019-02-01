/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schoolproject.Beans;

import at.htlpinkafeld.schoolproject.POJO.Schools;
import at.htlpinkafeld.schoolproject.POJO.User;
import at.htlpinkafeld.schoolproject.Services.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

public class LoginBean {
    private Service<User> srv;
    private String selectedSchool,
                   errorMsg = "";
    private User user;
    
    public LoginBean() {
        selectedSchool = Schools.values()[0].getName();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setSrv(Service<User> srv) {
        this.srv = srv;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public void authenticate(String pwd){
        if(user==null)
            errorMsg = "User nicht in dieser Schule!";
        else
            if(user.authenticate(pwd)){
                errorMsg="";
                try {
                    FacesContext.getCurrentInstance().getExternalContext().dispatch("/voting.xhtml");
                } catch (IOException ex) {}
            }else
                errorMsg = "Falsches Loginpasswort!";
    }
}
