/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.DTOs;

import at.htlpinkafeld.schoolproject.POJO.Schools;
import at.htlpinkafeld.schoolproject.POJO.User;
import at.htlpinkafeld.schoolproject.util.PBKDF2WithHmacSHA512;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLUserDAO implements DAO<User>{
    private Schools srv;
    private List<User> uList = new ArrayList<>();
    @Override
    public List<User> getList() {
        checkList();
        return uList;
    }

    @Override
    public User get(Integer idx) {
        checkList();
        return uList.get(idx);
    }
    
    private void checkList(){
        Connection con = DatabankAccessSingleton.getInstance().getConnection(srv.getHostname(), srv.getUser(), srv.getPwd());
        try {
            ResultSet set = con.createStatement().executeQuery("select count(*) from pupil");
            if(set.getInt(1) != uList.size()){
                uList = new ArrayList<>();
                set = con.createStatement().executeQuery("select name,class,department,pwd from pupil");
                while (set.next()){
                    try {
                        byte [] salt;
                        salt = PBKDF2WithHmacSHA512.salt();
                        uList.add(new User(set.getString(1),set.getString(2),set.getString(3),PBKDF2WithHmacSHA512.hash(set.getString(4), salt),salt));
                    } catch (Exception ex) {
                        System.out.println("User Password Cipher Error:" + ex);
                    }
                }  
            }
        } catch (SQLException ex) {
            System.out.println("SQL Execution Error: " + ex);
        }        
    }

}
