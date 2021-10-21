package encriptdemo;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Ejemplo extraido de:
 * @reference http://oliviertech.com/es/java/generate-SHA1-hash-from-a-String/
 * @author alumne
 */
public class DigestExample {

    public static void main(String[] args) {

        String value = "admin";

        String sha1 = "";

        // With the java libraries
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(value.getBytes("utf8"));
            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("The sha1 of \"" + value + "\" is:");
        System.out.println(sha1);
        System.out.println();

    }

}
