package com.safwan.data.hash;

import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;

import java.security.SecureRandom;
 

public class PassSecureUtil {

    /*public static void main(String[] args) throws NoSuchAlgorithmException {

        String password = "password";
        String salt = "safwan";
        String passwordToHash = salt+password;
        String securePassword = getSHA1SecurePassword(passwordToHash);
        System.out.println(securePassword);
        
        
        String newPassword = "password";
        String newPasswordToHash = salt+newPassword;
        String newSecurePassword = getSHA1SecurePassword(newPasswordToHash);
        System.out.println(newSecurePassword);
        
        if (securePassword.equals(newSecurePassword)) {
        	System.out.println("Match");
        }
       
    }*/

    public String getSHA1SecurePassword(String passwordToHash) {

        String generatedPassword = null;

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[] bytes = md.digest(passwordToHash.getBytes());

            StringBuilder sb = new StringBuilder();

            for(int i=0; i< bytes.length ;i++)

            {

                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));

            }

            generatedPassword = sb.toString();

        } 

        catch (NoSuchAlgorithmException e) 

        {

            e.printStackTrace();

        }

        return generatedPassword;

    }

}