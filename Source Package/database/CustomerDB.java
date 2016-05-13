package database;

import static database.OrderDB.formatResult;
import java.util.ArrayList;
import nf.Customer;

/**
 *
 * @author thomas
 */
public class CustomerDB {

    /**
     * CustomerDB class constructor.
     */
    public CustomerDB() {
    }

    /**
     * Add an customer in the database.
     *
     * @param cust, the customer to add.
     * @return true if the customer is added aand false if not.
     */
    public static boolean addCustomer(Customer cust) {

        if (CustomerDB.checkCustomerDuplicates(cust)) {

            String log = cust.getName() + " " + cust.getTown();
            String pass = "0000";
            ConnectionDB.requestInsert("insert into `Customer` (`Customer_Login`, `Customer_Name`, `Customer_Town`, `Customer_Password`) values ('" + log + "', '" + cust.getName() + "', '" + cust.getTown() + "', '" + pass + "')");
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
     * @return the status if the user can connect and "none" if not.
     */
    public static String checkUserConnection(String login, String password) {

        if (login != null && password != null) {

            String log = login.toUpperCase();
            String pass = password.toUpperCase();

            int result = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from `User` where `User_Login` = '" + login + "'"));
            
            if (result == 1) {

                return ConnectionDB.requestOneResult("select `Status_Name` from `User` where `User_Login` = '" + log + "' "
                        + "and `User_Password` = '" + pass + "'");
            }
        }
        return "none";
    }

}
