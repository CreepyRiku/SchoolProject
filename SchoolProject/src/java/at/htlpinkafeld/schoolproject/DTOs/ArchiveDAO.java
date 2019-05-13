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
import at.htlpinkafeld.schoolproject.POJO.User;
import java.util.List;

public interface ArchiveDAO {
    public List<Election> getAvailableElections(User u);
    public void addElection(ElectionType t,String className,Departments d,String dept);
    public void deleteElection(Integer id);
    public void updateElection(Integer id,Election e);
    public List<Candidate> getCandidates();
    public void addCandidate(String fName,String lName,String className,String year);
    public void deleteCandidate(Integer id);
    public void updateCandidate(Integer id,Candidate c);
}
