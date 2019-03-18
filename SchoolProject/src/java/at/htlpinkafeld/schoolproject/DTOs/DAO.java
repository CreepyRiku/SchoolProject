/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schoolproject.DTOs;

import at.htlpinkafeld.schoolproject.POJO.User;
import java.util.List;

/**
 *
 * @author JulianGanster
 */
public interface DAO<T> {
    public User getPupil(String user);
    public User getTeacher(String user);
    public List<User> getPupilList();
    public List<User> getTeacherList();
    public Boolean authenticate(User u,String attemptedPwd);
    public void refresh();
}
