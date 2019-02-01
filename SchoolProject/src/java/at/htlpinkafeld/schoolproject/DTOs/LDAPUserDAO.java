/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.DTOs;

import at.htlpinkafeld.schoolproject.POJO.User;
import java.util.Hashtable;
import java.util.List;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LDAPUserDAO implements DAO<User>{
    private DirContext ldapCon;
    
    public LDAPUserDAO(){
        Hashtable<String,String> env = new Hashtable<>(11);
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL,  "ldap://htldns2.htlpinkafeld.at");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=jean paul blanc,ou=MonOu,dc=dom,dc=fr");
        env.put(Context.SECURITY_CREDENTIALS, "pwd");
        try {
            ldapCon = new InitialDirContext(env);
        } catch (NamingException ex) {
            System.out.println("LDAP Access Error: " + ex);
        }
    }
    
    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public User get(Integer idx) {
        return null;
    }
    
}
