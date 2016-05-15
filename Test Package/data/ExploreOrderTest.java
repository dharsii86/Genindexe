/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author willa
 */
public class ExploreOrderTest {
    
    public ExploreOrderTest() {
    }

    /**
     * Test of getOrderList method, of class ExploreOrder.
     */
    @Test
    public void testGetOrderList() {
        System.out.println("getOrderList");
        String Customer_Login = "";
        ExploreOrder instance = new ExploreOrder();
        ArrayList expResult = null;
        ArrayList result = instance.getOrderList(Customer_Login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnalysisName method, of class ExploreOrder.
     */
    @Test
    public void testGetAnalysisName() {
        System.out.println("getAnalysisName");
        String OrderID = "";
        ExploreOrder instance = new ExploreOrder();
        String expResult = "";
        String result = instance.getAnalysisName(OrderID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderStatus method, of class ExploreOrder.
     */
    @Test
    public void testGetOrderStatus() {
        System.out.println("getOrderStatus");
        String OrderID = "";
        ExploreOrder instance = new ExploreOrder();
        String expResult = "";
        String result = instance.getOrderStatus(OrderID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalAnalysis method, of class ExploreOrder.
     */
    @Test
    public void testGetTotalAnalysis() {
        System.out.println("getTotalAnalysis");
        String OrderID = "";
        ExploreOrder instance = new ExploreOrder();
        int expResult = 0;
        int result = instance.getTotalAnalysis(OrderID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnalysisDone method, of class ExploreOrder.
     */
    @Test
    public void testGetAnalysisDone() {
        System.out.println("getAnalysisDone");
        String OrderID = "";
        ExploreOrder instance = new ExploreOrder();
        int expResult = 0;
        int result = instance.getAnalysisDone(OrderID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
