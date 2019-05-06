/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schoolproject.Beans;

import at.htlpinkafeld.schoolproject.DTOs.TestDAO;
import at.htlpinkafeld.schoolproject.POJO.Candidate;
import at.htlpinkafeld.schoolproject.POJO.CandidateElection;
import at.htlpinkafeld.schoolproject.POJO.Election;
import at.htlpinkafeld.schoolproject.POJO.User;
import at.htlpinkafeld.schoolproject.Services.Service;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author JulianGanster
 */
public class VotingBean {
    private LoginBean bean;
    private TestDAO archive;
    private Service<User> srv;
    private Election election;
    private List<CandidateElection> cList;
    private List<SelectItem> values;
    private Integer candId;
    
    @PostConstruct
    public void initialize(){
        election = (archive.getAvailableElections(srv.getPupil(bean.getUser()))).get(0);
        cList = new ArrayList<>();
        values = new ArrayList<>();
        for(Candidate each : election.getCanList())
            cList.add(new CandidateElection(each));
        for(int i=election.getType().getMaxPoints();i>=0;i--)
            if(i!=0)
                values.add(new SelectItem(i,"" + i));
            else
                values.add(new SelectItem(i,"nichts"));
    }
    
    public void setBean(LoginBean b){
        this.bean=b;
    }
    
    public void setArchive(TestDAO d){
        this.archive=d;
    }
    
    public void setSrv(Service<User> s){
        this.srv=s;
    }
    
    public List<CandidateElection> getCandidates(){
       return cList;
    }
    
    public void pointChangeListener(ValueChangeEvent e){
        if(e.getPhaseId()!=PhaseId.INVOKE_APPLICATION){
            e.setPhaseId(PhaseId.INVOKE_APPLICATION);
            e.queue();
            return;
        }
        Integer tmp = (Integer)e.getNewValue(),
                id = null,
                count=1;
        if(tmp!=0){
            for(CandidateElection each : cList){
                for(CandidateElection ele : cList){
                    if(!each.equals(ele))
                        if(each.getPoints()==ele.getPoints() && each.getCand().getId()!=candId)
                            id=each.getCand().getId();
                }
            }
            if(id!=null){
               CandidateElection cand=null;
               for(CandidateElection each : cList)
                   if(each.getCand().getId()==id){
                       cand=each;
                       break;
                   }
               cand.setPoints(0);
            }
        }
    }
    
    public void setCandId(Integer id){
        candId=id;
    }
    
    public List<SelectItem> getValues(){
        return values;
    }
    
    public void submit(){
    
    }
}
