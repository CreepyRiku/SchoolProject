/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.htlpinkafeld.schoolproject.util;

import at.htlpinkafeld.schoolproject.DTOs.LDAPUserDAO;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.naming.NamingException;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class LDAPTest {
    public static void main(String[] args) throws NamingException, NoSuchAlgorithmException, InvalidKeySpecException{
        new LDAPUserDAO();
    }
}
