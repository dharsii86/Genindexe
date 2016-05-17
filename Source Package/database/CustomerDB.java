package database;

import static database.OrderDB.formatResult;
import java.security.SecureRandom;
import java.util.Random;
import java.util.ArrayList;
import nf.Customer;

/**
 *
 * @author thomas
 */
public class CustomerDB {
    private static final Random RANDOM = new SecureRandom();
    /**
     * CustomerDB class constructor.
     */
    public CustomerDB() {
    }
    
    /**
     * Return a password that contains alpha numerics character
     * @return a password
     */
    private static String createPassword(){
        char[] symbol = "abcdefghijklmnopqrstuvwxyzAZERTYUIOPQSDFGHJKLMWXCVBN0123456789".toCharArray();
        String res = "";
        for (int i = 0; i < 10; i++){
            int index = (int)(RANDOM.nextDouble()*symbol.length);
            res = res+symbol[index];
        }
        return res;
    }
    

    /**
     * Add a customer in the database.
     *
     * @param cust, the customer to add.
     * @return true if the customer is added aand false if not.
     */
    public static boolean addCustomer(Customer cust) {

        if (CustomerDB.checkCustomerDuplicates(cust)) {

            String log = cust.getName() + cust.getTown();
            String pass = CustomerDB.createPassword();
            ConnectionDB.requestInsert("insert into `customer` (`Customer_Login`, `Customer_Name`, `Customer_Town`, `Customer_Password`) values ('" + log + "', '" + cust.getName() + "', '" + cust.getTown() + "', '" + pass + "')");
            //System.out.println("The customer has been added to the database");
            return true;
        }
        //System.out.println("This customer already exist in the database");
        return false;
    }

    /**
     * Check if the customer has a duplicate in the database.
     *
     * @param cust, the customer to add.
     * @return true if there is duplicate and false if not.
     */
    public static boolean checkCustomerDuplicates(Customer cust) {

        if (cust.getName() != null && cust.getTown() != null) {

            String n = cust.getName().toUpperCase();
            String t = cust.getTown().toUpperCase();

            int resultat = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from customer where customer_name = '" + n + "' and customer_town = '" + t + "'"));

            switch (resultat) {
                case 0:
                    return true;
                default:
                    return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Get the list of customers living places in the database, in order to list
     * them on the interface.
     *
     * @return ArrayList of string containing the available customers
     */
    public static String[] getCustomerTown() {
        String req = "SELECT customer_town from customer group by customer_town";
        ArrayList<ArrayList> arrayResult; // creating the result ArrayList
        arrayResult = ConnectionDB.requestStatic(req);

        String[] result = formatResult(arrayResult);

        return (result);
    }

    /**
     * Get the list of the customer that live in a defined town
     *
     * @param town The town (as a string) where the customers lives
     * @return An arraylist of customer living in this town.
     */
    public static String[] getCustomerName(String town) {
        String req = "SELECT customer_name from customer WHERE customer_town ='" + town + "'";
        ArrayList<ArrayList> arrayResult; // creating the result ArrayList
        arrayResult = ConnectionDB.requestStatic(req);

        String[] result = formatResult(arrayResult);

        return (result);
    }

    /**
     * Check if the user can connect.
     *
     * @param login, the login of the user to check.
     * @param password, the password of the user to check.
     * @return true if the customer can connect and false if not.
     */
    public static boolean checkCustomerConnection(String login, String password) {

        if (login != null && password != null) {

            String log = login.toUpperCase();
            String pass = password.toUpperCase();

           int result = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from `customer` where `Customer_Login` = '" + log + "' "
                        + "and `Customer_Password` = '" + pass + "'"));
            if (result == 1) {
                return true;
            }
        }
        return false;
    }
}