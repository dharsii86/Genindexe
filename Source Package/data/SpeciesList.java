package data;

import database.SpecieDB;
import java.util.HashMap;
import nf.Specie;
import nf.SpecieCategory;

/**
 * This class manage the static list of Species.
 * It is used to access species objects through the whole application.
 * The methods used to access the list are also static.
 * 
 * @author SCRUM Group 2.
 */
public class SpeciesList {
  
    // Hashmap of Species, the key is the name of the specie
    private static HashMap<String,Specie> speciesList;

    
    /**
     * Initialisation of the Species hashmap.
     */
    public static void launchSpeciesList(){
        SpeciesList.speciesList = new HashMap<>();
    }
    
    /**
     * Insert a new species on the application and on the database
     * 
     * @param spe The species to add
     * @param cat The category which the specie is in
     * @return  The success of the insertion
     */
    public static boolean add(Specie spe,SpecieCategory cat){
        if(SpecieDB.addSpecie(spe, cat)){
            speciesList.put(spe.getName(),spe);
            //printInfoDebug();
            return true;
        }else{
            return false;
        }   
    }
    
    /**
     * Print the categories in the list and their information.
     * This function is used for debug.
     */
    public static void printInfoDebug(){
        System.out.println("Species Information ");
        for(String k : speciesList.keySet()){
            System.out.println("specie : "+k);
        }
    }
    
    /**
     * Insert a new species only on the application
     * @param spe The specie to add
     */
    public static void put(Specie spe){
        speciesList.put(spe.getName(),spe);
    }
    
    /**
     * Getter for the species Hashmap
     * 
     * @return The species hashmap
     */
    public static HashMap getSpecies(){
        return speciesList;
    }
    
    /**
     * Method to get the Specie object from its name
     * 
     * @param s The specie name
     * @return The specie object
     */
    public static Specie get(String s){
        return speciesList.get(s);
    }
}
