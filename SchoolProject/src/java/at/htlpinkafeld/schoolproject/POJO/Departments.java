/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.POJO;

public enum Departments {
    Informatik,
    elektronik,
    Gebäudetechnik,
    bautechnik;
    
    public static String print(){
        String tmp = "";
        for(int i=0;i<Departments.values().length;i++){
            tmp+=Departments.values()[i];
            if(i+1<Departments.values().length)
                tmp+=",";
        }
        return tmp;
    }
}
