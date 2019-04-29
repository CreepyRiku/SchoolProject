/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.POJO;

import java.util.List;

public class Election {
    private Integer id;
    private ElectionType type;
    private Status status;
    private String allowedClass; //brechtigte Klassen für die Wahl 
    private String year; //Jahrgang
    private List<Candidate> canList;
    
    public Election(Integer id,ElectionType t, String classes,String year,List<Candidate> l){
        this.id=id;
        this.type=t;
        this.status=Status.Created;
        this.allowedClass = classes;
        this.year = year;
        this.canList = l;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ElectionType getType() {
        return type;
    }

    public void setType(ElectionType type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAllowedClass() {
        return allowedClass;
    }

    public void setAllowedClass(String allowedClass) {
        this.allowedClass = allowedClass;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Candidate> getCanList() {
        return canList;
    }

    public void setCanList(List<Candidate> canList) {
        this.canList = canList;
    }
}
