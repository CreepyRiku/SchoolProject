/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.DTOs;

import at.htlpinkafeld.schoolproject.POJO.Candidate;
import at.htlpinkafeld.schoolproject.POJO.Election;
import at.htlpinkafeld.schoolproject.POJO.ElectionType;
import at.htlpinkafeld.schoolproject.POJO.User;
import java.util.ArrayList;
import java.util.List;

public class TestDAO{
    private List<Election> eList = new ArrayList<>();
    
    public TestDAO(){
        List<Candidate> cList = new ArrayList<>();
        
        cList.add(new Candidate(1,"Hans","Juergen","4BHIF","2018/19"));
        cList.add(new Candidate(2,"Fridolin","Hausmeister","4BHIF","2018/19"));
        
        eList.add(new Election(1,ElectionType.KS,"4BHIF","2018/19",cList));
    }
    
    public List<Election> getAvailableElections(User u){
        List<Election> tmp = new ArrayList<>();
        
        for(Election each : eList)
            for(String ele : each.getAllowedClass().split(","))
                if(ele.equals(u.getClassName())){
                    tmp.add(each);
                    break;
                }
        return tmp;
    }
}
