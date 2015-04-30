package util;

import java.security.MessageDigest;

/**
 * Created by Ugo on 30/04/2015.
 */
public class PasswordGenerator {

    public static String encodePassword(String password){
        MessageDigest digest = null;
        try{
             digest = MessageDigest.getInstance("MD5");
        }catch(Exception e){
            throw new IllegalStateException("Message Encoding exception");
        }


        digest.update(password.getBytes());

        StringBuffer sb = new StringBuffer();
        for(byte b : digest.digest()){
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }


}
