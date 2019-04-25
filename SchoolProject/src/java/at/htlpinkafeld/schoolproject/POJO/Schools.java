/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.POJO;

import at.htlpinkafeld.schoolproject.Services.Service;
import at.htlpinkafeld.schoolproject.util.PBKDF2WithHmacSHA512;

public enum Schools {
    HTLuVa_Pinkafeld("HTLuVa Pinkafeld","userLDAPService");
    
    private String name,
                   srvName; //TODO get a list of all Beans to find the right service for each school. YEET!
    
    public String getName() {
        return name;
    }
    
    public String getSrvName(){
        return srvName;
    }

    private Schools(String name,String srv){
        this.name=name;
        srvName=srv;
    }
    
    public static Schools getByName(String name){
        for(Schools each : Schools.values())
            if(each.name.equals(name))
                return each;
        return null;
    }
}
