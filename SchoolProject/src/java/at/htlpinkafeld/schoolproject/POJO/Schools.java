/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.POJO;

import at.htlpinkafeld.schoolproject.Services.Service;
import at.htlpinkafeld.schoolproject.util.PBKDF2WithHmacSHA512;

public enum Schools {
    HTLuVa_Pinkafeld("HTLuVa Pinkafeld");
    
    private String name;
    private Service accSrv;
    
    public String getName() {
        return name;
    }

    private Schools(String name){
        this.name=name;
    }
    
    public static Schools getByName(String name){
        for(Schools each : Schools.values())
            if(each.name.equals(name))
                return each;
        return null;
    }
}
