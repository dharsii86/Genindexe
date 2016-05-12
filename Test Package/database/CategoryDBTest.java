package database;

import nf.SpecieCategory;
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
public class CategoryDBTest {

    public CategoryDBTest() {
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
     * Test of addCategory method, of class CustomerDB. Test the insertion of
     * the customers.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCustomer");

        // Creation of a SpecieCategory instance
        SpecieCategory newCat = new SpecieCategory("Bidule");

        // Number of category before insertion
        int resBefore = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from category"));
        //System.out.println(resAvant);

        // Creation of a CustomerDB instance
        CategoryDB instance = new CategoryDB();
        // Insertion of the customer
        instance.addCategory(newCat);

        // Number of customer after insertion
        int resAfter = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from category"));
        //System.out.println(resApres);

        if (resAfter == resBefore) {
            fail("Customer not added.");
        }
    }

    /**
     * Test of addCategory method, of class CategoryDB. Test the insertion of
     * duplicates.
     */
    @Test
    public void testAddCategoryDuplicates() {
        System.out.println("addCategoryDuplicates");

        // Creation of two customers with the same name and the same town
        SpecieCategory newCat1 = new SpecieCategory("Bird");
        SpecieCategory newCat2 = new SpecieCategory("BIRD");

        // Creation of a CustomerDB instance
        CategoryDB instance = new CategoryDB();
        // Insertion of the customers
        instance.addCategory(newCat1);
        instance.addCategory(newCat2);

        // Research of duplicates
        ConnectionDB cDB = new ConnectionDB();
        ResultSet res = cDB.request("select * from category");

        int cpt = 0;

        try {
            while (res.next()) {

                if (res.getString("Category_Name").equalsIgnoreCase(newCat1.getName())) {
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
