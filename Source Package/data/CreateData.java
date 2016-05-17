/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import database.ConnectionDB;
import database.CustomerDB;
import database.OrderDB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            System.out.println("Creation of all the information");
            CategoryList.launchCategoryList();
            SpeciesList.launchSpeciesList();
            CustomerList.launchCustomerList();
            OrderList.launchOrderList();
            SampleList.launchSampleList();

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
                        /////////////////////////////////
                        ////Récupération order 
                        //récupérer arraylist d'order pour ce customer
                        HashMap<Integer,Order> hmOrd = OrderDB.getOrder(cust);
                        // ajouter chaque élément de la liste à la liste d'order list
                        for (Integer k: hmOrd.keySet()){
                            OrderList.put(k, hmOrd.get(k));
                            cust.addOrder(hmOrd.get(k));
                        }                       
                }
                customerTownList.put(town,hashName);
            }
            CustomerList.put(customerTownList);
            /////////////////////////////////
            ////Récupération Sample 
            ArrayList<ArrayList> resultSpl= ConnectionDB.requestStatic("SELECT `Order_Id`, `Specie_Name`, `result`, `state` FROM `sample` WHERE 1");
            for(ArrayList<String> res:resultSpl){//pour chaque ligne du resultat pour l'order
                Order ord = OrderList.getOrder(Integer.parseInt(res.get(0)));
                String ana = ConnectionDB.requestOneResult("SELECT `Analysis_Name` FROM `order` WHERE `Order_Id`="+res.get(0));
                ArrayList<ArrayList> valueAna = ConnectionDB.requestStatic("SELECT `val1`, `val2`, `val3`, `val4` FROM `relevant` WHERE `Specie_Name` = '"+res.get(1)+"' and `Analysis_Name` = '"+ana+"';");
                ArrayList<Integer> val = valueAna.get(0);
                
                SexingTest sex = new SexingTest(SpeciesList.get(res.get(1)), val.get(0), val.get(1), val.get(2), val.get(3));
                ScrapieTest scp = new ScrapieTest(SpeciesList.get(res.get(1)),  val.get(0),  val.get(1));
                Sample newSpl = null;
                if (ana.equals("Sexing")){
                    newSpl = new Sample(sex, SpeciesList.get(res.get(1)), ord);//Attention ici problème il faut normalement une Analyse
                }else if(ana.equals("Scrapie")){
                    newSpl = new Sample(scp, SpeciesList.get(res.get(1)), ord);//Attention ici problème il faut normalement une Analyse
                }else{
                    System.out.println("Erreur, analyse incorrecte : Create Data during sample creation");
                }
                List listSample = ord.getSamples();
                ArrayList<Sample> listOfSamples = new ArrayList<>(listSample.size());
                listOfSamples.addAll(listSample);
                listOfSamples.add(newSpl);
                OrderStatus aux = ord.getStatus();
                ord.setSamples(listOfSamples);
                ord.setStatus(aux);
                
                
            }
            
            System.out.println("All the information have been created");
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


