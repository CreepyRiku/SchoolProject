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
    public T getPupil(String user);
    public T getTeacher(String user);
    public List<T> getPupilList();
    public List<T> getTeacherList();
    public Boolean authenticate(User u,String attemptedPwd);
    
}
