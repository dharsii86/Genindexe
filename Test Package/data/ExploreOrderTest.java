/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import database.ConnectionDB;
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
        String Customer_Login = "GphyPoitiers";
        ExploreOrder instance = new ExploreOrder();
        ConnectionDB.requestInsert("insert into order values ('',Standby','Sexing','GphyPoitiers')");
        ConnectionDB.requestInsert("insert into order values ('',Standby','Scrapie','SNCFFrance')");
        ConnectionDB.requestInsert("insert into order values ('',Standby','Sexing','SNCFFrance')");
        ArrayList expResult = ConnectionDB.requestStatic("select Order_Id from `order` where (Customer_Login = '"+Customer_Login+"');");
        ArrayList result = instance.getOrderList(Customer_Login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The customer is not correctly found.");
    }

    /**
     * Test of getAnalysisName method, of class ExploreOrder.
     */
    @Test
    public void testGetAnalysisName() {
        System.out.println("getAnalysisName");
        String OrderID = "1";
        ExploreOrder instance = new ExploreOrder();
        String expResult = ConnectionDB.requestOneResult("select `Analysis_Name` from `order` where (`Order_Id`='"+OrderID+"')");
        String result = instance.getAnalysisName(OrderID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The Function is false.");
    }

    /**
     * Test of getOrderStatus method, of class ExploreOrder.
     */
    @Test
    public void testGetOrderStatus() {
        System.out.println("getOrderStatus");
        String OrderID = "1";
        ExploreOrder instance = new ExploreOrder();
        String expResult = ConnectionDB.requestOneResult("select `Order_Status` from `order` where (`Order_Id`='"+OrderID+"')");
        String result = instance.getOrderStatus(OrderID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The Function is false.");
    }

    /**
     * Test of getTotalAnalysis method, of class ExploreOrder.
     */
    @Test
    public void testGetTotalAnalysis() {
        System.out.println("getTotalAnalysis");
        String OrderID = "1";
        ExploreOrder instance = new ExploreOrder();
        int expResult = Integer.parseInt(ConnectionDB.requestOneResult("SELECT count(*) FROM `order` WHERE (`Order_Status`='Done';"));
        int result = instance.getTotalAnalysis(OrderID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The Function is false.");
    }

    /**
     * Test of getAnalysisDone method, of class ExploreOrder.
     */
    @Test
    public void testGetAnalysisDone() {
        System.out.println("getAnalysisDone");
        String OrderID = "";
        ExploreOrder instance = new ExploreOrder();
        int expResult = Integer.parseInt(ConnectionDB.requestOneResult("SELECT count(*) FROM `order` WHERE (`Order_Status`='Done' AND `Order_Id`='"+OrderID+"');"));
        int result = instance.getAnalysisDone(OrderID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The Function is false.");
    }
    
}
