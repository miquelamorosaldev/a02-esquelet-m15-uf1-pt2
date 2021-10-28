/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EncryptDecryptSHA1;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author alumne
 */
public class PasswordDigestExampleMiquel {
    
     public static void main(String[] args) {

        String value = "admin";
        String sha1RealValue = "";
        String sha1ExpectedValue = "d033e22ae348aeb5660fc2140aec35850c4da997";

        // With the java libraries
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(value.getBytes("utf8"));
            sha1RealValue = String.format("%040x", 
                    new BigInteger(1, digest.digest()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("The sha1 of \"" + value + "\" is:");
        System.out.println(sha1RealValue);
        
        if(sha1ExpectedValue.equals(sha1RealValue)) {
            System.out.println("The user \"" + value + "\" is logged.");
        } else {
            System.out.println("Error logging user \"" + value );
        }

    }
}
