/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.Services;

import at.htlpinkafeld.schoolproject.DTOs.DAO;
import at.htlpinkafeld.schoolproject.DTOs.LDAPUserDAO;
import at.htlpinkafeld.schoolproject.POJO.User;
import java.util.List;
import javax.naming.NamingException;

public class LDAPUserService implements Service<User>{
    private DAO<User> dao;
    
    public LDAPUserService() throws NamingException{
        dao = new LDAPUserDAO();
    }
    
    @Override
    public User getPupil(String user) {
        return dao.getPupil(user);
    }

    @Override
    public User getTeacher(String user) {
        return dao.getTeacher(user);
    }

    @Override
    public List<User> getPupilList() {
        return dao.getPupilList();
    }

    @Override
    public List<User> getTeacherList() {
        return dao.getTeacherList();
    }

    @Override
    public Boolean authenticate(User u, String attemptedPwd) {
        return dao.authenticate(u, attemptedPwd);
    }

}
