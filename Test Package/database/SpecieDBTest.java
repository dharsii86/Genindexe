/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import nf.Specie;
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
 * @author JCGx
 * test planed:
- check that the species is added to the Data Base. ok
- check that the species exist only once in the data base. ok
- check that the name field is fill.ok
- check that the species contain only alphabetics.
- check that the chose category exists.
 */
public class SpecieDBTest {
    
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
    
    
    public SpecieDBTest() {
    }

    @Test
    /**
*Test1. : check that the species is added to the Data Base
**/
    public void testAddSpecie() {
        System.out.println("addSpecie");
        
        // Creation of a Customer instance
        Specie newSpecie = new Specie("Parrot");

        // Number of specie before insertion
        int resBefore = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from specie"));
        //System.out.println(resAvant);

        // Insertion of the customer
        SpecieDB.addSpecie(newSpecie);

        // Number of Specie after insertion
        int resAfter = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from specy"));
        //System.out.println(resApres);

        if (resAfter == resBefore) {
            fail("Specie not added.");
        }
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        
        
    }
    /**
*Tes2. :check that the species exist only once in the data base
**/
    public void testAddSpecieDuplicates() {
        System.out.println("addSpecieDuplicates");

        // Creation of two customers with the same name and the same town
        Specie newSpecie1 = new Specie("Parrot");
        Specie newSpecie2 = new Specie("parrot");

        // Creation of a SpecieDB instance
        SpecieDB instance = new SpecieDB();
        // Insertion of the customers
        SpecieDB.addSpecie(newSpecie1);
        SpecieDB.addSpecie(newSpecie2);

        // Research of duplicates
        ConnectionDB cDB = new ConnectionDB();
        ResultSet res = cDB.request("select * from specie");

        int cpt = 0;

        try {
            while (res.next()) {

                if (res.getString("Specie_Name").equalsIgnoreCase(newSpecie1.getName())) 
                {
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
*Test3. :check that the name field is fill
**/
    public void testFilledField() {
        System.out.println("filledField");
        // Creation of a SpecieDB instance
        SpecieDB instance = new SpecieDB();
        int resultat;
        Specie test = new Specie("");
        resultat = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from specie where Specie_Name = ''"));
        if(resultat > 0){
            fail("Creation of a Specie with no name!");
        }
    }
    /**
*Test4. : check that the species contain only alphabetics.
**/
    public void testAlphabeticEntry() {
        System.out.println("filledField");
        // Creation of a SpecieDB instance
        SpecieDB instance = new SpecieDB();
        
        int resultat;
        Specie test = new Specie("");
        resultat = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from specie where Specie_Name = ''"));
        if(resultat > 0){
            fail("Creation of a Specie with wrong name!");
        }       
    }
}