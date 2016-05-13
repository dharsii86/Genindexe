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
            
            HashMap<String,Customer> hashName;
            hashName = new HashMap<>();
            customerList.put(town,hashName);
            
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
    
    /*
     * Insert a new species category only on the application
     * @param cat 
     
    public static void put(SpecieCategory cat){
        categoryList.put(cat.getName(),cat);
    }
    
    public static HashMap getCategory(){
        return categoryList;
    }
    
    public static String[] getListSpecieFromCat(String cat){
	ArrayList<String> res = new ArrayList<>();
	SpecieCategory sCat = categoryList.get(cat);
        Set<Specie> setSpe = sCat.getSpecies();
        List<Specie> list = new ArrayList<>(setSpe);
        for (Specie list1 : list) {
            res.add(list1.getName());
        }
        String[] result = new String[ res.size() ];
        return res.toArray( result );
    }
    
}