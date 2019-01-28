/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.Services;

import at.htlpinkafeld.schoolproject.DTOs.SQLUserDAO;
import at.htlpinkafeld.schoolproject.POJO.User;
import java.util.List;

public class UserService implements Service<User>{
    private SQLUserDAO dao;
    
    @Override
    public List<User> getList() {
        return dao.getList();
    }

    @Override
    public User get(Integer idx) {
        return dao.get(idx);
    }

    
}
