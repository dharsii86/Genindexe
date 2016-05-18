package database;

import java.util.ArrayList;
import java.util.HashMap;
import nf.Customer;
import nf.Order;
import nf.OrderStatus;

/**
 * This class contain the functions to manage orders. The goal is to manage the
 * interface of inputs and outputs.
 *
 * @author SCRUM Group 2.
 */
public class OrderDB {

    /**
     * Return the orders in an HashMap of one customer.
     *
     * @param cust, the cust to retrieve the orders from.
     * @return the HashMap containing the orders.
     */
    public static HashMap getOrder(Customer cust) {
        HashMap<Integer, Order> resultat = new HashMap<>();

        String custId = cust.getName() + cust.getTown();
        ArrayList<ArrayList> res = ConnectionDB.requestStatic("select `Order_Id`, `Order_Status`, `Analysis_Name`, `Customer_Login` from `order`");

        for (ArrayList<String> res2 : res) {
            Order ord = new Order(cust);
            ord.setStatus(OrderStatus.valueOf(res2.get(1)));
            cust.addOrder(ord);
            resultat.put(Integer.parseInt(res2.get(0)), ord);

        }
        return resultat;
    }

    /**
     * Format the results from request containg a string column. The results
     * from requestStatic are ArrayList of ArrayList (two dimensional). It
     * extract the values using a for loop and tmp variables.
     *
     * @param arrayResult, the ArrayList to convert in a String[].
     * @return the String array containing the results.
     */
    public static String[] formatResult(ArrayList<ArrayList> arrayResult) {

        // Temporary arraylist, make it easier to extract results from request
        ArrayList<String> tmp = new ArrayList();

        for (ArrayList<String> al : arrayResult) {
            // Here we get only one row, which is located at[0]
            tmp.add(al.get(0));
        }
        // Initialisation of the String array and conversion of the results
        String[] result = new String[tmp.size()];
        result = tmp.toArray(result);

        return (result);
    }

}
