/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.DTOs;

import at.htlpinkafeld.schoolproject.POJO.Role;
import at.htlpinkafeld.schoolproject.POJO.User;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class LDAPUserDAO implements DAO<User>{
    private final String[] departments = {"Informatik","elektronik","Gebäudetechnik","bautechnik"};
    private  List<String>   itClasses = null,
                            etClasses = null,
                            buildingClasses = null,
                            constructionClasses = null;
    private final String studentSearchBase = "dc=htlpinkafeld,dc=at";
    private final String teacherSearchBase = "ou=Lehrpersonal,ou=verwaltung,dc=htlpinkafeld,dc=at";
    private final String adminPwd = "GIJoqnMpIdys4i5YkurSivKbTlvo7j7xouaia8qmWV8=";
    private final String adminEmail = "julian.ganster@htlpinkafeld.at";
    private final StandardPBEStringEncryptor e = new StandardPBEStringEncryptor ();
    public static final String DOMAIN = "htlpinkafeld.at";
    public static final String ADSERVER = "htldns2.htlpinkafeld.at";
    
    
    private List<User> pList = null;
    private List<User> tList = null;
    private Properties properties;
    private DirContext dirContext;
    private SearchControls searchCtls;
    private String[] returnAttributes = {"mail", "name"};
    
    boolean isTeacher;

    public LDAPUserDAO() throws NamingException { 
        e.setPassword("Yeet");
        properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        properties.put(Context.PROVIDER_URL, "LDAP://" + ADSERVER);
        properties.put(Context.SECURITY_CREDENTIALS, e.decrypt(adminPwd));
        properties.put(Context.SECURITY_PRINCIPAL, adminEmail);
        
        testConnection();
        fillClassesList();
        refresh();
        
        searchCtls = new SearchControls();
        searchCtls.setReturningAttributes(returnAttributes);
    }

    public boolean testConnection() {
        try {
            dirContext = new InitialDirContext(properties);
        } catch (NamingException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    private void fillClassesList(){
        for(String each : departments)
            fillClassesList(each);
    }
    
    private void fillClassesList(String dept){
        List<String> tmp = new ArrayList<>();
        String searchBase = null;
        if(dept.equals(departments[0])) //Informatik
            searchBase = "ou=Klassen,ou=" + departments[0] + "," + studentSearchBase;
        if(dept.equals(departments[1])) //Elektronik
            searchBase = "ou=" + departments[1] + "," + studentSearchBase;
        if(dept.equals(departments[2])) //Gebaeudetechnik
            searchBase = "ou=" + departments[2] + "," + studentSearchBase;
        if(dept.equals(departments[3])) //Bautechnik
            searchBase = "ou=" + departments[3] + "," + studentSearchBase;
        try {
            NamingEnumeration<SearchResult> resultEnum = this.dirContext.search(searchBase, "(objectclass=*)",this.searchCtls);
            while(resultEnum.hasMore()){
                SearchResult tmpRes = resultEnum.next();
                String name = tmpRes.getName();
                if(name.startsWith("OU=1") || name.startsWith("OU=2") || name.startsWith("OU=3") || name.startsWith("OU=4") || name.startsWith("OU=5") || name.startsWith("OU=6"))
                    tmp.add(name);
            }

            if(dept.equals(departments[0])) //Informatik
                itClasses=tmp;
            if(dept.equals(departments[1])) //Elektronik
                etClasses=tmp;
            if(dept.equals(departments[2])) //Gebaeudetechnik
                buildingClasses=tmp;
            if(dept.equals(departments[3])) //Bautechnik
                constructionClasses=tmp;
         } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void fillPupilList(){
        if(pList==null)
            pList = new ArrayList<>();
        for(String each : itClasses){
            for(User ele : getList("Klassen,ou=" + departments[0],each))
                pList.add(ele);
        }
        for(String each : etClasses){
            for(User ele : getList(departments[1],each))
                pList.add(ele);
        }
        for(String each : buildingClasses){
            for(User ele : getList(departments[2],each))
                pList.add(ele);
        }
        for(String each : constructionClasses){
            for(User ele : getList(departments[3],each))
                pList.add(ele);
        }
    }
    
    public List<User> getList(String dept,String className){
        List<User> list = new ArrayList<>();
        String searchBase = className + ",ou=" + dept + "," + studentSearchBase;
		
        try {
            NamingEnumeration<SearchResult> resultEnum = this.dirContext.search(searchBase, "(sAMAccountName=*)",this.searchCtls);
            while(resultEnum.hasMore()){
                SearchResult tmp = resultEnum.next();
                Attributes attributes = tmp.getAttributes();
                Attribute emailAttribute = attributes.get("mail");
                Attribute nameAttribute = attributes.get("name");
                String mail = "";
                if(emailAttribute!=null)
                    mail = emailAttribute.get().toString();
                User userTmp = new User(mail.replace("@htlpinkafeld.at", ""),mail,className.replace("OU=", ""),dept.replace("Klassen,ou=", ""),nameAttribute.toString());
                userTmp.setRole(Role.PUPIL);
                list.add(userTmp);
            }
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    public List<User> getList(String searchBase){
        List<User> list = new ArrayList<>();
		
        try {
            NamingEnumeration<SearchResult> resultEnum = this.dirContext.search(searchBase, "(sAMAccountName=*)",this.searchCtls);
            while(resultEnum.hasMore()){
                SearchResult tmp = resultEnum.next();
                Attributes attributes = tmp.getAttributes();
                Attribute emailAttribute = attributes.get("mail");
                Attribute nameAttribute = attributes.get("name");
                String mail = "";
                if(emailAttribute!=null)
                    mail = emailAttribute.get().toString();
                User userTmp = new User(mail.replace("@htlpinkafeld.at", ""),mail,"","",nameAttribute.toString());
                userTmp.setRole(Role.TEACHER);
                list.add(userTmp);
            }
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    
    public void closeLdapConnection() {
        try {
            if (dirContext != null) {
                dirContext.close();
            }
        } catch (NamingException e) {
            System.out.println("LDAP Exception: " + e);
        }
    }

    private User getPupilByUser(String user){
        for(User each : pList)
            if(each.getUser().equals(user))
                return each;
        return null;
    }
    
    private User getTeacherByUser(String user){
        for(User each : tList)
            if(each.getUser().equals(user))
                return each;
        return null;
    }
    
    @Override
    public Boolean authenticate(User u,String attemptedPwd) {
        Hashtable environment;
        try {
            environment = (Hashtable) dirContext.getEnvironment().clone();
            environment.put(Context.SECURITY_PRINCIPAL, u.getEmail());
            environment.put(Context.SECURITY_CREDENTIALS, attemptedPwd);
            new InitialDirContext(environment);
        } catch (NamingException ex) {
            return false;
        }
        return true;
    }

    @Override
    public User getPupil(String user) {
        return getPupilByUser(user);
    }

    @Override
    public User getTeacher(String user) {
        return getTeacherByUser(user);
    }

    @Override
    public List<User> getPupilList() {
        return pList;
    }

    @Override
    public List<User> getTeacherList() {
        return tList;
    }

    @Override
    public void refresh() {
        fillPupilList();
        tList = getList(teacherSearchBase);
    }
}
