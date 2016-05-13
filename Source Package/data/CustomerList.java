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
import nf.Customer;

/**
 *
 * @author cube
 */
public class CustomerList {
        
    private static HashMap<String,HashMap> customerList;

    public static void launchCustomerList(){
        CustomerList.customerList = new HashMap<>();
    }
    
    /**
     * Insert a new customer to the application and into the database
     * @param name Name of the customer
     * @param town Town of the customer
     * @return Insertion result (success / fail )
     */
    public static boolean add(String name, String town){
        Customer cust = new Customer(name,town);
        
        if(CustomerDB.addCustomer(cust)){
            // if the town exist
            if(customerList.get(town)!=null){
                HashMap nameMap = customerList.get(town);
                
                // if the customer name do not already exist in the list
                // (Already checked by 
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
            
            //printInfoDebug();
            return true;
        }
        return false;  
    }

    public static void printInfoDebug(){
        System.out.println("category Information ");
        for(String k : customerList.keySet()){
            System.out.println("category : "+k);
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
}