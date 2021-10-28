package daousers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author alumne
 */
public class UserManagerDAOJSON implements UserManagerDAOInterface {
    
    @Override
    public boolean login (String username, String password) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(
                       new FileReader("usuarios.json"));

               JSONObject jsonObject = (JSONObject) obj;
               System.out.println("JSON LEIDO: " + jsonObject);

               JSONArray array = (JSONArray) jsonObject.get("Usuarios");
               System.out.println("");
               
           } catch (FileNotFoundException ex) {
               Logger.getLogger(UserManagerDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {   
             Logger.getLogger(UserManagerDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(UserManagerDAOJSON.class.getName()).log(Level.SEVERE, null, ex);
            }   
        // TODO.
        return false;
    }

    
    @Override
    public boolean logout (String username) {
        return false;
    }
    
}
