/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.POJO;

import at.htlpinkafeld.schoolproject.util.PBKDF2WithHmacSHA512;

public class User {
   private Integer id;
   private String user,
                  className,
                  dept;
   private byte[] hash,
                  salt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
   
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public byte[] getHash() {
        return hash;
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public User(Integer id,String user, String className, String dept, byte[] hash, byte[] salt) {
        this.id=id;
        this.user = user;
        this.className = className;
        this.dept = dept;
        this.hash = hash;
        this.salt = salt;
    }
    
    public boolean authenticate(String attemptedPwd){
       try {
           return PBKDF2WithHmacSHA512.authenticate(attemptedPwd, salt, hash);
       } catch (Exception ex) {
           System.out.println("Autentication Error: " + ex);
       }
       return false;
    }
}
