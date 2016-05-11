package database;

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
    public boolean addCustomer(Customer cust) {

        if (this.checkCustomerDuplicates(cust)) {

            ConnectionDB.requestInsert("insert into `customer` (`Cust_companyName`, `Cust_town`) values ('" + cust.getName() + "','" + cust.getTown() + "')");
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
    public boolean checkCustomerDuplicates(Customer cust) {

        if (cust.getName() != null && cust.getTown() != null) {

            String n = cust.getName().toUpperCase();
            String t = cust.getTown().toUpperCase();

            int resultat = Integer.parseInt(ConnectionDB.requestOneResult("select count(*) from customer where Cust_companyName = '" + n + "' and Cust_town = '" + t + "'"));

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
}
