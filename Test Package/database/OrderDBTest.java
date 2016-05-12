/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import nf.Order;
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
     * Test of getCustomerTown method, of class OrderDB.
     */
    @Test
    public void testGetCustomerTown() {
        ConnectionDB.requestInsert("delete from customer where Customer_Name = 'Machin' or Customer_Name = 'Truc' or Customer_Name = 'Bidule'");
        ConnectionDB.requestInsert("insert into customer (Customer_Name,Customer_Town) values('Machin','Town')");
        ConnectionDB.requestInsert("insert into customer (Customer_Name,Customer_Town) values('Truc','Town')");
        ConnectionDB.requestInsert("insert into customer (Customer_Name,Customer_Town) values('Bidule','Nope')");
        String[] listCustomerTown = OrderDB.getCustomerTown();
        ConnectionDB.requestInsert("delete from customer where Customer_Name = 'Machin' or Customer_Name = 'Truc' or Customer_Name = 'Bidule'");
        if (listCustomerTown.length != 2){
            fail("The function getCustomerTown() doesn't return the good results!");
        }
    }

    /**
     * Test of getCustomerName method, of class OrderDB.
     */
    @Test
    public void testGetCustomerName() {
        ConnectionDB.requestInsert("delete from customer where Customer_Name = 'Machin' or Customer_Name = 'Truc' or Customer_Name = 'Bidule'");
        ConnectionDB.requestInsert("insert into customer (Customer_Name,Customer_Town) values('Machin','Town')");
        ConnectionDB.requestInsert("insert into customer (Customer_Name,Customer_Town) values('Truc','Town')");
        ConnectionDB.requestInsert("insert into customer (Customer_Name,Customer_Town) values('Bidule','Nope')");
        String[] listCustomer = OrderDB.getCustomerName("Town");
        ConnectionDB.requestInsert("delete from customer where Customer_Name = 'Machin' or Customer_Name = 'Truc' or Customer_Name = 'Bidule'");
        if (listCustomer.length != 2){
            fail("The function getCustomerTown() doesn't return the good results!");
        }
    }

    /**
     * Test of getCategory method, of class OrderDB.
     */
    @Test
    public void testGetCategory() {
        ConnectionDB.requestInsert("delete from category where Category_Name = 'Machin' or Category_Name = 'Truc' or Category_Name = 'Bidule'");
        ConnectionDB.requestInsert("insert into category values ('Machin')");
        ConnectionDB.requestInsert("insert into category values ('Truc')");
        ConnectionDB.requestInsert("insert into category values ('Bidule')");
        String[] listCategory = OrderDB.getCategory();
        ConnectionDB.requestInsert("delete from category where Category_Name = 'Machin' or Category_Name = 'Truc' or Category_Name = 'Bidule'");
        if (listCategory.length != 3){
            fail("The function getCategory() doesn't return the good results!");
        }
    }

    /**
     * Test of getSpecies method, of class OrderDB.
     */
    @Test
    public void testGetSpecies() {
        ConnectionDB.requestInsert("delete from specie where Specie_Name = 'Lolo' or Specie_Name = 'Lala' or Specie_Name = 'Machin'");
        ConnectionDB.requestInsert("delete from category where Category_Name = 'Truc'");
        ConnectionDB.requestInsert("insert into category values('Truc')");
        ConnectionDB.requestInsert("insert into specie values('Lolo','Truc')");
        ConnectionDB.requestInsert("insert into specie values('Lala','Truc')");
        ConnectionDB.requestInsert("insert into specie values('Machin','Truc')");
        String[] listSpecies = OrderDB.getSpecies("Truc");
        ConnectionDB.requestInsert("delete from specie where Specie_Name = 'Lolo' or Specie_Name = 'Lala' or Specie_Name = 'Machin'");
        ConnectionDB.requestInsert("delete from category where Category_Name = 'Truc'");
        if (listSpecies.length != 3){
            fail("The function getSpecies() doesn't return the good results!");
        }
    }

    /**
     * Test of getAnalysis method, of class OrderDB.
     */
    @Test
    public void testGetAnalysis() {
        ConnectionDB.requestInsert("delete from relevant where Analysis_Name = 'Lolo' or Analysis_Name = 'Lala'");
        ConnectionDB.requestInsert("delete from analysis where Analysis_Name = 'Lolo' or Analysis_Name = 'Lala'");
        ConnectionDB.requestInsert("delete from specie where Specie_Name = 'Truc'");
        ConnectionDB.requestInsert("delete from category where Category_Name = 'Machin'");
        ConnectionDB.requestInsert("insert into category values('Machin')");
        ConnectionDB.requestInsert("insert into specie values('Truc','Machin')");
        ConnectionDB.requestInsert("insert into analysis values('Lolo')");
        ConnectionDB.requestInsert("insert into relevant values('Truc','Lolo')");
        ConnectionDB.requestInsert("insert into analysis values('Lala')");
        ConnectionDB.requestInsert("insert into relevant values('Truc','Lala')");
        String[] listAnalysis = OrderDB.getAnalysis("Truc");
        ConnectionDB.requestInsert("delete from relevant where Analysis_Name = 'Lolo' or Analysis_Name = 'Lala'");
        ConnectionDB.requestInsert("delete from analysis where Analysis_Name = 'Lolo' or Analysis_Name = 'Lala'");
        ConnectionDB.requestInsert("delete from specie where Specie_Name = 'Truc'");
        ConnectionDB.requestInsert("delete from category where Category_Name = 'Machin'");
        if (listAnalysis.length != 2){
            fail("The function getAnalysis() doesn't return the good results!");
        }
    }

    /**
     * Test of formatResult method, of class OrderDB.
     */
    @Test
    public void testFormatResult() {
        ArrayList list1 = new ArrayList();
        list1.add("Machin");
        ArrayList list2 = new ArrayList();
        list2.add("Truc");
        ArrayList list3 = new ArrayList();
        list3.add("Bidule");
        ArrayList listGlobal = new ArrayList();
        listGlobal.add(list1);
        listGlobal.add(list2);
        listGlobal.add(list3);
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
