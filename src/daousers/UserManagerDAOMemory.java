package daousers;

import java.util.ArrayList;
import poo2users.User;

/**
 *
 * @author alumne
 */
public class UserManagerDAOMemory implements UserManagerDAOInterface{

    private ArrayList<User> users = new ArrayList<>();
    
    public UserManagerDAOMemory() {
        User pr1 = new User("pga","123456","ADMIN");
        users.add(pr1);
        users.add(new User("mba","123456","ADMIN"));
        users.add(new User("rse","123456","ADMIN"));
        users.add(new User("vra","123456","ADMIN"));
        User pr5 = new User("mam","123456","ADMIN");
        users.add(pr5);
    }
    
    @Override
    public boolean login(String username, String password) {
        // User.contains is not possible, let's search in the collection.
        // users.contains()
        boolean exists = false;
        int listSize = users.size();
        for (int i = 0; i < listSize && !exists; i++) {
            if(users.get(i).getUsername().equals(username) 
                    && users.get(i).getPassword().equals(password) ) {
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
