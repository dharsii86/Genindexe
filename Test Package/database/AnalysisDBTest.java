/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import nf.Analysis;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicolas
 */
public class AnalysisDBTest {
    
    public AnalysisDBTest() {
    }

    /**
     * Test of addAnalysis method, of class AnalysisDB.
     */
    @Test
    public void testAddAnalysis() {
        ConnectionDB.requestInsert("insert into category values('Truc')");
        ConnectionDB.requestInsert("insert into specie values('Lala','Truc')");
        //Analysis priseSang = new Analysis();
        //boolean resultat = AnalysisDB.addAnalysis(priseSang);
    }

    /**
     * Test of checkAnalysisDuplicates method, of class AnalysisDB.
     */
    @Test
    public void testCheckAnalysisDuplicates() {
        System.out.println("checkAnalysisDuplicates");
        Analysis ana = null;
        boolean expResult = false;
        boolean result = AnalysisDB.checkAnalysisDuplicates(ana);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnalysis method, of class AnalysisDB.
     */
    @Test
    public void testGetAnalysis_String() {
        System.out.println("getAnalysis");
        String species = "";
        String[] expResult = null;
        String[] result = AnalysisDB.getAnalysis(species);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnalysis method, of class AnalysisDB.
     */
    @Test
    public void testGetAnalysis_0args() {
        System.out.println("getAnalysis");
        String[] expResult = null;
        String[] result = AnalysisDB.getAnalysis();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formatResult method, of class AnalysisDB.
     */
    @Test
    public void testFormatResult() {
        System.out.println("formatResult");
        ArrayList<ArrayList> arrayResult = null;
        String[] expResult = null;
        String[] result = AnalysisDB.formatResult(arrayResult);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
