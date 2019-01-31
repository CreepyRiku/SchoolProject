/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.Services;

import at.htlpinkafeld.schoolproject.POJO.User;
import at.htlpinkafeld.schoolproject.util.PBKDF2WithHmacSHA512;
import java.util.ArrayList;
import java.util.List;

public class UserTestService implements Service<User>{
    private List<User> uList;
    public UserTestService(){
        List<User> tmp = new ArrayList<>();
        try {
            byte[] salt = PBKDF2WithHmacSHA512.salt();
            tmp.add(new User(1,"julian.ganster","4BHIF","IT",PBKDF2WithHmacSHA512.hash("Test", salt),salt));
            salt = PBKDF2WithHmacSHA512.salt();
            tmp.add(new User(2,"admin","Yeet","School",PBKDF2WithHmacSHA512.hash("Admin", salt),salt));
        } catch (Exception e){
            System.out.println("RIIIIIIIIIIIIIII");
        }
        uList = tmp;
    }
    
    @Override
    public List<User> getList() {
        return uList;
    }

    @Override
    public User get(Integer id) {
        for(User each : uList)
            if(each.getId().equals(id))
                return each;
        return null;
    }

}
