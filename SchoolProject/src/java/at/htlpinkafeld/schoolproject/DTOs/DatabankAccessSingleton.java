/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.DTOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabankAccessSingleton {
    private static volatile DatabankAccessSingleton INSTANCE = new DatabankAccessSingleton();
    
    private DatabankAccessSingleton(){}
    
    public static DatabankAccessSingleton getInstance(){return INSTANCE;}
    
    public Connection getConnection(String hostname, String user, String pwd){
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error loadin File: " + ex);
        }
        
        try {
            return DriverManager.getConnection(hostname, user, pwd);
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
        }
        return null;
    }
}
