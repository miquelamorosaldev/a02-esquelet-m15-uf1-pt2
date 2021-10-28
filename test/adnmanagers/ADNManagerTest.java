package adnmanagers;


import junit.framework.TestCase;

/**
 *
 * @author alumne
 */
public class ADNManagerTest extends TestCase {
    
    ADN_Manager adnManager;
    
    public ADNManagerTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        adnManager = new ADN_Manager();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    
    public void testCorrectADN() {
        // Esperamos que el resultado sea true con una cadena
        // de ADN válida.
        boolean resEsperat = true;
        boolean resReal = adnManager.validarADN("actgcaggattac");
        assertEquals(resEsperat, resReal);
    }
    
    
    public void testCorrectADNLong() {
        // Esperamos que el resultado sea true con una cadena
        // de ADN válida y larga
        // Otra forma similar de hacer el test, en vez 
        // del assertEquals
        assertTrue(
            adnManager.validarADN("actgcaggattacctatggtaaaggttaacctcgtacgtgatgctagctagctagc"));
    }
    
    public void testIncorrectADNLetters() {
        // Esperamos que el login sea false con una cadena de letras
        // que no todas son del ADN
        boolean resEsperat = false;
        boolean resReal = adnManager.validarADN("cgfgcuugatxrta");
        assertEquals(resEsperat, resReal);
    }   
    
    public void testIncorrectADNNumbers() {
        // Esperamos que el login sea false con una cadena de letras
        // y numeros sin mucho sentido.
        // Otra forma similar de hacer el test, en vez 
        // del assertEquals
        assertFalse(
           adnManager.validarADN("a32fgc45534xsalsda"));
    }   
}
