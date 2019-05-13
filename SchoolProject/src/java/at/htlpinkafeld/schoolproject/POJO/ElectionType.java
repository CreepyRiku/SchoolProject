/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.POJO;

public enum ElectionType {
    //Ksp=Klassensprecher,ASp=Abteilungssprecher,SSp=Schulsprecher,SW=Stichwahl
    KSp(2),     
    KSp_SW(2),
    ASp(6),
    ASp_SW(6),
    SSp(6),
    SSp_SW(6);
    
    private int max_points;
    
    private ElectionType(int p){
        max_points=p;
    }
    
    public int getMaxPoints(){
        return max_points;
    }
}
