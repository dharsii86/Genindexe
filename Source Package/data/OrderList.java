package data;

import java.util.HashMap;
import nf.Order;

/**
 * This class manage the static list of orders.
 * It is used to access order objects through the whole application.
 * The methods used to access the list are also static.
 * 
 * @author SCRUM Group 2.
 */
public class OrderList {
    // Static Hashmap of order, the key is the order id (in database)
    private static HashMap<Integer,Order> orderList;
    
    /**
     * Initialisation of the Order hashmap.
     */
    public static void launchOrderList(){
        OrderList.orderList = new HashMap<>();
    }
 
     /**
     * Print the categories in the list and their information.
     * This function is used for debug.
     */
    public static void printInfoDebug(){
        System.out.println("List order ");
        for(int k : orderList.keySet()){
            System.out.println("order n° "+k);
        }
    }
    
    /**
     * Insert a new order only in the application
     * 
     * @param cat, the category to insert.
     */
    public static void put(int id,Order ord  ){  
        orderList.put(id, ord);
    }
    
    /**
     * Return the list of order in a HashMap.
     * 
     * @return the HashMap containing the categories.
     */
    public static Order getOrder(int id){
        return orderList.get(id);
    }
   
}
