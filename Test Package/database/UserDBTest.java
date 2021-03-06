/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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
 * @author thoma
 */
public class UserDBTest {

    public UserDBTest() {
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
     * Test of addUser method, of class UserDB. Test the insertion of the users.
     */
    @Test
    public void testAddUser() {

        System.out.println("addUser");

        // Number of users before insertion
        int resBefore = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from User"));
        System.out.println(resBefore);

        // Insertion of a user
        UserDB.addUser("jm", "123", "jm@gmail.com", "Jean-Michel", "Bidule", "Secretaire");

        // Number of users after insertion
        int resAfter = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from User"));
        System.out.println(resAfter);

        if (resAfter == resBefore) {
            fail("User not added.");
        }
    }

    /**
     * Test of addUser method, of class UserDB. Test the insertion of
     * duplicates.
     */
    @Test
    public void testAddUserDuplicates() {

        System.out.println("addUserDuplicates");

        // Insertion of users
        UserDB.addUser("ac", "123", "ac@gmail.com", "Artie", "Cho", "Secretaire");
        UserDB.addUser("AC", "123", "ac@gmail.com", "Artie", "Cho", "Secretaire");

        // Research of duplicates
        ConnectionDB cDB = new ConnectionDB();
        ResultSet res = cDB.request("select * from User");

        int cpt = 0;

        try {
            while (res.next()) {

                if (res.getString("User_Login").equalsIgnoreCase("ac")) {
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
     * Test of checkUserConnection method, of class UserDB. Test if the method
     * retrieve the status correctly.
     */
    @Test
    public void testCheckUserConnection() {

        System.out.println("checkUserConnection");

        // Insertion of a user
        UserDB.addUser("al", "123", "al@gmail.com", "Arthur", "Leroy", "Secretaire");

        String status = UserDB.checkUserConnection("al", "123");

        if (!status.equalsIgnoreCase("secretaire")) {
            fail("Satus not retrieved.");
        }
    }
}
