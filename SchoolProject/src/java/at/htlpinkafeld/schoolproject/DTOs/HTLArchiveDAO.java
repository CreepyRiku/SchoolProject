/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.DTOs;

import at.htlpinkafeld.schoolproject.POJO.Candidate;
import at.htlpinkafeld.schoolproject.POJO.Departments;
import at.htlpinkafeld.schoolproject.POJO.Election;
import at.htlpinkafeld.schoolproject.POJO.ElectionType;
import at.htlpinkafeld.schoolproject.POJO.Status;
import at.htlpinkafeld.schoolproject.POJO.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HTLArchiveDAO implements ArchiveDAO{
    private List<Election> eList = new ArrayList<>();
    private List<Candidate> cList = null;
    
    public HTLArchiveDAO(){
        List<Candidate> cList;
        try(Statement stm = ConnectionManager.getInstance().getCon().createStatement()) {
            ResultSet setEle = stm.executeQuery("SELECT ElectionNumber,ElectionType,Class,Status,Year,Department FROM Election");
            while(setEle.next()){
                ResultSet setEleCan = stm.executeQuery("SELECT CandidateNr FROM CandidateElection WHERE ElectionNr=" + setEle.getString(1));
                cList = new ArrayList<>();
                while(setEleCan.next()){
                    if(this.cList==null){
                        this.cList = new ArrayList<>();
                        ResultSet setCan = stm.executeQuery("SELECT CandidateNumber,Forename,Surename,Class,Year,Deleted FROM Candidate");
                        Candidate tmp = new Candidate(setCan.getInt(1),setCan.getString(2),setCan.getString(3),setCan.getString(4),setCan.getString(5));
                        Integer del = setCan.getInt(6);
                        if(del==1)
                            tmp.setDeleted(true);
                        tmp.setDeleted(false);
                        this.cList.add(tmp);
                    }
                    for(Candidate each : this.cList){
                        if(each.getId()==setEleCan.getInt(1))
                            cList.add(each);
                    }
                }
                Election tmp = new Election(setEle.getInt(1),ElectionType.valueOf(setEle.getString(2)),Status.valueOf(setEle.getString(4)),setEle.getString(5));
                String className = setEle.getString(3);
                String dept = setEle.getString(6);
                if(!className.isEmpty())
                    tmp.setAllowedClass(className);
                if(!dept.isEmpty())
                    tmp.setDept(Departments.valueOf(dept));
                eList.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HTLArchiveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Election> getAvailableElections(User u) {
         List<Election> tmp = new ArrayList<>();
         for(Election each : eList){
             if(each.getStatus()==Status.Acitve){
                switch(each.getType()){
                    case KSp: case KSp_SW:{    
                        if(each.getAllowedClass().equals(u.getClassName()))
                            tmp.add(each);
                        break;
                    }
                    case ASp: case ASp_SW:{
                        if(each.getDept()==u.getDept())
                            tmp.add(each);
                        break;
                    }
                    case SSp: case SSp_SW:{
                        tmp.add(each);
                    }
                }
             }
         }
         return tmp;
    }

    @Override
    public void addElection(ElectionType t, String className, Departments d, String dept) {
        
    }

    @Override
    public void deleteElection(Integer id) {
    }

    @Override
    public void updateElection(Integer id, Election e) {
    }

    @Override
    public List<Candidate> getCandidates() {
    }

    @Override
    public void addCandidate(String fName, String lName, String className, String year) {
    }

    @Override
    public void deleteCandidate(Integer id) {
    }

    @Override
    public void updateCandidate(Integer id, Candidate c) {
    }
}
