package daousers;

import EncryptDecryptSHA1.EncryptAndDecryptSHA1;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import poo2users.User;

/**
 *
 * @author alumne
 */
public class UserManagerDAOMemory implements UserManagerDAOInterface{

    private ArrayList<User> users = new ArrayList<>();
    
    private final String CLAVE_PRIVADA = "claveprivada";
    
    public UserManagerDAOMemory() {
        User pr1 = new User("pga","zqXUGxblz37qSchfgfdshg==","ADMIN");
        users.add(pr1);
        users.add(new User("mba","zqXUGxblz37qSchfgfdshg==","ADMIN"));
        users.add(new User("rse","zqXUGxblz37qSchfgfdshg==","ADMIN"));
        users.add(new User("vra","zqXUGxblz37qSchfgfdshg==","ADMIN"));
        User pr5 = new User("mam","zqXUGxblz37qSchfgfdshg==","ADMIN");
        users.add(pr5);
    }
    
    @Override
    public boolean login(String username, String password) {
        // User.contains is not possible, let's search in the collection.
        // users.contains()
        boolean exists = false;
        int listSize = users.size();
        // Let's encrypt the user password.
        EncryptAndDecryptSHA1 ead = new EncryptAndDecryptSHA1();
        String encryptedUserPassword = "";
        String encryptedDatabasePassword = "";
        try {
            encryptedUserPassword = ead.encrypt
                    (password, CLAVE_PRIVADA);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserManagerDAOMemory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(UserManagerDAOMemory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(UserManagerDAOMemory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserManagerDAOMemory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(UserManagerDAOMemory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(UserManagerDAOMemory.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < listSize && !exists; i++) {
            
            // Now, we get the encrypted password from the database.
            encryptedDatabasePassword = users.get(i).getPassword();
            // If user password and database password match, the user
            // is logged succesfully.
            if(users.get(i).getUsername().equals(username) 
                    && encryptedUserPassword.equals(encryptedDatabasePassword) ) {
                exists = true;
            }
        }
        return exists;
    }

    @Override
    public boolean logout(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
