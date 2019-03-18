/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schoolproject.Beans;

import at.htlpinkafeld.schoolproject.POJO.Schools;
import at.htlpinkafeld.schoolproject.POJO.User;
import at.htlpinkafeld.schoolproject.Services.Service;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

public class LoginBean {
    private String errorMsg = "";
    private Schools selectedSchool;
    private User user = new User();
    private Service srv;
    
    public LoginBean() {
        selectedSchool = Schools.values()[0];
    }
    
    public void setSrv(Service s){
        srv=s;
    }
    
    public String getErrorMsg() {
        return errorMsg;
    }
    
    public List<SelectItem> getSchoolList(){
        List<SelectItem> tmp = new ArrayList<>();
        for(Schools each : Schools.values())
            tmp.add(new SelectItem(each.getName(),each.name()));
        return tmp;
    }

    public String getSelectedSchool() {
        return selectedSchool.getName();
    }

    public void setSelectedSchool(String selectedSchool) {
        this.selectedSchool = Schools.getByName(selectedSchool);
    }

    public String getUser() {
        return user.getUser();
    }

    public void setUser(String user) {
        if(user.length()==4)
            this.user=srv.getTeacher(user);
        else
            this.user=srv.getPupil(capitalize(user));
    }
    
    private String capitalize(String s){
        List<String> tmp = new ArrayList<>();
        String tmpS = "";
        for(char each : s.toCharArray())
            if(each!='.')
                tmpS+=each;
            else{
                tmp.add(tmpS);
                tmpS="";
            }
        tmp.add(tmpS); 
        
        return ("" + tmp.get(0).charAt(0)).toUpperCase() + tmp.get(0).substring(1) + "." + ("" + tmp.get(1).charAt(0)).toUpperCase() + tmp.get(1).substring(1);
    }
    
    public Object authenticate(String pwd){
        if(user==null)
            errorMsg = "User nicht in dieser Schule vorhanden!";
        else
            if(srv.authenticate(user, pwd)){
                errorMsg="";
                return "success";
            }else
                errorMsg = "Falsches Loginpasswort!";
        return "failure";
    }
}
