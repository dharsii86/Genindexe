package data;

import java.util.HashMap;
import java.util.Set;
import database.CustomerDB;
import nf.Customer;

/**
 * This class manage the static list of customer.
 * It is used to access customer objects through the whole application.
 * The methods used to access the list are also static.
 * 
 * @author SCRUM Group 2.
 */
public class CustomerList {
        
    /*This HashMap contains at first a key that correspond to the Town and
      allows to access another HashMap. The other one have for key the name of 
      the customer and allows to access to the customer object.
     */
    private static HashMap<String,HashMap> customerList;
    

    /**
     * Initialise the static list of  customer.
     */
    public static void launchCustomerList(){
        CustomerList.customerList = new HashMap<>();
    }
    
    /**
     * Insert a new customer to the application and into the database
     * 
     * @param cust The customer object to add
     * @return Insertion result (success / fail )
     */
    public static boolean add(Customer cust){
        String name = cust.getName();
        String town =  cust.getTown();
        
        if(CustomerDB.addCustomer(cust)){
            printInfoDebug();
            // if the town exist
            if(customerList.get(town)!=null){
                HashMap nameMap = customerList.get(town);
                // If the customer name do not already exist in the list
                if(nameMap.get(name)==null){
                    nameMap.put(name,cust);
                }
            }
            // If this is a new town
            else{
                HashMap<String,Customer> nameMap = new HashMap<>();
                nameMap.put(name,cust);
                customerList.put(town, nameMap);
            }
            
            printInfoDebug();
            return true;
        }
        return false;  
    }

    /**
     * Print the categories in the list and their information.
     * This function is used for debug.
     */
    public static void printInfoDebug(){
        System.out.println("customer Information ");
        for(String k : customerList.keySet()){
            System.out.println("customer : "+k);
        }
    }
    
    /**
     * Insert a new species category only on the application
     * @param  list The bidimensional hashmap containing customer objects.
     */
    public static void put(HashMap<String,HashMap> list ){  
        customerList=list;
    }
    
    /**
     * Method to get the list of town where customer lives.
     * 
     * @return A string array containing the customers town.
     */
    public static String[] getCustomerTowns(){
        Set customerSet= customerList.keySet();
        String[] townArray= (String[]) customerSet.toArray(new String[customerSet.size()]);
        return townArray;
    }
    
    /**
     * Method to get the user that lives in a specific town
     * 
     * @param town The town to search in
     * @return The String array of customer names that live there.
     */
    public static String[] getCustomerNameByTown(String town){
        HashMap nameMap = customerList.get(town);
        Set nameSet = nameMap.keySet();
        String[] nameArray = (String[]) nameSet.toArray(new String[nameSet.size()]);
        return(nameArray);
    }
    
    /**
     * Test if a customer exist
     * 
     * @param name The name of the customer
     * @param town The town of the customer
     * @return If the customer exist. 
     */
    public static boolean exist(String name, String town){
            return customerList.get(town).get(name) != null;
    }
    
    /**
     * Get the customer object from his name and town
     * 
     * @param name The name of the customer
     * @param town The town of the customer
     * @return The customer object. 
     */
    public static Customer getCustomer(String name, String town){
        if(CustomerList.exist(name, town)){
            return (Customer) customerList.get(town).get(name);
        }
        return null;
    }
    
   /**
     * Function to format text with an upper case letter first and lower case.
     * Follow format: "Abcd"
     * 
     * @param s The string to treat
     * @return The formatted string.
     */
    public static String textFormat(String s){
        s =s.toLowerCase();
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        return(s);
    } 
}
