package database;

import nf.Specie;
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
 *
 * @author JCGx test planed: - check that the species is added to the Data Base.
 * ok - check that the species exist only once in the data base. ok - check that
 * the name field is fill.ok - check that the species contain only alphabetics.
 * - check that the chose category exists.
 */
public class SpecieDBTest {

    public static void CustomerDBTest() {
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

    public SpecieDBTest() {
    }

    @Test
    /**
     * Check that the species is added to the database
     */
    public void testAddSpecie() {

        System.out.println("addSpecie");

        // Creation of a category instance
        SpecieCategory newCat = new SpecieCategory("Bird");

        // Creation of a specie instance
        Specie newSpe = new Specie("Parrot");

        // Number of species before insertion
        int resBefore = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from specie"));
        //System.out.println(resAvant);

        // Insertion of the specie and category
        CategoryDB.addCategory(newCat);
        SpecieDB.addSpecie(newSpe, newCat);

        // Number of species after insertion
        int resAfter = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from specie"));
        //System.out.println(resApres);

        if (resAfter == resBefore) {
            fail("Specie not added.");
        }
    }

    @Test
    /**
     * Check that the specie exist only once in the database
     */
    public void testAddSpecieDuplicates() {

        System.out.println("addSpecieDuplicates");

        // Creation of a category instance
        SpecieCategory newCat = new SpecieCategory("Feline");
        CategoryDB.addCategory(newCat);

        // Creation of two species with the same name
        Specie newSpe1 = new Specie("Tiger");
        Specie newSpe2 = new Specie("TIGER");

        // Insertion of the customers
        SpecieDB.addSpecie(newSpe1, newCat);
        SpecieDB.addSpecie(newSpe2, newCat);

        // Research of duplicates
        ConnectionDB cDB = new ConnectionDB();
        ResultSet res = cDB.request("select * from specie");

        int cpt = 0;
        try {
            while (res.next()) {

                if (res.getString("Specie_Name").equalsIgnoreCase(newSpe1.getName())) {
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
