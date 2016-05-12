package screen;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thoma
 */
public class SpecieInputTest {
    
    public SpecieInputTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of specieInputContol method, of class SpecieInput.
     */
    @Test
    public void testSpecieInputContol() {
        System.out.println("specieInputContol");
        
        String speName = "xy8lel9la fast5idiosa";
        String expResult = "Xylella fastidiosa";
        
        String result = SpecieInput.specieInputContol(speName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
