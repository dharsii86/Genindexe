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
}
