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
        ConnectionDB.requestInsert("insert into `order`(`Order_Status`, `Analysis_Name`, `Customer_Login`) values ('Standby','Sexing','GPhyPoitiers')");
        ConnectionDB.requestInsert("insert into `order`(`Order_Status`, `Analysis_Name`, `Customer_Login`) values ('Standby','Scrapie','SNCFFrance')");
        ConnectionDB.requestInsert("insert into `order`(`Order_Status`, `Analysis_Name`, `Customer_Login`) values ('Standby','Sexing','SNCFFrance')");
        ArrayList expResult = ConnectionDB.requestStatic("select Order_Id from `order` where (Customer_Login = '"+Customer_Login+"');");
        ArrayList result = instance.getOrderList(Customer_Login);
        if(expResult == null || result == null || !expResult.equals(result)){
            fail("The Function is false.");
        }
    }

    /**
     * Test of getAnalysisName method, of class ExploreOrder.
     */
    @Test
    public void testGetAnalysisName() {
        System.out.println("getAnalysisName");
        int OrderID = 1;
        ExploreOrder instance = new ExploreOrder();
        String expResult = ConnectionDB.requestOneResult("select `Analysis_Name` from `order` where (`Order_Id`="+OrderID+")");
        String result = instance.getAnalysisName(OrderID);
        if(expResult == null || result == null || !expResult.equals(result)){
            fail("The Function is false.");
        }
    }

    /**
     * Test of getOrderStatus method, of class ExploreOrder.
     */
    @Test
    public void testGetOrderStatus() {
        System.out.println("getOrderStatus");
        int OrderID = 1;
        ExploreOrder instance = new ExploreOrder();
        String expResult = ConnectionDB.requestOneResult("select `Order_Status` from `order` where (`Order_Id`="+OrderID+")");
        String result = instance.getOrderStatus(OrderID);
        if(expResult == null || result == null || !expResult.equals(result)){
            fail("The Function is false.");
        }

    }

    /**
     * Test of getTotalAnalysis method, of class ExploreOrder.
     */
    @Test
    public void testGetTotalAnalysis() {
        System.out.println("getTotalAnalysis");
        int OrderID = 1;
        ExploreOrder instance = new ExploreOrder();
        int expResult = Integer.parseInt(ConnectionDB.requestOneResult("SELECT count(*) FROM `sample` WHERE (`Order_Id`="+OrderID+")"));
        int result = instance.getTotalAnalysis(OrderID);
        if(expResult != result){
            fail("The Function is false.");
        }
    }

    /**
     * Test of getAnalysisDone method, of class ExploreOrder.
     */
    @Test
    public void testGetAnalysisDone() {
        System.out.println("getAnalysisDone");
        int OrderID = 1;
        ExploreOrder instance = new ExploreOrder();
        int expResult = Integer.parseInt(ConnectionDB.requestOneResult("SELECT count(*) FROM `order` WHERE (`Order_Status`='Done' AND `Order_Id`="+OrderID+");"));
        int result = instance.getAnalysisDone(OrderID);
        if(expResult != result){
            fail("The Function is false.");
        }
    }

}
