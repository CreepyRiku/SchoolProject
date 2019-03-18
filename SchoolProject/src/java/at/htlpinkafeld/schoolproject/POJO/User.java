/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.POJO;

public class User {
   private String user,
                  email,
                  className,
                  dept,
                  name;
   private Role role;
   
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email=email;
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
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(String user,String email, String className, String dept,String name, Role role) {
        this.user = user;
        this.email = email;
        this.className = className;
        this.dept = dept;
        this.name = name;
        this.role = role;
    }
    
    public User(String user,String email, String className, String dept, String name){
        this(user,email,className,dept,name,null);
    }
    
    public User(){
        this("",null,null,null,null,null);
    }

    @Override
    public String toString() {
        return "User{" + "user=" + user + ", email=" + email + ", className=" + className + ", dept=" + dept + ", name=" + name + ", role=" + role + '}';
    }
    
}
