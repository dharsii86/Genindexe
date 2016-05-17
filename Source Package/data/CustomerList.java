/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import database.CustomerDB;
import java.security.KeyException;
import nf.Customer;

/**
 *
 * @author cube
 */
public class CustomerList {
        
    private static HashMap<String,HashMap> customerList;
    /*This HashMap contains at first a key that correspond to the Town and allow to access another HashMap
     *The other have for the key the name of the customer and allow to access to the object customer
     */

    public static void launchCustomerList(){
        CustomerList.customerList = new HashMap<>();
    }
    
    /**
     * Insert a new customer to the application and into the database
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
                System.out.println("Town exist");
                
                // If the customer name do not already exist in the list
                if(nameMap.get(name)==null){
                    nameMap.put(name,cust);
                }
            }
            // If this is a new town
            else{
                System.out.println("Town do not exist");
                HashMap<String,Customer> nameMap = new HashMap<>();
                nameMap.put(name,cust);
                customerList.put(town, nameMap);
            }
            
            printInfoDebug();
            return true;
        }
        return false;  
    }

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
    
    public static String[] getCustomerTowns(){
        Set customerSet= customerList.keySet();
        String[] townArray= (String[]) customerSet.toArray(new String[customerSet.size()]);
        return townArray;
    }
    
    public static String[] getCustomerNameByTown(String town){
        HashMap nameMap = customerList.get(town);
        Set nameSet = nameMap.keySet();
        String[] nameArray = (String[]) nameSet.toArray(new String[nameSet.size()]);
        return(nameArray);
    }
    
    public static boolean exist(String name, String town){
            return customerList.get(town).get(name) != null;
    }
    
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
