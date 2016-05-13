/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import database.ConnectionDB;
import database.CustomerDB;
import java.util.ArrayList;
import java.util.HashMap;
import nf.*;
/**
 *
 * @author Quentin Bonenfant
 */
public class CreateData {
    
    private static boolean possibilityToCreate = true;
    
    public static void createAllInfo(){
        //create order
        /*
        1- Category
        2- Species
        3- Analysis
        4- Customer
        */
        if(possibilityToCreate){
            CategoryList.launchCategoryList();
            SpeciesList.launchSpeciesList();

            String[] catList = getCategory();
            System.out.println("category Creation");

            for (String cat: catList){
                // creation of the new category
                SpecieCategory category = new SpecieCategory(cat);
                // the object category is created
                String[] specList = getSpecies(cat);// get the species for that category
                //add the species for this category
                for(String spec : specList){
                    Specie sp = new Specie(spec);
                    SpeciesList.put(sp);
                    category.addSpecie(sp);
                }
                //Add the object category
                CategoryList.put(category);
            }
            
            // 4- Creation of customer objects and lists
            
            // Initialisation
            HashMap<String,HashMap> customerTownList = new HashMap<>();
            HashMap<String,Customer> hashName;
            String[] nameList;
            String[] townList = CustomerDB.getCustomerTown();
            Customer cust;
            // filling
            for(String town:townList){
                
                nameList= CustomerDB.getCustomerName(town);
                hashName = new HashMap<>(); 
                for(String name: nameList){
                       cust= new Customer(name,town);
                       hashName.put(name,cust);
                }
                customerTownList.put(town,hashName);
            }
            CustomerList.put(customerTownList);
            
            
            System.out.println("Creation of all the information");
            possibilityToCreate = false;
        }else{
            System.out.println("All the data are already created");
        }
        
        
    }
    
    
   /**
    * Get the existing category from the database
    * 
    * @return The string array containing the existing categories.
    */
   public static String[] getCategory(){
     String req = "SELECT Category_Name from category";
     ArrayList<ArrayList> arrayResult; // creating the result ArrayList
     arrayResult = ConnectionDB.requestStatic(req);    
    
     String[] result = formatResult(arrayResult);
     
    return(result);
    }
   
    /**
      * Get the list of the species that match 
      * a defined category
      * 
      * @param  category The category of species to find
      * @return An arraylist of string containing the possible species.
      */
   public static String[] getSpecies(String category){
     String req = "SELECT Specie_Name from specie WHERE Category_Name = '"+ category+"'";
     ArrayList<ArrayList> arrayResult; // creating the result ArrayList
     arrayResult = ConnectionDB.requestStatic(req);    
     String[] result = formatResult(arrayResult);
     
    return(result);
 }
   
   /**   
     *  Function to format the results from request containg a string column.  
     *  The results from requestStatic are ArrayList of ArrayList (two dimensional).
     *  That's why we need to extract the values using a for loop
     *  and tmp variable.
     * 
     * @param arrayResult The arraylist to convert in String[]
     * @return The string array containing the result
     */ 
   public static String[] formatResult(ArrayList<ArrayList> arrayResult){

         // Temporary arraylist, make it easier to extract results from request
         ArrayList<String> tmp = new ArrayList();
         
         for( ArrayList<String> al: arrayResult ){
             //Here we get only one row, which is located at[0]
             tmp.add(al.get(0)); 
         }
        // Initialisation of the String array and conversion of the results
        String[] result = new String[tmp.size()];
        result = tmp.toArray(result);
        
        return(result);
  }
    
    
    
}


