/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import database.CustomerDB;
import java.util.HashMap;
import nf.Customer;
import nf.Specie;

/**
 *
 * @author Quentin Bonenfant
 */

public class CustomerList {

    private static HashMap<String,HashMap> customerList;

    
    /**
     *  Initialisation of the customer static hashmap
     */
    public static void launchCustomerList(){
        CustomerList.customerList = new HashMap<>();
    }
    
    
    /**
     * Insert a new customers on the application and on the database
     * @param name The name of the customer
     * @param town The town of the customer
     * 
     * @return Result of the insertion (success or fail )
     */
    public static boolean add(String name, String town){
        
        // initialisation of the customer object
        Customer cust= new Customer(name,town);
        if(CustomerDB.addCustomer(cust)){
            
            HashMap<String,Customer> hashName;
            hashName = new HashMap<String,Customer>(cust.getName(),cust);
            customerList.put(cust.getTown(),hashName);
            //printInfoDebug();
            return true;
        }
        return false;       
    }
    
    
    public static void printInfoDebug(){
        System.out.println("Species Information ");
        for(String k : speciesList.keySet()){
            System.out.println("specie : "+k);
        }
    }
    
    /**
     * Insert a new species only on the application
     * @param cat 
     */
    public static void put(Customer cust){
        customerList.put( cust.getTown() , new HashMap(cust.getName(),cust) );
    }
    
    
    public static HashMap getSpecies(){
        return speciesList;
    }
}
