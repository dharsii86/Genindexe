package data;

import database.ConnectionDB;
import database.CustomerDB;
import database.OrderDB;
import database.ResultDB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import nf.*;

/**
 * This class initialise all the objects when the application start.
 * The creation process use the database scripts to retrieve information.
 * Objects are stored in dedicated classes, in static lists.
 * 
 * @author SCRUM Group 2.
 */
public class CreateData {
    
    // Needed to know if object have been initialised once.
    private static boolean possibilityToCreate = true;
    
    // used to print useful information if debug is needed
    private final static boolean debug = false;
    
    /**
     * Object initialisation / creation function.
     * This is the core function of this class.
     * It convert information from the database in objects.
     */
    public static void createAllInfo(){
        /* 
        Objects created here:
       
        1- Category
        2- Species
        3- Customer 
        4- Order
        5- Samples and Analysis
        6- Result
        */
        
        // If the script have never been launched before.
        if(possibilityToCreate){
            
            // Initialisation
            if(debug){System.out.println("Creation of all the information");}
            
            CategoryList.launchCategoryList();
            SpeciesList.launchSpeciesList();
            CustomerList.launchCustomerList();
            OrderList.launchOrderList();
            SampleList.launchSampleList();
            String[] catList = getCategory();
            
            // 1 - Category Creation
            
            if(debug){System.out.println("Category creation");}
            for (String cat: catList){
                // Creation of the new category.
                SpecieCategory category = new SpecieCategory(cat);
                // The category is created.
                
                // 2- Species creation, linked to categories
                
                String[] specList = getSpecies(cat); // Get the species for that category
                // Add the species for this category
                for(String spec : specList){
                    Specie sp = new Specie(spec);
                    SpeciesList.put(sp);
                    category.addSpecie(sp);
                }
                // Add the category
                CategoryList.put(category);
            }
            
            
            // 3 - Creation of customer objects and lists
            
            // Initialisation
            HashMap<String,HashMap> customerTownList = new HashMap<>();
            HashMap<String,Customer> hashName;
            String[] nameList;
            String[] townList = CustomerDB.getCustomerTown();
            Customer cust;
            
            // Filling the lists
            for(String town:townList){
                nameList= CustomerDB.getCustomerName(town);
                hashName = new HashMap<>(); 
                for(String name: nameList){
                        cust= new Customer(name,town);
                        hashName.put(name,cust);
                        
                        // 4- Order List creation
                        
                        // Get the list of orders for the customer
                        HashMap<Integer,Order> hmOrd = OrderDB.getOrder(cust);
                        
                        // Append each element to the global order list.
                        for (Integer k: hmOrd.keySet()){
                            OrderList.put(k, hmOrd.get(k));
                            cust.addOrder(hmOrd.get(k));
                        }                       
                }
                customerTownList.put(town,hashName);
            }
            CustomerList.put(customerTownList);
            
            // 5 - Sample list creation, for each analysis
            
            ArrayList<ArrayList> resultSpl= ConnectionDB.requestStatic("SELECT `Order_Id`, `Specie_Name`,`Sample_Id` FROM `sample` WHERE 1");
            for(ArrayList<String> res:resultSpl){//pour chaque ligne du resultat pour l'order
                Order ord = OrderList.getOrder(Integer.parseInt(res.get(0)));
                String ana = ConnectionDB.requestOneResult("SELECT `Analysis_Name` FROM `order` WHERE `Order_Id`="+res.get(0));
                ArrayList<ArrayList> valueAna = ConnectionDB.requestStatic("SELECT `val1`, `val2`, `val3`, `val4` FROM `relevant` WHERE `Specie_Name` = '"+res.get(1)+"' and `Analysis_Name` = '"+ana+"';");
                ArrayList<String> val = valueAna.get(0);
                
                int val0 = Integer.parseInt(val.get(0));
                int val1 = Integer.parseInt(val.get(1));
                int val2 = Integer.parseInt(val.get(2));
                int val3 = Integer.parseInt(val.get(3));
                
                // Analysis selection for samples
                
                SexingTest sex = new SexingTest(SpeciesList.get(res.get(1)), val0, val1, val2, val3);
                
                ScrapieTest scp = new ScrapieTest(SpeciesList.get(res.get(1)),  val0,  val1);
                Sample newSpl = null;
                
                
                switch (ana) {
                    case "Sexing":
                        newSpl = new Sample(sex, SpeciesList.get(res.get(1)), ord);
                        break;
                    case "Scrapie":
                        newSpl = new Sample(scp, SpeciesList.get(res.get(1)), ord);
                        break;
                    default:
                        System.out.println("Erreur, analyse incorrecte : Create Data during sample creation");
                        break;
                }
                
                // 6- Result creation
                if(newSpl != null){
                    ArrayList<ArrayList> allResult= ConnectionDB.requestStatic("SELECT `result1`, `result2`, `result3` FROM `sample` WHERE `Sample_Id` = "+res.get(2));
                    for(ArrayList<String> ligne:allResult){
                        String res1 = ligne.get(0);
                        String res2 = ligne.get(1);
                        String res3 = ligne.get(2);
                        if(res1 != null){
                            newSpl.addResult(ResultDB.getResult(Integer.parseInt(res1),ana));
                            if(res2 != null){
                                newSpl.addResult(ResultDB.getResult(Integer.parseInt(res2),ana));
                                if(res3 != null){
                                    newSpl.addResult(ResultDB.getResult(Integer.parseInt(res3),ana));
                                }
                            }
                        }
                    }
                }
                
                List listSample = ord.getSamples();
                if(listSample == null){
                    ArrayList<Sample> listOfSamples = new ArrayList<>();
                    listOfSamples.add(newSpl);
                    OrderStatus aux = ord.getStatus();
                    ord.setSamples(listOfSamples);
                    ord.setStatus(aux);
                }else{
                    ArrayList<Sample> listOfSamples = new ArrayList<>(listSample.size());
                    listOfSamples.addAll(listSample);
                    listOfSamples.add(newSpl);
                    OrderStatus aux = ord.getStatus();
                    ord.setSamples(listOfSamples);
                    ord.setStatus(aux);
                }  
            }
            if(debug){System.out.println("All the information have been created");}
            possibilityToCreate = false;
        }else{
            System.out.println("All the data are already created");
        }
    }
    
    
   /**
    * Get the existing categories from the database
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