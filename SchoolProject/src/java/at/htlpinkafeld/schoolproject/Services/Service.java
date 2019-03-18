/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schoolproject.Services;

import at.htlpinkafeld.schoolproject.POJO.User;
import java.util.List;

/**
 *
 * @author JulianGanster
 * 
 * The Service interface which allows to authenticate a User
 * and to change the user's passwords if the user would forget it
 */
public interface Service<T> {
    public User getPupil(String user);
    public User getTeacher(String user);
    public List<User> getPupilList();
    public List<User> getTeacherList();
    public Boolean authenticate(User u,String attemptedPwd);
    
}
