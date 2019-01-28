/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.POJO;

import at.htlpinkafeld.schoolproject.util.PBKDF2WithHmacSHA512;

public enum Schools {
    HTLuVa_Pinkafeld("HTLuVa Pinkafeld","hostname","user","pwd");
    
    private String name,
                   hostname,
                   user,
                   pwd;

    public String getName() {
        return name;
    }

    public String getHostname() {
        return hostname;
    }
    
    public String getUser(){
        return user;
    }
    
    public String getPwd(){
        return pwd;
    }
    
    private Schools(String name,String hostname,String user, String pwd){
        this.name=name;
        this.hostname=hostname;
        this.user=user;
        this.pwd=pwd;
    }
    
    public static Schools getByName(String name){
        for(Schools each : Schools.values())
            if(each.name.equals(name))
                return each;
        return null;
    }
}
