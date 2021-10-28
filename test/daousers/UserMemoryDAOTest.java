package daousers;

import adnmanagers.ADN_Manager;
import junit.framework.TestCase;

/**
 *
 * @author alumne
 */
public class UserMemoryDAOTest extends TestCase {
    
    UserManagerDAOInterface userDAO;
    ADN_Manager adnManager;
    
    public UserMemoryDAOTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        userDAO = new UserManagerDAOMemory();
        adnManager  = new ADN_Manager();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    
    public void testLoginExistingUser() {
        // Esperamos que el login sea true.
        boolean resEsperat = true;
        boolean resReal = userDAO.login("pga","admin");
        assertEquals(resEsperat, resReal);
    }
    
    public void testLoginNonExistingUser() {
        // Esperamos que el login sea false.
        boolean resEsperat = false;
        boolean resReal = userDAO.login("new","admin");
        assertEquals(resEsperat, resReal);
    }
    
}
