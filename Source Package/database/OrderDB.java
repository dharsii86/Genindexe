/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;

/**
 * This class contain the necessary functions to manage orders.
 * The goal is to manage the interface inputs and outputs.
 * 
 * @author Quentin Bonenfant
 */
public class OrderDB {

    
/**
 * Get the list of customers living places in the database,
 * in order to list them on the interface.
 *
 * @return ArrayList of string containing the available customers
 */
 public String[] getCustomerTown(){
     String req = "SELECT Customer_Town from Customer group by Customer_Town";
     ArrayList<ArrayList> arrayResult; // creating the result ArrayList
     arrayResult = ConnectionDB.requestStatic(req);    
    
     String[] result = formatResult(arrayResult);
     
    return(result);
 }
 
/**
 * Get the list of the customer that live in
 * a defined town
 * 
 * @param  town  The town  (as a string)  where the customers lives 
 * @return An arraylist of customer living in this town.
 */
  public String[] getCustomerName(String town){
     String req = "SELECT Customer_Name from Customer WHERE Customer_Town ="+ town;
     ArrayList<ArrayList> arrayResult; // creating the result ArrayList
     arrayResult = ConnectionDB.requestStatic(req);    
    
     String[] result = formatResult(arrayResult);
     
    return(result);
 }
 
/**
 * Get the list of the existing category in the database
 * 
 * @return ArrayList of string containing the existing categories
 */
 public String[] getCategory(){
     String req = "SELECT Category_Name from Category";
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
 public String[] getSpecies(String category){
     String req = "SELECT Specie_Name from Specie WHERE Category_Name ="+ category;
     ArrayList<ArrayList> arrayResult; // creating the result ArrayList
     arrayResult = ConnectionDB.requestStatic(req);    
    
     String[] result = formatResult(arrayResult);
     
    return(result);
 }

    /**
     * Get the list of possible analysis that match 
     * a defined species
     * 
     * @param  species  The species we want to analyse
     * @return An arraylist of string containing the possible analysis.
     */
     public String[] getAnalysis(String species){
        String req = "SELECT Analysis_Name from Relevant WHERE Species_Name ="+ species;
        ArrayList<ArrayList> arrayResult; // creating the result ArrayList
        arrayResult = ConnectionDB.requestStatic(req);    
    
     String[] result = formatResult(arrayResult);
     
    return(result);
    } 

    /**
     * Creation of the order in the database.
     * This method send the new order to the database.
     *
     * @param theOrder The order object to send.
     */ 

    /**   
     *  Function to format the results from request containg a string column.  
     *  The results from requestStatic are ArrayList of ArrayList (two dimensional).
     *  That's why we need to extract the values using a for loop
     *  and tmp variable.
     * 
     * @param arrayResult The arraylist to convert in String[]
     * @return The string array containing the result
     */ 

    public String[] formatResult(ArrayList<ArrayList> arrayResult){

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