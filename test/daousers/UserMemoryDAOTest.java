package daousers;

import junit.framework.TestCase;

/**
 *
 * @author alumne
 */
public class UserMemoryDAOTest extends TestCase {
    
    UserManagerDAOInterface userDAO;
    
    public UserMemoryDAOTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        userDAO = new UserManagerDAOMemory();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    
    public void testLoginExistingUser() {
        // Esperamos que el login sea true.
        boolean resEsperat = true;
        boolean resReal = userDAO.login("pga","123456");
        assertEquals(resEsperat, resReal);
    }
    
    public void testLoginNonExistingUser() {
        // Esperamos que el login sea false.
        boolean resEsperat = false;
        boolean resReal = userDAO.login("new","1234");
        assertEquals(resEsperat, resReal);
    }
}
