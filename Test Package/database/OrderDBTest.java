/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.HashMap;
import data.CreateData;
import data.CustomerList;
import nf.Order;
import nf.Customer;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicolas
 */
public class OrderDBTest {
    
    public OrderDBTest() {
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
     * Test of getGetOrder method, of class OrderDB.
     */
    @Test
    public void testGetOrder() {
        ConnectionDB.requestInsert("DELETE FROM `order` WHERE `Customer_Login` = 'XX' OR `Customer_Login` = 'YY'");
        ConnectionDB.requestInsert("DELETE FROM `customer` WHERE `Customer_Login` = 'XX' OR `Customer_Login` = 'YY'");
        ConnectionDB.requestInsert("INSERT INTO `customer` (`Customer_Login`, `Customer_Name`, `Customer_Town`, `Customer_Password`) values ('XX','X','X','X')");
        ConnectionDB.requestInsert("INSERT INTO `customer` (`Customer_Login`, `Customer_Name`, `Customer_Town`, `Customer_Password`) values ('YY','Y','Y','Y')");
        ConnectionDB.requestInsert("INSERT INTO `order` (`Order_Date`, `Order_Status`, `Analysis_Name`, `Customer_Login`) values ('2016-01-01','completed','Sexing','X')");
        ConnectionDB.requestInsert("INSERT INTO `order` (`Order_Date`, `Order_Status`, `Analysis_Name`, `Customer_Login`) values ('2016-01-04','completed','Scrapie','Y')");
        ConnectionDB.requestInsert("INSERT INTO `order` (`Order_Date`, `Order_Status`, `Analysis_Name`, `Customer_Login`) values ('2016-01-16','toAnalyze','Scrapie','X')");
        ConnectionDB.requestInsert("INSERT INTO `order` (`Order_Date`, `Order_Status`, `Analysis_Name`, `Customer_Login`) values ('2016-02-13','inProgress','Sexing','X')");
        
        HashMap<Integer, Order> orderList = OrderDB.getOrder(new Customer("X","X"));
        ConnectionDB.requestInsert("DELETE FROM `order` WHERE `Customer_Login` = 'XX' OR `Customer_Login` = 'YY'");
        ConnectionDB.requestInsert("DELETE FROM `customer` WHERE `Customer_Login` = 'XX' OR `Customer_Login` = 'YY'");
        if (orderList.size() != 3 ){
            fail("The function getOrder doesn't all the good results");
        }
    }

    /**
     * Test of formatResult method, of class OrderDB.
     */
    @Test
    public void testFormatResult() {
        //Creation of three Arraylist of one element
        ArrayList list1 = new ArrayList();
        list1.add("Machin");
        ArrayList list2 = new ArrayList();
        list2.add("Truc");
        ArrayList list3 = new ArrayList();
        list3.add("Bidule");
        //Creation of an ArrayList listGlobal which contains the three previous ArrayList for the test
        //This listGlobal is in the format received by the tested method
        ArrayList listGlobal = new ArrayList();
        listGlobal.add(list1);
        listGlobal.add(list2);
        listGlobal.add(list3);
        //Method test
        try{
            String[] listResult = OrderDB.formatResult(listGlobal);
            if (!listResult[0].equals("Machin") && !listResult[1].equals("Truc") && !listResult[2].equals("Bidule")){
                fail("the function formatResult() doesn't contain expected values!");
            }
        } catch (Exception ex){
            fail("the function formatResult() doesn't create StringArray!");
        }
    }
    
}

