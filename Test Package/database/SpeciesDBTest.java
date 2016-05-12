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
- check that the species is added to the Data Base ok
- check that the species exist only once in the data base. ok
- check that the species is link to one category in the DB.
- check that the species contain only alphabetics.
- check that the chose category exists.
 */
public class SpeciesDBTest {
    
    public SpeciesDBTest() {
    }

    @Test
    public void testAddSpecie() {
        System.out.println("addSpecie");
        
        // Creation of a Customer instance
        Specie newSpecie = new Specie("Parrot");

        // Number of specie before insertion
        int resBefore = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from specie"));
        //System.out.println(resAvant);

        // Creation of a SpecieDB instance
        SpecieDB instance = new SpecieDB();
        // Insertion of the customer
        instance.addSpecie(newSpecie);

        // Number of Specie after insertion
        int resAfter = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from specy"));
        //System.out.println(resApres);

        if (resAfter == resBefore) {
            fail("Specie not added.");
        }
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        
        
    }
    public void testAddSpecieDuplicates() {
        System.out.println("addSpecieDuplicates");

        // Creation of two customers with the same name and the same town
        Specie newSpecie1 = new Specie("Parrot");
        Specie newSpecie2 = new Specie("parrot");

        // Creation of a SpecieDB instance
        SpecieDB instance = new SpecieDB();
        // Insertion of the customers
        instance.addSpecie(newSpecie1);
        instance.addSpecie(newSpecie2);

        // Research of duplicates
        ConnectionDB cDB = new ConnectionDB();
        ResultSet res = cDB.request("select * from specie");

        int cpt = 0;

        try {
            while (res.next()) {

                if (res.getString("Specie_Name").equalsIgnoreCase(newSpecie1.getName())
                        && res.getString("Specie_Town").equalsIgnoreCase(newSpecie1.getTown())) {
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
