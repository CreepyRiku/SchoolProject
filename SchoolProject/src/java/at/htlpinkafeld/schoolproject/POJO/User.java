/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.POJO;

public class User {
   private String user,
                  className,
                  dept;
   private byte[] hash,
                  salt;

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

    public User(String user, String className, String dept, byte[] hash, byte[] salt) {
        this.user = user;
        this.className = className;
        this.dept = dept;
        this.hash = hash;
        this.salt = salt;
    }

}
