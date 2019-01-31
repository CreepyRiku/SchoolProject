/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schoolproject.util;

import at.htlpinkafeld.schoolproject.POJO.User;
import at.htlpinkafeld.schoolproject.Services.Service;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author JulianGanster
 */
public class UserConverter implements Converter{
    private Service<User> srv;
    public UserConverter() {}

    public void setSrv(Service<User> srv) {
        this.srv = srv;
    }
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        for(User each : srv.getList())
            if(each.getUser().equals(string))
                return each;
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((User)o).getUser();
    }
    
}
