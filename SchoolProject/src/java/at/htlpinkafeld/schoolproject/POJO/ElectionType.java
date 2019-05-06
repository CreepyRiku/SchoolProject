/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.POJO;

public enum ElectionType {
    KS(2),
    KS_SW(2);
    
    private int max_points;
    
    private ElectionType(int p){
        max_points=p;
    }
    
    public int getMaxPoints(){
        return max_points;
    }
}
