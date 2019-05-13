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
    public T getPupil(String user);
    public T getTeacher(String user);
    public List<T> getPupilList();
    public List<T> getTeacherList();
    public Boolean authenticate(T u,String attemptedPwd);
    public void refresh();
}
