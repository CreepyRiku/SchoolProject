/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.POJO;

public class Candidate {
    private Integer id,
                    points;
    private String firstName,
                   lastName,
                   className,
                   year;
    private Boolean deleted;

    public Candidate(Integer id, String firstName, String lastName, String className, String year) {
        this.id = id;
        points=0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.className = className;
        this.year = year;
        this.deleted=false;
    }
    
    public Candidate(Integer id,String fName,String lName,String className,String year,Boolean deleted){
        this(id,fName,lName,className,year);
        this.deleted=deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
