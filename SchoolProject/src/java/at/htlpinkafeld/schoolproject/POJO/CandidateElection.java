/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.POJO;

public class CandidateElection{
    private Candidate cand;
    private Integer points;
    
    public CandidateElection(Candidate c){
        this(c,0);
    }
    
    public CandidateElection(Candidate c, Integer p){
        this.cand=c;
        this.points=p;
    }

    public Candidate getCand() {
        return cand;
    }

    public void setCand(Candidate cand) {
        this.cand = cand;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
        System.out.println("" + cand.getId() + " " + points);
    }
}
