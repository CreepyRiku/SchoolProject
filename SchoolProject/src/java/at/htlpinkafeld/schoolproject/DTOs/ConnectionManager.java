/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.DTOs;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {
    private final static String dataSourceName = "java:comp/env/E_Voting";
    private static volatile ConnectionManager mgr = null;
    private DataSource ds;
    
    private ConnectionManager(){
        try {
            ds = (DataSource) (new InitialContext()).lookup(dataSourceName);
        } catch (NamingException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static synchronized ConnectionManager getInstance(){
        if(mgr==null)
            mgr=new ConnectionManager();
        return mgr;
    }
    
    public Connection getCon(){
        try {
            return ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
