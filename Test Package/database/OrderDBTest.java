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
        //Delete in the database information which can hinder the test
        ConnectionDB.requestInsert("delete from customer where Customer_Name = 'Machin' or Customer_Name = 'Truc' or Customer_Name = 'Bidule' or Customer_Name = 'What'");
        //Insert in the database information needed for the test
        ConnectionDB.requestInsert("insert into customer (Customer_Name,Customer_Town) values('Machin','What')");
        ConnectionDB.requestInsert("insert into customer (Customer_Name,Customer_Town) values('Machin','Town')");
        ConnectionDB.requestInsert("insert into customer (Customer_Name,Customer_Town) values('Truc','Town')");
        ConnectionDB.requestInsert("insert into customer (Customer_Name,Customer_Town) values('Bidule','Nope')");
        //Try the tested method and collect results
        String[] listCustomerTown = OrderDB.getCustomerTown();
        //Delete in the database inforamtion used for the test
        ConnectionDB.requestInsert("delete from customer where Customer_Name = 'Machin' or Customer_Name = 'Truc' or Customer_Name = 'Bidule' or Customer_Name = 'What'");
        //Test the results
        if (listCustomerTown.length != 3){
            fail("The function getCustomerTown() doesn't return the good results!");
        }
    }

    /**
     * Test of getCustomerName method, of class OrderDB.
     */
    @Test
    public void testGetCustomerName() {
        //Delete in the database information which can hinder the test
        ConnectionDB.requestInsert("delete from customer where Customer_Name = 'Machin' or Customer_Name = 'Truc' or Customer_Name = 'Bidule'");
        //Insert in the database information needed for the test
        ConnectionDB.requestInsert("insert into customer (Customer_Name,Customer_Town) values('Machin','Town')");
        ConnectionDB.requestInsert("insert into customer (Customer_Name,Customer_Town) values('Truc','Town')");
        ConnectionDB.requestInsert("insert into customer (Customer_Name,Customer_Town) values('Bidule','Nope')");
        //Try the tested method and collect results
        String[] listCustomer = OrderDB.getCustomerName("Town");
        //Delete in the database inforamtion used for the test
        ConnectionDB.requestInsert("delete from customer where Customer_Name = 'Machin' or Customer_Name = 'Truc' or Customer_Name = 'Bidule'");
        //Test the results
        if (listCustomer.length != 2){
            fail("The function getCustomerTown() doesn't return the good results!");
        }
    }

    /**
     * Test of getCategory method, of class OrderDB.
     */
    @Test
    public void testGetCategory() {
        //Delete in the database information which can hinder the test
        ConnectionDB.requestInsert("delete from category where Category_Name = 'Machin' or Category_Name = 'Truc' or Category_Name = 'Bidule'");
        //Insert in the database information needed for the test
        ConnectionDB.requestInsert("insert into category values ('Machin')");
        ConnectionDB.requestInsert("insert into category values ('Truc')");
        ConnectionDB.requestInsert("insert into category values ('Bidule')");
        //Try the tested method and collect results
        String[] listCategory = OrderDB.getCategory();
        //Delete in the database inforamtion used for the test
        ConnectionDB.requestInsert("delete from category where Category_Name = 'Machin' or Category_Name = 'Truc' or Category_Name = 'Bidule'");
        //Test the results
        if (listCategory.length != 3){
            fail("The function getCategory() doesn't return the good results!");
        }
    }

    /**
     * Test of getSpecies method, of class OrderDB.
     */
    @Test
    public void testGetSpecies() {
        //Delete in the database information which can hinder the test
        ConnectionDB.requestInsert("delete from specie where Specie_Name = 'Lolo' or Specie_Name = 'Lala' or Specie_Name = 'Machin'");
        ConnectionDB.requestInsert("delete from category where Category_Name = 'Truc' or Category_Name = 'Trac'");
        //Insert in the database information needed for the test
        ConnectionDB.requestInsert("insert into category values('Truc')");
        ConnectionDB.requestInsert("insert into category values('Trac')");
        ConnectionDB.requestInsert("insert into specie values('Lolo','Trac')");
        ConnectionDB.requestInsert("insert into specie values('Lala','Truc')");
        ConnectionDB.requestInsert("insert into specie values('Machin','Truc')");
        //Try the tested method and collect results
        String[] listSpecies = OrderDB.getSpecies("Truc");
        //Delete in the database inforamtion used for the test
        ConnectionDB.requestInsert("delete from specie where Specie_Name = 'Lolo' or Specie_Name = 'Lala' or Specie_Name = 'Machin'");
        ConnectionDB.requestInsert("delete from category where Category_Name = 'Truc' or Category_Name = 'Trac'");
        //Test the results
        if (listSpecies.length != 2){
            fail("The function getSpecies() doesn't return the good results!");
        }
    }

    /**
     * Test of getAnalysis method, of class OrderDB.
     */
    @Test
    public void testGetAnalysis() {
        //Delete in the database information which can hinder the test
        ConnectionDB.requestInsert("delete from relevant where Analysis_Name = 'Lolo' or Analysis_Name = 'Lala' or Analysis_Name = 'Lulu'");
        ConnectionDB.requestInsert("delete from analysis where Analysis_Name = 'Lolo' or Analysis_Name = 'Lala' or Analysis_Name = 'Lulu'");
        ConnectionDB.requestInsert("delete from specie where Specie_Name = 'Truc' or Specie_Name = 'Trac'");
        ConnectionDB.requestInsert("delete from category where Category_Name = 'Machin'");
        //Insert in the database information needed for the test
        ConnectionDB.requestInsert("insert into category values('Machin')");
        ConnectionDB.requestInsert("insert into specie values('Truc','Machin')");
        ConnectionDB.requestInsert("insert into specie values('Trac','Machin')");
        ConnectionDB.requestInsert("insert into analysis values('Lolo')");
        ConnectionDB.requestInsert("insert into relevant values('Truc','Lolo')");
        ConnectionDB.requestInsert("insert into analysis values('Lala')");
        ConnectionDB.requestInsert("insert into relevant values('Truc','Lala')");
        ConnectionDB.requestInsert("insert into analysis values('Lulu')");
        ConnectionDB.requestInsert("insert into relevant values('Trac','Lulu')");
        //Try the tested method and collect results
        String[] listAnalysis = OrderDB.getAnalysis("Truc");
        //Delete in the database inforamtion used for the test
        ConnectionDB.requestInsert("delete from relevant where Analysis_Name = 'Lolo' or Analysis_Name = 'Lala' or Analysis_Name = 'Lulu'");
        ConnectionDB.requestInsert("delete from analysis where Analysis_Name = 'Lolo' or Analysis_Name = 'Lala' or Analysis_Name = 'Lulu'");
        ConnectionDB.requestInsert("delete from specie where Specie_Name = 'Truc' or Specie_Name = 'Trac'");
        ConnectionDB.requestInsert("delete from category where Category_Name = 'Machin'");
        //Test the results
        if (listAnalysis.length != 2){
            fail("The function getAnalysis() doesn't return the good results!");
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
