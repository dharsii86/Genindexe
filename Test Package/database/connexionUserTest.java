/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicolas
 */
public class connexionUserTest {
    
    public connexionUserTest() {
    }

    /**
     * Test of checkMDP method, of class connexionUser.
     */
    @Test
    public void testCheckMDP() {
        ConnectionDB.requestInsert("DELETE FROM `user` WHERE `User_Login` = 'X' AND `User_Mail` = 'X' AND `User_Name` = 'X' AND `User_LastName` = 'X' AND `User_Password` = 'X' AND `Status_Name` = 'Secretary' ");
        ConnectionDB.requestInsert("INSERT INTO `user` VALUES ('X','X','X','X','X','Secretary')");
        boolean result = connexionUser.checkMDP("X","X");
        if (result == false){
            fail("Right name and password doesn't permit to access the session!");
        }
        result = connexionUser.checkMDP("", "");
        if (result == true){
            fail("Null name and location allows to access the session!");
        }
        result = connexionUser.checkMDP("$&$%", "$&$%");
        if (result == true){
            fail("Wrong user name and password allows to access the session!");
        }
    }
    
}
