/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.Services;

import at.htlpinkafeld.schoolproject.DTOs.DAO;
import at.htlpinkafeld.schoolproject.POJO.User;
import java.util.List;

public class UserService implements Service<User>{
    private DAO<User> dao;
    
    @Override
    public List<User> getList() {
        return dao.getList();
    }

    @Override
    public User get(Integer id) {
       for(User each : dao.getList())
            if(each.getId().equals(id))
                return each;
        return null;
    }

}
