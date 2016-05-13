package database;

import nf.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Manage the test of the CustomerDB class.
 *
 * @author SCRUM Group 2.
 */
public class CustomerDBTest {

    public CustomerDBTest() {
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
     * Test of addCustomer method, of class CustomerDB. Test the insertion of
     * the customers.
     */
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");

        // Creation of a Customer instance
        Customer newCustomer = new Customer("Bidule", "London");

        // Number of customer before insertion
        int resBefore = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from customer"));
        //System.out.println(resAvant);

        // Insertion of the customer
        CustomerDB.addCustomer(newCustomer);

        // Number of customer after insertion
        int resAfter = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from customer"));
        //System.out.println(resApres);

        if (resAfter == resBefore) {
            fail("Customer not added.");
        }
    }

    /**
     * Test of addCustomer method, of class CustomerDB. Test the insertion of
     * duplicates.
     */
    @Test
    public void testAddCustomerDuplicates() {
        System.out.println("addCustomerDuplicates");

        // Creation of two customers with the same name and the same town
        Customer newCustomer1 = new Customer("Parrots Academy", "London");
        Customer newCustomer2 = new Customer("PARROTS ACADEMY", "London");

        // Insertion of the customers
        CustomerDB.addCustomer(newCustomer1);
        CustomerDB.addCustomer(newCustomer2);

        // Research of duplicates
        ConnectionDB cDB = new ConnectionDB();
        ResultSet res = cDB.request("select * from customer");

        int cpt = 0;

        try {
            while (res.next()) {

                if (res.getString("Customer_Name").equalsIgnoreCase(newCustomer1.getName())
                        && res.getString("Customer_Town").equalsIgnoreCase(newCustomer1.getTown())) {
                    cpt++;
                }
            }
        } catch (SQLException ex) {
        }
        cDB.delete();

        if (cpt > 1) {
            fail("Duplicates allowed.");
        }
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
        String[] listCustomerTown = CustomerDB.getCustomerTown();
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
        String[] listCustomer = CustomerDB.getCustomerName("Town");
        //Delete in the database inforamtion used for the test
        ConnectionDB.requestInsert("delete from customer where Customer_Name = 'Machin' or Customer_Name = 'Truc' or Customer_Name = 'Bidule'");
        //Test the results
        if (listCustomer.length != 2){
            fail("The function getCustomerTown() doesn't return the good results!");
        }
    }
}
